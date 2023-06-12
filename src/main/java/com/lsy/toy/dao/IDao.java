package com.lsy.toy.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.lsy.toy.dto.toyDto;
import com.lsy.toy.util.Pagination;
import com.lsy.toy.util.Search;

public interface IDao {
	
	public ArrayList<toyDto> list(Search search);
	public ArrayList<toyDto> listCO(Search search);
	public ArrayList<toyDto> listLN(Search search);
	public ArrayList<toyDto> listDP(Search search);
	
	public void write(String elementid, String img_key, String cust_no, String cust_nm, String doc_cd, 
			String file_nm, Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn);
	public void write_LN(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn);
	public void write_DP(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn);
	public void write_CO(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn);
	
	
	public ArrayList<toyDto> content_view(String img_key);
	public void modify(String img_key, String cust_no, String cust_nm, String doc_cd, String file_nm,
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String elementid);
	public void delete(String elementid);
	public int getBoardListCnt(Search search);
//	public ArrayList<toyDto> eidlist();
	
}