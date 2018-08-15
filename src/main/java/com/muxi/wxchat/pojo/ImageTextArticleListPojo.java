package com.muxi.wxchat.pojo;


/*
 *------------------------------.
 *@ClassName : ImageTextInformation
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/3 22:12
 *@描述 : 图文信息
 *@Version : 1.0
 *------------------------------
 */

import java.util.List;
public class ImageTextArticleListPojo extends BaseMessage{


    private Integer ArticleCount;       //图文消息个数 最多10个

    private List<ImageTextAriticlePojo> Articles;           //多条图文信息  默认第一个item为大图


    public void setArticleCount(Integer ariticleCount) {
        ArticleCount = ariticleCount;
    }

    public void setArticles(List<ImageTextAriticlePojo> articles) {
        Articles = articles;
    }

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public List<ImageTextAriticlePojo> getArticles() {
        return Articles;
    }
}
