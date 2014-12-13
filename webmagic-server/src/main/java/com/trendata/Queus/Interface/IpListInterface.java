package com.trendata.Queus.Interface;

import com.trendata.Queus.Entity.IpEntity;

import java.util.List;

/**
 * Created by friddle on 12/10/14.
 */
public interface IpListInterface {
	public  boolean addIp(IpEntity ip);
	public  String getAvaiableIp(String url);
	public  String setIpBlockUrl(String url,String blockip);
	public  boolean initIps(List<IpEntity> ips);
	public  boolean refreshIps(List<IpEntity> ips);
}
