/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SetProperty;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author AFAQE3
 */
public class CrawlerOperations {

    public List<Review> getallreviews(String url, int pno) throws IOException, ParseException {
        System.out.println("url is " + url);
        String t = url.substring(8);
        String g[] = t.split("/");
        
        List<Review> reviews = new ArrayList<>();
        for (int i = 1; i < pno; i++) {
            System.out.println("page number " + i);
            Document doc = Jsoup.connect(url +"ref=cm_cr_dp_d_show_all_btm?ie=UTF8&reviewerType=all_reviews&pageNumber="+ i).get();
            Elements reviewElements = doc.select(".review");
            if (reviewElements == null || reviewElements.isEmpty()) {
                //    break;
            }

            for (Element reviewElement : reviewElements) {

                Element titleElement = reviewElement.select(".review-title").first();
                Element reviewdateElement = reviewElement.select(".review-date").first();
                if (titleElement == null) {
                    //       LOG.error("Title element is null");
                    System.out.println(titleElement.text());
                    System.out.println("review date" + reviewdateElement.text());
                    continue;
                }
                String title = titleElement.text();
                //   System.out.println("yaraba "+reviewdateElement.text());
                String reviedate = reviewdateElement.text();

                Element textElement = reviewElement.select(".review-text").first();
                if (textElement == null) {
                    //        LOG.error("Text element is null");
                    continue;
                }
                String text = textElement.text();
                System.out.println("text data" + text);
                if (!(reviedate.indexOf(",")==-1)) {
                    System.out.println("in comma");
                    String datearr[] = reviedate.split(",");
                    String year = datearr[1].trim();
                    String dat2[] = datearr[0].split(" ");
                    String mon = new utilsclass().getmap(dat2[0]);
                    String day = dat2[1];
                    String tdate = year + "-"+mon+"-"+ day;
                    Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(tdate);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    reviews.add(new Review(title, text, sqlDate,g[1], g[3]));
                } else {
                    String datearr[] = reviedate.split(" ");
                    String day = datearr[0];
                    String year = datearr[2];
                    String mon = new utilsclass().getmap(datearr[1]);
                    String tdate = year + "-" + mon + "-" + day;
                    Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(tdate);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    reviews.add(new Review(title, text, sqlDate,g[1], g[3]));
                }
            }

            // pageNumber++;
            // System.out.println("page number " + pageNumber);
            //   }
            //   LOG.info("Number of reviews: {}", reviews.size());
            // SimpleDateFormat formatter2=new SimpleDateFormat("dd  yyyy");
            for (Review review : reviews) {
                System.out.println(review.getTitle());
                System.out.println(review.getText());
                System.out.println("after edition , " + review.getDate());
                System.out.println(review.getDate());
                System.out.println("\n");
            }
        }
        return reviews;
    }
}
