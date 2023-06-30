package com.lsy.toy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Search extends Pagination{
	
	private String searchType;
	private String keyword;	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String sdate;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String edate;
			
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
}