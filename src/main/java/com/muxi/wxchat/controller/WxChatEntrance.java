package com.muxi.wxchat.controller;
import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.AccessToken;
import com.muxi.wxchat.services.logicservices.authentication.AccessTokenAuthentication;
import com.muxi.wxchat.services.logicservices.createMenu.MenuFunction;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.AritificialMenu;
import com.muxi.wxchat.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *------------------------------.
 *@ClassName : WxChatEntrance
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/27 16:16
 *@描述 : 请求公众号入口 GET/POST
 *@Version : 1.0
 *------------------------------
 */
@Controller
public class WxChatEntrance {
    final Logger logger = Logger.getLogger(WxChatEntrance.class);

    @Autowired
    private AccessTokenAuthentication accessTokenAuthentication;

    @Autowired
    private MenuFunction menuFunction;

    @Autowired
    private AritificialMenu aritificialMenu;
    /*
    *------------------------------.
    *@ClassName : WxChatEntrance
    *@创建人 : 沐惜
    *@创建时间 : 2018/7/27 16:38
    *@方法描述 : 用户首次请求
    *@Param :
    @Return : 
    *@Version : 1.0
    *------------------------------
    */
    @RequestMapping(value = "getEntrnceMethod.html",method = RequestMethod.GET)
    public void getEntrnceMethod(HttpServletRequest request, HttpServletResponse response){
    /*验证身份 并获取accessToken*/
    AccessToken accessToken = accessTokenAuthentication.getAccessToken(WXStaticConstant.APP_ID, WXStaticConstant.APPSECRET);
    LoggerUtil.setLogger("accessToken= "+accessToken);

    /*菜单创建*/
    //menuFunction.createMenu(accessToken);

    /*信息互动*/
    /*首次登陆echostr不为null*/
    if(null != request.getParameter("echostr") && request.getParameter("echostr").length() > 1){
    /*发送欢迎语及基础菜单*/
    aritificialMenu.sendStatement(response,aritificialMenu.getRequestInitializationMenu());
    }else{
    /*互动中*/

    }
    }
    /*
    *------------------------------.
    *@ClassName : WxChatEntrance
    *@创建人 : 沐惜
    *@创建时间 : 2018/7/27 16:42
    *@方法描述 : 交互请求
    *@Param :
    @Return :
    *@Version : 1.0
    *------------------------------
    */
    @RequestMapping(value = "postEntrnceMethod.html",method = RequestMethod.POST)
    public void postEntrnceMethod(HttpServletRequest request, HttpServletResponse response){
        getEntrnceMethod(request,response);
    }
}
