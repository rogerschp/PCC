<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./ProductServlet" method="post"> 
        <!-- Create an element with mandatory name attribute, 
        so that data can be transfer to the servlet using getParameter() -->
        <input type="text" name="nameProduct" placeholder="Nome do Produto:"/> 
        <br/> 
        <input type="text" name="amountProduct" placeholder="Quantidade de produtos:"/> 
        <br/><br/><br/> 
        <input type="submit"  name="registerProduct">Cadastrar produto</input>
        <input type="submit"  name="readProduct">Listar todos os produtos</input>
        <input type="submit"  name="updateProduct">Editar produto</input>
        <input type="submit"  name="deleteProduct">Deletar produto</input> 
    </form> 
</body>
</html>