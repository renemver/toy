package com.lsy.toy.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.lsy.toy.dto.toyDto;
import com.lsy.toy.user.dto.UserVO;
import com.lsy.toy.util.Search;

public class toyDao implements IDao{
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	@Inject
	private SqlSession sqlSession;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public toyDao() {}
	
	public ArrayList<toyDto> list(Search search) {return null;}
	public ArrayList<toyDto> listCO(Search search) {return null;}
	public ArrayList<toyDto> listLN(Search search) {return null;}
	public ArrayList<toyDto> listDP(Search search) {return null;}

	@Override
	public void write(String elementid, String img_key, String cust_no, String cust_nm, String doc_cd, 
			String file_nm, Timestamp enr_dtm, String enr_user_id, String enr_org_cd, String del_yn) {}
	@Override
	public void write_LN(String img_key, String cust_no, String cust_nm, String doc_cd, Timestamp enr_dtm,
			String enr_user_id, String enr_org_cd, String del_yn) {}
	@Override
	public void write_DP(String img_key, String cust_no, String cust_nm, String doc_cd, Timestamp enr_dtm,
			String enr_user_id, String enr_org_cd, String del_yn) {}
	@Override
	public void write_CO(String img_key, String cust_no, String cust_nm, String doc_cd, Timestamp enr_dtm,
			String enr_user_id, String enr_org_cd, String del_yn) {}
	
	public ArrayList<toyDto> content_view(String img_key) {return null;}

	public void modify(final String cust_no, final String cust_nm, final String doc_cd, final String file_nm,	
			final Timestamp enr_dtm, final String enr_user_id, final String enr_org_cd,final String img_key) {}
	public void modify_content(final String file_nm, final Timestamp enr_dtm, final String elementid) {}

	public void delete(final String elementid) {}
	public void delete_content(final String elementid) {}
	
	public int getBoardListCnt(Search search) {
		return sqlSession.selectOne("com.lsy.toy.dao.mapper.IDao.getBoardListCnt");
	}
//	public ArrayList<toyDto> eidlist() {return null;}

	public List<UserVO> getUserList(Search search) {
		return null;
	}
	
	public UserVO getUserInfo(String enr_user_id){
		return sqlSession.selectOne("com.lsy.toy.dao.mapper.IDao.getUserInfo", enr_user_id);
	}
	
	public void insertUser(String ENR_USER_NO,String ENR_USER_ID,
			String ENR_USER_POSITION, String ENR_USER_GROUP,String ENR_USER_PW){}
	
	public void updateUser(String ENR_USER_NO,String ENR_USER_ID,String ENR_USER_POSITION, String ENR_USER_GROUP,
			String CREATE_GRANT,String READ_GRANT,String UPDATE_GRANT,String DELETE_GRANT,String ENR_USER_PW){}
	
	public int deleteUser(String enr_user_id){
		return sqlSession.delete("com.lsy.toy.dao.mapper.IDao.deleteUser", enr_user_id);
	}

	public String loginCheck(@Param("enr_user_no") String enr_user_no, @Param("enr_user_pw") String enr_user_pw, HttpSession session) {
		String enr_user_id = sqlSession.selectOne("com.lsy.toy.dao.mapper.IDao.loginCheck");
		return enr_user_id;
	}
	
	public UserVO viewMember(UserVO vo) {
		return sqlSession.selectOne("com.lsy.toy.dao.mapper.IDao.viewMember", vo);
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
}














