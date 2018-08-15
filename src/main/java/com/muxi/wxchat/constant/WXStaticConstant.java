package com.muxi.wxchat.constant;


/*
 *------------------------------.
 *@ClassName : WXStaticConstant
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:29
 *@描述 : WX公众号常量配置
 *@Version : 1.0
 *------------------------------
 */

public class WXStaticConstant {

    public static final String APP_ID = "wx3188b7c5b23d9857";

    public static final String APPSECRET = "78b1a9ec808f854cbc29625866c22b52";

    public static final String TOKEN = "wxchat";

    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static final String OPPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

    public static final String REQUEST_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
}
