/*****************************************************************************************
 * Project Key : jflex-example
 * Create on 2021-1-19 9:50:30
 * Copyright (c) 2008 - 2021.深圳市快付通金融网络科技服务有限公司版权所有. 粤ICP备10228891号
 * 注意：本内容仅限于深圳市快付通金融网络科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ****************************************************************************************/
package com.jflex.jflexexample.http;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.jflex.jflexexample.http.handler.HttpHandlerEnum;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * 
 * HttpServer
 * @author wangshaolin
 * @since
 */
@Service
public class HttpRestServer implements InitializingBean {

	
	public void init() throws IOException, InstantiationException, IllegalAccessException {
        //创建http服务器，绑定本地8888端口*
		HttpServer server = HttpServer.create();
		server.bind(new InetSocketAddress(8888), 0);
        //创建上下文监听,拦截包含/test的请求*
		//server.createContext("/test", new TestHttpHandler());
		
		HttpHandlerEnum[] uris = HttpHandlerEnum.values();
		for(HttpHandlerEnum uri : uris) {
			
			HttpHandler handler = uri.getHandlerClass().newInstance();
			server.createContext(uri.getUri(),handler);
			System.out.println("init uri ["+uri.getUri()+"]");
		}
		
		System.out.println("HttpServer is started");
		
		server.start();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		this.init();
	}
}
