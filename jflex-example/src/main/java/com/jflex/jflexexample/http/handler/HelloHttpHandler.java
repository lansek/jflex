/*****************************************************************************************
 * Project Key : jflex-example
 * Create on 2021-1-19 16:20:46
 * Copyright (c) 2008 - 2021.深圳市快付通金融网络科技服务有限公司版权所有. 粤ICP备10228891号
 * 注意：本内容仅限于深圳市快付通金融网络科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ****************************************************************************************/
package com.jflex.jflexexample.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * 
 * @author Administrator
 * @since
 */
public class HelloHttpHandler implements HttpHandler {

	private static final Logger logger = LoggerFactory.getLogger(HelloHttpHandler.class);
	/** 
	 * @see com.sun.net.httpserver.HttpHandler#handle(com.sun.net.httpserver.HttpExchange)
	 */
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		//	exchange.getRequestBody();
		logger.info("Request is [{}]",exchange.getRequestURI());
        String response = "hello message,protocol: "+ exchange.getProtocol() ;
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes("UTF-8"));
        os.close();
	}

}
