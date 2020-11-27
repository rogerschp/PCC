<%-- 
    Roger Schmidt de Paula RGM: 11191102577
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="model.Produto"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
       
        <%
            String m1 = (String) request.getAttribute("mensagem");                
            
        %>
        <h1>
            
            <%out.println(m1);%>:
        </h1>
    </body>
</html>
