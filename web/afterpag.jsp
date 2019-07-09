<%-- 
    Document   : myjsp
    Created on : Feb 7, 2019, 12:03:05 PM
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
        <table border="1"  width="100"  cellpadding="5" class="table table-striped" cellspacing="5">
            <tr>
                <th>Review date</th>
                <th>Review title</th>

            </tr>
            <div class="text-primary"> product reviews for  ${pcategory} after white friday</div>
             <%
             
             %>
            <c:forEach items="${after}" var="p">
                <tr>
                    <td>${p.date}</td>
                    <td>${p.title}</td>
                </tr>
            </c:forEach>
        </table>

        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
            <a href="myser?action=afterl&page=${currentPage - 1}&pcategory=${pcategory}">Previous</a>
        </c:if>

        <%--For displaying Page numbers. 
        The when condition does not display a link for the current page--%>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    ${i}
                </c:when>
                <c:otherwise>
                    <a href="myser?action=afterl&page=${i}&pcategory=${pcategory}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>



        <%--For displaying Next link --%>
        <c:if test="${currentPage lt noOfPages}">
            <a href="myser?action=afterl&page=${currentPage + 1}&pcategory=${pcategory}" >Next</a>
        </c:if>
            <br>
            <br>
            
    </body>
</html>
