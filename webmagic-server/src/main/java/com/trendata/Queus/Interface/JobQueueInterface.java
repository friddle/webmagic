package com.trendata.Queus.Interface;

import com.trendata.Queus.Entity.JobEntity;
import com.trendata.Queus.Entity.Machine;

import java.util.ArrayList;

/**
 * Created by friddle on 12/10/14.
 */
public interface JobQueueInterface {
	public ArrayList<JobEntity> popEntity(Machine machine,int nums) ;
	public void pushEntity(JobEntity entity);
}
