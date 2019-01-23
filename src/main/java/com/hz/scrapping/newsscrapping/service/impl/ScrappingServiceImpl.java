package com.hz.scrapping.newsscrapping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hz.scrapping.newsscrapping.models.ArticleDetails;
import com.hz.scrapping.newsscrapping.repository.ArticleRepository;
import com.hz.scrapping.newsscrapping.scrapper.ScrappingUtility;
import com.hz.scrapping.newsscrapping.service.ScrappingService;

@Service
public class ScrappingServiceImpl implements ScrappingService {

	@Autowired
	private ScrappingUtility utility;
	
	@Autowired
	private ArticleRepository repository;
	
	public List<String> retrieveAuthorList() {
		return utility.getAuthorName();
	}

	public List<ArticleDetails> retrieveArticleByAuthorName(String name) {
		
		return repository.findByAuthorName(name);
	}
	
	
}
