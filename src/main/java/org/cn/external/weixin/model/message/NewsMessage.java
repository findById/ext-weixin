package org.cn.external.weixin.model.message;

import org.cn.external.weixin.utils.XmlElement;

import java.util.List;

/**
 * 图文消息
 * MsgType news
 */
public class NewsMessage extends BaseMessage {
    private int ArticleCount; // 图文消息个数，限制为10条以内
    @XmlElement(name = "Articles")
    private List<Article> articles; // 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
