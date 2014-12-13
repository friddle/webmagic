package com.trendata.Queus.Entity;

import java.sql.Timestamp;

/**
 * Created by friddle on 12/10/14.
 */
public class WorkEntity extends JobEntity{
	public String hostname;
	public int states;
	public String errormessage;
	public Timestamp timestamp;
	public int TryTimes;
}
