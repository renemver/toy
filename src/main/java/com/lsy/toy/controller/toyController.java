package com.lsy.toy.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lsy.toy.command.toyCommand;
import com.lsy.toy.dao.IDao;
import com.lsy.toy.dao.toyDao;
import com.lsy.toy.user.dto.UserVO;
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
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getBoardListCnt(search);
		search.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", search);
		model.addAttribute("listCO", dao.listCO(search));
				
		return "listCO";
	}
	
	@RequestMapping("/listLN")
	public String listLN(Model model
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
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getBoardListCnt(search);
		search.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", search);
		model.addAttribute("listLN", dao.listLN(search));
				
		return "listLN";
	}
	
	@RequestMapping("/listDP")
	public String listDP(Model model
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
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		IDao dao = sqlSession.getMapper(IDao.class);

		//전체 게시글 개수
		int listCnt = dao.getBoardListCnt(search);
		search.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination", search);
		model.addAttribute("listDP", dao.listDP(search));
				
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
		
		if(doccd.equals("01")) {
			dao.write_CO(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd") , "N" );
		}
		else if(doccd.equals("02")) {
			dao.write_DP(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd") , "N" );
		}
		else if(doccd.equals("03")) {
			dao.write_LN(request.getParameter("img_key"), request.getParameter("cust_no"), request.getParameter("cust_nm"), 
			request.getParameter("doc_cd"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd") , "N" );
		}
		return "redirect:list";
	}

	@RequestMapping("/write_content")
	public String write_content(Model model, MultipartHttpServletRequest file) {
		System.out.println("write_content()");
		
		List<MultipartFile> list = file.getFiles("file");
		String img_key = null;
		for(int i = 0; i<list.size(); i++) {
			String filepath = "D:/temp";
			String fileRealName = list.get(i).getOriginalFilename();
//			String ext = FilenameUtils.getExtension(list.get(i).getName());
			filepath = filepath + "/" + UUID.randomUUID().toString() + fileRealName;
			File f = new File(filepath);
			try {
				list.get(i).transferTo(f);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			String elementid = null;
			String CC = "TOY_CC";
			img_key = file.getParameter("img_key");
			String doc_cd = file.getParameter("doc_cd");
			if(doc_cd.substring(0,2).equals("01"))
				CC = "CO_CC";
			else if(doc_cd.substring(0,2).equals("02"))
				CC = "DP_CC";
			else if(doc_cd.substring(0,2).equals("03"))
				CC = "LN_CC";
			
			try {
				elementid = EcmUtil.create(filepath, CC);
				if(elementid!=null) {
					f.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			IDao dao = sqlSession.getMapper(IDao.class);
			
			String cust_no = file.getParameter("cust_no");
			String cust_nm = file.getParameter("cust_nm");
			String enr_user_id = file.getParameter("enr_user_id");
			String enr_org_cd = file.getParameter("enr_org_cd");
			
			dao.write(elementid, img_key, cust_no, cust_nm, doc_cd, fileRealName, timestamp, enr_user_id, enr_org_cd, "N" );
		}
		 
		return "redirect:content_view?img_key="+img_key;
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam(value="checkbox", required=false)String value, 
			HttpServletRequest request, Model model) {
		System.out.println("content_view()");
	
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("img_key")));

		String[] elementid = request.getParameterValues("ck");
	
		return "content_view";
	}

	@RequestMapping(method=RequestMethod.POST, value="/download_content")
	public String download_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("download_content()");

		String filepath = "D:/temp";
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
		
		return "redirect:content_view?img_key="+img_key;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
	public String modify(@RequestParam(value="checkbox", required=false)String value, 
			HttpServletRequest request, Model model) {
		System.out.println("modify()");
	
		String img_key = request.getParameter("img_key");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify( request.getParameter("cust_no"), request.getParameter("cust_nm"), request.getParameter("doc_cd"), 
request.getParameter("file_nm"), timestamp, request.getParameter("enr_user_id"), request.getParameter("enr_org_cd"), img_key);	

		return "redirect:content_view?img_key="+img_key;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modify_content")
	public String modify_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, MultipartFile replace_file, Model model) {
		System.out.println("modify_content()");
	
		String filepath = "D:/temp";
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

		return "redirect:content_view?img_key="+img_key;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="checkbox", required=false)String value, 
			HttpServletRequest request, Model model) {
		System.out.println("delete()");
		String img_key = request.getParameter("img_key");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println(value);
	
		String str[] = value.split(",");
		for(int i = 0 ; i<str.length; i++) {
			String res = str[i];
			dao.delete(res);
		}

		return "redirect:content_view?img_key="+img_key;
	}
	
	@RequestMapping("/delete_content")
	public String delete_content(@RequestParam(value="checkbox", required=false)String value,
			HttpServletRequest request, Model model) {
		System.out.println("delete_content()");
		String img_key = request.getParameter("img_key");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println(value);
	
		String str[] = value.split(",");
		for(int i = 0 ; i<str.length; i++) {
			String res = str[i];
			dao.delete_content(res);
		}

		return "redirect:content_view?img_key="+img_key;
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

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.insertUser(request.getParameter("enr_user_no"), request.getParameter("enr_user_id"), 
		request.getParameter("enr_user_position"), request.getParameter("enr_user_group"), request.getParameter("enr_user_pw"));
		
		return "redirect:/list";
	}
	
	@RequestMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName, HttpServletRequest request){
		System.out.println("display");
		
		String filepath = "D:/temp";
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







