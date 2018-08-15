package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : VoiceMessage
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/6 19:37
 *@描述 : 音频消息
 *@Version : 1.0
 *------------------------------
 */

public class VoiceMessage {

    private String MediaId;             // 媒体ID

    private String Format;              // 语音格式

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMediaId() {

        return MediaId;
    }

    public String getFormat() {
        return Format;
    }
}
