package com.vlocity.qe;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpMethods {

	private Logger log = LoggerFactory.getLogger(ElementFinder.class);

	public int testLinksWorking(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			return httpConn.getResponseCode();
		} catch (MalformedURLException e) {
			log.info("Incorrect URL");
		} catch (IOException e) {
			log.info("IO exception"); 
		}
		return 0;

	}
}
