package com.lib.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lib.app.dto.Book;
import com.lib.app.dto.Member;

@Repository
public class mDAO {

	@Autowired
	private SqlSessionTemplate sql;

	public int mJoin(Member member) {
		return sql.insert("Member.mJoin", member);
	}

	public Member mLogin(String MId) {
		return sql.selectOne("Member.mLogin", MId);
	}

	public List<Book> mBookList() {
		return sql.selectList("Book.mBookList");
	}

	public int mBookRent(Book book) {
		return sql.update("Book.mBookRent", book);
	}

	public List<Book> mbookCheck(String MId) {
		return sql.selectList("Book.mbookCheck",MId);
	}

	public int mBookReturn(List<Integer>KNo) {
		int num = 0;
		System.out.println(KNo.size());
		for(int i=0; i<KNo.size(); i++) {
			int ReturnKNo = KNo.get(i);
			num = sql.update("Book.mBookReturn", ReturnKNo);
		}
		return num;
	}
	
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	//회원 정보보기
	public Member mView(String MId) {
		
		return sql.selectOne("Member.mView", MId);
	}
	//정보 수정
	public int mModify(Member member) {
		return sql.update("Member.mModify", member);
	}
	//회원 삭제
	public int mDelete(String MId) {
		
		return sql.delete("Member.mDelete", MId);
	}
}
