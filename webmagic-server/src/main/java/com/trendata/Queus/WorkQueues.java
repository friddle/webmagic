package com.trendata.Queus;

import com.trendata.Queus.Entity.WorkEntity;
import com.trendata.Queus.Entity.WorkStateEntity;
import com.trendata.Queus.Interface.JobQueueInterface;
import com.trendata.Queus.Interface.UrlRuleInterface;
import com.trendata.Queus.Interface.WorkQueuePipeline;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Created by friddle on 12/10/14.
 * the WorkQueues contains different kind of type of url to one hostname
 * when client invoke the Interface ,so url add to distinct WorkQueues,And WorkQueues keep it,url,crawl status.use time,hash.....
 * do not let the upper to modify the WorkQueue
 */
public class WorkQueues {
	public static ConcurrentHashMap<String,WorkQueues> mQueues;
	public String hostname;
	static Logger logger= Logger.getLogger("WorkQueues");
	public JobQueueInterface job;
	public WorkQueuePipeline pipeline;
	public UrlRuleInterface rules;
	public ConcurrentHashMap<String,WorkEntity> worklist;

	/**
	 * @param hostname
	 * @param States
	 * @return  the states numbers
	 */
	public static int getJobStatesNum(String hostname,int States)
	{
		return 0;
	}

	public WorkQueues(String hostname)
	{
		this.hostname=hostname;
		this.job=JobQueues.getJobQueues();
		this.pipeline=new WorkQueueDatabase();
	}


	public synchronized void clearJobs()
	{
		worklist.clear();
	}

	public void setUnsupportedMachine(String machinehost)
	{
		MachineList.setBlockList(this.hostname,machinehost);
	}



	public synchronized void addNewJob(String url)
	{
		WorkEntity mEntity=new WorkEntity();
		mEntity.processname= rules.getProcessName(url);
		mEntity.pipename= rules.getPipelineName(url);
		mEntity.entityname= rules.getEntityName(url);
		mEntity.states= WorkStateEntity.begin;
		mEntity.timestamp=new Timestamp(new Date().getTime());
		mEntity.hostname=this.hostname;
		mEntity.url=url;
		worklist.put(url,mEntity);
		this.job.pushEntity(mEntity);
	}


	/**
	 * if the url work success,just remove it from hash and get it to pipeline
	 * else just change the state and keep it in the lists
	 * when failed times out of the max,just keep it be dead and aosl linked to pipeline
	 * @param entity
	 */
	public synchronized void checkResultJobs(List<WorkEntity> entity)
	{

	}
}
