package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.aritificialMenuImpl;


/*
 *------------------------------.
 *@ClassName : informationProcessingCentreImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 17:26
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.AritificialMenu;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.ImageTextAriticle;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.InformationProcessingCentre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationProcessingCentreImpl implements InformationProcessingCentre {

    @Autowired
    private AritificialMenu aritificialMenu;

    @Autowired
    private ImageTextAriticle imageTextAriticle;

    @Override
    public String attentionReply(String param) {
        if(param.equals("1") || param.equals("2") || param.equals("3") || param.equals("4")){
            return aritificialMenu.fontBackOrg();
        }else if(param.equalsIgnoreCase("A") || param.equalsIgnoreCase("B") || param.equalsIgnoreCase("C") || param.equalsIgnoreCase("D")){
            return getCargoAssign(param);
        }else{
            return "noText";
        }
    }

    @Override
    public String getCargoAssign(String param) {
        return aritificialMenu.attentionReplyHandle(param);
    }
}
