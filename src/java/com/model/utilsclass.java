/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AFAQE3
 */
public class utilsclass {
    public String getmap(String input) {
        String m = "";
        if (input.equalsIgnoreCase("January")) {
            m = "01";
        }
        if (input.equalsIgnoreCase("February")) {
            m = "02";
        }
        if (input.equalsIgnoreCase("March")) {
            m = "03";
        }
        if (input.equalsIgnoreCase("April")) {
            m = "04";
        }
        if (input.equalsIgnoreCase("May")) {
            m = "05";
        }
        if (input.equalsIgnoreCase("June")) {
            m = "06";
        }
        if (input.equalsIgnoreCase("July")) {
            m = "07";
        }
        if (input.equalsIgnoreCase("August")) {
            m = "08";
        }
        if (input.equalsIgnoreCase("September")) {
            m = "09";
        }
        if (input.equalsIgnoreCase("October")) {
            m = "10";
        }
        if (input.equalsIgnoreCase("November")) {
            m = "11";
        }
        if (input.equalsIgnoreCase("December")) {
            m = "12";
        }
        return m;
    }
}
