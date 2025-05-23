package com.smhrd.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smhrd.answer.AnswerVO;

@Service
public class QnaService {

    @Autowired
    private QnaMapper qnaMapper;

    // 조회수 증가
    public void increaseViews(int qnaNo) {
        qnaMapper.updateQnaViews(qnaNo);
    }

    // Qna 상세 게시글 조회
    public QnaVO getQnaDetail(int qnaIdx) {
        return qnaMapper.getQna(qnaIdx);
    }

    // Qna 상세 게시글 조회 (문자열 받아서 int 변환)
    public QnaVO getQnaDetail(String reNum) {
        int qnaIdx = Integer.parseInt(reNum);
        return getQnaDetail(qnaIdx);
    }

    // Answer 조회
    public AnswerVO getAnswer(int qnaIdx) {
        return qnaMapper.getAnswerByQnaIdx(qnaIdx);
    }
    
    // Answer 작성
    public int writeAnswer(AnswerVO vo) {
        return qnaMapper.insertAnswer(vo);
    }
    // Answer 수정
    public int updateAnswer(AnswerVO vo) {
        return qnaMapper.updateAnswer(vo);
    }
    // Answer 삭제
    public int deleteAnswer(AnswerVO vo) {
        return qnaMapper.deleteAnswer(vo);
    }
}
