package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : LocationMessage
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/6 19:34
 *@描述 : 请求地位置
 *@Version : 1.0
 *------------------------------
 */

public class LocationMessage extends BaseMessage {

    private String Location_X;                // 地理位置维度

    private String Location_Y;                // 地理位置经度

    private String Scale;                     // 地图缩放大小

    private String labellocation;              // 地理位置信息

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public void setLabellocation(String labellocation) {
        this.labellocation = labellocation;
    }

    public String getLocation_X() {

        return Location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public String getLabellocation() {
        return labellocation;
    }
}
