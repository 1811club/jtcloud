package com.student.service;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.common.vo.PageBean;
import com.jt.common.vo.PageBean2;
import com.jt.common.vo.Score;



@FeignClient("service-sc")
public interface SCService {
	@RequestMapping(value="scoreList",method=RequestMethod.GET)
	public PageBean scoreList(@RequestParam(value="pageNo")String pageNo,
			@RequestParam(value="pageCount") String pageCount);

	
	
	@RequestMapping(value="scoreDelete",method=RequestMethod.GET)
	public int deleteScore(@RequestParam(value="scoreID")Integer scoreID);



	@RequestMapping(value="selectOne",method=RequestMethod.GET)
	public List<Score> selectOne(@RequestParam (value ="scoreID")Integer scoreID);


	@RequestMapping(value="editScore",method=RequestMethod.POST)
	public int editCos(@RequestBody Score score) throws Exception;

	@RequestMapping(value="searchScore",method=RequestMethod.POST)
	public PageBean search(@RequestBody Score score);

	@RequestMapping(value="sumList",method=RequestMethod.GET)
	public PageBean2 sumList();
	
	@RequestMapping(value="addScore",method=RequestMethod.POST)
	public int addScore(@RequestBody Score score);
	

	
//	@RequestMapping("score/info")
//	public Score selectScoreInfo(@RequestBody Score score);
//	
//	@RequestMapping("score/add")
//	public int addScore(@RequestBody Score score);
//	
//	@RequestMapping("page")
//    public PageBean scoreListPage(@Param(value="pageNo") Integer pageNo,
//    		@Param(value="pageCount") Integer pageCount);
		
	
}