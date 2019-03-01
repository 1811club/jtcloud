package com.student.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.common.vo.PageBean;
import com.jt.common.vo.PageBean2;
import com.jt.common.vo.Score;
import com.student.service.SCService;

@Controller
public class ScoController {
	
	@Autowired 
	private SCService sCService;

	@RequestMapping("ServletFindAllScore")
	public String selectAllSocre(Model model,String pageNo,String pageCount){
		
		PageBean scoreList = sCService.scoreList(pageNo,pageCount);
		
		model.addAttribute("list",scoreList);
		
		return "admin/scoreAllInfo";
		
	}
	
	@RequestMapping("ServletDeleteScore")
	public String deleteSocre(Model model,String scoreID){
	
		int rs = sCService.deleteScore(Integer.parseInt(scoreID));
		
		if(rs>0){
			model.addAttribute("msg","删除成功");
			
			return "admin/scoreAllInfo";
			
		}else{
			model.addAttribute("msg","删除失败");
			
			return "admin/scoreAllInfo";
			
		}
	}
	@RequestMapping("ServletSelectScore")
	public String selectOneSocre(Model model,String scoreID){
		
		List<Score> list = sCService.selectOne(Integer.parseInt(scoreID));
		
		model.addAttribute("list",list);
		return "admin/editScore";
		
	}
	
	//修改
	@RequestMapping("ServletEditScore")
	public String editSocre(Model model,HttpServletRequest req) throws Exception{
		int scoreID = Integer.parseInt(req.getParameter("scoreID"));
		String stuNum = req.getParameter("stuNum");
		String stuName = req.getParameter("stuName");
		String stuClass = req.getParameter("stuClass");
		String courseName = req.getParameter("courseName");
		double scoreGrade=Double.parseDouble(req.getParameter("scoreGrade"));
		String major = req.getParameter("major");
		
		Score score=new Score(scoreID,stuNum,stuName,stuClass,courseName,scoreGrade,major);
		
		int rs=sCService.editCos(score);
		if(rs>0){
			model.addAttribute("msg","修改成功");
			
			return "admin/scoreAllInfo";
			
		}else{
			model.addAttribute("msg","修改失败");
			
			return "admin/scoreAllInfo";
			
		}
	}
	
	
	@RequestMapping("ServletSearchScore")
	public String searchSocre(Model model,HttpServletRequest request){
		
		String stuNum=request.getParameter("stuNum");
		String courseName=request.getParameter("cosName");
		String stuName=request.getParameter("stuName");
		String stuClass=request.getParameter("stuClass");
		String major=request.getParameter("major");
		double scoreGrade=0;
		Score score=new Score( stuNum,  stuName,  stuClass,
				 courseName,  scoreGrade,  major);
		PageBean list = sCService.search(score);
		model.addAttribute("list",list);
		return "admin/scoreAllInfo";
	}
	
	@RequestMapping("ServletStuSumList")
	public String sumList(Model model){
		
		PageBean2 list = sCService.sumList();
		
		model.addAttribute("list",list);
		
		return "admin/stuScoreList";
		
	}
	
	//添加成绩
	@RequestMapping("ServletaddScore")
	public String addScore(Score score,Model model){
		/*
		String stuNum = request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuClass = request.getParameter("stuClass");
		String courseName = request.getParameter("courseName");
		double scoreGrade=Double.parseDouble(request.getParameter("scoreGrade"));
		String major = request.getParameter("major");
		Score score = new Score(stuNum, stuName, stuClass, courseName, scoreGrade, major);*/
		int rs = sCService.addScore(score);
		if(rs>0){
			model.addAttribute("msg","添加成功");
			
			return "admin/scoreAllInfo";
			
		}else{
			model.addAttribute("msg","添加失败");
			
			return "admin/scoreAllInfo";
			
		}
	}
	
	//查询总成绩
	@RequestMapping("ServletStuSum")
	public String totalScore(){
		
		return "admin/scoreAllInfo";
		
	}
	
	
	
}
