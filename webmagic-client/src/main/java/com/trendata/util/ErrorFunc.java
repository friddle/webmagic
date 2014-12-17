package com.trendata.util;

import com.trendata.entity.ErrorType;

/**
 * Created by friddle on 12/16/14.
 */
public class ErrorFunc {
	public static  int getErrorTypeByStates(int codestatus)
	{
		if(codestatus==404)
		{
			return com.trendata.entity.ErrorType.error404;
		}
		else if(codestatus==502||codestatus==500)
		{
			return com.trendata.entity.ErrorType.clenterror;
		}
		else if(codestatus==130)
		{
			 return ErrorType.proxydead;
		}
		return 0;
	}
	public static int getErrorTypeByException(Exception e)
	{
		if(e.getMessage().contains("Connection refused"))
		{
			return ErrorType.proxydead;
		}
		return 0;
	}
}
