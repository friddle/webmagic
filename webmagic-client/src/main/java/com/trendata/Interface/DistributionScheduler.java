package com.trendata.Interface;

import java.sql.Timestamp;

/**
 * Created by friddle on 12/11/14.
 */
public interface DistributionScheduler {
	public void addFinishDistributionUrl(String url,Timestamp timestamp);
	public void addFailedDistributionUrl(String url,String errormessage,int states);
	public void addNewDistributionUrl(String url);
	public void onFinish();
}
