<%-- 
    Document   : beforeFriday
    Created on : Feb 1, 2019, 10:07:43 AM
    Author     : AFAQE3
--%>
<%@page import="com.model.DAO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table border="1" align="left" id="aftt" class="table table-striped" >
            <caption> Review before white Friday included</caption>
            <tr>
                <th>Review Date</th>
                <th>Review Text</th>
            </tr>

            <c:forEach items="${before}" var="p">
                <tr>
                    <td>${p.date}</td>
                    <td>${p.title}</td>
                </tr>
            </c:forEach>

        </table>
        <%
            // System.out.println("erro here");
            if (request.getParameter("befpages") != null && !request.getParameter("befpages").isEmpty()) {
                System.out.println("inside if");
                int cou = Integer.parseInt(request.getParameter("befpages"));
                int no = cou / 5;
                for (int i = 1; i < cou; i++) {
        %>
         
        <%}} %>
        
    </body>
</html>
