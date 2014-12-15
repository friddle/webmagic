package com.trendata.distribution;

import java.sql.Timestamp;

/**
 * one scheduler cross the three place,Spider,Process,And the Downloader-->ErrorCode.
 * Created by friddle on 12/11/14.
 */
public interface DistributionScheduler {
	public void addFinishDistributionUrl(String url,Timestamp timestamp);
	public void updateErrorToFinshUrl(String url,int errorstate,String errormessage);
	public void addFailedDistributionUrl(String url,String error,int states);
	public void addNewDistributionUrl(String url);
	public void onFinish();
}
