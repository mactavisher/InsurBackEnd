package org.insurgency.forms;

/**
 * form used when user register
 *
 * @author Lynx
 *
 * @since 2020/07/19
 */

@SuppressWarnings("unused")
public class UserForm {

    /**
     * user name
     */
    private String userName;

    /**
     * nick name
     */
    private String nickName;

    /**
     * password
     */
    private String password;

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
}
