package cn.damai.beautiful_article.core.domain;

import java.util.Date;

/**
 * Created by fkk on 2016/12/6.
 */
public class Article {
    //主键
    private Long articleId;
    private String articleTitle;
    private Long userId;
    private Date createTime;
    private Long articleContentId;
    private Date opteraterTime;
    private int dataState;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getArticleContentId() {
        return articleContentId;
    }

    public void setArticleContentId(Long articleContentId) {
        this.articleContentId = articleContentId;
    }

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }

    public Date getOpteraterTime() {
        return opteraterTime;
    }

    public void setOpteraterTime(Date opteraterTime) {
        this.opteraterTime = opteraterTime;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
