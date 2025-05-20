package com.smhrd.notice;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

	public List<NoticeVO> NoticeList();
	
    NoticeVO getNotice(int notice_idx);

	
}
