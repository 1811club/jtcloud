package com.student.score.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.Score;
import com.jt.common.vo.ScoreSum;


public interface ScoreMapper{

	List<Score> selectAllScore(@Param("page")int page , @Param("pageCount")int pageCount);

	int selectCou();

	int deleteS(@Param("scoreId")int scoreID);

	List<Score> selectOneSc(@Param("scid")int scoreID1);

	List<Score> searchSco(Score score);

	int searchCount(Score score);

	List<ScoreSum> selSum();

	int selectCouByName();

	int update(Score score);

	int insertOne(Score score);

	List<Score> selectOneByCos(@Param("courseN")String courseName,@Param("stuN")String stuN);

}
