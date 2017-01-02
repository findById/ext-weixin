package org.cn.external.weixin.model.message;

/**
 * 语音消息
 * MsgType voice
 */
public class VoiceMessage extends BaseMessage {
    private String mediaId; // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String format; // 语音格式，如amr，speex等

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
