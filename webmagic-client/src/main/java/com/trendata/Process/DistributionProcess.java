package com.trendata.Process;

import com.trendata.Entity.WorkStateEntity;
import com.trendata.Interface.DistributionScheduler;
import us.codecraft.webmagic.Site;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by friddle on 12/10/14.
 */
public class DistributionProcess {
	public ConcurrentLinkedQueue<String> urls=new ConcurrentLinkedQueue<String>();
	public DistributionScheduler scheduler;
	public Site site;
	public void setSite(Site site) {this.site=site;}
	public void setDistributionScheduler(DistributionScheduler scheduler)
	{
		this.scheduler=scheduler;
	}

	public void addNewDistributionUrl(String url)
	{
		this.scheduler.addNewDistributionUrl(url);
	}
	public void addFinishDistributionUrl(String url)
	{
		this.scheduler.addFinishDistributionUrl(url);
	}
	public void onfailed(String url)
	{
		this.scheduler.addFailedDistributionUrl(url,"can't dowload the url"+url, WorkStateEntity.faild);
	}
	public void onfinish()
	{
		this.scheduler.onFinish();
	}
}
