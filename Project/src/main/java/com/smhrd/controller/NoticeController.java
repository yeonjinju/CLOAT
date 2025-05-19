package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.mapper.NoticeMapper;
import com.smhrd.model.NoticeVO;

@Controller 
public class NoticeController {
	
	@Autowired
	NoticeMapper mapper;

	
	@RequestMapping("/NoticeList")
	public String NoticeList(Model model) {
	    List<NoticeVO> list = mapper.NoticeList();

	    // 여기서 데이터 개수 로그 찍기
	    System.out.println("가져온 데이터 개수: " + list.size());

	    model.addAttribute("list", list);
	    return "Notice";
	}

}
