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
Tarefa: <input type=text name="tarefa" value="${tarefa.tarefa }"/>
Hor�rio do dia: <input type=text name="horaDoDia" value="${tarefa.hora }"/>
Dia da semana: <input type=text name="diaDaSemana" value="${tarefa.diaDaSemana }"/>
Dia do m�s: <input type=text name="diaDoMes" value="${tarefa.diaDoMes }"/>
<input type="hidden" name="id" value="${tarefa.id }"/>

<input type="hidden" name="acao" value="AlteraTarefa" />

<input type="submit" value="Alterar Tarefa!"/>




</form>

</body>
</html>