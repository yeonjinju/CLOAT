package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.mapper.BoardMapper;
import com.smhrd.model.BoardVO;

@Controller 
public class BoardController {
	
	@Autowired
	BoardMapper mapper;

	
	@RequestMapping("/BoardList")
	public String BoardList(Model model) {
	    List<BoardVO> list = mapper.BoardList();

	    // 여기서 데이터 개수 로그 찍기
	    System.out.println("가져온 데이터 개수: " + list.size());

	    model.addAttribute("list", list);
	    return "Board";
	}

}
