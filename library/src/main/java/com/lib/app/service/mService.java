package com.lib.app.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Member;
import com.lib.app.dao.mDAO;

@Service
public class mService {

	@Autowired
	private mDAO dao;

	@Autowired
	private HttpSession session;

	@Autowired
	private BCryptPasswordEncoder pwEnc;

	private ModelAndView mav = new ModelAndView();

	// 회원가입
	public ModelAndView mJoin(Member member) throws IllegalStateException, IOException {

		// 파일 이름 가져오기(MProfile은 파일 자체, MProfileName이 파일이름)
		// MProfile > MProfileName
		MultipartFile MProfile = member.getMProfile();
		String MProfileName = MProfile.getOriginalFilename();

		// 주소 합치기
		member.setMAddr("(" + member.getAddr1() + ") " + member.getAddr2() + ", " + member.getAddr3());

		// location D:\springWorksapce\MEMBOARD
		// 파일 저장위치
		String savePath = "C:/Users/joype/Documents/workspace-spring-tool-suite-4-4.11.1.RELEASE/library/src/main/webapp/resources/profile/"
				+ MProfileName;

		// 파일이 선택됐다면
		if (!MProfile.isEmpty()) {
			member.setMProfileName(MProfileName);
			MProfile.transferTo(new File(savePath));
		}

		// 암호화
		member.setMPw(pwEnc.encode(member.getMPw()));

		// 생일
		String Mmonth = "";
		if (member.getMonth() <= 9) {
			Mmonth = "0" + member.getMonth();
		} else {
			Mmonth = "" + member.getMonth();
		}
		String birth = member.getYear() + "-" + Mmonth + "-" + member.getDay();

		member.setMBirth(birth);

		System.out.println(member.toString());

		int result = dao.mJoin(member);

		if (result > 0) {
			mav.setViewName("m_Login");
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// 로그인
	public ModelAndView mLogin(Member member) {
		
		Member encPw = dao.mLogin(member.getMId());
		if(encPw.getMPw() == null) {
			mav.setViewName("m_Login");
			return mav;
		}
		
		
		if (pwEnc.matches(member.getMPw(), encPw.getMPw())) {
			session.setAttribute("loginId", encPw.getMId());
			session.setAttribute("profile", encPw.getMProfileName());
			mav.setViewName("index");
		} else {
			mav.setViewName("m_Login");
		}

		return mav;
	}

	// 정보보기
	public ModelAndView mView(String MId, int page) {

		Member member = dao.mView(MId);

		mav.addObject("view", member);
		mav.addObject("page", page);
		mav.setViewName("m_View");
		return mav;
	}

	// 회원 수정 페이지 이동
	public ModelAndView m_modiForm(String MId, int page) {

		Member member = dao.mView(MId);

		mav.addObject("modify", member);
		mav.addObject("page", page);
		mav.setViewName("m_Modify");
		return mav;
	}

	// 삭제
	public ModelAndView mDelete(String MId, int page) {

		int result = dao.mDelete(MId);

		if (result > 0) {
			session.invalidate();
			mav.setViewName("redirect:/M_list?page=" + page);
		} else {
			mav.setViewName("index");
		}

		return mav;
	}

	// 수정
	public ModelAndView m_modify(Member member, int page) throws IllegalStateException, IOException {

		MultipartFile MProfile = member.getMProfile();
		String MProfileName = MProfile.getOriginalFilename();

		// 파일 저장위치
		String savePath = "" + MProfileName;

		if (!MProfile.isEmpty()) {
			member.setMProfileName(MProfileName);
			MProfile.transferTo(new File(savePath));
		}

		int result = dao.mModify(member);

		if (result > 0) {
			mav.setViewName("redirect:/m_view?MId=" + member.getMId() + "&page=" + page);
		} else {
			mav.setViewName("index");
		}

		return mav;
	}
}
