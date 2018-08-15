package com.muxi.wxchat.controller;
import com.muxi.wxchat.constant.MessageStaticConstant;
import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.AccessToken;
import com.muxi.wxchat.pojo.ImageTextArticleListPojo;
import com.muxi.wxchat.pojo.Message;
import com.muxi.wxchat.pojo.MessageText;
import com.muxi.wxchat.pojo.WXPOJO.WxAttentionUser;
import com.muxi.wxchat.services.logicservices.authentication.AccessTokenAuthentication;
import com.muxi.wxchat.services.logicservices.createMenu.MenuFunction;
import com.muxi.wxchat.services.logicservices.formatParsing.XMLFormatParsing;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.AritificialMenu;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.ImageTextAriticle;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.InformationProcessingCentre;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.UserInformationDispose;
import com.muxi.wxchat.util.LoggerUtil;
import com.muxi.wxchat.util.MapUtil;
import com.muxi.wxchat.util.MessageUtil;
import com.muxi.wxchat.util.XmlUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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

    @Autowired
    private XMLFormatParsing xmlFormatParsing;

    @Autowired
    private InformationProcessingCentre informationProcessingCentre;

    @Autowired
    private ImageTextAriticle imageTextAriticle;

    @Autowired
    private UserInformationDispose userInformationDispose;

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
    /*首次登陆echostr不为null*/
        System.err.println(request.getParameter("echostr"));
    if(null != request.getParameter("echostr") && request.getParameter("echostr").length() > 1){
    aritificialMenu.sendStatement(response,request.getParameter("echostr"));
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
    @RequestMapping(value = "getEntrnceMethod.html",method = RequestMethod.POST)
    public void postEntrnceMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*将微信请求转换为Map信息*/
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

            Map<String,String> map = MessageUtil.xmlToMap(request);
            Message message =  MapUtil.mapToBean(map,new Message());
            MessageText messageText = MapUtil.mapToBean(map,new MessageText());
            String sendMessageStr = "";
            if(MessageStaticConstant.MESSAGE_EVENT.equals(message.getMsgType())) {               /*事件类型*/
                if (MessageStaticConstant.EVENT_SUB.equals(message.getEvent())) {                /*关注事件*/
                    sendMessageStr = MessageUtil.sendMessage(message.getFromUserName(), message.getToUserName(), aritificialMenu.getRequestInitializationMenu(),message);
                }else if(MessageStaticConstant.EVENT_CLICK.equals(message.getEvent())){          /*点击事件*/
                }
            }else if(MessageStaticConstant.MESSAGE_TEXT.equals(message.getMsgType())){           /*文本信息*/
                if(!"noText".equals(informationProcessingCentre.attentionReply(messageText.getContent())))
                    sendMessageStr = MessageUtil.sendMessage(message.getFromUserName(), message.getToUserName(), informationProcessingCentre.attentionReply(messageText.getContent()),message);
                else{
                    /*获取图文对象*/
                    sendMessageStr =  XmlUtil.newsImageTextArticleListPojoToXml(imageTextAriticle.creatImageTextInformation(messageText, 0));
                }
            }
            out.print(sendMessageStr);
            out.close();
    }
}
