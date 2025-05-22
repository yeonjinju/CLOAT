package com.smhrd.news;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smhrd.news.NewsService;
import com.smhrd.news.NewsVO;

@Controller 
public class NewsController {
	
	@Autowired
	NewsMapper mapper;
	
    @Autowired
    private NewsService newsService;

    // 뉴스 상세보기 + 조회수 증가
    @RequestMapping("/newsview")
    public String newsView(@RequestParam("no") int newsIdx,
                             @RequestParam(value="pageNum", defaultValue="1") int pageNum,
                             Model model) {
        newsService.increaseViews(newsIdx);
        NewsVO news = mapper.getNews(newsIdx);
        model.addAttribute("news", news);
        model.addAttribute("pageNum", pageNum);  // 페이지 번호 같이 넘김
        return "news/NewsView";
    }

    // 공지사항 목록 + 페이징 처리
    @RequestMapping("/NewsList")
    public String newsList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
        int pageSize = 10;
        int startRow = (pageNum - 1) * pageSize + 1;
        int endRow = pageNum * pageSize;

        int totalCount = mapper.getTotalCount();
        int totalPageCount = (totalCount + pageSize - 1) / pageSize;

        List<NewsVO> list = mapper.getNewssByPage(startRow, endRow);
        if (list == null) list = new ArrayList<>();

        int pageBlock = 10;
        int startPageNum = ((pageNum - 1) / pageBlock) * pageBlock + 1;
        int endPageNum = Math.min(startPageNum + pageBlock - 1, totalPageCount);

        model.addAttribute("list", list);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "news/News";
    }

    // 게시글 상세보기 (예: 리뷰 형식, 쿼리 파라미터로 reNum 받음)
    @RequestMapping("/newsdetailreview")
    public ModelAndView detail(@RequestParam("reNum") String reNum) throws Exception {
        return new ModelAndView("detail", "detail1", newsService.getNewsDetail(reNum));
    }
}
