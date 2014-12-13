package com.trendata.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by friddle on 12/10/14.
 */

@Controller
public class ClientProvider {

	/**
	 * request paramaters must contains "last url hash,last url states,last use time,must be list"
	 * return must be contains "pipename","classname","urlhash","url","ips"
	 */
	@ResponseBody
	@RequestMapping(value="/getAvailableTask")
	public String getAvailableTask(HttpServletRequest request)
	{
		return "";
	}

	@RequestMapping(value="/getDefaultSettings")
	@ResponseBody
	public String getDefaultSettings(HttpServletRequest request)
	{
		return "";
	}
}
