package com.muxi.wxchat.services.logicservices.createMenu.MenuFunctionImpl;


/*
 *------------------------------.
 *@ClassName : MenuFunctionImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 2:00
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.function.menu.CreateMenu;
import com.muxi.wxchat.function.menu.MenuManager;
import com.muxi.wxchat.pojo.AccessToken;
import com.muxi.wxchat.services.logicservices.createMenu.MenuFunction;
import com.muxi.wxchat.util.LoggerUtil;

public class MenuFunctionImpl implements MenuFunction {
    @Override
    public void createMenu(AccessToken accessToken) {
        if (null != accessToken) {
            MenuManager menuManager = new MenuManager();
            CreateMenu createMenu = new CreateMenu();
            int result = createMenu.createMenu(menuManager.getMenu(), accessToken.getToken());

            if (0 == result)
                LoggerUtil.setLogger("菜单创建成功");
            else {
                LoggerUtil.setLogger("菜单创建失败");
            }
        }
    }
}
