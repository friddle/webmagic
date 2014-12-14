package com.trendata.pipeline;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by friddle on 12/10/14.
 */
public class OrmPipeline implements PageModelPipeline {
	public void process(Object o, Task task) {
		System.out.print(o);
	}
}
