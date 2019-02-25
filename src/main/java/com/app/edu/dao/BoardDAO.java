package com.app.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.app.edu.model.Board;



@Mapper
@Repository
public interface BoardDAO {

	public int selectBoardTotalCount() throws Exception;

	public List<Board> selectBoardList(Map<String, Integer> paramMap);

	public Board selectBoard(int num);

	public int updateBoard(Board apiBoard);

	public int deleteBoard(int num);

	public int insertBoard(Board apiBoard);

	

	
	

 }
