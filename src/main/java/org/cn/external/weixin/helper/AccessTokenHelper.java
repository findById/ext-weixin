package org.cn.external.weixin.helper;

import com.alibaba.fastjson.JSON;
import org.cn.core.rpc.Response;
import org.cn.core.rpc.RpcEngine;
import org.cn.external.weixin.WeixinConfig;
import org.cn.external.weixin.model.AccessToken;

/**
 * Access token
 */
public class AccessTokenHelper {

    public static String GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s";

    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN">获取access_token</a>
     */
    public void getToken() {
        Response response = RpcEngine.get(String.format(GET_TOKEN, WeixinConfig.APP_ID, WeixinConfig.APP_SECRET));
        if (!response.isSuccess()) {
            return;
        }
        AccessToken accessToken = JSON.parseObject(response.response, AccessToken.class);
        if (accessToken.getErrcode() != 0) {
            getToken();
            return;
        }
        WeixinConfig.CURRENT_WECHAT_TOKEN = accessToken.getAccess_token();
    }

}
