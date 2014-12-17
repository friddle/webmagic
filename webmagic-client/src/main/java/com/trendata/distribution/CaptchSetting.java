package com.trendata.distribution;

import us.codecraft.webmagic.selector.Html;

/**
 * Created by friddle on 12/15/14.
 * if output of the url is codeing.
 */
public interface CaptchSetting {
	public boolean isCaptchUrl(String url);
	public boolean dealCaptch(Html html);
}
