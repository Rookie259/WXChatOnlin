package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu;


import com.muxi.wxchat.pojo.ImageTextArticleListPojo;
import com.muxi.wxchat.pojo.MessageText;

import java.util.List;

/*
 *------------------------------.
 *@ClassName : ImageTextAriticle
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/3 22:06
 *@描述 : 图文信息发送
 *@Version : 1.0
 *------------------------------
 */
public interface ImageTextAriticle {



    /*创建图文信息*/
    public ImageTextArticleListPojo creatImageTextInformation(MessageText messageText, Integer coord);

    /*创建单图文信息*/
    public ImageTextArticleListPojo creatSingleImageTextInformation(MessageText messageText, Integer coord);

    /*创建单图文信息   不含图片*/
    public void createSingleTextInformation();

    /*创建多图文信息*/
    public void createManyImageTextInformation();

    /*创建多图文信息  首条信息不含图片*/
    public void createManyHeadNoImageTextInformation();

    /*创建多图文信息  最后一条不含图片*/
    public void createManyLastNoImageTextInformation();

}
