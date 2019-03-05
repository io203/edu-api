package com.app.edu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.edu.dao.BoardDAO;
import com.app.edu.model.Board;
import com.app.edu.spring.redis.RedisManager;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private RedisManager<Board> redisManager;

	@Override
	public int selectBoardTotalCount() throws Exception {

		int totalCnt = boardDAO.selectBoardTotalCount();
		log.info("spr-API------------DB call:---------total count---------------------");
		log.info("totalCnt:" + totalCnt);
		return totalCnt;

	}

	@Override
	public List<Board> boardList(int start, int end) throws Exception {
		log.info("ch-1-2");

		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("from", start);
		paramMap.put("to", end);
		List<Board> list = boardDAO.selectBoardList(paramMap);

		return list;
	}

	@Override
	public Board selectBoard(int num) throws Exception {
		
		Board board = redisManager.getValue("board_" + num);
		if (board == null) {
			log.info("edu-api------------DB call:---------selectBoard(num)---------------------");
			board = boardDAO.selectBoard(num);
			redisManager.put("board_" + num, board, 15, TimeUnit.SECONDS);

		}

		return board;
	}

	@Override
	public int deleteBoard(int num) throws Exception {

		int result = boardDAO.deleteBoard(num);
		
		redisManager.delete(String.valueOf(num));

		return result;
	}

	@Override
	public int insertBoard(Board board) throws Exception {

		return boardDAO.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		int result = boardDAO.updateBoard(board);
		redisManager.delete(String.valueOf(board.getNum()));
		
		return result;
		 
	}

}
