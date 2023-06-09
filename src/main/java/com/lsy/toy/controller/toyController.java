package com.lsy.toy.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lsy.toy.command.toyCommand;
import com.lsy.toy.dao.IDao;
import com.lsy.toy.dao.toyDao;
import com.lsy.toy.dto.menuDto;
import com.lsy.toy.dto.toyDto;
import com.lsy.toy.util.AESCryptoUtil;
import com.lsy.toy.util.EcmUtil;
import com.lsy.toy.util.Search;

@Controller
public class toyController {
	
	toyCommand command;
	public JdbcTemplate template;
	private static final Logger logger = LoggerFactory.getLogger(toyController.class);
	toyDao dao;
	
	@Autowired
	private SqlSession sqlSession;
	
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
	
		search.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", search);
		model.addAttribute("list", dao.list(search));
				
		return "list";
	}
	
	@RequestMapping("/listCO")
	public String listCO( Model model
			, @RequestParam(value = "sdate", required = false) String sdate
            , @RequestParam(value = "edate", required = false) String edate
			, @RequestParam(required = false, defaultValue = "1") String element
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "img_key") String searchType
			, @RequestParam(required = false) String keyword
			) {
		System.out.println("listCO()");
		if(!element.equals("1")) {
			searchType="doc_cd";
			keyword="01"+element;
		}
		if(sdate==""||sdate==null) {sdate="19000101";}
		if(edate==""||edate==null) {edate="99991231";}
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setSdate(sdate);
		search.setEdate(edate);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getCOCnt(search);
		search.pageInfo(page, range, listCnt);

		AESCryptoUtil aes = new AESCryptoUtil();
		String dec_rrn = null;
		
		ArrayList<toyDto> list = dao.listCO(search);
		for(int i=0; i<list.size(); i++) {
			try {
				dec_rrn = aes.decrypt(list.get(i).getRrn_no());
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.get(i).setRrn_no(dec_rrn);
		}
		
		ArrayList<menuDto> mlist = dao.getmidmenu("01");

		model.addAttribute("pagination", search);
		model.addAttribute("listCO", list);
		model.addAttribute("menuCO", mlist);
				
		return "listCO";
	}
	
	@RequestMapping("/listLN")
	public String listLN(Model model
			, @RequestParam(value = "sdate", required = false) String sdate
            , @RequestParam(value = "edate", required = false) String edate
			, @RequestParam(required = false, defaultValue = "1") String element
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "img_key") String searchType
			, @RequestParam(required = false) String keyword
			) {
		System.out.println("listLN()");
		
		if(!element.equals("1")) {
			searchType="doc_cd";
			keyword="03"+element;
		}
		if(sdate==""||sdate==null) {sdate="19000101";}
		if(edate==""||edate==null) {edate="99991231";}
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setSdate(sdate);
		search.setEdate(edate);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getLNCnt(search);
		search.pageInfo(page, range, listCnt);
		
		AESCryptoUtil aes = new AESCryptoUtil();
		String dec_rrn = null;
		
		ArrayList<toyDto> list = dao.listLN(search);
		for(int i=0; i<list.size(); i++) {
			try {
				dec_rrn = aes.decrypt(list.get(i).getRrn_no());
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.get(i).setRrn_no(dec_rrn);
		}

		ArrayList<menuDto> mlist = dao.getmidmenu("03");
		
		model.addAttribute("pagination", search);
		model.addAttribute("listLN", list);
		model.addAttribute("menuLN", mlist);
				
		return "listLN";
	}
	
	@RequestMapping("/listDP")
	public String listDP(Model model
			, @RequestParam(value = "sdate", required = false) String sdate
            , @RequestParam(value = "edate", required = false) String edate
			, @RequestParam(required = false, defaultValue = "1") String element
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "img_key") String searchType
			, @RequestParam(required = false) String keyword
			) {
		System.out.println("listDP()");
		
		if(!element.equals("1")) {
			searchType="doc_cd";
			keyword="02"+element;
		}
		if(sdate==""||sdate==null) {sdate="19000101";}
		if(edate==""||edate==null) {edate="99991231";}
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setSdate(sdate);
		search.setEdate(edate);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getDPCnt(search);
		search.pageInfo(page, range, listCnt);
		
		AESCryptoUtil aes = new AESCryptoUtil();
		String dec_rrn = null;
		
		ArrayList<toyDto> list = dao.listDP(search);
		for(int i=0; i<list.size(); i++) {
			try {
				dec_rrn = aes.decrypt(list.get(i).getRrn_no());
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.get(i).setRrn_no(dec_rrn);
		}

		ArrayList<menuDto> mlist = dao.getmidmenu("02");
		
		model.addAttribute("pagination", search);
		model.addAttribute("listDP", list);
		model.addAttribute("menuDP", mlist);
				
		return "listDP";
	}
    
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		IDao dao = sqlSession.getMapper(IDao.class);
		String doccd = request.getParameter("doc_cd").substring(0,2);
		String cd = null;
		AESCryptoUtil aes = new AESCryptoUtil();
		String crypt_rrn = null;
		try {
			crypt_rrn = aes.encrypt(request.getParameter("rrn_no"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(doccd.equals("01")) {
			cd="CO";
			dao.write_CO(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"),
			"N", crypt_rrn);
		}
		else if(doccd.equals("02")) {
			cd="DP";
			dao.write_DP(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"), 
			"N", crypt_rrn );
		}
		else if(doccd.equals("03")) {
			cd="LN";
			dao.write_LN(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"), 
			"N", crypt_rrn);
		}
	    return "redirect:list"+ cd;
	}

	@RequestMapping("/write_content")
	public String write_content(Model model, MultipartHttpServletRequest file, HttpServletRequest request) {
		System.out.println("write_content()");
		
		List<MultipartFile> list = file.getFiles("file");
		String img_key = null;
		String cust_no = null;
		String cust_nm = null;
		String doc_cd = null;
		String enr_user_id = null;
		String enr_org_cd = null;
		String rrn_no = null;
		int seq_no = 1;
		
		for(int i = 0; i<list.size(); i++) {
			String filepath = "/home/p354056/temp";
			String fileRealName = list.get(i).getOriginalFilename();
//			String ext = FilenameUtils.getExtension(list.get(i).getName());
			filepath = filepath + "/" + UUID.randomUUID().toString() + fileRealName;
			File f = new File(filepath);
			try {
				list.get(i).transferTo(f);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			IDao dao = sqlSession.getMapper(IDao.class);
			String elementid = null;
			String CC = "TOY_CC";
			
			img_key = file.getParameter("img_key");
			doc_cd = file.getParameter("doc_cd");
			if(doc_cd==null) {
				doc_cd = request.getParameter("dcd");
			}
			if(doc_cd.substring(0,2).equals("01")) {
				CC = "CO_CC";
			}
			else if(doc_cd.substring(0,2).equals("02")) {
				CC = "DP_CC";
			}
			else if(doc_cd.substring(0,2).equals("03")) {
				CC = "LN_CC";
			}
			
			if(img_key==null) {
				img_key = request.getParameter("ikey");
				toyDto dto = new toyDto();
				if(CC.equals("CO_CC")) 		{dto = dao.selectCO(img_key);}
				else if(CC.equals("DP_CC")) {dto = dao.selectDP(img_key);}
				else if(CC.equals("LN_CC")) {dto = dao.selectLN(img_key);}
				
				cust_no = dto.getCust_no();
				cust_nm = dto.getCust_nm();
				enr_user_id = dto.getEnr_user_id();
				enr_org_cd = dto.getEnr_org_cd();
				rrn_no = dto.getRrn_no();
			}
			else {
				cust_no = file.getParameter("cust_no");
				cust_nm = file.getParameter("cust_nm");
				enr_user_id = file.getParameter("enr_user_id");
				enr_org_cd = file.getParameter("enr_org_cd");
				rrn_no = file.getParameter("rrn_no");
				seq_no = dao.getMaxNo(img_key) + 1;
			}
			
			try {
				elementid = EcmUtil.create(filepath, CC);
				if(elementid!=null) {
					f.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(rrn_no.length()==13) {
				AESCryptoUtil aes = new AESCryptoUtil();
				try {
					String dec_rrn = aes.encrypt(rrn_no);
					rrn_no = dec_rrn;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			dao.write(elementid, img_key, cust_no, cust_nm, doc_cd, fileRealName, 
					timestamp, enr_user_id, enr_org_cd, "N" ,rrn_no, seq_no );
		}
		 
		return "redirect:content_view?img_key="+img_key + "&doc_cd="+doc_cd;
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam(value="checkbox", required=false)String value, 
			HttpServletRequest request, Model model) {
		System.out.println("content_view()");
	
		AESCryptoUtil aes = new AESCryptoUtil();
		String dec_rrn = null;
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<toyDto> list = dao.content_view(request.getParameter("img_key"), request.getParameter("doc_cd"));
		for(int i=0; i<list.size(); i++) {
			try {
				dec_rrn = aes.decrypt(list.get(i).getRrn_no());
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.get(i).setRrn_no(dec_rrn);
		}
		model.addAttribute("content_view", list);
		

		String[] elementid = request.getParameterValues("ck");
	
		return "content_view";
	}

	@RequestMapping(method=RequestMethod.POST, value="/download_content")
	public String download_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("download_content()");

		String refer = request.getHeader("Referer");
		String filepath = "/home/p354056/temp";
		String eid = value;

		try {
			EcmUtil.download(filepath, eid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String img_key = request.getParameter("img_key");
		File f = new File(filepath + "/" + eid);
		FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    ServletOutputStream sos = null;
	    
		try {
	         String reFilename = "";
	         
	         boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1 || 
	        		 request.getHeader("user-agent").indexOf("Trident") != -1;	            
	         if(isMSIE) {
	             reFilename = URLEncoder.encode(eid, "utf-8");
	             reFilename = reFilename.replaceAll("\\+", "%20");
	         }else {
	             reFilename = new String(eid.getBytes("utf-8"), "ISO-8859-1");
	         }
			
	//         reFilename = URLEncoder.encode(eid, "utf-8");
	         response.setHeader("Content-Disposition", "attachment;filename=\""+reFilename+"\"");
	         response.setHeader("Content-Transfer-Encoding", "binary;");
	         response.setContentType("application/octet-stream;");
	         response.setContentLength((int)f.length());

			 fis = new FileInputStream(f);
	         bis = new BufferedInputStream(fis);
	         sos = response.getOutputStream();
	         
	         int read = 0;
	         while((read = bis.read()) != -1) {
	             sos.write(read);
	         }
	         
	         File dfile = new File(filepath +"/"+ eid);
	         dfile.delete();
	         
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				sos.flush();
				sos.close();
                bis.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

		return "redirect:"+refer;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		String img_key = request.getParameter("img_key");
		String p_doc_cd = request.getParameter("p_doc_cd");
		String doc_cd = request.getParameter("doc_cd");
		String doccd = doc_cd.substring(0,2);
		AESCryptoUtil aes = new AESCryptoUtil();
		String crypt_rrn = null;
		String cd = null;
		try {
			crypt_rrn = aes.encrypt(request.getParameter("rrn_no"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify(request.getParameter("cust_no"), request.getParameter("cust_nm"), crypt_rrn, request.getParameter("doc_cd"), 
				request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"), img_key, p_doc_cd);	

		if(doccd.equals("01")) {
			cd = "CO";
			dao.modify_CO( request.getParameter("cust_no"), request.getParameter("cust_nm"), crypt_rrn,
			request.getParameter("doc_cd"), request.getParameter("enr_user_id"), 
			request.getParameter("enr_org_cd") , img_key, p_doc_cd );
		}
		else if(doccd.equals("02")) {
			cd = "DP";
			dao.modify_DP( request.getParameter("cust_no"), request.getParameter("cust_nm"), crypt_rrn,
			request.getParameter("doc_cd"), request.getParameter("enr_user_id"), 
			request.getParameter("enr_org_cd") , img_key, p_doc_cd );
		}
		else if(doccd.equals("03")) {
			cd = "LN";
			dao.modify_LN( request.getParameter("cust_no"), request.getParameter("cust_nm"), crypt_rrn,
			request.getParameter("doc_cd"), request.getParameter("enr_user_id"), 
			request.getParameter("enr_org_cd") , img_key, p_doc_cd);
		}
		

	    return "redirect:list"+ cd;
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("modify_view()");
		request.getParameter("img_key");
		return "modify_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify_content")
	public String modify_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, MultipartFile replace_file, Model model) {
		System.out.println("modify_content()");

		String refer = request.getHeader("Referer");
		String filepath = "/home/p354056/temp";
		String fileRealName = replace_file.getOriginalFilename();
//		String ext = FilenameUtils.getExtension(list.get(i).getName());
		filepath = filepath + "/" + UUID.randomUUID().toString() + fileRealName;
		File f = new File(filepath);
		try {
			replace_file.transferTo(f);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String elementid = value;
		String img_key = request.getParameter("img_key");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			EcmUtil.replace(filepath, elementid, "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify_content(fileRealName, timestamp, elementid);

		return "redirect:"+refer;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		String img_key = request.getParameter("img_key");
		String doc_cd = request.getParameter("doc_cd");
		String chk = doc_cd.substring(0,2);
		String refer = request.getHeader("Referer");
		IDao dao = sqlSession.getMapper(IDao.class);

		dao.deleteimgkey(img_key, doc_cd);
		if(chk.equals("01")) {
			dao.deleteimgkey_CO(img_key,doc_cd);}
		else if(chk.equals("02")) {
			dao.deleteimgkey_DP(img_key,doc_cd);}
		else if(chk.equals("03")) {
			dao.deleteimgkey_LN(img_key,doc_cd);
		}
		
		return "redirect:"+refer;
	}
	
	@RequestMapping("/delete_content")
	public String delete_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, Model model) {
		System.out.println("delete_content()");
		String img_key = request.getParameter("img_key");
		String doc_cd = request.getParameter("doc_cd");
		String chk = doc_cd.substring(0,2);
		String refer = request.getHeader("Referer");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteeid(value);
		
		int delcnt = dao.sel_delcnt(img_key, doc_cd);
		if(delcnt==0) {
			if(chk.equals("01")) {
				dao.deleteimgkey_CO(img_key, doc_cd);}
			else if(chk.equals("02")) {
				dao.deleteimgkey_DP(img_key, doc_cd);}
			else if(chk.equals("03")) {
				dao.deleteimgkey_LN(img_key, doc_cd);
			}
		}

		return "redirect:"+refer;
	}
	
	@RequestMapping("/menu_view")
	public String menu_view(HttpServletRequest request, Model model) {
		System.out.println("menu_view()");
		
		String img_key = null;
	
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("menu_view", dao.menu_view(img_key));
		
		return "menu_view";
	}
	
	@RequestMapping("/write_menu")
	public String write_menu(Model model) {
		System.out.println("write_menu()");
		
		return "write_menu";
	}
	
	@RequestMapping("/write_menu_content")
	public String write_menu_content(HttpServletRequest request, Model model) {
		System.out.println("write_menu_content()");

		IDao dao = sqlSession.getMapper(IDao.class);
		String doc_cd = request.getParameter("main_cd")+request.getParameter("middle_cd")+request.getParameter("sub_cd");
		dao.write_menu(doc_cd, request.getParameter("main_cd"), request.getParameter("middle_cd"), request.getParameter("sub_cd"),
				request.getParameter("main_desc"), request.getParameter("middle_desc"), request.getParameter("sub_desc"));
		
		return "redirect:menu_view";
	}
	
	@RequestMapping("/modify_menu")
	public String modify_menu(Model model) {
		System.out.println("modify_menu()");
		
		return "modify_menu";
	}
	
	@RequestMapping("/modify_menu_content")
	public String modify_menu_content(HttpServletRequest request, Model model) {
		System.out.println("modify_menu_content()");
		
		String p_doc_cd = request.getParameter("doc_cd");
		IDao dao = sqlSession.getMapper(IDao.class);
		String doc_cd = request.getParameter("main_cd")+request.getParameter("middle_cd")+request.getParameter("sub_cd");
		dao.modify_menu(doc_cd, request.getParameter("main_cd"), request.getParameter("middle_cd"), request.getParameter("sub_cd"),
				request.getParameter("main_desc"), request.getParameter("middle_desc"), request.getParameter("sub_desc"), p_doc_cd);
		
		return "redirect:menu_view";
	}
	
	@RequestMapping("/modify_user")
	public String modify_user(Model model) {
		System.out.println("modify_user()");
		
		return "modify_user";
	}
	
	@RequestMapping("/modify_user_content")
	public String modify_user_content(HttpServletRequest request, Model model) {
		System.out.println("modify_user_content()");
		
		String enr_user_no = request.getParameter("enr_user_no");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.updateUser(request.getParameter("enr_user_position"), request.getParameter("enr_user_group"), 
	request.getParameter("create_grant"), request.getParameter("update_grant"), request.getParameter("delete_grant"), enr_user_no);

		return "redirect:userList";
	}
	
	@RequestMapping("/delete_menu")
	public String delete_menu(HttpServletRequest request, Model model) {
		System.out.println("delete_menu()");
		String doc_cd = request.getParameter("doc_cd");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int result = dao.delete_menu(doc_cd);

		return "redirect:menu_view";
	}
	
	@RequestMapping("/userList")
	public String getUserList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "img_key") String searchType
			, @RequestParam(required = false) String keyword) throws Exception{
		logger.info("getUserList()");
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		model.addAttribute("pagination", search);
		model.addAttribute("userList", dao.getUserList(search));
		
		return "userList";
	}
	
	@RequestMapping("/insertUser")
	public String insertUser(HttpServletRequest request, Model model) throws Exception {
		logger.info("insertUser()");
		String pw = request.getParameter("enr_user_pw");
		AESCryptoUtil aes = new AESCryptoUtil();
		String crpyt_pw = null;
		try {
			crpyt_pw = aes.encrypt(pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.insertUser(request.getParameter("enr_user_no"), request.getParameter("enr_user_id"), 
		request.getParameter("enr_user_position"), request.getParameter("enr_user_group"), crpyt_pw);
		
		return "redirect:/";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request, Model model) throws Exception {
		logger.info("deleteUser()");
		
		String enr_user_no = request.getParameter("enr_user_no");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteUser(enr_user_no);

		return "redirect:userList";
	}
	
	@RequestMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName, HttpServletRequest request){
		System.out.println("display");
		
		String filepath = "/home/p354056/temp";
		String str[] = request.getParameter("elementid").split("\\?");
		String eid = str[0];
		String filenm[] = str[1].split("\\=");
		String file_nm[] = filenm[1].split("\\.");
		String ext = file_nm[1];
		try {
			EcmUtil.download_view(filepath, eid, ext);
		} catch (Exception e) {
			e.printStackTrace();
		}

		File file = new File(filepath + "/" + eid + "." +ext);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();	
			header.add("Content-type", Files.probeContentType(file.toPath()));		
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			file.delete();
		}catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		
		return result;
	}
	
	
}







