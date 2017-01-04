package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

/**
 * 语音消息
 * MsgType voice
 */
public class VoiceMessage extends BaseMessage {
    @XmlElement(name = "MediaId")
    private String mediaId; // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    @XmlElement(name = "Format")
    private String format; // 语音格式，如amr，speex等
    @XmlElement(name = "Recognition") // 语音识别结果，UTF8编码
    private String recognition;

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

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
