package com.smhrd.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class ReviewController {
	
	@Autowired
	ReviewMapper mapper;

	
	@RequestMapping("/ReviewList")
	public String ReviewList(Model model) {
	    List<ReviewVO> list = mapper.ReviewList();

	    // 여기서 데이터 개수 로그 찍기
	    System.out.println("가져온 데이터 개수: " + list.size());

	    model.addAttribute("list", list);
	    return "Review";
	}

}
