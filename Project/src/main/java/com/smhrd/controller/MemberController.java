package com.smhrd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.MapVO;

@Controller
public class MemberController {

	@Autowired
	MemberMapper mapper;
	
	@RequestMapping("/")
	public String book() {	
		return "main";
	}

	@RequestMapping("/map")
	public String map(Model model) {
		List<MapVO> mapvo = mapper.map();
		model.addAttribute("mapvo", mapvo);
		return "map";
	}
}
