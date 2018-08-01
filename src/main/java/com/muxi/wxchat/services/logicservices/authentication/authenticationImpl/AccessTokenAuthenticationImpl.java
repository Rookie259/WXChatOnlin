package com.muxi.wxchat.services.logicservices.authentication.authenticationImpl;


/*
 *------------------------------.
 *@ClassName : AccessTokenAuthenticationImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:43
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.AccessToken;
import com.muxi.wxchat.services.logicservices.authentication.AccessTokenAuthentication;
import com.muxi.wxchat.services.logicservices.http.HttpRequest;
import com.muxi.wxchat.util.LoggerUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccessTokenAuthenticationImpl implements AccessTokenAuthentication {

    @Autowired
    private HttpRequest httpRequest;

    /*
        *------------------------------.
        *@ClassName : AccessTokenAuthenticationImpl
        *@创建人 : 沐惜
        *@创建时间 : 2018/7/30 0:44
        *@方法描述 : 获取ACCESSTOKEN身份验证
        *@Param :APP_ID APPSECRET
        @Return : AccessToken
        *@Version : 1.0
        *------------------------------
        */
    @Override
    public AccessToken getAccessToken(String APP_ID, String APPSECRET) {
        AccessToken accessToken = null;
        JSONObject jsonObject = httpRequest.httpRequest(WXStaticConstant.REQUEST_URL.replace("APPID", APP_ID).replace("APPSECRET", APPSECRET),"GET",null);
        LoggerUtil.setLogger("WXStaticConstant.REQUEST_URL= "+WXStaticConstant.REQUEST_URL);

        if (null != jsonObject) {
            LoggerUtil.setLogger("jsonObject=" + jsonObject);
            LoggerUtil.setLogger("请求成功");
            try {
                accessToken = new AccessToken();
                accessToken.setToken(WXStaticConstant.TOKEN);
            } catch (Exception e) {
                LoggerUtil.setLogger("请求失败!  accessToken= "+WXStaticConstant.TOKEN);
                accessToken = null;
            }
        }
        return accessToken;
    }
}
