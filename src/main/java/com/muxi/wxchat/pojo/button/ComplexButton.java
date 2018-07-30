package com.muxi.wxchat.pojo.button;


/*
 *------------------------------.
 *@ClassName : ComplexButton
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 1:35
 *@描述 : 一级菜单
 *@Version : 1.0
 *------------------------------
 */

public class ComplexButton extends Button{

    private Button[] sub_button;

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

    public Button[] getSub_button() {

        return sub_button;
    }
}
