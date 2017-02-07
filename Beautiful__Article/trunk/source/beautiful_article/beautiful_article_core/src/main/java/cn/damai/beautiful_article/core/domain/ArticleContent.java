package cn.damai.beautiful_article.core.domain;

/**
 * Created by fkk on 2016/12/6.
 */
public class ArticleContent {
    //主键
    private Long articleContentId;
    private Long content;
    private int dataState;

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Long getArticleContentId() {
        return articleContentId;
    }

    public void setArticleContentId(Long articleContentId) {
        this.articleContentId = articleContentId;
    }
}
