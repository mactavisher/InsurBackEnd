package org.insurgency.dao.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for our user
 * 
 * @author Lynx
 * 
 * @since 2020/07/19
 */

@SuppressWarnings("unused")
public class UserDTO implements Serializable {

    /**
     * primary key
     */
    public Long id;

    /**
     * user name
     */
    private String userName;

    /**
     * nick name
     */
    private String nickName;

    /**
     * is an active user
     */
    private Integer isActive;

    /**
     * create by
     */
    private String createBy;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * update by
     */
    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
