package org.cn.external.weixin.helper;

import org.cn.core.rpc.Response;
import org.cn.core.rpc.RpcEngine;

/**
 * 消息相关
 */
public class MessageHelper {

    public static String SEND_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%1$s";

    public void sendMessage(String message) {
        Response response = RpcEngine.post(SEND_MESSAGE, message);
        if (!response.isSuccess()) {
            System.out.println(response.toString());
            return;
        }
    }

}
