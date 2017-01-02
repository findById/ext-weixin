package org.cn.external.weixin.helper;

import com.alibaba.fastjson.JSON;
import org.cn.core.rpc.Response;
import org.cn.core.rpc.RpcEngine;

/**
 * 用户相关
 */
public class UserHelper {

    public static final String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%1$s&openid=%2$s";
    public static final String GET_USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%1$s&next_openid=%2$s";

    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140839&token=&lang=zh_CN">获取用户基本信息</a>
     */
    public String getUserInfo(String token, String openId) {
        Response response = RpcEngine.get(String.format(GET_USER_INFO, token, openId));
        if (!response.isSuccess()) {
            return "";
        }
        return JSON.parseObject(response.response).toJSONString();
    }

    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140840&token=&lang=zh_CN">获取用户列表</a>
     */
    public String getUserList(String token, String openId) {
        String url = "";
        if (openId == null) {
            url = String.format(GET_USER_LIST, token, "");
        } else {
            url = String.format(GET_USER_LIST, token, openId);
        }
        Response response = RpcEngine.get(url);
        if (!response.isSuccess()) {
            return "";
        }
        return JSON.parseObject(response.response).toJSONString();
    }

}
