package cn.damai.beautiful_article.common.utils;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class DataResult {
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回结果
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
