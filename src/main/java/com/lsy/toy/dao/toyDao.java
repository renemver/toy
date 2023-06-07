package com.lsy.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lsy.toy.dto.toyDto;
import com.lsy.toy.util.Pagination;
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
	
	public toyDao() {	

	}
	
	public ArrayList<toyDto> list(Search search) {return null;}

	public void write(final String elementid, final String img_key, final String cust_no, final String cust_nm, final String doc_cd, 
			final String file_nm, final Timestamp enr_dtm, final String enr_user_id, final String enr_org_cd, String del_yn) {}

	public ArrayList<toyDto> content_view(String img_key) {return null;}

	public void modify(final String img_key, final String cust_no, final String cust_nm, final String doc_cd, final String file_nm,	
			final Timestamp enr_dtm, final String enr_user_id, final String enr_org_cd, final String elementid) {}

	public void delete(final String elementid) {}
	
	public int getBoardListCnt(Search search) {
		return sqlSession.selectOne("com.lsy.toy.dao.mapper.IDao.getBoardListCnt");
	}
//	public ArrayList<toyDto> eidlist() {return null;}

}














