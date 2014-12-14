package com.trendata.Queus.Entity;

import java.sql.Timestamp;

/**
 * Created by friddle on 12/10/14.
 * the machinename must be argument to machine host
 */
public class WorkEntity extends JobEntity{
	public int states;
	public String errormessage;
	public Timestamp timestamp;
	public int TryTimes;
}
