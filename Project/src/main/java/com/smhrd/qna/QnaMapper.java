package com.smhrd.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaMapper {

	public List<QnaVO> QnaList();
	
}
