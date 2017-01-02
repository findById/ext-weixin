package org.cn.external.weixin.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.*;

public class XMLUtil {

    public static Element parseObject(String xml) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            return document.getDocumentElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String extract(String xml, String key) {
        try {
            Element root = parseObject(xml);

            NodeList msg = root.getElementsByTagName(key);
            if (msg != null) {
                return msg.item(0).getFirstChild().getNodeValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String, String> parseXml(String xml) {
        Map<String, String> map = new HashMap<>();
        Element element = parseObject(xml);
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                map.put(node.getNodeName(), node.getTextContent());
            }
        }
        return map;
    }

    public static String toXmlString(Object obj) {
        return toXmlString(obj, true);
    }

    public static String toXmlString(Object obj, boolean root) {
        Class<?> clazz = obj.getClass();

        StringBuffer xml = new StringBuffer();
        String node = "";
        if (root) {
            node = "xml";
        } else {
            XmlElement nodeName = clazz.getAnnotation(XmlElement.class);
            node = (nodeName != null && !"".equals(nodeName.name())) ? nodeName.name() : clazz.getSimpleName();
        }
        xml.append("<").append(node).append(">");

        Field[] fields = getFields(clazz);
        for (Field field : fields) {
            try {
                XmlElement a = field.getAnnotation(XmlElement.class);
                field.setAccessible(true);
                Object o = field.get(obj);

                xml.append('<');
                xml.append((a != null && !"".equals(a.name())) ? a.name() : field.getName());
                xml.append('>');
                if (o instanceof List) {
                    List list = (List) o;
                    for (Object item : list) {
                        xml.append(toXmlString(item, false));
                    }
                } else {
                    xml.append(o == null ? "" : o);
                }
                xml.append("</");
                xml.append((a != null && !"".equals(a.name())) ? a.name() : field.getName());
                xml.append('>');
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        xml.append("</").append(node).append('>');
        return xml.toString();
    }

    private static Field[] getFields(Class<?> clazz) {
        List<Field> list = new ArrayList<>();
        list.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Class<?> superclass = clazz;
        while ((superclass = superclass.getSuperclass()).getDeclaredFields().length > 0) {
            list.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        return list.toArray(new Field[list.size()]);
    }

}
