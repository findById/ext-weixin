package org.cn.external.weixin.helper;

/**
 * 素材相关
 */
public class MaterialHelper {

    public static final String ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    public static final String GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    public static final String DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
    public static final String UPDATE_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";

    public static final String GET_MATERIAL_LIST = "";

    // 获取零时媒体文件
    public static String GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=%1$s&media_id=%2$s";

    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738729&token=&lang=zh_CN">新增永久素材</a>
     */
    public String addMaterial() {
        return "";
    }


    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738730&token=&lang=zh_CN">获取永久素材</a>
     */
    public String getMaterial() {
        return "";
    }

    /**
     * <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738731&token=&lang=zh_CN">删除永久素材</a>
     */
    public String delMaterial() {
        return "";
    }

    /**
     * <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738732&token=&lang=zh_CN">修改永久图文素材</a>
     */
    public String updateMaterial() {
        return "";
    }

    /**
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1444738734&token=&lang=zh_CN">获取素材列表</a>
     */
    public String getMaterialList() {
        return "";
    }

}
