package com.smhrd.notice;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {

	private int notice_idx;
	private String notice_title;
	private String notice_content;
	private String notice_file;
	private String notice_views;
	// 왜...... admin작성자가 안뜨는거지
    private String admin_id;          // 작성자 아이디 (FK)
	private String id;
	private Date created_at;
	
	
	
	
}