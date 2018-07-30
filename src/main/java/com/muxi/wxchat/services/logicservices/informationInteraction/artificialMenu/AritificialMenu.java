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

public interface AritificialMenu {

    /*get请求出事化菜单*/
    public String getRequestInitializationMenu();

    /*回复 LQGH或lqgh(领取干货) 获取领取地址*/
    public String getDry();


}
