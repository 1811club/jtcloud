package com.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;
import com.student.service.SsoService;
import com.student.sso.pojo.User;

@Controller
public class LoginController {
	
	
	
	@Autowired
	private SsoService ssoService;
//	
//	@RequestMapping("/user_ajax/checkUserName")
//	@ResponseBody
//	public SysResult checkUserName(String username) throws Exception{
//		int exists=Integer.parseInt(ssoService.checkUsername(username));
//		SysResult result=new SysResult();
//		result.setStatus(exists);
//		return result;
//	}
	 
//	@RequestMapping("/user_ajax/regist")
//	@ResponseBody
//	public SysResult regist(User user) throws Exception{
//		SysResult result =new SysResult();
//		
//		int success=Integer.parseInt(ssoService.doRgister(user));
//		result.setStatus(success);
//		if(success==1){
//		
//			String msg="鐢ㄦ埛:"+user.getUserName()+"娉ㄥ唽鎴愬姛";
//			result.setMsg(msg);
//		}else{
//			String msg="鐢ㄦ埛:"+user.getUserName()+"娉ㄥ唽澶辫触";
//			result.setMsg(msg);
//		}
//		return result;
//	}
	
	//user_ajax/login
	@RequestMapping("ServletLogin")
	public String login(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String num=request.getParameter("ID");
		String pwd=request.getParameter("pwd");
		int roleID=Integer.parseInt(request.getParameter("role")); 
		User user= new User(num,pwd,roleID);
		User rs= ssoService.checkLogin(user);
		if(rs.getUserName()!=null){
			if(rs.getUserNum().equals(user.getUserNum())){
				if(rs.getPassword().equals(user.getPassword())){
					if(rs.getRoleID()==user.getRoleID()){
						if(rs.getRoleID()==2){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
							return "admin/admin";
						}else if(rs.getRoleID()==1){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("teacher/teacher.jsp").forward(request, response);
							return "teacher/teacher";
						}else if(rs.getRoleID()==0){
							request.getSession().setAttribute("username", rs.getUserName());
							request.getSession().setAttribute("usernum", rs.getUserNum());
							request.getRequestDispatcher("student/student.jsp").forward(request, response);
							return "student/student";
						}
					}else{
						request.setAttribute("massage","角色不正确！！");
						request.getRequestDispatcher("login/login.jsp").forward(request, response);
						return "login/login";
					}
				}else{
					request.setAttribute("massage","密码不正确！！");
					request.getRequestDispatcher("login/login.jsp").forward(request, response);
					return "login/login";
				}
			}else{
				request.setAttribute("massage","用户不存在！！");
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
				return "login/login";
			}
		}else{
			request.setAttribute("massage","用户不存在！！");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
			return "login/login";
		}
		return "";
		
		/*SysResult result=new SysResult();
		String ticket=userService.login(user);
		if(StringUtils.isNotEmpty(ticket)){
			CookieUtils.setCookie(request, response, 
					"JT_TICKET", ticket);
			result.setStatus(1);
			return result;
		}else{
			result.setStatus(0);
			return result;
		}*/
		
		
	}
	
	@RequestMapping("ServletselectPwd")
	public String logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//锟斤拷锟絪ession锟叫碉拷锟斤拷锟斤拷adf
		String userNum=(String) request.getSession().getAttribute("usernum");
		User rs= ssoService.checkUsername(userNum);
		String pwd=rs.getPassword();
		request.setAttribute("password", pwd);
		request.getRequestDispatcher("admin/selectPwd.jsp").forward(request, response);
		return "redirect:admin/selectPwd.jsp";
	}
	
	@RequestMapping("ServletInfo")
	public String ServletInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//锟斤拷锟絪ession锟叫碉拷锟斤拷锟斤拷
		String userNum=(String) request.getSession().getAttribute("usernum");
		User rs= ssoService.checkUsername(userNum);
		String pwd=rs.getPassword();
		request.setAttribute("userID", rs.getUserID());
		request.setAttribute("phone", rs.getPhone());
		request.getRequestDispatcher("admin/selectInfo.jsp").forward(request, response);
		return "redirect:admin/selectPwd.jsp";
	}
	
	

}
