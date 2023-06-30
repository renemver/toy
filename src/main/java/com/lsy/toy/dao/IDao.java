package com.lsy.toy.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.lsy.toy.dto.menuDto;
import com.lsy.toy.dto.toyDto;
import com.lsy.toy.user.dto.UserVO;
import com.lsy.toy.util.Search;

public interface IDao {
	
	public ArrayList<toyDto> list(Search search);
	public ArrayList<toyDto> listCO(Search search);
	public ArrayList<toyDto> listLN(Search search);
	public ArrayList<toyDto> listDP(Search search);
	
	public toyDto selectCO(String img_key) ;
	public toyDto selectDP(String img_key) ;
	public toyDto selectLN(String img_key) ;
	
	public void write(String elementid, String img_key, String cust_no, String cust_nm, String doc_cd, 
			String file_nm, Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn, String rrn_no, int seq_no);
	public void write_LN(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn, String rrn_no);
	public void write_DP(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn, String rrn_no);
	public void write_CO(String img_key, String cust_no, String cust_nm, String doc_cd, 
			Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn, String rrn_no);

	public void modify( String cust_no, String cust_nm, String doc_cd,
			String enr_user_id, String enr_org_cd, String rrn_no,String img_key);
	public void modify_CO(String cust_no, String cust_nm, String rrn_no, String doc_cd, 
			String enr_user_id,	String enr_org_cd, String img_key);
	public void modify_DP(String cust_no, String cust_nm, String rrn_no, String doc_cd, 
			String enr_user_id,	String enr_org_cd, String img_key);
	public void modify_LN(String cust_no, String cust_nm, String rrn_no, String doc_cd, 
			String enr_user_id,	String enr_org_cd, String img_key);
	
	public ArrayList<toyDto> content_view(String img_key, String doc_cd);
	
	public void modify_content(String file_nm, Timestamp enr_dtm, String elementid);
	
	public void deleteeid(String elementid);
	public void deleteimgkey(String img_key);

	public void deleteeid_CO(String img_key, String doc_cd);
	public void deleteimgkey_CO(String img_key);
	public void deleteeid_DP(String img_key, String doc_cd);
	public void deleteimgkey_DP(String img_key);
	public void deleteeid_LN(String img_key, String doc_cd);
	public void deleteimgkey_LN(String img_key);

	public int getBoardListCnt(Search search);
	public int getCOCnt(Search search) ;
	public int getDPCnt(Search search) ;
	public int getLNCnt(Search search) ;
	
	public ArrayList<menuDto> menu_view(String img_key);
	public ArrayList<menuDto> getmidmenu(String midmenu);

	public List<UserVO> getUserList(Search search);
	public UserVO getUserInfo(String enr_user_id);
	public UserVO getUpdateUserInfo(String enr_user_id);
	
	public void insertUser(String ENR_USER_NO,String ENR_USER_ID,
			String ENR_USER_POSITION, String ENR_USER_GROUP,String ENR_USER_PW);
	public void updateUser(String ENR_USER_POSITION, String ENR_USER_GROUP,
			String CREATE_GRANT,String UPDATE_GRANT,String DELETE_GRANT,String ENR_USER_NO);
	public void deleteUser(String enr_user_no);
	
	public String loginCheck(@Param("enr_user_no") String enr_user_no, @Param("enr_user_pw") String enr_user_pw, HttpSession session);
	public UserVO viewMember(UserVO vo);
	public void logout(HttpSession session);
	public void write_menu(String doc_cd, String main_cd, String middle_cd, 
		String sub_cd, String main_desc, String middle_desc,String sub_desc);
	public void modify_menu(String doc_cd, String main_cd, String middle_cd, String sub_cd, 
			String main_desc, String middle_desc, String sub_desc, String p_doc_cd);
	public int delete_menu(String doc_cd);
	public int getMaxNo(String img_key);
	
}