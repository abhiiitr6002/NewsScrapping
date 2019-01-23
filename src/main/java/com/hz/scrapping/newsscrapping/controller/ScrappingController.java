package com.hz.scrapping.newsscrapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hz.scrapping.newsscrapping.models.ArticleDetails;
import com.hz.scrapping.newsscrapping.service.ScrappingService;

@RestController
public class ScrappingController {
	
	@Autowired
	private ScrappingService service;
	
	@GetMapping(value="/authorlist")
	public List<String> getAuthorsList(){
		return service.retrieveAuthorList();
	}
	
	@GetMapping(value="/articlelist")
	public List<ArticleDetails> getArticleByAuthorName(@RequestParam(value="authorName",required = true) String name){
		return service.retrieveArticleByAuthorName(name);
	}

}
