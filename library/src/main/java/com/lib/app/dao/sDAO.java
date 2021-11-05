package com.lib.app.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.lib.app.dto.Spot;

@Repository
public class sDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	// 좌석 최대 이용시간 경과 후 데이터 값 "empty"로 변경
	public int mTimeOver() {
		return sql.update("Spot.mTimeOver");
	}
	public int aTimeOver() {
		return sql.update("Spot.aTimeOver");
	}
	public int eTimeOver() {
		return sql.update("Spot.eTimeOver");
	}
	
	
	// 해당 좌석의 시간대 가져오기
	public String sReservNo(String SNo) {
		return sql.selectOne("Spot.sReservNo", SNo);
	}
	
	// 좌석의 시간대 값이 "empty"인지 확인
	// 해당 좌석 번호의 MTime 시간대
	public String mtimeCheck(String SNo) {
		return sql.selectOne("Spot.mtimeCheck", SNo);
	}
	// 해당 좌석 번호의 ATime 시간대
	public String atimeCheck(String SNo) {
		return sql.selectOne("Spot.atimeCheck", SNo);
	}
	// 해당 좌석 번호의 ETime 시간대
	public String etimeCheck(String SNo) {
		return sql.selectOne("Spot.etimeCheck", SNo);
	}

	
	// 열람실 좌석 예약
	public String reservMTime(String SNo, String MId) {
		sql.update("Spot.reservMTimeR",SNo);
		sql.update("Spot.reservMTimeP", MId);
		return sql.selectOne("Spot.reservMTime", MId);
	}
	public String reservATime(String SNo, String MId) {
		sql.update("Spot.reservATimeR",SNo);
		sql.update("Spot.reservATimeP", MId);
		return sql.selectOne("Spot.reservATime", MId);
	}

	public String reservETime(String SNo, String MId) {
		sql.update("Spot.reservETimeR",SNo);
		sql.update("Spot.reservETimeP", MId);
		return sql.selectOne("Spot.reservETime", MId);
	}

	// 나의 열람실 이용현황
	public List<Spot> myReserv(String MId) {
		return sql.selectList("Spot.myReserv", MId);
	}

	// 예약 취소
	public int reservDel(String MId) {
		return sql.update("Spot.reservDel", MId);
	}


}
