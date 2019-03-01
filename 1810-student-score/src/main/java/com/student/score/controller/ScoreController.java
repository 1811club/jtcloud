package com.student.score.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.PageBean;
import com.jt.common.vo.PageBean2;
import com.jt.common.vo.Score;
import com.jt.common.vo.ScoreSum;
import com.student.score.mapper.ScoreMapper;

@RestController
public class ScoreController {
	
	@Autowired
	private ScoreMapper scMapper;
	
	//查询所有成绩
	@RequestMapping(value="scoreList",method=RequestMethod.GET)
	public PageBean scoreList(String pageNo1,String pageCount1){
		int pageNo=1;
		int pageCount=10;					
		if(pageNo1!=null){
			pageNo=Integer.parseInt(pageNo1);
		}
		if(pageCount1!=null){
			pageCount=Integer.parseInt(pageCount1);
		}
		
		//Score score=null;
		
		int scoreCount = scMapper.selectCou();
		
		List<Score> list =scMapper.selectAllScore((pageNo-1)*pageCount,pageCount);
		
		//list.setTotalCount(scoreCount);
		PageBean pList = new PageBean(list, scoreCount, pageNo, pageCount);
		return pList;
	}
	
	//删除成绩
	@RequestMapping(value="scoreDelete",method=RequestMethod.GET)
	public int deleteScore(int scoreID){
		return scMapper.deleteS(scoreID);
		
	}
	
	//查询个人成绩
	@RequestMapping(value="selectOne",method=RequestMethod.GET)
	public List<Score> selectOne(int scoreID){
		return scMapper.selectOneSc(scoreID);
	}
	
	//修改成绩
	@RequestMapping(value="editScore",method=RequestMethod.POST)
	public int editCos(@RequestBody Score score) throws Exception{
		
		int rs = scMapper.update(score);
		
		return rs;
	}
	
	//条件查询
	@RequestMapping(value="searchScore",method=RequestMethod.POST)
	public PageBean search(@RequestBody Score score){
		
		List<Score> list = scMapper.searchSco(score);
		int totalCount = scMapper.searchCount(score);
		
		PageBean rs = new PageBean(list, totalCount, 1, totalCount);
		
		return rs;		
		
	}
	
	//成绩排名
	@RequestMapping(value="sumList",method=RequestMethod.GET)
	public PageBean2 sumList(){
		int countT = scMapper.selectCouByName();
		List<ScoreSum> list = scMapper.selSum();
		PageBean2 rs = new PageBean2(list, countT, 1, countT);
		return rs;
	}
	
	//添加成绩
	@RequestMapping(value="addScore",method=RequestMethod.POST)
	public int addScore(@RequestBody Score score){
		
		List<Score> rs1=scMapper.selectOneByCos(score.getCourseName(),score.getStuName());
		
		if(rs1.size()==0){
			return scMapper.insertOne(score);
		}else{
			return -1;
		}
		
		
	}
	
//	@RequestMapping("score/info")
//	public Score selectScoreInfo(@RequestBody Score score){
//		return scMapper.selectOne(score);
//	}
//	
//	@RequestMapping("score/add")
//	public int addScore(@RequestBody Score score){
//		return scMapper.insert(score);
//	}
	/*
	@RequestMapping("page")
	 public PageBean scoreListPage(@RequestParam(value="pageNo") Integer pageNo,
	    		@RequestParam(value="pageCount") Integer pageCount){
		
		
		
		
	}
	*/
}
