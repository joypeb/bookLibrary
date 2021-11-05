package com.lib.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Member;
import com.lib.app.service.mService;

@Controller
public class mController {

	@Autowired
	private mService msvc;

	@Autowired
	private HttpSession session;

	@Autowired
	JavaMailSender mailsender;

	private ModelAndView mav = new ModelAndView();

	// 초기 실행화면 : 프로젝트 실행화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// M_joinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/m_joinForm", method = RequestMethod.GET)
	public String mJoinForm() {
		return "m_Join";
	}

	@RequestMapping(value = "/m_join", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute Member member) throws IllegalStateException, IOException {
		mav = msvc.mJoin(member);
		return mav;
	}

	// M_loginForm : 로그인 페이지 이동
	@RequestMapping(value = "/m_loginForm", method = RequestMethod.GET)
	public String mLoginForm() {
		return "m_Login";
	}

	// M_login : 로그인
	@RequestMapping(value = "/m_login", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute Member member) {
		mav = msvc.mLogin(member);
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "/m_logout", method = RequestMethod.GET)
	public String mLogout() {
		session.invalidate();
		return "index";
	}

	// m_View : 회원상세보기
	@RequestMapping(value = "/m_view", method = RequestMethod.GET)
	public ModelAndView mList(@RequestParam("MId") String MId,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		mav = msvc.mView(MId, page);

		return mav;
	}

	// m_modiForm : 회원정보 수정페이지로 이동
	@RequestMapping(value = "/m_modiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("MId") String MId,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		mav = msvc.m_modiForm(MId, page);

		return mav;
	}

	// m_modify : 회원수정
	@RequestMapping(value = "/m_modify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute Member member,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page)
			throws IllegalStateException, IOException {

		mav = msvc.m_modify(member, page);

		return mav;
	}

	// m_delete : 회원삭제
	@RequestMapping(value = "/m_delete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("MId") String MId,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		mav = msvc.mDelete(MId, page);

		return mav;
	}

}
