package com.smhrd.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smhrd.qna.QnaVO;

@Mapper
public interface QnaMapper {

	public List<QnaVO> QnaList();

    QnaVO getQna(int qna_idx);

    int getTotalCount();

    List<QnaVO> getQnasByPage(@Param("startRow") int startRow, @Param("endRow") int endRow);

    void updateQnaViews(@Param("qnaIdx") int qnaIdx);
}
