package org.insuergency.dao.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * user 关系映射表
 * </p>
 *
 * @author Lynx
 * @since 2020-07-16
 */
@TableName("t_user")
@SuppressWarnings("unused")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * primary key
     */
    @TableId(type = IdType.ID_WORKER)
    public Long id;

    /**
     * user name
     */
    @TableField("user_name")
    private String userName;

    /**
     * nick name
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * password
     */
    @TableField("password")
    private String password;

    /**
     * is an active user
     */
    @TableField("is_active")
    private Integer isActive;

    /**
     * create by
     */
    @TableField("create_by")
    private String createBy;

    /**
     * create time
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * update time
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * update by
     */
    @TableField("update_by")
    private String updateBy;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
