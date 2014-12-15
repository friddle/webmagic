package com.trendata.distribution;

import com.trendata.entity.WorkStateEntity;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.processor.PageProcessor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by friddle on 12/11/14.
 * Can't extends OOSpider,because something can't use it
 * DistributionSpider is deprecated because of some function must add to the Downloader
 */
public class DistributionSpider<T> extends Spider {

	private DistributionScheduler distributionscheduler;
	private DistributionDownloader downloader=new DistributionDownloader();

	public DistributionSpider(Site site,PageProcessor pageProcessor,DistributionScheduler scheduler){
		super(pageProcessor, site);
		this.distributionscheduler=scheduler;
		this.downloader.setSpiderListener(getSpiderListener());
		super.setDownloader(downloader);
	}


	public void setCaptch(CaptchSetting setting)
	{
		this.downloader.setCaptchSetting(setting);
	}

	public static DistributionSpider create(Site site, PageProcessor processor,DistributionScheduler scheduler) {
		DistributionSpider spider=new DistributionSpider(site, processor,scheduler);
		return spider;
	}

	@Override
	public void close()
	{
		super.close();
		DistributionSpider.this.distributionscheduler.onFinish();
	}

	public  SpiderListener getSpiderListener()
	{
		SpiderListener mListener=new SpiderListener() {
			@Override
			public void onSuccess(Request request) {
				DistributionSpider.this.distributionscheduler.addFinishDistributionUrl(request.getUrl(),new Timestamp(new Date().getTime()));
			}

			@Override
			public void onError(Request request) {
				DistributionSpider.this.distributionscheduler.addFailedDistributionUrl(request.getUrl(),request.getExtra(request.STATUS_CODE).toString(),WorkStateEntity.faild);
			}
		};
		return mListener;
	}
}
