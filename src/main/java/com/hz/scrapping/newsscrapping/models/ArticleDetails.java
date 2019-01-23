package com.hz.scrapping.newsscrapping.models;

public class ArticleDetails {
	
	private String articleId;
	private String authorName;
	private String heading;
	private String detailedArticle;
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String htmlElement) {
		this.authorName = htmlElement;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
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
