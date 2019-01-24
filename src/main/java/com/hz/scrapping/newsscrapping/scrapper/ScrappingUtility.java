package com.hz.scrapping.newsscrapping.scrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hz.scrapping.newsscrapping.models.ArticleDetails;
import com.hz.scrapping.newsscrapping.models.ArticleHeading;
import com.hz.scrapping.newsscrapping.repository.ArticleRepository;

@Component
public class ScrappingUtility {
	
	List<String> list = 
	           Collections.synchronizedList(new ArrayList<String>());
	
	@Autowired
	private ArticleRepository repository;
	
	@EventListener
	public void getData(ContextStartedEvent event) {
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			String searchUrl = "https://www.thehindu.com/archive/web/2019/01/01/";
			HtmlPage page = client.getPage(searchUrl);
			List<HtmlElement> items = (List<HtmlElement>) (Object)page.getByXPath("//ul[@class='archive-list']") ;
			if(items.isEmpty()) {
				System.out.println("No Element Found");
			}else {
				for(HtmlElement element: items) {
					HtmlAnchor itemAnchor =  ((HtmlAnchor) element.getFirstByXPath(".//a"));
					ArticleHeading heading = new ArticleHeading();
					heading.setLink(itemAnchor.getHrefAttribute());
					heading.setHeading(element.asText());
					String articleUrl = heading.getLink();
					HtmlPage articlePage = client.getPage(articleUrl);
				//	HtmlAnchor itemAnchor1 =  ((HtmlAnchor) articlePage.getByXPath("//div[@class='articlepage']"));
				//	String articleId = itemAnchor1.getAttribute("data-artid");
				//	System.out.println("articl"+articleId);
					List<HtmlElement> articleIdElement = (List<HtmlElement>) (Object)articlePage.getByXPath("//div[@class='articlepage']");
					List<HtmlElement> authorName = (List<HtmlElement>) (Object)articlePage.getByXPath("//a[starts-with(@class,'auth-nm')]") ;
					List<HtmlElement> articleElement = (List<HtmlElement>) (Object)articlePage.getByXPath("//div[starts-with(@id,'content-body')]/p") ;
					if(articleElement.isEmpty()) {
						System.out.println("No content found here");
					}else {
					//  System.out.println(articleElement.size());
					//	System.out.println(articleElement.get(0);
					//	System.out.println(authorName.get(0).asText());
						
						
						ArticleDetails details = new ArticleDetails();
						
						for(HtmlElement idElement: articleIdElement) {
							/*HtmlAnchor itemAnchor1 = ((HtmlAnchor) idElement.getFirstByXPath(".//div"));
							String articleId = itemAnchor1.getAttribute("data-artid");*/
							String articleId = idElement.getAttribute("data-artid");
							details.setArticleId(articleId);
						}
						
						StringBuilder builder = new StringBuilder();
						for(HtmlElement element1:articleIdElement) {
							builder.append(element1.asText());
						}
						if(!authorName.isEmpty()) {
							details.setAuthorName(authorName.get(0).asText());
							list.add(authorName.get(0).asText());
						}
						details.setHeading(heading.getHeading());
						details.setDetailedArticle(builder.toString());
						repository.save(details);
					//	System.out.println(details.toString());
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getAuthorName(){
		return list;
	}

}
