package com.trendata.distribution;

import us.codecraft.webmagic.selector.Html;

/**
 * Created by friddle on 12/15/14.
 * captch must be the String or FileObject
 */
public interface CaptchSetting {
	public boolean isCaptchUrl(String url);
	public boolean dealCaptch(Html html);
}
