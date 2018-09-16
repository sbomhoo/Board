package com.gglee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gglee.domain.Criteria;
import com.gglee.domain.PageMaker;
import com.gglee.domain.ReplyVO;
import com.gglee.service.IReplyService;

/**
 * 댓글 REST 컨트롤러 클래스<br>
 * 댓글 관련 작업 URI는 /replies 로 시작한다.
 * 
 * @author gglee
 */
@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Inject
	private IReplyService replyService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply) {
		ResponseEntity<String> entity = null;
		
		try {
			replyService.addReply(reply);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("register reply error: " + ex.getMessage());
			entity = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno) {
		ResponseEntity<List<ReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<>(replyService.listReply(bno), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("list reply error: " + ex.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ReplyVO reply) {
		ResponseEntity<String> entity = null;
		
		try {
			reply.setRno(rno);
			replyService.modifyReply(reply);

			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("update reply error: " + ex.getMessage());
			entity = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") Integer rno) {
		ResponseEntity<String> entity = null;
		
		try {
			replyService.removeReply(rno);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("delete reply error: " + ex.getMessage());
			entity = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") Integer bno,
			@PathVariable("page") Integer page) {
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria criteria = new Criteria();
			criteria.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			
			Map<String, Object> map = new HashMap<>();
			
			List<ReplyVO> replyItems = replyService.listReplyPage(bno, criteria);
			
			map.put("list", replyItems);
			
			int replyCount = replyService.count(bno);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("list reply page error: " + ex.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
