package com.myspring.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.domain.BoardVO;
import com.myspring.service.BoardService;

@Controller
@RequestMapping("/board/*")
 
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardVO board,Model model) throws Exception{
		
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board,Model model) throws Exception{

		service.regist(board);
		
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		model.addAttribute("list",service.listAll());
		
	}
	
	
	
}
