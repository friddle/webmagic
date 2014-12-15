package com.trendata.distribution;

import org.apache.http.HttpHost;

import java.net.HttpCookie;
import java.util.HashMap;


/**
 * this DistributionSetting interface must for download to use it
 * the most of the part can be used by Site
 * so how to do it?set the site?
 */
@Deprecated
public interface DistributionSetting {
	public HttpHost getHttpProxy();
	public int getSleepTime();
	public HttpCookie getCookies();
	public HashMap<String,String> getHttpParameter();
	public boolean isJsRendering();
}
