package com.smhrd.review;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

	public List<ReviewVO> ReviewList();
	
}
