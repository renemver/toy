package com.lsy.toy.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class toyDto{

	String elementid; 
	String img_key;
	String cust_no;
	String cust_nm;
	String doc_cd;
	String file_nm;
	Timestamp enr_dtm;
	String enr_user_id;
	String enr_org_cd;
	String seq_no;
	String rrn_no;
	String del_yn;
	
	public toyDto(){}
	
	public toyDto(String elementid, String img_key, String cust_no, String cust_nm, 
			String doc_cd, String file_nm, Timestamp enr_dtm,
			String enr_user_id, String enr_org_cd, String del_yn) {
		this.elementid = elementid;
		this.img_key = img_key;
		this.cust_no = cust_no;
		this.cust_nm = cust_nm;
		this.doc_cd = doc_cd;
		this.file_nm = file_nm;
		this.enr_dtm = enr_dtm;
		this.enr_user_id = enr_user_id;
		this.enr_org_cd = enr_org_cd;
		this.del_yn = "N";
	}

	public String getElementid() {
		return elementid;
	}

	public void setElementid(String elementid) {
		this.elementid = elementid;
	}

	public String getImg_key() {
		return img_key;
	}

	public void setImg_key(String img_key) {
		this.img_key = img_key;
	}

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getCust_nm() {
		return cust_nm;
	}

	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}

	public String getDoc_cd() {
		return doc_cd;
	}

	public void setDoc_cd(String doc_cd) {
		this.doc_cd = doc_cd;
	}

	public String getFile_nm() {
		return file_nm;
	}

	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}

	public Timestamp getEnr_dtm() {
		return enr_dtm;
	}

	public void setEnr_dtm(Timestamp enr_dtm) {
		this.enr_dtm = enr_dtm;
	}

	public String getEnr_user_id() {
		return enr_user_id;
	}

	public void setEnr_user_id(String enr_user_id) {
		this.enr_user_id = enr_user_id;
	}

	public String getEnr_org_cd() {
		return enr_org_cd;
	}

	public void setEnr_org_cd(String enr_org_cd) {
		this.enr_org_cd = enr_org_cd;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public String getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(String seq_no) {
		this.seq_no = seq_no;
	}

	public String getRrn_no() {
		return rrn_no;
	}

	public void setRrn_no(String rrn_no) {
		this.rrn_no = rrn_no;
	}
}