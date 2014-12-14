package com.trendata.Queus.Interface;

import com.trendata.Queus.Entity.WorkEntity;

/**
 * Created by friddle on 12/14/14.
 */
public interface WorkQueuePipeline {
	public void addJobToDatabase(WorkEntity entity);
	public void updateJobStats(WorkEntity entity);
}
