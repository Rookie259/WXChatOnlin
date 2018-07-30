package com.muxi.wxchat.services.logicservices.http;


import net.sf.json.JSONObject;

/*
 *------------------------------.
 *@ClassName : httpRequest
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:48
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */
public interface HttpRequest {

    public  JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr);
}
