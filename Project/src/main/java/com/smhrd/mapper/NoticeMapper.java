package com.smhrd.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.smhrd.model.NoticeVO;

@Mapper
public interface NoticeMapper {

	public List<NoticeVO> NoticeList();
	
}
