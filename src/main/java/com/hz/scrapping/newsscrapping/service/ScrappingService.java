package com.hz.scrapping.newsscrapping.service;

import java.util.List;

import com.hz.scrapping.newsscrapping.models.ArticleDetails;

public interface ScrappingService {

	public List<String> retrieveAuthorList();
	
	public List<ArticleDetails> retrieveArticleByAuthorName(String name);
}
