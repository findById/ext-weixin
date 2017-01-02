package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

/**
 * 文本消息
 * MsgType text
 */
public class TextMessage extends BaseMessage {
    @XmlElement(name = "Content")
    private String content; // 文本消息内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
