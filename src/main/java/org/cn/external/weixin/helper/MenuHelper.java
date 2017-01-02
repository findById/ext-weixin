package org.cn.external.weixin.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.cn.core.rpc.Response;
import org.cn.core.rpc.RpcEngine;

/**
 * 菜单相关
 */
public class MenuHelper {

    public static String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
    public static String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    public static String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";

    public String get(String token) {
        Response response = RpcEngine.get(GET_MENU + token);
        if (!response.isSuccess()) {
            return "";
        }
        return JSON.parseObject(response.response).toJSONString();
    }

    public String create(String token, String value) {
        Response response = RpcEngine.post(CREATE_MENU + token, value);
        if (!response.isSuccess()) {
            return "";
        }
        JSONObject obj = JSON.parseObject(response.response);
        return obj.getString("errmsg");
    }

    public String delete(String token) {
        Response response = RpcEngine.get(DELETE_MENU + token);
        if (!response.isSuccess()) {
            return "";
        }
        JSONObject obj = JSON.parseObject(response.response);
        return obj.getString("errmsg");
    }
}
