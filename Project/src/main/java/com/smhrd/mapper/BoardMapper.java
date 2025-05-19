package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> BoardList();
	
}
