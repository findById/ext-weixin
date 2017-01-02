package org.cn.external.weixin.model.message;

/**
 * 图片消息
 * MsgType image
 */
public class ImageMessage extends BaseMessage {
    private String picUrl; // 图片链接（由系统生成）
    private String mediaId; // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
