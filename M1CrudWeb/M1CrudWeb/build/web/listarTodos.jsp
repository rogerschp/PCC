<%-- 
    Roger Schmidt de Paula RGM: 11191102577
--%>

<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CONSULTA</h1>
        <table>
        <%
            List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");            
            for (Produto prod : lprod) {
                %><tr><%
                %><td><%out.print(prod.getId());%></td><%
                %><td><%out.print(prod.getDescricao());%></td><%
                %><td><%out.print(prod.getPreco());%></td><%
                %></tr><%
            }
        %>
        </table>
    </body>
</html>
