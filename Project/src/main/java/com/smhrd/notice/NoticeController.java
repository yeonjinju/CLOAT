package com.smhrd.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	    return "notice/Notice";
	}
	

    @RequestMapping("/noticeview")
    public String noticeView(@RequestParam("no") int noticeIdx, Model model) {
        NoticeVO notice = mapper.getNotice(noticeIdx);
        model.addAttribute("notice", notice);
        return "notice/NoticeView";
    }

}
