package com.muxi.wxchat.function.menu;


/*
 *------------------------------.
 *@ClassName : MenuManager
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 1:37
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.pojo.button.Button;
import com.muxi.wxchat.pojo.button.CommonButton;
import com.muxi.wxchat.pojo.button.ComplexButton;
import com.muxi.wxchat.pojo.menu.Menu;

public class MenuManager {

    public Menu getMenu()
    {
        CommonButton Menu_Vice_Current_Events = new CommonButton();
        Menu_Vice_Current_Events.setName("时讯信息");
        Menu_Vice_Current_Events.setType("click");
        Menu_Vice_Current_Events.setKey("Current_Events");

        CommonButton Menu_Vice__Shark = new CommonButton();
        Menu_Vice__Shark.setName("摇一摇");
        Menu_Vice__Shark.setType("click");
        Menu_Vice__Shark.setKey("Shark");

        CommonButton Menu_Vice__Apes_Lives = new CommonButton();
        Menu_Vice__Apes_Lives.setName("猿生活");
        Menu_Vice__Apes_Lives.setType("click");
        Menu_Vice__Apes_Lives.setKey("Apes_Lives");

        CommonButton Menu_Vice__Receive = new CommonButton();
        Menu_Vice__Receive.setName("干货领取");
        Menu_Vice__Receive.setType("click");
        Menu_Vice__Receive.setKey("Receive");

        CommonButton Menu_Vic_Receive_Roman_Road = new CommonButton();
        Menu_Vic_Receive_Roman_Road.setName("罗马大道");
        Menu_Vic_Receive_Roman_Road.setType("click");
        Menu_Vic_Receive_Roman_Road.setKey("Roman_Road");

        CommonButton  Menu_Vice_Mentoring_Introduced = new CommonButton();
        Menu_Vice_Mentoring_Introduced.setName("师徒介绍");
        Menu_Vice_Mentoring_Introduced.setType("click");
        Menu_Vice_Mentoring_Introduced.setKey("Mentoring_Introduced");


        ComplexButton Menu_Main_Special_Topic = new ComplexButton();
        Menu_Main_Special_Topic.setName("精彩推荐");
        Menu_Main_Special_Topic.setSub_button(new CommonButton[] { Menu_Vice_Current_Events, Menu_Vice__Shark, Menu_Vice__Apes_Lives});

        ComplexButton Menu_MainIT_Governance_Institute = new ComplexButton();
        Menu_MainIT_Governance_Institute.setName("IT学院");
        Menu_MainIT_Governance_Institute.setSub_button(new CommonButton[] { Menu_Vice__Receive, Menu_Vic_Receive_Roman_Road, Menu_Vice_Mentoring_Introduced});

        /*待定菜单主题*/
        ComplexButton Menu_MainUndetermined  = new ComplexButton();
        Menu_MainUndetermined.setName("更多体验");
        Menu_MainUndetermined.setSub_button(null);

        Menu menu = new Menu();
        menu.setButton(new Button[] { Menu_Main_Special_Topic, Menu_MainIT_Governance_Institute, Menu_MainUndetermined });

        return menu;
    }
}
