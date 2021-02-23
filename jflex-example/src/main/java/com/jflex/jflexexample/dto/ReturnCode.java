/*****************************************************************************************
 * Project Key : jflex-example
 * Create on 2021-1-4 15:17:12
 * Copyright (c) 2008 - 2021.深圳市快付通金融网络科技服务有限公司版权所有. 粤ICP备10228891号
 * 注意：本内容仅限于深圳市快付通金融网络科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ****************************************************************************************/
package com.jflex.jflexexample.dto;

/**
 * 
 * @author Administrator
 * @since
 */
public enum ReturnCode {
	
	SUCCESS("0000","成功"),
	;
	private String code;
	
	private String defaultMessage;

	private ReturnCode(String code,String defaultMessage) {
		this.setCode(code);
		this.setDefaultMessage(defaultMessage);
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
