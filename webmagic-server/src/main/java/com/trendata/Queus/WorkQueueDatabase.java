package com.trendata.Queus;

import com.trendata.Queus.Entity.WorkEntity;
import com.trendata.Queus.Interface.WorkQueuePipeline;

/**
 * Created by friddle on 12/14/14.
 */
public class WorkQueueDatabase implements WorkQueuePipeline{

	@Override
	public void addJobToDatabase(WorkEntity entity) {

	}

	@Override
	public void updateJobStats(WorkEntity entity) {

	}
}
