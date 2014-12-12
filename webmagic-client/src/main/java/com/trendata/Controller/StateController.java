package com.trendata.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by friddle on 12/10/14.
 */

public class StateController {
	@RequestMapping(value="/getres")
	@ResponseBody
	public String StateController()
	{
	    return "";
	}

}
