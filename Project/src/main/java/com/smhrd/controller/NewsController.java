package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.mapper.NewsMapper;
import com.smhrd.model.NewsVO;

@Controller 
public class NewsController {
	
	@Autowired
	NewsMapper mapper;

	
	@RequestMapping("/NewsList")
	public String NewsList(Model model) {
	    List<NewsVO> list = mapper.NewsList();

	    // 여기서 데이터 개수 로그 찍기
	    System.out.println("가져온 데이터 개수: " + list.size());

	    model.addAttribute("list", list);
	    return "News";
	}

}
