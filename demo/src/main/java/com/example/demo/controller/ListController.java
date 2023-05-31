package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.ListEntity;
import com.example.demo.repository.ListRepository;

@Controller
public class ListController {
	
	ListEntity listEntity;
	
	@Autowired
	ListRepository listRepository;
	
	//게시글 작성 완료 처리
	@PostMapping("/createlist")
	public String createList(ListEntity list) {
		
		//System.out.println(list.getTitle() + list.getContent());
		listRepository.save(list);
		
		return "redirect:/list";
	}
	
	//게시글 삭제 처리
	@GetMapping("/detail/delete")
	public String delete(Long id) {
		
		listRepository.deleteById(id);
		
		return"redirect:/list";
	}
	
	//게시글 수정 처리
	@PostMapping("/detail/update")
	public String update(Long id, ListEntity listEntity) {
		
		ListEntity list=listRepository.findById(id).get();
		
		list.setTitle(listEntity.getTitle());
		list.setContent(listEntity.getContent());
		
		listRepository.save(list);
		
		return "redirect:/list";
	}
}

