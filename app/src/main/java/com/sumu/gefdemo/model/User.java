package com.sumu.gefdemo.model;

/**
 * Created by gefufeng on 15/12/9.
 */
public class User extends BaseModel {
    private String nameId;
    private String avatar;
    private String nick;

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "User{" +
                "nameId=" + nameId +
                ", avatar='" + avatar + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
