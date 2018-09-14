package com.gglee.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gglee.domain.BoardVO;
import com.gglee.domain.Criteria;
import com.gglee.domain.PageMaker;
import com.gglee.service.IBoardService;

/**
 * 게시글 컨트롤러 클래스<br>
 * 게시글 관련 작업 URI는 /board 로 시작한다.
 * 
 * @author gglee
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private IBoardService boardService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register page get..........");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post ..........");
		logger.info(board.toString());
		
		// 게시글 등록
		boardService.register(board);
		
		// 리다이렉트 시점에 한 번만 사용되는 데이터 전송을 위해서
		// RedirectAttributes 클래스의 addFlashAttribute를 사용한다.
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list page...........");
		
		model.addAttribute("list", boardService.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("criteria") Criteria criteria, Model model)
			throws Exception {
		logger.info("read page...........");

		model.addAttribute("boardVO", boardService.read(bno));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria criteria, RedirectAttributes rttr) throws Exception {
		boardService.remove(bno);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {
		model.addAttribute(boardService.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, Criteria criteria, RedirectAttributes rttr) throws Exception {
		logger.info("modify post.............");
		
		boardService.modify(board);
		
		rttr.addAttribute("page", criteria.getPage());
		rttr.addAttribute("perPageNum", criteria.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/listCri", method = RequestMethod.GET)
	public void listCriteria(Criteria criteria, Model model) throws Exception {
		logger.info("show list page with criteria..............");
		
		model.addAttribute("list", boardService.listCriteria(criteria));
	}
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public void listPage(Criteria criteria, Model model) throws Exception {
		logger.info("show list page with pagemaker..............");
		logger.info(criteria.toString());
		
		model.addAttribute("list", boardService.listCriteria(criteria));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.listCountCriteria(criteria));

		model.addAttribute("pageMaker", pageMaker);
	}
	
}
