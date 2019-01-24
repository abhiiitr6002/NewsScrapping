package com.hz.scrapping.newsscrapping.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ArticleDetails {
	
	@Id
	@Indexed
	private String articleId;
	private String authorName;
	private String heading;
	private String detailedArticle;
	
	@JsonInclude(Include.NON_NULL)
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	@JsonInclude(Include.NON_NULL)
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String htmlElement) {
		this.authorName = htmlElement;
	}
	
	@JsonInclude(Include.NON_NULL)
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	@JsonInclude(Include.NON_NULL)
	public String getDetailedArticle() {
		return detailedArticle;
	}
	public void setDetailedArticle(String detailedArticle) {
		this.detailedArticle = detailedArticle;
	}
	
	@Override
	public String toString() {
		return "ArticleDetails [articleId=" + articleId + ", authorName=" + authorName + ", heading=" + heading
				+ ", detailedArticle=" + detailedArticle + "]";
	}

}
