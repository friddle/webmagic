package com.trendata.Queus.Interface;

import com.trendata.Queus.Entity.JobEntity;
import com.trendata.Queus.Entity.Machine;

/**
 * Created by friddle on 12/10/14.
 */
public interface JobQueueInterface {
	public JobEntity popEntity(Machine machine) ;
	public void pushEntity(JobEntity entity);
}
