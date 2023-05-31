package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ListEntity;
import com.example.demo.repository.ListRepository;


@Controller
public class PageController {

	@Autowired
	ListRepository listRepository;
	
	//로그인 페이지 이동
	@GetMapping("/signin")
	public String login() {
		
		return "signin";
	}
	
	//회원가입 페이지 이동
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	//게시글 작성 페이지로 이동
	@GetMapping("/createlist")
	public String createList() {
		return "createList";
	}
	
	//게시글 페이지로 이동
	@GetMapping("/list")
	public String list(Model model) {
		
		List<ListEntity> listEntity = listRepository.findAll();
		
		model.addAttribute("listEntity", listEntity);
		
		return "list";
	}
	
	//상세 페이지로 이동
	@GetMapping("/detail")
	public String detail(Model model,Long id) {
		
		model.addAttribute("board",listRepository.findById(id).get());
		return "detail";
	}
	
	//수정 페이지로 이동
	@GetMapping("/detail/notify")
	public String notify(Long id, Model model) {
		
		
		model.addAttribute("board", listRepository.findById(id).get());
		
		return "notify";
	}
	
}
