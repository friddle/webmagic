package com.trendata.work;


import com.trendata.distribution.DistributionProcess;
import com.trendata.distribution.DistributionScheduler;
import com.trendata.entity.WorkEntity;
import com.trendata.entity.WorkState;
import com.trendata.exceptions.StateException;
import com.trendata.util.HashFunc;
import com.trendata.util.HttpFunc;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

/**
 * two type,if variable use process you can't construct with any paramater,
 * the one type must contains process
 */

/**
 *  There must be a Main Process alaways run
 *  the process use WorkProcess do the job
 *  when job finish!
 */

public class WorkProcess implements DistributionScheduler{
	static ConcurrentLinkedQueue<WorkProcess> workprocess=new ConcurrentLinkedQueue();
	volatile ConcurrentLinkedQueue<WorkEntity> newurls=new ConcurrentLinkedQueue<WorkEntity>();
	volatile ConcurrentHashMap<String,WorkEntity> finishurls=new ConcurrentHashMap<String,WorkEntity>();

	public void createSpiderByProcess(String processname,List<String> urls,Site mSite) throws StateException
	{
		Logger logger= Logger.getLogger(this.getClass().getName());
		try
		{
			Class<?> c = Class.forName(processname);
			Constructor<?> cons = c.getConstructor();
			DistributionProcess object = (DistributionProcess)cons.newInstance();
			object.setSite(mSite);
			Spider spider= Spider.create((PageProcessor) object);
			for(String url:urls)
			{
				 spider.addUrl(url);
			}
			spider.run();
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			throw new StateException(WorkState.unsupport,e.getMessage().toString()+" not found");
		}
	}

	public void createSpiderByEntity(String entity,String pipeline,List<String> urls,Site mSite) throws StateException
	{
		Logger logger= Logger.getLogger(this.getClass().getName());
		try
		{
			Class centity = Class.forName(entity);
			Class<?> cpipeline = Class.forName(pipeline);
			Constructor<?> conpipeline = cpipeline.getConstructor();
		    PageModelPipeline pipeobject = (PageModelPipeline)conpipeline.newInstance();
			for(String url:urls)
			{
				mSite.addStartUrl(url);
			}
		    //DistributionSpider.create(mSite, pipeobject, centity).run();
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
			throw new StateException(WorkState.unsupport,e.getMessage().toString()+" not found");
		}
	}


	/**
	 * if ip is null,mean the ip is the host ip
	 * @param url
	 * @param timestamp
	 */

	@Override
	public void addFinishDistributionUrl(String url,Timestamp timestamp) {
		WorkEntity mEntity=new WorkEntity();
		mEntity.url=url;
		mEntity.hostname= HttpFunc.getHosts();
		mEntity.states= WorkState.finsh;
		mEntity.hash= HashFunc.HashFunc(url);
		mEntity.timestamp=timestamp;
	}

	@Override
	public void updateErrorToFinshUrl(String url, int errorstate, String errormessage) {
		WorkEntity mEntity=finishurls.get(url);
	}

	@Override
	public void addFailedDistributionUrl(String url, String errormessage, int states) {
		WorkEntity mEntity=new WorkEntity();
		mEntity.url=url;
		mEntity.hostname= HttpFunc.getHosts();
		mEntity.states= WorkState.finsh;
		mEntity.hash= HashFunc.HashFunc(url);
		mEntity.errormessage=errormessage;
		mEntity.states=states;
	}

	@Override
	public void addNewDistributionUrl(String url) {

	}

	@Override
	public void onFinish() {
	}

	public List<WorkEntity> getFinishUrls()
	{
		return null;
	}
	public List<WorkEntity> getAllNewUrls()
	{
		return null;
	}
}