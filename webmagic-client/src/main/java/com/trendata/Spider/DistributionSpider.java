package com.trendata.Spider;

import com.trendata.Interface.DistributionScheduler;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by friddle on 12/11/14.
 * Can't extends OOSpider,because something can't use it
 */
public class DistributionSpider<T> extends OOSpider {

	private DistributionScheduler distributionscheduler;

	/**
	 * create a spider
	 *
	 * @param site
	 * @param pageModelPipeline
	 * @param pageModels
	 */
	public DistributionSpider(Site site, PageModelPipeline pageModelPipeline, Class... pageModels) {
		super(site,pageModelPipeline,pageModels);
	}

	public static DistributionSpider create(Site site, PageModelPipeline pageModelPipeline, DistributionSpider scheduler,Class... pageModels) {
		DistributionSpider spider=new DistributionSpider(site, pageModelPipeline, pageModels);
		spider.setSpiderListeners(spider.getSpiderListeners());
		return spider;
	}

	@Override
	public void close()
	{
		super.close();
		DistributionSpider.this.distributionscheduler.onFinish();
	}

	public  List<SpiderListener> getSpiderListener()
	{
		SpiderListener mListener=new SpiderListener() {
			@Override
			public void onSuccess(Request request) {
				DistributionSpider.this.distributionscheduler.addFinishDistributionUrl(request.getUrl());
			}

			@Override
			public void onError(Request request) {
				DistributionSpider.this.distributionscheduler.addFailedDistributionUrl(request.getUrl(), "can't download", WorkStateEntity.faild);
			}
		};
		ArrayList<SpiderListener> mListeners=new ArrayList<SpiderListener>();
		mListeners.add(mListener);
		return mListeners;
	}
}
