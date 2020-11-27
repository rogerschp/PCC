<%-- 
    Roger Schmidt de Paula RGM: 11191102577
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Produto</h1>
        <h2>Todos os campos precisam estar em branco para consultar o botão Visualizar</h2>
        <form action="ControleManterProduto" method="post">
            ID: <input type="text" name="txtid"> <br>
            Descrição: <input type="text" name="txtdescricao"> <br>
            Preço: <input type="text" name="txtpreco"> <br>
            <input type="submit" name="btnoperacao" value="Cadastrar">
            <input type="submit" name="btnoperacao" value="Deletar">
            <input type="submit" name="btnoperacao" value="Alterar">
            <input type="submit" name="btnoperacao" value="Visualizar">
            
        </form>
    </body>
</html>
