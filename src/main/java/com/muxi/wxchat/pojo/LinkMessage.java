package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : LinkMessage
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/6 19:36
 *@描述 : 链接消息
 *@Version : 1.0
 *------------------------------
 */

public class LinkMessage {

    private String Title;                    // 消息标题

    private String Description;              // 消息描述

    private String Url;                     // 消息链接

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {

        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getUrl() {
        return Url;
    }
}
