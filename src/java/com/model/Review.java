/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Date;

/**
 *
 * @author AFAQE3
 */
public class Review {

    private final String title;
    private final String text;
    private final Date date;
    private final String pname;
    private final String ASIN;
    public String getTitle() {
        return title;
    }

    public String getPname() {
        return pname;
    }

    public String getASIN() {
        return ASIN;
    }

    public Review(String title, String text, Date date, String pname, String ASIN) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.pname = pname;
        this.ASIN = ASIN;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
    
     
}
