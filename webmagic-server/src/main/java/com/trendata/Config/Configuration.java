package com.trendata.Config;

/**
 * Created by friddle on 12/10/14.
 */
public class Configuration {

	public static class MySQLConfig
	{
		private static String url="";
		private static String user="";
		private static String password="";
		private static String database="";

		public synchronized void setMySQLConf(String url,String user,String password,String database)
		{
			this.url=url;
			this.user=user;
			this.password=password;
			this.database=database;
		}
	}

}
