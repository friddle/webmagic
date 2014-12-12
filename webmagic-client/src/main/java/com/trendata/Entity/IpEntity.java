package com.trendata.Entity;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Created by friddle on 12/10/14.
 */
public class IpEntity {
	public HashMap<String,Timestamp> blockurls;
	public String ip;
	public String user;
	public String passwd;
	public String port;
	public int state;

	public class IpState
	{
		public static final int new_ip=1;
		public static final int work=2;
		public static final int failed=4;
		public static final int timeout=5;
		public static final int dead=4;
	}

	public synchronized void addblockUrl(String hostname)
	{

	}
	public IpEntity(String ip,String user,String passwd,String port)
	{

	}

	public boolean isUrlOk(String url)
	{
	  //remember to refresh the url
	  //check the timeout
      return true;
	}
}
