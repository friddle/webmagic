package com.trendata.process;

import com.trendata.exceptions.StateException;
import com.trendata.Work.WorkProcess;
import org.junit.Before;
import org.junit.Test;
import us.codecraft.webmagic.Site;

import java.util.ArrayList;

/**
 * Created by friddle on 12/10/14.
 */
public class WorkProcessTest {
	@Before
	public void test(){}

	@Test
	public void test_process() throws StateException
	{
		String processname="com.trendata.Process.FiveEightCity";
		ArrayList<String> urls=new ArrayList<String>();
		urls.add("http://www.baidu.com");
		urls.add("http://www.douban.com");
		WorkProcess mProcess=new WorkProcess();
		mProcess.createSpiderByProcess(processname,urls,Site.me());
	}

	@Test
	public void test_entity() throws StateException
	{
		String entityname="com.trendata.Entity.GithubRepo";
		String pipename="us.codecraft.webmagic.pipeline.JsonFilePageModelPipeline";
		ArrayList<String> urls=new ArrayList<String>();
		urls.add("https://github.com/explore");
		WorkProcess mProcess=new WorkProcess();
		mProcess.createSpiderByEntity(entityname,pipename,urls,Site.me());
	}
}
