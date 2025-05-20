package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.QnaVO;

@Mapper
public interface QnaMapper {

	public List<QnaVO> QnaList();
	
}
