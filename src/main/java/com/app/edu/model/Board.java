package com.app.edu.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Board {
	 
	private int num;
	private String title;
	private String contents;
	private String writeName;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime writeDate;
	
	private String modifyName;	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime  modifyDate;	 
	 
	private int cnt;
	private String writeId;
	private String modifyId;
	
	
	

}

