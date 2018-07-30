package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu;


/*
 *------------------------------.
 *@ClassName : AritificialMenu
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 2:10
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */


import javax.servlet.http.HttpServletResponse;

public interface AritificialMenu {

    /*send发送语句*/
    public void sendStatement(HttpServletResponse response, String statement);

    /*get请求出事化菜单*/
    public String getRequestInitializationMenu();

    /*回复 LQGH或lqgh(领取干货) 获取领取地址*/
    public String getDry();

    /*图灵机器人回复信息*/
    public String getTulingResult(String content);




}
