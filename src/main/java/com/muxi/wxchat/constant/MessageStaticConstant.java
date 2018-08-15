package com.muxi.wxchat.constant;


/*
 *------------------------------.
 *@ClassName : MessageStaticConstant
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 16:29
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class MessageStaticConstant {
    public static final String MESSAGE_TEXT = "text";             //请求消息类型：文本

    public static final String MESSAGE_IMAGE = "image";           //请求消息类型：图片

    public static final String MESSAGE_VOICE = "voice";           //响应消息类型：语音

    public static final String MESSAGE_VIDEO = "video";           //请求消息类型：视频

    public static final String MESSAGE_SHORTVIDEO = "shortvideo"; //请求消息类型：小视频

    public static final String MESSAGE_LINK = "link";             //请求消息类型：链接

    public static final String MESSAGE_LOCATION = "location";     //请求消息类型：地理位置

    public static final String MESSAGE_EVENT = "event";           //请求消息类型：事件推送

    public static final String EVENT_SUB = "subscribe";           //事件类型：subscribe(订阅)

    public static final String EVENT_UNSUB = "unsubscribe";       //事件类型：unsubscribe(取消订阅)

    public static final String EVENT_SCAN = "scan";               // 事件类型：scan(用户已关注时的扫描带参数二维码)

    public static final String EVENT_TYPE_LOCATION = "LOCATION";  // 事件类型：LOCATION(上报地理位置)

    public static final String EVENT_CLICK = "CLICK";             //事件类型：CLICK(自定义菜单)

    public static final String EVENT_VIEW = "VIEW";               //视图

    public static final String RESP_MESSAGE_TYPE_NEWS = "news";   //响应图文信息

}
