package cn.damai.beautiful_article.core.domain;

import java.util.Date;

/**
 * Created by fkk on 2016/12/6.
 */
public class Review {
    //主键
    private Long reviewId;
    private Long userId;
    private Long articleId;
    private Long parentReviewId;
    private Date createTime;
    private String reviewContent;
    private int dateState;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getParentReviewId() {
        return parentReviewId;
    }

    public void setParentReviewId(Long parentReviewId) {
        this.parentReviewId = parentReviewId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getDateState() {
        return dateState;
    }

    public void setDateState(int dateState) {
        this.dateState = dateState;
    }
}
