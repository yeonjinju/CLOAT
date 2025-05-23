package com.smhrd.review;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller 
public class ReviewController {
	
	@Autowired
	ReviewMapper mapper;


    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    ServletContext context;

    // 리뷰 상세보기 + 조회수 증가
    @RequestMapping("/reviewview")
    public String reviewView(@RequestParam("no") int reviewIdx,
                             @RequestParam(value="pageNum", defaultValue="1") int pageNum, Model model) {
    	reviewService.increaseViews(reviewIdx);
        ReviewVO review = mapper.getReview(reviewIdx);
        ReviewVO answer = reviewService.getAnswer(reviewIdx);
        
        model.addAttribute("review", review);
        
        
        model.addAttribute("answer", answer);
        model.addAttribute("pageNum", pageNum);  // 페이지 번호 같이 넘김
        return "review/ReviewView";
    }
    
    
    
    

	// Answer 작성
	@RequestMapping(value = "/writeReviewAnswer", method = RequestMethod.POST)
	public String writeReviewAnswer(ReviewVO vo, HttpSession session, @RequestParam String id) {

		System.out.println("loginId : " + id);
		System.out.println("Review_idx : " + vo.getReview_idx());

		vo.setId(id);
		System.out.println(vo);
		int result = reviewService.writeReviewAnswer(vo);

		if (result > 0) {
			System.out.println("댓글 작성 성공");
		} else {
			System.out.println("댓글 작성 실패");
		}

		return "redirect:/reviewview?no=" + vo.getReview_idx();
	}

	// Answer 수정
	@RequestMapping("/updateReviewAnswer")
	public String updateReviewAnswer(ReviewVO vo, HttpSession session, @RequestParam String id) {

		System.out.println("loginId : " + id);
		System.out.println("Review_idx : " + vo.getReview_idx());

		vo.setId(id);
		System.out.println(vo);

		int result = reviewService.updateReviewAnswer(vo);

		if (result > 0) {
			System.out.println("댓글 수정 성공");
		} else {
			System.out.println("댓글 수정 실패");
		}
		return "redirect:/reviewview?no=" + vo.getReview_idx();
	}

	// Answer 삭제
	@RequestMapping("/deleteReviewAnswer")
	public String deleteReviewAnswer(ReviewVO vo, HttpSession session, @RequestParam String id) {
		
		System.out.println("loginId : " + id);
		System.out.println("Review_idx : " + vo.getReview_idx());

		vo.setId(id);
		System.out.println(vo);
		
		int result = reviewService.deleteReviewAnswer(vo);

		if (result > 0) {
			System.out.println("댓글 삭제 성공");
		} else {
			System.out.println("댓글 삭제 실패");
		}

		return "redirect:/reviewview?no=" + vo.getReview_idx();
	}
	
	@RequestMapping("/reviewcommentlist")
	public String reviewcommentlist() {
		return null;
	}

	
	


    // 리뷰 목록 + 페이징 처리
    @RequestMapping("/ReviewList")
    public String reviewList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model) {
        int pageSize = 10;
        int startRow = (pageNum - 1) * pageSize + 1;
        int endRow = pageNum * pageSize;

        int totalCount = mapper.getTotalCount();
        int totalPageCount = (totalCount + pageSize - 1) / pageSize;

        List<ReviewVO> list = mapper.getReviewsByPage(startRow, endRow);
        if (list == null) list = new ArrayList<>();

        int pageBlock = 10;
        int startPageNum = ((pageNum - 1) / pageBlock) * pageBlock + 1;
        int endPageNum = Math.min(startPageNum + pageBlock - 1, totalPageCount);

        model.addAttribute("list", list);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "review/Review";
    }

    // 게시글 상세보기 (예: 리뷰 형식, 쿼리 파라미터로 reNum 받음)
    @RequestMapping("/reviewdetailreview")
    public ModelAndView detail(@RequestParam("reNum") String reNum) throws Exception {
        return new ModelAndView("detail", "detail1", reviewService.getReviewDetail(reNum));
    }
    // 검색기능
	@RequestMapping("/ReviewSearch")
	public String ReviewSearch(@RequestParam String searchValue, @RequestParam String searchContent ,Model model) {
		
		List<ReviewVO> list = mapper.ReviewSearch(searchValue, searchContent);
		System.out.println(searchValue + " " + searchContent);
		model.addAttribute("list", list);
		return "review/Review";
	}

	@RequestMapping("/ReviewWrite")
	public String ReviewWrite(Model model) {
		return "review/ReviewWrite";
	}
	// 글쓰기 기능
	@RequestMapping("/ReviewUpload")
	public String ReviewUpload(ReviewVO vo, @RequestParam(value= "file", required = false)MultipartFile file) {
		String loc = context.getRealPath("/resources/file/");
		FileOutputStream fos;
		String fileDemo = null;
		if (file != null && !file.isEmpty()) {
			fileDemo = file.getOriginalFilename();
			if(fileDemo.length() > 0) {
				try {
					String baseName = fileDemo.substring(0, fileDemo.lastIndexOf("."));
					String extension = fileDemo.substring(fileDemo.lastIndexOf("."));
					fileDemo = baseName + '_' + UUID.randomUUID().toString() + extension;
					File targetFile = new File(loc, fileDemo);
					fos = new FileOutputStream(targetFile);
					fos.write(file.getBytes());
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		vo.setReview_file(fileDemo);
		vo.setReview_views(0);
		
		int result = mapper.write(vo);
		
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return "redirect:/ReviewList";
	}
	
	
}
    
   