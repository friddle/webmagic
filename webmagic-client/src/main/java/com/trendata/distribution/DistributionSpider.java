package com.trendata.distribution;

import org.apache.http.impl.client.CloseableHttpClient;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by friddle on 12/11/14.
 * Can't extends OOSpider,because something can't use it
 */
public class DistributionSpider<T> extends Spider {

	private DistributionScheduler distributionscheduler;

	public DistributionSpider(Site site,PageProcessor pageProcessor){
		super(pageProcessor, site);
	}

	public static DistributionSpider create(Site site, PageProcessor processor,DistributionSpider scheduler) {
		DistributionSpider spider=new DistributionSpider(site, processor);
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


    @Override
  protected void processRequest(Request request) {
        Page page = downloader.download(request, this);
        if (page == null) {
            sleep(site.getSleepTime());
            onError(request);
            return;
        }
        // for cycle retry
        if (page.isNeedCycleRetry()) {
            extractAndAddRequests(page, true);
            sleep(site.getSleepTime());
            return;
        }
        pageProcessor.process(page);
        extractAndAddRequests(page, spawnUrl);
        if (!page.getResultItems().isSkip()) {
            for (Pipeline pipeline : pipelines) {
                pipeline.process(page.getResultItems(), this);
            }
        }
        //for proxy status management
        request.putExtra(Request.STATUS_CODE, page.getStatusCode());
        sleep(site.getSleepTime());
    }

}
