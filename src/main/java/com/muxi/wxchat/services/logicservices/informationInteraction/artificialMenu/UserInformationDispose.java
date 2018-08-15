package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu;


import com.muxi.wxchat.pojo.WXPOJO.WxAttentionUser;
import net.sf.json.JSONObject;

/*
 *------------------------------.
 *@ClassName : UserInformationDispose
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 0:14
 *@描述 : 用户信息处理
 *@Version : 1.0
 *------------------------------
 */
public interface UserInformationDispose {


   /*
   *------------------------------.
   *@ClassName : UserInformationDispose
   *@创建人 : 沐惜
   *@创建时间 : 2018/8/12 0:22
   *@方法描述 : 用户关注时 获取 基本信息
   *@Param :
   @Return :
   *@Version : 1.0
   *------------------------------
   */
   public WxAttentionUser getAttentionUserInformation(String accessToken,String openId);

}
