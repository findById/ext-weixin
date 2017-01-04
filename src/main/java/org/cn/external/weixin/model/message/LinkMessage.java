package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

/**
 * 链接消息
 * MsgType link
 */
public class LinkMessage extends BaseMessage {
    @XmlElement(name = "Title")
    private String title; // 消息标题
    @XmlElement(name = "Description")
    private String description; // 消息描述
    @XmlElement(name = "Url")
    private String url; // 消息链接

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
