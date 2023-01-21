<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Tarefas</title>
</head>
<body>
Olá: ${usuarioLogado.login }
<br><br>
<c:import url="logout-parcial.jsp"/>

Lista de Tarefas:




<c:forEach items="${listaTarefa }" var="lista">
<ul>
Tarefa: ${lista.tarefa }
Horario do dia: ${lista.hora }
Dia da semana: ${lista.diaDaSemana }
Dia do Mês: ${lista.diaDoMes }
<a href="/tarefas/controller?acao=MostraTarefa&id=${lista.id }">Editar</a>
<a href="/tarefas/controller?acao=RemoveTarefa&id=${lista.id }">Remover</a>
</ul>

</c:forEach>



</body>
</html>