<%-- 
    Document   : products
    Created on : Jan 31, 2019, 1:35:04 PM
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
        <title>Amazon Product Reviews</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
            // Var s = $('#category').val();
            // $('#ic').attr('href', 'myservlet?action=afterl&pcategory=' + s);
            //   $category = $('#category');
            function getComboA(selectObject) {
                var value = selectObject.value;
                document.getElementById();
                alert('valus is' + value);
            }
            // $category.Change (
            // function() {
            //   $.ajax({
            //     type: "GET",
            //        url: "retrieve",
            //          data: {category: $category.attr("selectedIndex") },
            //          success: function(data){
            //                $("#aftt").html(data)
            //          }
            //        });
            //     }
            //   );


        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div align="center">
            <h1>Amazon Products </h1>
            <%
                List<String> c = new DAO().getallproducts();
            %>


            <form action="myser">
                <p>Select product</p>
                <select id="category" name="pcategory" class="form-control" onchange="getComboA(this)">
                    <%
                        for (String s : c) {
                    %>
                    <option  value="<%=s%>"> 
                        <%= s%>
                    </option>
                    <%
                        }
                    %>

                </select>
                <br/><br/>
                <input type="submit" id="buttonSubmit" value="ALL Reviews" class="btn btn-primary" /> 
            </form>
            <jsp:include page="beforepag.jsp"/>  
            <jsp:include page="afterpag.jsp"/>
           
        </div>
    </body>
</html>
