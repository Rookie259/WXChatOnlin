package com.muxi.wxchat.pojo.WXPOJO;


/*
 *------------------------------.
 *@ClassName : Token
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 11:03
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class Token {
    // 接口访问凭证֤
    private String accessToken;
    // 凭证有效期单位：second
    private int expiresIn;
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
