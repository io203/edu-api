package com.app.edu.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultMessage {
	private String successYn;
	private String statusCode;
	private String code;	 
	private String message;
	private String devMessage;
	
	
	public ResultMessage() {		
	}

	public ResultMessage(String successYn) {
		this.successYn = successYn;
		this.statusCode = null;
		this.message = null;
		this.devMessage = null;
	}
	public ResultMessage(String successYn, String message) {
		this.successYn = successYn;
		this.statusCode = null;
		this.message = message;
		this.devMessage = null;
	}
	
	

	
}