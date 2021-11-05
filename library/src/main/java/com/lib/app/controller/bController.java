package com.lib.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Book;
import com.lib.app.service.bService;

@Controller
public class bController {
	@Autowired
	private bService bsvc;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();
	
	// 도서 리스트
	@RequestMapping(value = "/b_BookList", method = RequestMethod.GET)
	public ModelAndView bBookList() {
		mav = bsvc.bBookList();
		return mav;
	}

	// 도서 대여
	@RequestMapping(value = "/b_bookRent", method = RequestMethod.POST)
	public ModelAndView bbookRent(@ModelAttribute Book book) {
		System.out.println(book.toString());
		mav = bsvc.bBookRent(book);
		return mav;
	}

	// 도서 대여 확인
	@RequestMapping(value = "/b_bookCheck", method = RequestMethod.GET)
	public ModelAndView bbookCheck(@RequestParam String MId) {
		System.out.println("컨트롤러" + MId);
		mav = bsvc.bbookCheck(MId);
		return mav;
	}

	// 도서 반납
	@RequestMapping(value = "/b_BookReturn", method = RequestMethod.POST)
	public ModelAndView bBookReturn(@RequestParam(name = "bookReturn") List<Integer> KNo) {
		System.out.println(KNo);
		mav = bsvc.bBookReturn(KNo);
		return mav;
	}
}
