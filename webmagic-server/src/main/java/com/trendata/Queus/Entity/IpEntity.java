package com.trendata.Queus.Entity;

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
	public synchronized void addblockUrl(String url)
	{

	}

	public IpEntity(String ip)
	{

	}

	public boolean isUrlOk(String url)
	{
	  //remember to refresh the url
	  //check the timeout
      return true;
	}
}
