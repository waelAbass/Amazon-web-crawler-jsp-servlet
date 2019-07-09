/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AFAQE3
 */
public class retrieve extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("application/json;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        System.out.println("hrrrrrrrrrrrrr");
        String pcategory = request.getParameter("category");
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            System.out.println("inside page");
            request.setAttribute("befpages", new DAO().getallbefore(pcategory).size());
            request.setAttribute("aftpages", new DAO().getallafter(pcategory).size());
            int offset = Integer.parseInt(request.getParameter("page"));
            int total = 5;
            System.out.println("ccccccccc");
            request.setAttribute("before", new DAO().getallbefore(pcategory, offset, total));
            request.setAttribute("after", new DAO().getallafter(pcategory, offset, total));
            //System.out.println("no of after" + new DAO().getallafter(pcategory).size());
            RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("befpages", new DAO().getallbefore(pcategory).size());
            request.setAttribute("aftpages", new DAO().getallafter(pcategory).size());
            // int offset = Integer.parseInt(request.getParameter("page"));
            int total = 5;
            request.setAttribute("before", new DAO().getallbefore(pcategory));
            request.setAttribute("after", new DAO().getallafter(pcategory));
            //System.out.println("no of after" + new DAO().getallafter(pcategory).size());
            RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
            dispatcher.forward(request, response);
        }
        //  int start = Integer.parseInt(request.getParameter("start"));
        //  int total = Integer.parseInt(request.getParameter("total"));

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
