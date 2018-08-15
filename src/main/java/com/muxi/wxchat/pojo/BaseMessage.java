package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : BaseMessage
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/6 19:21
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class BaseMessage {

    private String ToUserName;                       // 开发者微信号


    private String FromUserName;                     // 发送方帐号（一个OpenID）


    private long CreateTime;                         // 消息创建时间 （整型）


    private String MsgType;                          // 消息类型（text/image/location/link）



    private int FuncFlag;                            // 位0x0001被标志时，星标刚收到的消息

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public void setFuncFlag(int funcFlag) {
        FuncFlag = funcFlag;
    }

    public String getToUserName() {

        return ToUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public int getFuncFlag() {
        return FuncFlag;
    }
}
