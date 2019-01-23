package com.hz.scrapping.newsscrapping.models;

public class ArticleHeading {
	
	private String link;
	
	private String Heading;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	@Override
	public String toString() {
		return "ArticleHeading [link=" + link + ", Heading=" + Heading + "]";
	}

}
