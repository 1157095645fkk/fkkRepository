package cn.damai.beautiful_article.core.domain;

/**
 * Created by fkk on 2016/12/6.
 */
public class CategoryArticleRelation {
    //主键
    private Long categoryArticleId;
    private Long categoryId;
    private Long articleId;
    private int dataState;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }

    public Long getCategoryArticleId() {
        return categoryArticleId;
    }

    public void setCategoryArticleId(Long categoryArticleId) {
        this.categoryArticleId = categoryArticleId;
    }
}
