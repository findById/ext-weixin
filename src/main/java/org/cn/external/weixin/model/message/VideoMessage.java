package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

/**
 * 视频消息
 * MsgType 小视频为shortvideo, 视频为video
 */
public class VideoMessage extends BaseMessage {
    @XmlElement(name = "MediaId")
    private String mediaId; // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId; // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
