package com.app.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.app.edu.model.Board;




public interface BoardService {

	public int selectBoardTotalCount() throws Exception;

	public List<Board> boardList(int start, int end) throws Exception;

	public int insertBoard(Board board) throws Exception;

	public Board selectBoard(int num) throws Exception;

	public int deleteBoard(int num) throws Exception;
	public int updateBoard( Board apiBoard);

}
