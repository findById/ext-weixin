package org.cn.external.weixin;

import org.cn.external.weixin.model.MsgType;
import org.cn.external.weixin.utils.VerifyUtil;
import org.cn.external.weixin.utils.XMLUtil;

public abstract class MessageHandler {

    public String verify(String signature, String timestamp, String nonce, String echostr) {
        try {
            return echostr;
        } catch (Throwable e) {
            e.printStackTrace();
            return handleError("verify", "verification failed.");
        }
    }

    public String handleMessage(String signature, String timestamp, String nonce, String body) {
        try {
            if (!VerifyUtil.signatureVerify(signature, timestamp, nonce)) {
                return handleError("verify", "verification failed.");
            }

            String type = XMLUtil.extract(body, "MsgType");

            String result = "";
            if (MsgType.EVENT.equals(type)) {
                String event = XMLUtil.extract(body, "Event");
                // String ticket =  XMLUtil.extract(body, "Ticket");
                result = handleEvent(event, body);
            } else if (type != null && type.length() > 0) {
                result = handleMessage(type, body);
            } else {
            }
            System.out.println(result);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            return handleError("error", e.getMessage());
        }
    }

    protected String handleMessage(String type, String body) {
        return "";
    }

    protected String handleEvent(String type, String body) {
        return "";
    }

    protected String handleError(String type, String message) {
        return "";
    }

}
