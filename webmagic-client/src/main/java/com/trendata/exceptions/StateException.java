package com.trendata.exceptions;

/**
 * Created by friddle on 12/10/14.
 */
public class StateException extends Exception{
	public int states;
	public String errormessage;


    public static class StateExceptionStatus
    {
        public int proxyfailed=1;
        public int databasefailed=2;
        public int httpfailed=3;
    }

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
