package com.trendata.distribution;

import junit.framework.TestCase;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.selector.Html;

/**
 * Created by friddle on 12/15/14.
 */
public class DistributionDownloaderTest extends TestCase {
	public void testDownload() throws Exception {
		DistributionDownloader downloader=new DistributionDownloader();
		CaptchSetting mSetting=new CaptchSetting() {

			@Override
			public boolean isCaptchUrl(String url) {
				return true;
			}

			@Override
			public boolean dealCaptch(Html html) {
				return false;
			}
		};
		downloader.setCaptchSetting(mSetting);
		Request mRequest=new Request("http://t.cn/RzE1iQW");
		Task mTask=new Task()
		{
			@Override
			public String getUUID() {
				return null;
			}

			@Override
			public Site getSite() {
				return Site.me();
			}
		};
		downloader.download(mRequest,mTask);
	}
}
