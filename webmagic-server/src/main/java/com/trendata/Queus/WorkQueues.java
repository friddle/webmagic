package com.trendata.Queus;

import com.trendata.Queus.Entity.Machine;
import com.trendata.Queus.Entity.WorkStateEntity;
import com.trendata.Queus.Interface.JobQueueInterface;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Created by friddle on 12/10/14.
 * the WorkQueues contains different kind of type of url to one hostname
 * when client invoke the Interface ,so url add to distinct WorkQueues,And WorkQueues keep it,urlcrawl status.use time,hash.....
 * and also judge the class by grep the hostname to choose the class
 *
 */
public class WorkQueues {
	public static ConcurrentHashMap<String,WorkQueues> mQueues;
	public String hostname;
	static Logger logger= Logger.getLogger("WorkQueues");
	public JobQueueInterface job;
	public ConcurrentHashMap<String,Machine> unsupport_list;

	public static boolean addJobs(String hostname,String url,int states)
	{
		if(mQueues.contains(hostname)==false)
		{
			try
			{
				mQueues.put(hostname,new WorkQueues(hostname));
			}
			catch(Exception e)
			{
				logger.info(e.getStackTrace().toString());
				logger.info("can't put to queues");
			}
		}
		if(states== WorkStateEntity.faild)
		{
			mQueues.get(hostname).addFailedJobs(url);
		}
		else
		{
			mQueues.get(hostname).addJobs(url);
		}
		return true;
	}

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
	}

	public synchronized  void clearStates()
	{

	}

	public synchronized  void setUnsupportedMachine()
	{

	}


	/**
	 * how to keep failed
	 *
	 */
	public synchronized  boolean addJobs(String url)
	{
		return true;
	}

	/**
	 * remeber try times set
	 * @return
	 */
	public synchronized boolean addFailedJobs(String url)
	{
		return true;
	}

}
