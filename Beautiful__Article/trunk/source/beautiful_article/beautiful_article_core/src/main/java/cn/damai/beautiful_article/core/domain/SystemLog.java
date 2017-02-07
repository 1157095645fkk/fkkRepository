package cn.damai.beautiful_article.core.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class SystemLog implements Serializable{
    /**
     * 日志id
     */
    private long logId;
    /**
     * 日志类型
     * 1 表示用户注册类型
     */
    private int logType;
    /**
     * 日志内容
     */
    private String logContent;
    /**
     * 用户id
     */
    private long userId;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }
}
