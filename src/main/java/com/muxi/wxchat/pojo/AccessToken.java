package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : AccessToken
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:42
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class AccessToken {

    private String token;

    private int expiresIn;


    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {

        return token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}
