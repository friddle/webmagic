package com.trendata.Queus.Interface;

/**
 * Created by friddle on 12/14/14.
 */
public interface UrlRuleInterface {
	public String getEntityName(String url);
	public String getProcessName(String url);
	public String getPipelineName(String url);
}
