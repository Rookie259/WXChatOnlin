package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu;


import com.muxi.wxchat.pojo.MessageText;

/*
 *------------------------------.
 *@ClassName : informationProcessingCentre
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 17:26
 *@描述 : 文本信息及时间处理
 *@Version : 1.0
 *------------------------------
 */
public interface InformationProcessingCentre {


     /*关注回复语返回干货领取菜单*/
    public String attentionReply(String param);

    /*干货领取菜单对应领取URL*/
    public String getCargoAssign(String param);






}
