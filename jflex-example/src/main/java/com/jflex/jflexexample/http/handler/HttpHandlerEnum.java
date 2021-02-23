package com.jflex.jflexexample.http.handler;
import com.sun.net.httpserver.HttpHandler;
import com.jflex.jflexexample.http.handler.FirstHttpHandler;

public enum HttpHandlerEnum {
	
	FIRST_HTTP_HANDLER("/first",FirstHttpHandler.class),
	
	HELLO_HTTP_HANDLER("/hello",HelloHttpHandler.class)
	;
	/**
	 * HTTP处理器
	 */
	private Class<? extends HttpHandler> handlerClass;
	/**
	 * HTTP uri
	 */
	private String uri;
	
	HttpHandlerEnum(String uri,Class<? extends HttpHandler> handlerClass){
		this.handlerClass = handlerClass;
		this.uri = uri;
	}

	public Class<? extends HttpHandler> getHandlerClass() {
		return handlerClass;
	}

	public void setHandlerClass(Class<? extends HttpHandler> handlerClass) {
		this.handlerClass = handlerClass;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
