package org.cn.external.weixin;

public class MessageBroker {

    MessageHandler handler = null;

    public MessageBroker(String appId, String appSecret, String token, MessageHandler handler) {
        WeixinConfig.APP_ID = appId;
        WeixinConfig.APP_SECRET = appSecret;
        WeixinConfig.LOCAL_TOKEN = token;
        this.handler = handler;
    }

    public String verify(String signature, String timestamp, String nonce, String echostr) {
        return handler.verify(signature, timestamp, nonce, echostr);
    }

    public String handleMessage(String signature, String timestamp, String nonce, String body) {
        return handler.handleMessage(signature, timestamp, nonce, body);
    }
}
