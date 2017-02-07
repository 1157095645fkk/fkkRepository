package cn.damai.beautiful_article.core.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class UserVo implements Serializable{

    private static final long serialVersionUID = -5414438472838395339L;
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
     * 再次确认密码
     */
    private String rePassword;
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
    private String createTime;
    /**
     * 用户操作时间
     */
    private String operateTime;
    /**
     * 用户数据状态
     */
    private String dataState;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}
