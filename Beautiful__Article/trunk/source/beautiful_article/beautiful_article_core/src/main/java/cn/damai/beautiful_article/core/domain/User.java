package cn.damai.beautiful_article.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -143740478064918662L;
    /**
     * 用户id
     */
    private long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户性别
     */
    private int userSex;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户e-mail
     */
    private String userEmail;
    /**
     * 用户创建时间
     */
    private Date createTime;
    /**
     * 用户操作时间
     */
    private Date operateTime;
    /**
     * 用户数据状态
     */
    private int dataState;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }
}
