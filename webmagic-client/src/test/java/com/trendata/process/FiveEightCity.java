package com.trendata.process;

import com.trendata.distribution.DistributionProcess;
import com.trendata.pipeline.OrmPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by friddle on 12/10/14.
 */
public class FiveEightCity extends DistributionProcess implements PageProcessor{
	@Override
	public void process(Page page) {
		OrmPipeline mPipeline=new OrmPipeline();
		System.out.println(page.getHtml());
	}
	@Override
	public Site getSite() {
	return this.site;
	}
}
