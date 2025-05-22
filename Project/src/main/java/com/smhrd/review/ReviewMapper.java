package com.smhrd.review;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ReviewMapper {

	public List<ReviewVO> ReviewList();
	
    ReviewVO getReview(int review_idx);

    int getTotalCount();

    List<ReviewVO> getReviewsByPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

    void updateReviewViews(@Param("reviewIdx") int reviewIdx);
    
    
    

	public int write(ReviewVO vo);

	public List<ReviewVO> ReviewSearch(String searchValue, String searchContent);
	
}