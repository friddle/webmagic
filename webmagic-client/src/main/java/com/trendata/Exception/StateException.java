package com.trendata.Exception;

/**
 * Created by friddle on 12/10/14.
 */
public class StateException extends Exception{
	public int states;
	public String errormessage;

	public StateException(int state,String errormessage)
	{
		super(errormessage);
		this.states=state;
		this.errormessage=errormessage;
	}

	public int getStates()
	{
		 return states;
	}

	public String getErrorMessage()
	{
		return errormessage;
	}

}
