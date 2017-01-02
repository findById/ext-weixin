package org.cn.external.weixin;

import org.cn.external.weixin.model.EventType;
import org.cn.external.weixin.model.MsgType;
import org.cn.external.weixin.model.message.TextMessage;
import org.cn.external.weixin.utils.XMLUtil;

import java.util.Map;

public class SimpleMessageHandler extends MessageHandler {

    @Override
    protected String handleMessage(String type, String body) {
        Map<String, String> map = XMLUtil.parseXml(body);
        switch (type) {
            case MsgType.TEXT: {
                TextMessage tm = new TextMessage();
                tm.setToUserName(map.get("UserId"));
                tm.setFromUserName(map.get("CorpId"));
                tm.setMsgType(MsgType.TEXT);
                tm.setCreateTime(String.valueOf(System.currentTimeMillis()));
                tm.setContent(map.get("Content"));
                return XMLUtil.toXmlString(tm);
            }
            case MsgType.IMAGE: {

                break;
            }
            default:
                break;
        }
        return super.handleMessage(type, body);
    }

    @Override
    protected String handleEvent(String type, String body) {
        Map<String, String> map = XMLUtil.parseXml(body);
        switch (type) {
            case EventType.SUBSCRIBE: {
                TextMessage tm = new TextMessage();
                tm.setToUserName(map.get("UserId"));
                tm.setFromUserName(map.get("CorpId"));
                tm.setMsgType(MsgType.TEXT);
                tm.setCreateTime(String.valueOf(System.currentTimeMillis()));
                tm.setContent("Thanks for your subscription us.");
                return XMLUtil.toXmlString(tm);
            }
            case EventType.UNSUBSCRIBE: {
                break;
            }
            case EventType.CLICK: {
                String eventKey = map.getOrDefault("EventKey", "");
                break;
            }
            default:
                break;
        }
        return super.handleEvent(type, body);
    }

    @Override
    protected String handleError(String type, String message) {
        return super.handleError(type, message);
    }
}
