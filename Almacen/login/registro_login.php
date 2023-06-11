<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro de Usuario</title>
<style>
	body {
		background-color: #f1f1f1;
		font-family: Arial, sans-serif;
	}

	form {
		background-color: white;
		border-radius: 10px;
		padding: 20px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
		max-width: 500px;
		margin: auto;
	}

	h1 {
		font-size: 28px;
		margin-bottom: 20px;
		text-align: center;
	}

	label {
		display: block;
		font-size: 16px;
		margin-bottom: 5px;
	}

	input[type="text"],
	input[type="password"],
	input[type="email"],
	input[type="number"] {
		width: 95%;
		padding: 10px;
		border: 1px solid #ccc;
		border-radius: 5px;
		margin-bottom: 15px;
	}

	input[type="submit"] {
		background-color: #4CAF50;
		color: white;
		padding: 10px 20px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
		font-size: 16px;
		margin-top: 10px;
	}

	input[type="submit"]:hover {
		background-color: #3e8e41;
	}

	a {
		display: block;
		text-align: center;
		margin-top: 20px;
	}
</style>

</head>
<body>
	<?php
	include("../querys/conexion.php");
	$con = conectar();
	?>
	<br>
	<br>
	<br>
	<div>
		<form action="registrar_login.php" method="POST" enctype="multipart/form-data">
			<h1>REGISTRO DE USUARIO</h1>
			<label>ID rol:</label><br>
			<input type="text" name="id_rol" maxlength="30" value="1"><br>
			<label>Nombre:</label><br>
			<input type="text" name="nombres" maxlength="50" required><br>
			<label>Apellido paterno:</label><br>
			<input type="text" name="ap" maxlength="50" required><br>
			<label>Apellido materno:</label><br>
			<input type="text" name="am" maxlength="50" required><br>
			<label>Edad:</label><br>
			<input type="number" name="edad" min="18" max="99" required><br>
			<label>Usuario:</label><br>
			<input type="text" name="usuario" maxlength="20" required><br>
			<label>Contraseña:</label><br>
			<input type="password" name="password" maxlength="20" required><br>
			<label>Correo:</label><br>
			<input type="email" name="correo" maxlength="40" required><br>
			<input type="submit" name="agregar" value="Agregar">
			<a href="login.php">Inicio de Sesión</a>
		</form>
		<br>
		<br>
		<br>
	</div>
</body>
</html>