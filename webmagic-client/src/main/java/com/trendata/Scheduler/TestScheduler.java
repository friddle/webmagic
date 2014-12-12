package com.trendata.Scheduler;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * Created by friddle on 12/10/14.
 */
public class TestScheduler implements Scheduler{


	@Override
	public void push(Request request, Task task) {

	}

	@Override
	public Request poll(Task task) {
		return null;
	}
}
