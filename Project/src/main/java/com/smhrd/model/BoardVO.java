package com.smhrd.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private int qna_idx;
	private String qna_title;
	private String qna_content;
	private int qna_file;
	private String qna_views;
	private String id;
	private Date created_at;
}
