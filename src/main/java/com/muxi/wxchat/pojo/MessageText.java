package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : MessageText
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 11:26
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class MessageText extends  BaseMessage{

    private String Content;//文本消息内容

    public MessageText() {
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getContent() {

        return Content;
    }
}
