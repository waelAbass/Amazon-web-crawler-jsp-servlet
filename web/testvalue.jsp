<%-- 
    Document   : testvalue
    Created on : Jan 31, 2019, 4:19:46 PM
    Author     : AFAQE3
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/ecommerce" user="root" password="root" />

        <sql:query dataSource="${dataSource}" var="categories" scope="session">
            SELECT * FROM reviews
        </sql:query>
        <c:set var="categories" value="${categories}" />
        <c:set var="rowsPerPage" value="2" />

        <c:set var="x" value="10"/>
        <c:set var="pageNumber" value="${param.pageNumber}"/>
        <c:set var="a">
            <fmt:formatNumber value="${x/rowsPerPage}" maxFractionDigits="0"/>
        </c:set>

        <c:set var="b" value="${x/rowsPerPage}" />


        <c:choose>
            <c:when test="${a==0}">
                <c:set var="numberOfPages" value="1" scope="session"/>   
            </c:when>

            <c:when test="${b>a}">
                <c:set var="xxx" value="${b%a}"/>
                <c:if test="${xxx>0}">
                    <c:set var="numberOfPages" value="${b-xxx+1}" scope="session"/>   
                </c:if>
            </c:when>

            <c:when test="${a>=b}">
                <c:set var="numberOfPages" value="${a}" scope="session"/>    
            </c:when>
        </c:choose>

        <c:set var="start" value="${pageNumber*rowsPerPage-rowsPerPage}"/>
        <c:set var="stop" value="${pageNumber*rowsPerPage-1}"/>
    <center>
        <table border="1" width="40%">                    
            <c:set var="columns" value="0" scope="session"/>
            <c:forEach items="${colu}" var="name">
                <c:set var="columns" value="${columns+1}"/>
                <td bgcolor="silver"><c:out value="${name}"/></td>
            </c:forEach>
            <c:set var="columns" value="${columns-1}"/>

            <c:forEach items="3" var="row" begin="${start}" end="${stop}">
                <tr>
                    <c:forEach begin="0" end="${columns}" var="x">
                        <td><c:out value="${row[x]}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

        <%--For displaying Previous link --%>
        <c:if test="${pageNumber gt 1}">
            <a href="dispresult.jsp?pageNumber=${pageNumber - 1}">Previous</a>
        </c:if>
        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${i!=pageNumber}">
                    <a href="dispresult.jsp?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
                </c:when>
                <c:otherwise>
                    <c:out value="${i}"/>
                </c:otherwise>        
            </c:choose>       
        </c:forEach>  
        <%--For displaying Next link --%>
        <c:if test="${pageNumber lt numberOfPages}">
            <a href="dispresult.jsp?pageNumber=${pageNumber + 1}">Next</a>
        </c:if>
    </center>      
</body>
</html>
