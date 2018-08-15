package com.muxi.wxchat.pojo.WXPOJO;


/*
 *------------------------------.
 *@ClassName : WxAttentionUser
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 0:15
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

public class WxAttentionUser {

    private String wxattenid;                       //微信用户ID

    private String wxoppenid;                       //微信关注者唯一标识

    private String wxnickname;                      //微信用户昵称

    private Integer wxsex;                           //微信用户性别  1是男性，2是女性，0是未知

    private String wxcity;                          //微信用户城市

    private String wxcountry;                       //微信用户城市

    private String wxprovince;                      //微信用户省份

    private String wxlanguage;                      //微信用户语言

    private String wxheadimgurl;                    //微信用户头像

    private String wxsubscribetime;                 //微信用户关注时间

    private String wxunionid;                       //用户绑定公众号

    private String wxremark;                        //微信公众号对粉丝备注

    private String wxgroupid;                       //用户所在的分组ID

    private Integer wxsubscribe;                    // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息

    public void setWxsubscribe(Integer wxsubscribe) {
        this.wxsubscribe = wxsubscribe;
    }

    public Integer getWxsubscribe() {

        return wxsubscribe;
    }

    public void setWxattenid(String wxattenid) {
        this.wxattenid = wxattenid;
    }

    public void setWxoppenid(String wxoppenid) {
        this.wxoppenid = wxoppenid;
    }

    public void setWxnickname(String wxnickname) {
        this.wxnickname = wxnickname;
    }

    public void setWxsex(Integer wxsex) {
        this.wxsex = wxsex;
    }

    public void setWxcity(String wxcity) {
        this.wxcity = wxcity;
    }

    public void setWxcountry(String wxcountry) {
        this.wxcountry = wxcountry;
    }

    public void setWxprovince(String wxprovince) {
        this.wxprovince = wxprovince;
    }

    public void setWxlanguage(String wxlanguage) {
        this.wxlanguage = wxlanguage;
    }

    public void setWxheadimgurl(String wxheadimgurl) {
        this.wxheadimgurl = wxheadimgurl;
    }

    public void setWxsubscribetime(String wxsubscribetime) {
        this.wxsubscribetime = wxsubscribetime;
    }

    public void setWxunionid(String wxunionid) {
        this.wxunionid = wxunionid;
    }

    public void setWxremark(String wxremark) {
        this.wxremark = wxremark;
    }

    public void setWxgroupid(String wxgroupid) {
        this.wxgroupid = wxgroupid;
    }

    public String getWxattenid() {

        return wxattenid;
    }

    public String getWxoppenid() {
        return wxoppenid;
    }

    public String getWxnickname() {
        return wxnickname;
    }

    public Integer getWxsex() {
        return wxsex;
    }

    public String getWxcity() {
        return wxcity;
    }

    public String getWxcountry() {
        return wxcountry;
    }

    public String getWxprovince() {
        return wxprovince;
    }

    public String getWxlanguage() {
        return wxlanguage;
    }

    public String getWxheadimgurl() {
        return wxheadimgurl;
    }

    public String getWxsubscribetime() {
        return wxsubscribetime;
    }

    public String getWxunionid() {
        return wxunionid;
    }

    public String getWxremark() {
        return wxremark;
    }

    public String getWxgroupid() {
        return wxgroupid;
    }

    @Override
    public String toString() {
        return "WxAttentionUser{" +
                "wxattenid='" + wxattenid + '\'' +
                ", wxoppenid='" + wxoppenid + '\'' +
                ", wxnickname='" + wxnickname + '\'' +
                ", wxsex=" + wxsex +
                ", wxcity='" + wxcity + '\'' +
                ", wxcountry='" + wxcountry + '\'' +
                ", wxprovince='" + wxprovince + '\'' +
                ", wxlanguage='" + wxlanguage + '\'' +
                ", wxheadimgurl='" + wxheadimgurl + '\'' +
                ", wxsubscribetime='" + wxsubscribetime + '\'' +
                ", wxunionid='" + wxunionid + '\'' +
                ", wxremark='" + wxremark + '\'' +
                ", wxgroupid='" + wxgroupid + '\'' +
                ", wxsubscribe=" + wxsubscribe +
                '}';
    }
}
