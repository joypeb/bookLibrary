package com.lib.app.dto;

import lombok.Data;

@Data
public class Page {
	private int page;
	private int maxPage;
	private int StartPage;
	private int endPage;
	private int startRow;
	private int endRow;
}