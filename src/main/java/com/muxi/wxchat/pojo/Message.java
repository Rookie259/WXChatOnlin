package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : Message
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 11:16
 *@描述 : 请求信息对应参数
 *@Version : 1.0
 *------------------------------
 */

public class Message extends BaseMessage {

    private String EventKey;

    private String Event;


    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public void setEvent(String event) {
        Event = event;
    }


    public String getEventKey() {
        return EventKey;
    }

    public String getEvent() {
        return Event;
    }
}
