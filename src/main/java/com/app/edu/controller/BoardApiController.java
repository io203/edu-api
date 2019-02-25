package com.app.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.edu.model.Board;
import com.app.edu.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/apis/boards")
@Slf4j
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/totalCount")
	public int totalCount() throws Exception {
		return boardService.selectBoardTotalCount();
	}

	// @GetMapping(produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	@GetMapping()
	public  ResponseEntity<List<Board>>  list(@RequestParam(value="start", defaultValue = "0")  int start , @RequestParam(value="end", defaultValue = "10") int end) throws Exception {

		List<Board> list = boardService.boardList(start, end);
		// delay(1);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@GetMapping("/{num}")
	public Board view(@PathVariable(value = "num") int num) throws Exception {
		Board board = boardService.selectBoard(num);
		return board;

	}

	@PostMapping()
	public ResponseEntity<ResultMessage> insert(@Valid @RequestBody Board apiBoard) throws Exception {
		log.debug("--------api insert");
		int result = boardService.insertBoard(apiBoard);
		return getResponseEntity(result);
	}

	@PutMapping()
	public ResponseEntity<ResultMessage> update(@Valid @RequestBody Board apiBoard) throws Exception {
		log.debug("--------api update");
		int result = boardService.updateBoard(apiBoard);
		return getResponseEntity(result);

	}

	@DeleteMapping("/{num}")
	public ResponseEntity<ResultMessage> delete(@PathVariable(value = "num") int num) throws Exception {
		int result = boardService.deleteBoard(num);
		return getResponseEntity(result);

	}

	private ResponseEntity<ResultMessage> getResponseEntity(int result) {
		ResultMessage resultMessage;
		if (result > 0) {
			resultMessage = new ResultMessage("Y", "정상");
			return ResponseEntity.ok(resultMessage);
		}
		resultMessage = new ResultMessage("N", "오류");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMessage);

	}

}
