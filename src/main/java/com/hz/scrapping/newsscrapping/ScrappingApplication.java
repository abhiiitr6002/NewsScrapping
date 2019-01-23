package com.hz.scrapping.newsscrapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class ScrappingApplication 
{
    public static void main( String[] args ){
    	ConfigurableApplicationContext context =  SpringApplication.run(ScrappingApplication.class, args);
    	context.start();
    }
}