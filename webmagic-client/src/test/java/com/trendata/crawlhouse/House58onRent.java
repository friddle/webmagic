package com.trendata.crawlhouse;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by friddle on 12/16/14.
 */
public class House58onRent implements PageProcessor{
	@Override
	public void process(Page page) {
		try
		{
		String title=page.getHtml().xpath("//div[@class=\"bigtitle\"]/h1/text()").toString();
		String price=page.getHtml().xpath("//div[@class=\"liv0\"]/allText()").toString();
		String id=page.getHtml().xpath("//li[@class=bianhao]/text()").regex("\\d+").toString();
		String time=page.getHtml().xpath("//li[@class=time]/text()").toString();
		splitTags(page.getHtml().xpath("//ul[@class=\"suUI\"]/li[1]/div[@class=\"su_con\"]/text()").toString());
		String floors=page.getHtml().xpath("//ul[@class=\"suUI\"]/li[2]/div[@class=\"su_con\"]/text()").toString();
		String location=page.getHtml().xpath("//div[@class=\"su_con w382\"]/a/allText()").toString();
		String phone=page.getHtml().xpath("//span[@id=tphone]/text()").toString();
		String tags=page.getHtml().xpath("//div[@class=\"peizhi\"]/allText()").toString();
		//for the user
		}
		catch(Exception e)
		{
			System.out.println(page.getUrl());
		}

	}

	public void getJJR(Page page)
	{
		String name=page.getHtml().xpath("//div[@id=\"side\"]//li[@class=\"li_jjrname\"]").toString();
		String company=page.getHtml().xpath("//div[@id=\"side\"]//ul[@class=\"jjrbot\"]/li[0]/text()").toString()

	}

	public void translateFormat(String location)
	{

	}

	public void splitTags(String tags)
	{
		String[] infos=tags.split("\\s+");
	}


	@Override
	public Site getSite() {
		return null;
	}
	public static void main(String[] args)
	{
		Spider.create(new House58onRent()).addUrl("http://hz.58.com/zufang/20249162005639x.shtml?ecspm=0jYQFhnqEbcvP1EOrNPawN7DnbmzwbNznNcOn17aEbE1nHELENcQPjD3P1c3PHbQPHDz&PGTID=14187285931680.8720294990274082&ClickID=0").start();
	}
}
