package com.trendata.distribution;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * provide function to processObject(object,type)
 * provide function to addNewUrl()
 * provide function to addFailedUrl()
 * Created by friddle on 12/10/14.
 */
public abstract class DistributionProcess implements PageProcessor {
    public DistributionScheduler scheduler;
    public Site site;
    public List<DistributionPipeline> pipelines;
	public ConcurrentLinkedQueue<String> urls=new ConcurrentLinkedQueue<String>();
	public void setSite(Site site) {this.site=site;}
	public Site getSite()
	{
		return this.site;
	}
    public void addPipeline(DistributionPipeline pipeline)
    {
       pipelines.add(pipeline);
    }
    public void processObject(Object object,Class type) throws Exception {
        for(DistributionPipeline pipeline:pipelines)
        {
            pipeline.process(object,type);
        }
    }
    public void setDistributionScheduler(DistributionScheduler scheduler)
	{
		this.scheduler=scheduler;
	}
    public void addNewDistributionUrl(String url)
	{
		this.scheduler.addNewDistributionUrl(url);
	}
	public void onfailed(String url,String message,int code)
	{
		this.scheduler.updateErrorToFinshUrl(url,code,message);
	}
}
