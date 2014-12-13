package com.trendata.Queus;

import com.trendata.Queus.Entity.JobEntity;
import com.trendata.Queus.Entity.Machine;
import com.trendata.Queus.Interface.JobQueueInterface;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by friddle on 12/10/14.
 * remember to add system
 */
public class JobQueues implements JobQueueInterface{
	public static ConcurrentLinkedDeque<JobEntity> jobLinkedDeque;
	public static JobQueues jobQueues;
	public static synchronized JobQueues getJobQueues()
	{
	  if(jobQueues==null)
	  {
		  jobLinkedDeque=new ConcurrentLinkedDeque<JobEntity>();
		  jobQueues=new JobQueues();
	  }
	  return jobQueues;
	}

	@Override
	public JobEntity popEntity(Machine machine) {
		return null;
	}

	@Override
	public void pushEntity(JobEntity entity) {

	}
}
