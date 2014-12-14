package com.trendata.Queus;

import com.trendata.Queus.Entity.IpEntity;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * just to keep two things,ip and ip block list
 * keep refresh the ip list
 * Created by friddle on 12/10/14.
 */
public class IpList {
	public static volatile ConcurrentLinkedQueue ipListQueue;

	public static boolean addIp(IpEntity ip) {
		return false;
	}

	public static String getAvaiableIp(String url) {
		return null;
	}

	public static String setIpBlockUrl(String url, String blockip) {
		return null;
	}
	public static boolean initIps(List<IpEntity> ipconfigs)
	{
		return true;
	}
	public static boolean refreshIps(List<IpEntity> ipconfigs)
	{
		return true;
	}
}
