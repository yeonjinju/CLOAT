package com.smhrd.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public void increaseViews(int reviewNo) { // 조회수 증가
    	reviewMapper.updateReviewViews(reviewNo);
    }

    public ReviewVO getReviewDetail(int reviewIdx) { // Review 상세 게시글 조회
        return reviewMapper.getReview(reviewIdx);
    }

    public ReviewVO getReviewDetail(String reNum) { // review 상세 게시글 조회 (문자열 받아서 int 변환)
        int reviewIdx = Integer.parseInt(reNum);
        return getReviewDetail(reviewIdx);
    }

    // Answer 조회
    public ReviewVO getAnswer(int reviewIdx) {
        return reviewMapper.getAnswerByReviewIdx(reviewIdx);
    }
    
    // Answer 작성
    public int writeReviewAnswer(ReviewVO vo) {
        return reviewMapper.insertReviewAnswer(vo);
    }
    // Answer 수정
    public int updateReviewAnswer(ReviewVO vo) {
        return reviewMapper.updateReviewAnswer(vo);
    }
    // Answer 삭제
    public int deleteReviewAnswer(ReviewVO vo) {
        return reviewMapper.deleteReviewAnswer(vo);
    }
}
