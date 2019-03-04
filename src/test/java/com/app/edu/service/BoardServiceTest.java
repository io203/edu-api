package com.app.edu.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.edu.EduApiApplication;
import com.app.edu.model.Board;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EduApiApplication.class)
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	
	@Test
	public void boardList_test() throws Exception {
		int start=0;
		int end=10;
		List<Board> list = service.boardList(start, end);
		
		System.out.println("list:"+list.toString());
	}

}
