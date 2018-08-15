package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.aritificialMenuImpl;


/*
 *------------------------------.
 *@ClassName : ImageTextAriticleImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/3 22:11
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.constant.MessageStaticConstant;
import com.muxi.wxchat.pojo.*;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.ImageTextAriticle;
import com.muxi.wxchat.util.MessageUtil;
import com.muxi.wxchat.util.XmlUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageTextAriticleImpl implements ImageTextAriticle {


    @Override
    public ImageTextArticleListPojo creatImageTextInformation(MessageText messageText, Integer coord) {
        /*后期 取数据库信息 存入*/
        List<ImageTextAriticlePojo> list = new ArrayList<ImageTextAriticlePojo>();

        ImageTextArticleListPojo imageTextInformation = new ImageTextArticleListPojo();
        imageTextInformation.setFromUserName(messageText.getToUserName());
        imageTextInformation.setToUserName(messageText.getFromUserName());
        imageTextInformation.setCreateTime(messageText.getCreateTime());
        imageTextInformation.setMsgType(MessageStaticConstant.RESP_MESSAGE_TYPE_NEWS);

        ImageTextAriticlePojo imageTextInformation0 = new ImageTextAriticlePojo();
        imageTextInformation0.setTitle("RookieBoy推送文章1\n引言");
        imageTextInformation0.setDescription("沐惜");
        imageTextInformation0.setPicUrl("http://wxchatonline1.oss-cn-hongkong.aliyuncs.com/%E5%9B%BE%E6%96%871.jpg");
        imageTextInformation0.setUrl("https://www.baidu.com");

        ImageTextAriticlePojo imageTextInformation1 = new ImageTextAriticlePojo();
        imageTextInformation1.setTitle("RookieBoy推送文章2\n引言");
        imageTextInformation1.setDescription("沐惜");
        imageTextInformation1.setPicUrl("http://wxchatonline1.oss-cn-hongkong.aliyuncs.com/%E5%9B%BE%E6%96%872.jpg");
        imageTextInformation1.setUrl("https://www.taobao.com/");

        ImageTextAriticlePojo imageTextInformation2 = new ImageTextAriticlePojo();
        imageTextInformation2.setTitle("RookieBoy推送文章3\n引言");
        imageTextInformation2.setDescription("沐惜");
        imageTextInformation2.setPicUrl("http://wxchatonline1.oss-cn-hongkong.aliyuncs.com/%E5%9B%BE%E6%96%873.jpg");
        imageTextInformation2.setUrl("https://www.taobao.net/");

        ImageTextAriticlePojo imageTextInformation3 = new ImageTextAriticlePojo();
        imageTextInformation3.setTitle("RookieBoy推送文章4\n引言");
        imageTextInformation3.setDescription("沐惜");
        imageTextInformation3.setPicUrl("http://wxchatonline1.oss-cn-hongkong.aliyuncs.com/%E5%9B%BE%E6%96%874.jpg");
        imageTextInformation3.setUrl("https://www.taobao.net/");

        list.add(imageTextInformation0);
        list.add(imageTextInformation1);
        list.add(imageTextInformation2);
        list.add(imageTextInformation3);

        imageTextInformation.setArticleCount(list.size());
        imageTextInformation.setArticles(list);


        return imageTextInformation;
    }



    @Override
    public ImageTextArticleListPojo creatSingleImageTextInformation(MessageText messageText, Integer coord) {
        /*后期 取数据库信息 存入*/
        List<ImageTextAriticlePojo> list = new ArrayList<ImageTextAriticlePojo>();

        ImageTextArticleListPojo imageTextInformation = new ImageTextArticleListPojo();
        imageTextInformation.setFromUserName(messageText.getToUserName());
        imageTextInformation.setToUserName(messageText.getFromUserName());
        imageTextInformation.setCreateTime(messageText.getCreateTime());
        imageTextInformation.setMsgType(MessageStaticConstant.RESP_MESSAGE_TYPE_NEWS);

        ImageTextAriticlePojo imageTextInformation0 = new ImageTextAriticlePojo();
        imageTextInformation0.setTitle("RookieBoy推送文章1\n引言");
        imageTextInformation0.setDescription("沐惜");
        imageTextInformation0.setPicUrl("http://f.hiphotos.baidu.com/image/pic/item/6159252dd42a283441d4d0dc50b5c9ea14cebff3.jpg");
        imageTextInformation0.setUrl("https://www.baidu.com");
        list.add(imageTextInformation0);
        imageTextInformation.setArticleCount(list.size());
        imageTextInformation.setArticles(list);


        return imageTextInformation;
    }

    @Override
    public void createSingleTextInformation() {

    }

    @Override
    public void createManyImageTextInformation() {

    }

    @Override
    public void createManyHeadNoImageTextInformation() {

    }

    @Override
    public void createManyLastNoImageTextInformation() {

    }
}
