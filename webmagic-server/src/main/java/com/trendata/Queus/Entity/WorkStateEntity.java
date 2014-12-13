package com.trendata.Queus.Entity;

/**
 * Created by friddle on 12/10/14.
 */
public class WorkStateEntity {
	public final static int begin=0;
	public final static int run=1;
	public final static int finsh=3;
	public final static int faild=4;
	public final static int dead=5;
	public final static int unsupport=6;
	public final static int repeat=7;
	public final static int unknow=8;
	//faild means can be work in other machine,dead means over the trytimes or all machine failed.so let if failed
}
