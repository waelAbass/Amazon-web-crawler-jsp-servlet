/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.model.DAO;
import com.model.product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AFAQE3
 */
public class myservlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        DAO dao = new DAO();
        String pcategory = request.getParameter("pcategory");
        System.out.println("categer noq is " + pcategory);
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("afterl")) {
            
            List<product> list = dao.getallafter(pcategory, (page - 1) * recordsPerPage,
                    5);
            System.out.println("page number  " + page);
           
            int noOfRecords = new DAO().noofrecord(pcategory);
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("after", list);
            request.setAttribute("noOfPages", noOfPages + page);
            request.setAttribute("currentPage", page);
            // HttpSession session = request.getSession();
            request.setAttribute("pcategory", pcategory);
            System.out.println("math is " + noOfPages);
            RequestDispatcher view = request.getRequestDispatcher("afterpag.jsp");
            view.forward(request, response);
        }
        if (action.equalsIgnoreCase("beforel")) {
            List<product> list = dao.getallbefore(pcategory, (page - 1) * recordsPerPage,
                    5);
            int noOfRecords = new DAO().noofrecord(pcategory);
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            System.out.println("inside before");
            request.setAttribute("before", list);
            request.setAttribute("noOfPages", noOfPages + page);
            request.setAttribute("currentPage", page);
            request.setAttribute("pcategory", pcategory);
            System.out.println("math is " + noOfPages);
            RequestDispatcher view = request.getRequestDispatcher("beforepag.jsp");
            view.forward(request, response);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
