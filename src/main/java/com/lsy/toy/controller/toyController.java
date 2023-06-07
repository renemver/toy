package com.lsy.toy.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lsy.toy.command.toyCommand;
import com.lsy.toy.dao.IDao;
import com.lsy.toy.dao.toyDao;
import com.lsy.toy.util.EcmUtil;
import com.lsy.toy.util.Pagination;
import com.lsy.toy.util.Search;

@Controller
public class toyController {
	
	toyCommand command;
	public JdbcTemplate template;
	private static final Logger logger = LoggerFactory.getLogger(toyController.class);
	toyDao dao;
	
	@Autowired
	private SqlSession sqlSession;
/*
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	*/
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list")
	public String list(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "img_key") String searchType
			, @RequestParam(required = false) String keyword
			) {
		System.out.println("list()");

		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getBoardListCnt(search);
		
		//Pagination 객체생성
//		Pagination pagination = new Pagination();
//		pagination.pageInfo(page, range, listCnt);
		search.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", search);
		model.addAttribute("list", dao.list(search));
				
		return "list";
	}
	/**
     * Tiles 사용
     */        
    @RequestMapping(value="/testTiles.do")
    public String testPage() {
        System.out.println("tiles Test!");
        return "tilesTest.page";
    }
    
	/*
	@RequestMapping("/eidlist")
	public String eidlist(Model model) {
		System.out.println("eidlist()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("eidlist", dao.eidlist());
		
		return "eidlist";
	}
	*/
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");

		String elementid = null;
		try {
			elementid = EcmUtil.create("C:\\Users\\user\\Downloads\\test.txt", "TOY_CC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(elementid, request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), request.getParameter("doc_cd"),
				request.getParameter("file_nm"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd") , "N" );
		 
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam(value="checkbox", required=false)String value, HttpServletRequest request, Model model) {
		System.out.println("content_view()");
	
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("img_key")));

		String[] elementid = request.getParameterValues("ck");
	
		return "content_view";
	}

	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
	
		String elementid = request.getParameter("elementid");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
//			EcmUtil.replace("C:\\Users\\user\\Downloads\\test.txt", elementid, "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), request.getParameter("doc_cd"), 
				request.getParameter("file_nm"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"), elementid);	
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
	
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(request.getParameter("elementid"));

		return "redirect:list";
	}
	
	@RequestMapping(value="layout.do", method = RequestMethod.GET)
	public String layout(Model model) {
		return "layout";
	}
}







