package com.smhrd.news;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {

	public List<NewsVO> NewsList();
	
}
