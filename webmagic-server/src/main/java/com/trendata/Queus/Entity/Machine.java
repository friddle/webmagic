package com.trendata.Queus.Entity;


import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by friddle on 12/10/14.
 */
	public class Machine
	{
		public String machine_id;
		public String ip_host;
		public String ip_port;
		public String host_name;
		public Timestamp last_time;
		public int threadnums;
		public Map<String,Timestamp> blocklists;
	}

