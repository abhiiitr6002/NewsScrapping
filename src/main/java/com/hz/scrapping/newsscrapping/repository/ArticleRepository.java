package com.hz.scrapping.newsscrapping.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hz.scrapping.newsscrapping.models.ArticleDetails;

public interface ArticleRepository extends MongoRepository<ArticleDetails, String> {
	
	public List<ArticleDetails> findByAuthorName(String authorName);

}
