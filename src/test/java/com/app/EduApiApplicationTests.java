package com.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.edu.dao.BoardDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduApiApplicationTests {
	
	@Autowired
	BoardDAO dao;

	@Test
	public void testDao() throws Exception {
		
		int totalCount = dao.selectBoardTotalCount();
		
		System.out.println("count:"+totalCount);
	}

}

