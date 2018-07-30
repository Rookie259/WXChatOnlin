package com.muxi.wxchat.pojo.button;


/*
 *------------------------------.
 *@ClassName : CommonButton
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 1:34
 *@描述 : 二级菜单
 *@Version : 1.0
 *------------------------------
 */

public class CommonButton extends Button{

    private String type;

    private String key;

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {

        return type;
    }

    public String getKey() {
        return key;
    }
}
