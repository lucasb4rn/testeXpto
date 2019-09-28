<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>IMPORTAR ARQUIVO CSV CIDADES</title>
</head>

<body>
	<div>
		<form method="POST" enctype="multipart/form-data" action="/arquivo">
			Selecionar arquivo: 
			<br>
			<input type="file" name="file" /> 
			<br>
			<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>



</body>
</html>