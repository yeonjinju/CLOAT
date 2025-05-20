package com.smhrd.map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MapController {

	@Autowired 
	MapMapper mapper;
	
	@RequestMapping("/map")
	public String map() {
		return "Map";
	}
	
	@RequestMapping("/searchMap")
	public String searchMap(@RequestParam String searchValue,  @RequestParam String searchKeyword, Model model){
		
		List<MapVO> mapvo = null;
		
		if(searchValue=="1") {
			mapvo = mapper.searchMap1(searchKeyword);
		}else if(searchValue=="2") {
			mapvo = mapper.searchMap2(searchKeyword);
		}else if(searchValue=="3") {
			mapvo = mapper.searchMap3(searchKeyword);
		}else {
			mapvo = mapper.searchMap(searchKeyword);
		}

		model.addAttribute("mapvo", mapvo);
		return "Map";
	}
	
	
}