/**
 * 
 */
package com.jflex.jflexexample.dto;

import java.io.Serializable;

/**
 * 
 * 基本结果对象
 * @author wangshaolin
 */
public class BaseResult implements Serializable {
	
	/**
	 * 成功返回码
	 */
	public final static String SUCCESS_CODE = "0000"; 

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回码
	 */
	private String returnCode;
	
	/**
	 * 返回消息
	 */
	private String returnMessage;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	
}
