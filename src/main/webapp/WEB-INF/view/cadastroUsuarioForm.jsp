<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastra Tarefa</title>
</head>
<body>

<form action="/tarefas/controller" method="post">
Login: <input type="text" name="login"/>
Senha: <input type="password" name="senha"/>
Senha: <input type="password" name="senha2"/>


<input type="hidden" name="acao" value="CadastroUsuario"/>

<input type="submit" value="Cadastrar"/>
<br><br>
Mensagem: ${mensagem }





</form>

</body>
</html>