package com.lib.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dao.sDAO;
import com.lib.app.dto.Spot;

@Service
public class sService {
	
	@Autowired
	private sDAO dao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();

	// 해당 좌석의 이용 시간대가 종료하면 그 시간대의 좌석을 모두 "empty로 변경"
	// 13시
	public int mTimeOver(String hours) {
		int result = dao.mTimeOver();
		return result;
	}
	// 17시
	public int aTimeOver(String hours) {
		int result = dao.aTimeOver();
		return result;
	}
	// 21시
	public int eTimeOver(String hours) {
		int result = dao.eTimeOver();
		return result;
	}
	
	
	
	// 해당 좌석 번호를 클릭하면 시간대를 가져오기
	public String sReservNo(String SNo) {
		String checkSNo = dao.sReservNo(SNo);
		return checkSNo;
	}

	// 열람실 좌석 예약 : String result가 'empty'인지 확인 후, empty라면 해당 아이디로 예약하기
	// MTime == "empty"?
	public String mtimeCheck(String SNo, String MId) {
		String check = dao.mtimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservMTime(SNo, MId);
		} else {
			System.out.println("해당사항 없음!");
		}
		return result;
	}
	// ATime == "empty"?
	public String atimeCheck(String SNo, String MId) {
		String check = dao.atimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservATime(SNo, MId);
		} else {
			System.out.println("해당사항 없음!");
		}
		return result;
	}
	// ETime == "empty"?
	public String etimeCheck(String SNo, String MId) {
		String check = dao.etimeCheck(SNo);
		String result = null;
		if (check.equals("empty")) {
			result = reservETime(SNo, MId);
		} else {
			System.out.println("해당사항 없음!");
		}
		return result;
	}

	
	// 해당 아이디로 좌석 예약하기
	public String reservMTime(String SNo, String MId) {
		String result = dao.reservMTime(SNo, MId);
		return result;
	}
	public String reservATime(String SNo, String MId) {
		String result = dao.reservATime(SNo, MId);
		return result;
	}
	public String reservETime(String SNo, String MId) {
		String result = dao.reservETime(SNo, MId);
		return result;
	}

	// 내정보보기 -> 나의 열람실 이용현황 확인
	public List<Spot> myReserv(String MId) {
		List<Spot> spotList = dao.myReserv(MId);
		return spotList;
	}

	// 내정보보기 -> 예약 취소
	public ModelAndView  reservDel(String MId) {
		int result = dao.reservDel(MId);
		if(result>0) {
			mav.setViewName("redirect:/S_reservForm?MId=" + MId);
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

}
