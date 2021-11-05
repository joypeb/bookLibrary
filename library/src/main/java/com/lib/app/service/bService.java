package com.lib.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Book;
import com.lib.app.dao.mDAO;

@Service
public class bService {

	@Autowired
	private mDAO dao;

	private ModelAndView mav = new ModelAndView();

	// 도서 목록
	public ModelAndView bBookList() {
		List<Book> bookList = dao.mBookList();

		mav.addObject("bookList", bookList);
		mav.setViewName("b_BookRent");
		return mav;
	}

	// 도서 대여
	public ModelAndView bBookRent(Book book) {

		LocalDateTime now = LocalDateTime.now();

		String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String returnTime = now.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		book.setNowTime(nowTime);
		book.setReturnTime(returnTime);

		System.out.println(book.toString());
		int result = dao.mBookRent(book);
		if (result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("b_BookRent");
		}
		return mav;
	}

	// 도서 대여 확인
	public ModelAndView bbookCheck(String MId) {
		List<Book> bookCheck = dao.mbookCheck(MId);
		System.out.println(bookCheck.get(0));
		mav.addObject("bookCheckList", bookCheck);
		mav.setViewName("b_BookCheck");
		return mav;
	}

	// 도서 반납
	public ModelAndView bBookReturn(List<Integer> KNo) {
		int mBookReturn = dao.mBookReturn(KNo);

		if (mBookReturn > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("b_BookCheck");
		}
		return mav;
	}
}
