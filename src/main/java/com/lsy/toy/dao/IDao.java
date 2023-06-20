package com.lsy.toy.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.lsy.toy.dto.toyDto;
import com.lsy.toy.user.dto.UserVO;
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
	public void modify(String cust_no, String cust_nm, String doc_cd, String file_nm,
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd,String img_key);
	public void modify_content(String file_nm, Timestamp enr_dtm, String elementid);
	public void delete(String elementid);
	public void delete_content(String elementid);
	public int getBoardListCnt(Search search);
//	public ArrayList<toyDto> eidlist();
	

	public List<UserVO> getUserList(Search search);
	public UserVO getUserInfo(String enr_user_id);
	public void insertUser(String ENR_USER_NO,String ENR_USER_ID,
			String ENR_USER_POSITION, String ENR_USER_GROUP,String ENR_USER_PW);
	public void updateUser(String ENR_USER_NO,String ENR_USER_ID,String ENR_USER_POSITION, String ENR_USER_GROUP,
			String CREATE_GRANT,String READ_GRANT,String UPDATE_GRANT,String DELETE_GRANT,String ENR_USER_PW);
	public int deleteUser(String enr_user_id);
	
}