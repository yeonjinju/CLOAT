package com.smhrd.news;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface NewsMapper {

	public List<NewsVO> NewsList();

    NewsVO getNews(int news_idx);

    int getTotalCount();

    List<NewsVO> getNewssByPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

    void updateNewsViews(@Param("newsIdx") int newsIdx);
}
