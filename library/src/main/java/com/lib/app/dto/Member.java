package com.lib.app.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {

	private String MId, MPw, MName,MGender, MPhone, MBirth, MEmail, MAddr, MProfileName;
	private MultipartFile MProfile;
	private String addr1, addr2, addr3;
	private int year,month,day;
}
