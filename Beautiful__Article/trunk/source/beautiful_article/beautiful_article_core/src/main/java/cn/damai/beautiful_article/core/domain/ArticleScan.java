package cn.damai.beautiful_article.core.domain;

/**
 * Created by fkk on 2016/12/6.
 */
public class ArticleScan {
    //主键
    private Long articleScanId;
    private Long articleId;
    private Long userId;
    private int userLikeState;

    public Long getArticleScanId() {
        return articleScanId;
    }

    public void setArticleScanId(Long articleScanId) {
        this.articleScanId = articleScanId;
    }

    public int getUserLikeState() {
        return userLikeState;
    }

    public void setUserLikeState(int userLikeState) {
        this.userLikeState = userLikeState;
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
}
