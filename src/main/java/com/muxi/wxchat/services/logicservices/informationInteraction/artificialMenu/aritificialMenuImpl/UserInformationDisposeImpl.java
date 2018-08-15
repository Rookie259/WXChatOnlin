package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.aritificialMenuImpl;


/*
 *------------------------------.
 *@ClassName : UserInformationDisposeImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 0:21
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.WXPOJO.WxAttentionUser;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.UserInformationDispose;
import com.muxi.wxchat.util.CommonUtil;
import com.muxi.wxchat.util.UUIDUtil;
import net.sf.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserInformationDisposeImpl implements UserInformationDispose {


    @Override
    public WxAttentionUser getAttentionUserInformation(String accessToken,String openId) {
           /* wxAttentionUser.setWxattenid(UUIDUtil.getUUID());
            wxAttentionUser.setWxoppenid(jsonUser.get("oppenid").getAsString());
            wxAttentionUser.setWxnickname(jsonUser.get("nickname").getAsString());
            wxAttentionUser.setWxsex(jsonUser.get("sex").getAsString());
            wxAttentionUser.setWxcity(jsonUser.get("city").getAsString());
            wxAttentionUser.setWxprovince(jsonUser.get("province").getAsString());
            wxAttentionUser.setWxcountry(jsonUser.get("county").getAsString());
            wxAttentionUser.setWxlanguage(jsonUser.get("language").getAsString());
            wxAttentionUser.setWxheadimgurl(jsonUser.get("headimggurl").getAsString());
            wxAttentionUser.setWxsubscribetime(jsonUser.get("subscribetime").getAsString());
            wxAttentionUser.setWxunionid(jsonUser.get("unionid").getAsString());
            wxAttentionUser.setWxremark(jsonUser.get("remark").getAsString());
            wxAttentionUser.setWxgroupid(jsonUser.get("groupid").getAsString());*/
        return null;
    }

}
