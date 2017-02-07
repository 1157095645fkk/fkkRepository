package cn.damai.beautiful_article.core.domain;

/**
 * Created by fkk on 2016/12/6.
 */
public class Category {
    //主键
    private Long categoryId;
    private String categoryName;
    private int dataState;

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
