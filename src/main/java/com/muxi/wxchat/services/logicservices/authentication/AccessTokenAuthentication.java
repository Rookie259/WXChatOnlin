package com.muxi.wxchat.services.logicservices.authentication;


/*
 *------------------------------.
 *@ClassName : AccessTokenAuthentication
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:41
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.pojo.AccessToken;

public interface AccessTokenAuthentication {

    public  AccessToken getAccessToken(String APP_ID, String APPSECRET);
}
