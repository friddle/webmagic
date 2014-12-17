package com.trendata.process;

import com.trendata.distribution.DistributionProcess;
import us.codecraft.webmagic.Page;

/**
 * Created by friddle on 12/10/14.
 * provide function to do all the work
 * addDistributionNewUrl
 * onFailed
 *
 */
public class FiveEightCity extends DistributionProcess {
	//you just need to extract the url
	@Override
	public void process(Page page) {
		try {
			processObject(page.getHtml().toString(), String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
