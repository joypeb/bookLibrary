package com.lib.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.app.dto.Board;
import com.lib.app.dto.Page;

@Repository
public class BoDAO {

	@Autowired
	private SqlSessionTemplate sql;

	// 게시글 작성하기
	public int bWrite(Board board) {
		return sql.insert("Board.bWrite", board);
	}

	// 게시글 페이징 처리를 위한 목록 갯수 카운트하기
	public int mListCount() {
		return sql.selectOne("Board.bListCount");
	}

	// 게시글 목록보기
	public List<Board> mList(Page paging) {
		return sql.selectList("Board.bList", paging);
	}

	// 게시글 상세보기
	public Board bView(int BNo, int page) {
		return sql.selectOne("Board.bView", BNo);
	}

	// 게시글 수정하기
	public int bModi(Board board, int page) {
		return sql.update("Board.bModi", board);
	}

	// 게시글 삭제하기
	public int bDel(int BNo, int page) {
		return sql.delete("Board.bDel", BNo);
	}
	
	

}
