/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.vdurmont.emoji.EmojiParser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AFAQE3
 */
public class DAO {

    public void insertproduct(Review r) throws ClassNotFoundException {

        try {
            String sql = "insert into reviews(rtime,title,ASIN,Pname) values (?,?,?,?)";
            System.out.println("hereee");
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            String x = EmojiParser.removeAllEmojis(r.getTitle());
            pre.setDate(1, r.getDate());
            pre.setString(2, x);
            pre.setString(3, r.getASIN());
            pre.setString(4, r.getPname());
            int i = pre.executeUpdate();
            System.out.println(" sql props i " + i);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getErrorCode());
            //   Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List getallproducts() {
        List<String> ldata = new ArrayList();
        try {
            String sql = "select DISTINCT pname from reviews ";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                System.out.println("p name is " + rs.getString(1));
                ldata.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }

    public List<product> getallbefore(String pname) {
        List<product> ldata = new ArrayList();
        try {
            String sql = "select * from reviews where rtime < '2018-11-30' and Pname=?  ";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            pre.setString(1, pname);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product p = new product();
                //  System.out.println("p name is "+rs.getString(1));
                p.setDate(rs.getString(1));
                p.setTitle(rs.getString(2));
                ldata.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }

    public List<product> getallbefore(String pname, int offset, int count) {
        List<product> ldata = new ArrayList();
        try {
            String sql = "select * from reviews where rtime < '2018-11-30' and Pname=? limit ? , ? ";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            pre.setString(1, pname);
            pre.setInt(2, offset);
            pre.setInt(3, count);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product p = new product();
                //  System.out.println("p name is "+rs.getString(1));
                p.setDate(rs.getString(1));
                p.setTitle(rs.getString(2));
                ldata.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }

    public int noofrecord(String productname) throws ClassNotFoundException {
        int count = 0;
        try {
            String sql = "select count(*) from reviews where Pname=?";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            pre.setString(1, productname);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ++count;
                System.out.println("count is " + count);
                // Get data from the current row and use it
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
         //   Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public List<product> getallafter(String pname) {
        List<product> ldata = new ArrayList();
        try {
            String sql = "select * from reviews where rtime > '2018-11-30' and Pname=? ";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            pre.setString(1, pname);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product p = new product();
                //  System.out.println("p name is "+rs.getString(1));
                p.setDate(rs.getString(1));
                p.setTitle(rs.getString(2));
                ldata.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }

    public List<product> getallafter(String pname, int offset, int count) {
        List<product> ldata = new ArrayList();
        try {
            String sql = "select * from reviews where rtime > '2018-11-30' and Pname=? limit ? , ?";
            PreparedStatement pre = Dbconnection.getconn().prepareCall(sql);
            pre.setString(1, pname);
            pre.setInt(2, offset);
            pre.setInt(3, count);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product p = new product();
                //  System.out.println("p name is "+rs.getString(1));
                p.setDate(rs.getString(1));
                p.setTitle(rs.getString(2));
                ldata.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Logger.getLogger(empoperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }

}
