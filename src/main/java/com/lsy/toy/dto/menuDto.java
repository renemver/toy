package com.lsy.toy.dto;

public class menuDto{

	String doc_cd; 
	String main_cd;
	String middle_cd;
	String sub_cd;
	String main_desc;
	String middle_desc;
	String sub_desc;
	
	public menuDto(){}
	
	public menuDto(String doc_cd,String main_cd,String middle_cd,String sub_cd, String main_desc, String middle_desc,String sub_desc) {
		this.doc_cd = doc_cd;
		this.main_cd = main_cd;
		this.middle_cd = middle_cd;
		this.sub_cd = sub_cd;
		this.main_desc = main_desc;
		this.middle_desc = middle_desc;
		this.sub_desc = sub_desc;
	}

	public String getDoc_cd() {
		return doc_cd;
	}

	public void setDoc_cd(String doc_cd) {
		this.doc_cd = doc_cd;
	}

	public String getMain_cd() {
		return main_cd;
	}

	public void setMain_cd(String main_cd) {
		this.main_cd = main_cd;
	}

	public String getMiddle_cd() {
		return middle_cd;
	}

	public void setMiddle_cd(String middle_cd) {
		this.middle_cd = middle_cd;
	}

	public String getSub_cd() {
		return sub_cd;
	}

	public void setSub_cd(String sub_cd) {
		this.sub_cd = sub_cd;
	}

	public String getMain_desc() {
		return main_desc;
	}

	public void setMain_desc(String main_desc) {
		this.main_desc = main_desc;
	}

	public String getMiddle_desc() {
		return middle_desc;
	}

	public void setMiddle_desc(String middle_desc) {
		this.middle_desc = middle_desc;
	}

	public String getSub_desc() {
		return sub_desc;
	}

	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}
}