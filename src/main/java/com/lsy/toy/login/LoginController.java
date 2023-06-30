package com.lsy.toy.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsy.toy.dao.IDao;
import com.lsy.toy.user.dto.UserVO;
import com.lsy.toy.util.AESCryptoUtil;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		System.out.println("login()");
		
		model.addAttribute("userVO", new UserVO());
		return "login/login";
	}
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		System.out.println("signupForm()");
		
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}
	
	@RequestMapping(value={"/loginCheck.do", "/login/loginCheck.do"})
	public ModelAndView loginCheck(UserVO vo, HttpServletRequest request, HttpSession session ) {
		System.out.println("loginCheck.do()");
		
		ModelAndView mav = new ModelAndView();
		String enr_user_no = request.getParameter("enr_user_no");
		String enr_user_pw = request.getParameter("enr_user_pw");
		Boolean result = false;
		AESCryptoUtil aes = new AESCryptoUtil();
		String crpyt_pw = null;
		try {
			crpyt_pw = aes.encrypt(enr_user_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IDao dao = sqlSession.getMapper(IDao.class);
		String res = dao.loginCheck(enr_user_no, crpyt_pw, session);
		
		if(res!=null) {
			vo.setEnr_user_no(enr_user_no);
			vo.setEnr_user_pw(crpyt_pw);
			UserVO vo2 = dao.viewMember(vo);
			session.setAttribute("enr_user_no", vo2.getEnr_user_no());
			session.setAttribute("enr_user_id", vo2.getEnr_user_id());
			session.setAttribute("enr_user_position", vo2.getEnr_user_position());
			session.setAttribute("enr_user_group", vo2.getEnr_user_group());
			session.setAttribute("create_grant", vo2.getCreate_grant());
			session.setAttribute("read_grant", vo2.getRead_grant());
			session.setAttribute("update_grant", vo2.getUpdate_grant());
			session.setAttribute("delete_grant", vo2.getDelete_grant());
			result = true;
		}
		mav.setViewName("/home");
		
		if(result==true) {
			mav.addObject("msg", "success");
		}else {
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		System.out.println("logout.do()");
		
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.logout(session);
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("msg", "logout");
		return mav;
		
	}
	
	
	
}