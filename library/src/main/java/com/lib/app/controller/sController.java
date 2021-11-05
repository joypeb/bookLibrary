package com.lib.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Spot;
import com.lib.app.service.sService;

@Controller
public class sController {
	
	@Autowired
	private sService ssvc;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();
		
	// 해당 좌석의 이용 시간대가 종료하면 그 시간대의 좌석을 모두 "empty로 변경"
	// S_mTimeOver : 13시부터 실행
	@RequestMapping(value = "/S_mTimeOver")
	public @ResponseBody int mTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.mTimeOver(hours);
		return result;
	}
	// S_aTimeOver : 17시부터 실행
	@RequestMapping(value = "/S_aTimeOver")
	public @ResponseBody int aTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.aTimeOver(hours);
		return result;
	}
	// S_eTimeOver : 21시부터 실행
	@RequestMapping(value = "/S_eTimeOver")
	public @ResponseBody int eTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.eTimeOver(hours);
		return result;
	}
	
	
	// S_reservForm : 열람실 좌석 예약 페이지로 이동
	@RequestMapping(value = "/S_reservForm", method = RequestMethod.GET)
	public String sReservForm() {
		return "S_Reserv";
	}	
	
	
	// S_Reservation : 좌석 값 가져오기
	@RequestMapping(value="/S_Reservation", method = RequestMethod.POST)
	public @ResponseBody String sReservNo(@RequestParam("SNo") String SNo) {
		String result = ssvc.sReservNo(SNo);
		return result;
	}
	
	// 좌석 이용가능 확인!
	// S_mtimeCheck : 해당 좌석의 8-12 시간대 이용가능한지 확인
	@RequestMapping(value="/S_mtimeCheck", method = RequestMethod.POST)
	public @ResponseBody String mtimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.mtimeCheck(SNo, MId);
		return result;
	}
	// S_atimeCheck : 해당 좌석의 12-16 시간대 이용가능한지 확인
	@RequestMapping(value="/S_atimeCheck", method = RequestMethod.POST)
	public @ResponseBody String atimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.atimeCheck(SNo, MId);
		return result;
	}
	// S_etimeCheck : 해당 좌석의 16-20 시간대 이용가능한지 확인
	@RequestMapping(value="/S_etimeCheck", method = RequestMethod.POST)
	public @ResponseBody String etimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.etimeCheck(SNo, MId);
		return result;
	}
	
	
	// S_reserv해당시간 : redirect로 받은 아이디, 좌석번호로 예약 완료하기
	// S_reservMTime
	@RequestMapping(value="/S_reservMTime", method = RequestMethod.GET)
	public String reservMTime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservMTime(SNo, MId);
		return result;	
	}
	// S_reservATime
	@RequestMapping(value="/S_reservATime", method = RequestMethod.GET)
	public String reservATime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservATime(SNo, MId);
		return result;	
	}
	// S_reservETime
	@RequestMapping(value="/S_reservETime", method = RequestMethod.GET)
	public String reservETime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservETime(SNo, MId);
		return result;	
	}
	
	// M_View 에서 동작
	// S_myTime : 내 예약 현황 조회( 좌석 번호와 시간대 전부를 List로 받아오기)
	@RequestMapping(value="/S_myTime", method = RequestMethod.POST)
	public @ResponseBody List<Spot> sMyTime(@RequestParam("MId") String MId) {
		List<Spot> spotList = ssvc.myReserv(MId);
		return spotList;
	}
	// S_reservDelete : 내 예약 현황 조회에서 예약 취소 버튼을 누르면 해당 예약을 취소하기
	@RequestMapping(value="/S_reservDelete")
	public ModelAndView reservDel(@RequestParam("MId") String MId) {
		mav = ssvc.reservDel(MId);
		return mav;	
	}
	

}
