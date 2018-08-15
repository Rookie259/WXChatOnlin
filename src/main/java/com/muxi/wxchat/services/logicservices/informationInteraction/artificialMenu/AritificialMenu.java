package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu;


/*
 *------------------------------.
 *@ClassName : AritificialMenu
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 2:10
 *@描述 : 公众号发送菜单String
 *@Version : 1.0
 *------------------------------
 */


import javax.servlet.http.HttpServletResponse;

public interface AritificialMenu {

    /*send发送语句*/
    public void sendStatement(HttpServletResponse response, String statement);



    /*回复 LQGH或lqgh(领取干货) 获取领取地址*/
    public String getDry();

    /*图灵机器人回复信息*/
    public String getTulingResult(String content);

    /*关注时欢迎语*/
    public String getRequestInitializationMenu();

    /*前后端领取分类*/
    public String fontBackOrg();

    /*关注后回复消息对应处理*/
    public String attentionReplyHandle(String param);

    /*对未知消息处理的菜单*/
    public String unknowMenu();

}
