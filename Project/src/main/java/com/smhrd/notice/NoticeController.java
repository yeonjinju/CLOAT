package com.smhrd.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {

    @Autowired
    private NoticeMapper mapper;

    @Autowired
    private NoticeService noticeService;

    // 공지사항 상세보기 + 조회수 증가
    @RequestMapping("/noticeview")
    public String noticeView(@RequestParam("no") int noticeIdx,
                             @RequestParam(value="pageNum", defaultValue="1") int pageNum,
                             Model model) {
        noticeService.increaseViews(noticeIdx);
        NoticeVO notice = mapper.getNotice(noticeIdx);
        model.addAttribute("notice", notice);
        model.addAttribute("pageNum", pageNum);  // 페이지 번호 같이 넘김
        return "notice/NoticeView";
    }


    // 공지사항 목록 + 페이징 처리
    @RequestMapping("/NoticeList")
    public String noticeList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
        int pageSize = 10;
        int startRow = (pageNum - 1) * pageSize + 1;
        int endRow = pageNum * pageSize;

        int totalCount = mapper.getTotalCount();
        int totalPageCount = (totalCount + pageSize - 1) / pageSize;

        List<NoticeVO> list = mapper.getNoticesByPage(startRow, endRow);
        if (list == null) list = new ArrayList<>();

        int pageBlock = 10;
        int startPageNum = ((pageNum - 1) / pageBlock) * pageBlock + 1;
        int endPageNum = Math.min(startPageNum + pageBlock - 1, totalPageCount);

        model.addAttribute("list", list);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "notice/Notice";
    }

    // 게시글 상세보기 (예: 리뷰 형식, 쿼리 파라미터로 reNum 받음)
    @RequestMapping("/noticedetailreview")
    public ModelAndView detail(@RequestParam("reNum") String reNum) throws Exception {
        return new ModelAndView("detail", "detail1", noticeService.getNoticeDetail(reNum));
    }
}
