package com.app.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.edu.model.Board;

@RestController
public class BoardApiController {
	
	@GetMapping("/boards")
	public List<Board> listBoard(){
		List<Board> list = new ArrayList<>();
		
		for(int i=0 ; i< 10;i++) {
			list.add(new Board(i+1,"test-"+i, "contents-"+i));
		}
		return list;
		
	}

}
