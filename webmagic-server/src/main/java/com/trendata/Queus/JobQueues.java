package com.trendata.Queus;

import com.trendata.Queus.Entity.JobEntity;
import com.trendata.Queus.Entity.Machine;
import com.trendata.Queus.Interface.JobQueueInterface;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by friddle on 12/10/14.
 * remember to add system
 */

public class JobQueues implements JobQueueInterface{
	public volatile static ConcurrentLinkedQueue<JobEntity> jobLinkedQueue;
	public static JobQueues jobQueues;
	public static synchronized JobQueues getJobQueues()
	{
	  if(jobQueues==null)
	  {
		  jobLinkedQueue=new ConcurrentLinkedQueue<JobEntity>();
		  jobQueues=new JobQueues();
	  }
	  return jobQueues;
	}

	/**
	 * judge all the hosts,if one host is zero,
	 * if all the host is 1.so clear it
	 */
	@Override
	public ArrayList<JobEntity> popEntity(Machine machine,int nums) {
		ArrayList<JobEntity> entitys=new ArrayList<JobEntity>();
		if(jobLinkedQueue.isEmpty())
		{
			return null;
		}
		else if(jobLinkedQueue.size()<=nums)
		{
			return popEntitys(machine,jobLinkedQueue.size());
		}
		else
		{
			return popEntitys(machine,nums);
		}
	}

	public ArrayList<JobEntity> popEntitys(Machine machine,int nums)
	{
		ArrayList<JobEntity> entitys=new ArrayList<JobEntity>();
		for(int i=0;i<nums;i++)
		{
			JobEntity entity=jobLinkedQueue.poll();
			if(MachineList.isBlock(machine,entity.url))
			{
				jobLinkedQueue.add(entity);
				continue;
			}
			entitys.add(entity);
		}
		return entitys;
	}


	//TODO:write the Random Queue to let it popout
	//just copy the currency HashMap
	@Override
	public void pushEntity(JobEntity entity) {
		jobLinkedQueue.add(entity);
	}
}
//




