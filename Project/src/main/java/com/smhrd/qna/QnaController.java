package com.smhrd.qna;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller 
public class QnaController {
	
	@Autowired
	QnaMapper mapper;


    @Autowired
    private QnaService qnaService;

    // 공지사항 상세보기 + 조회수 증가
    @RequestMapping("/qnaview")
    public String qnaView(@RequestParam("no") int qnaIdx,
                             @RequestParam(value="pageNum", defaultValue="1") int pageNum,
                             Model model) {
        qnaService.increaseViews(qnaIdx);
        QnaVO qna = mapper.getQna(qnaIdx);
        model.addAttribute("qna", qna);
        model.addAttribute("pageNum", pageNum);  // 페이지 번호 같이 넘김
        return "qna/QnaView";
    }


    // 공지사항 목록 + 페이징 처리
    @RequestMapping("/QnaList")
    public String qnaList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
        int pageSize = 10;
        int startRow = (pageNum - 1) * pageSize + 1;
        int endRow = pageNum * pageSize;

        int totalCount = mapper.getTotalCount();
        int totalPageCount = (totalCount + pageSize - 1) / pageSize;

        List<QnaVO> list = mapper.getQnasByPage(startRow, endRow);
        if (list == null) list = new ArrayList<>();

        int pageBlock = 10;
        int startPageNum = ((pageNum - 1) / pageBlock) * pageBlock + 1;
        int endPageNum = Math.min(startPageNum + pageBlock - 1, totalPageCount);

        model.addAttribute("list", list);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "qna/Qna";
    }

    // 게시글 상세보기 (예: 리뷰 형식, 쿼리 파라미터로 reNum 받음)
    @RequestMapping("/qnadetailreview")
    public ModelAndView detail(@RequestParam("reNum") String reNum) throws Exception {
        return new ModelAndView("detail", "detail1", qnaService.getQnaDetail(reNum));
    }
}
