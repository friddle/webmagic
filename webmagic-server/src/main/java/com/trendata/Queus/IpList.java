package com.trendata.Queus;

import com.trendata.Queus.Entity.IpEntity;
import com.trendata.Queus.Interface.IpListInterface;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * just to keep two things,ip and ip block list
 * keep refresh the ip list
 * Created by friddle on 12/10/14.
 */
public class IpList implements IpListInterface{
	public ConcurrentLinkedQueue ipListQueue;

	@Override
	public boolean addIp(IpEntity ip) {
		return false;
	}

	@Override
	public String getAvaiableIp(String url) {
		return null;
	}

	@Override
	public String setIpBlockUrl(String url, String blockip) {
		return null;
	}

	@Override
	public boolean initIps(List<IpEntity> ipconfigs)
	{
		return true;
	}

	@Override
	public boolean refreshIps(List<IpEntity> ipconfigs)
	{
		return true;
	}
}
