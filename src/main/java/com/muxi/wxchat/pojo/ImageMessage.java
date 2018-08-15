package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : ImageMessage
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/6 19:33
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class ImageMessage extends BaseMessage{

    private String PicUrl;   //图片url


    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getPicUrl() {

        return PicUrl;
    }
}
