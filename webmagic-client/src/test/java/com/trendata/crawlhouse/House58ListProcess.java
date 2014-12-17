package com.trendata.crawlhouse;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.HashMap;

/**
 * Created by friddle on 12/16/14.
 */
public class House58ListProcess implements PageProcessor{
	@Override
	public void process(Page page) {
		HashMap<String,String> maps=new HashMap<String,String>();
		int i=0;
		for(String item:page.getHtml().xpath("//tbody/tr").all())
		{
			i++;
			Html itemhtml=new Html(item);
			String url=itemhtml.xpath("//a[@class=\"t\"]/@href").toString();
			maps.put(String.valueOf(i),url);
		}
		String nextpage=page.getHtml().xpath("//div[@class=pager]/a[@class=\"next\"]/@href").toString();
	}


	@Override
	public Site getSite() {
		return Site.me();
	}

	public static void main(String[] args)
	{
		Spider.create(new House58ListProcess()).addUrl("http://hz.58.com/ershoufang/").start();
	}

}
