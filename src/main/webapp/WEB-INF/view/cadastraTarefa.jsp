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
Tarefa: <input type=text name="tarefa">
Horário do dia: <input type="text" name="horaDoDia">
Dia da semana: <input type="text" name="diaDaSemana">
Dia do mês: <input type="text" name="diaDoMes">
<input type="hidden" name="acao" value="NovaTarefa"/>

<input type="submit" value="Registrar Tarefa!"/>




</form>

</body>
</html>