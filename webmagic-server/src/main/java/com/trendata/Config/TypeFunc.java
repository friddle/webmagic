package com.trendata.Config;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by friddle on 12/14/14.
 */
public class TypeFunc {
	public static String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain;
	}
}
