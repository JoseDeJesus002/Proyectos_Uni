<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registro de producto</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }
        input[type=text], input[type=file], input[type=datetime] {
            width: 97%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
            font-size: 16px;
        }
        input[type=submit], a {
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            margin-top: 20px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        input[type=submit]:hover, a:hover {
            background-color: #3e8e41;
        }
		select {
			width: 100%;
			padding: 10px;
			border-radius: 5px;
			border: 1px solid #ccc;
			margin-bottom: 20px;
			font-size: 16px;
		}

    </style>
  </head>
<body>

		<?php
		include("querys/conexion.php");
			$con = conectar();
			date_default_timezone_set('America/Mexico_City');
			$fecha=date("d/m/Y");
			$hora=date('h:i:s');
		?>
		<br><br><br>
		<h1>Registro de producto</h1>
		<br><br><br>
		<div>
			<form action="querys/insertar.php" method="POST" enctype="multipart/form-data">
				<label>Id del producto</label><br>
				<input type="text" name="id_productos" maxlength="11" required><br>

				<label>Nombre</label><br>
				<input type="text" name="nombre" maxlength="30" required><br>
				
				<label>Cantidad</label><br>
				<input type="text" name="cantidad" maxlength="11" required><br>

				<label>Precio</label><br>
				<input type="text" name="precio" maxlength="5" required><br>

				<label for="categoria">Categoría:</label>
				<select name="categoria" required>
				
				<option value="">Selecciona una categoria</option>
				<output label="categorias">
					<?php
					$categoria = "SELECT * FROM categorias";
					$resultado=mysqli_query($con,$categoria);
					while ($row = mysqli_fetch_array($resultado)) 
					{
						echo '<option value="'.$row['id_categoria'].'">'.$row['categoria'].'</option>';
					}
					?>
				</output>
				</select><br>
				
				<label>Imagen</label><br>
				<input type="file" name="imagen" required><br>

				<label>Fecha de registro</label><br>
				<input type="datetime" name="fecha_ingreso" value="<?= $fecha?>" readonly><br>

				<label>Hora de registro</label><br>
				<input type="text" name="hora_ingreso" value="<?= $hora?>" readonly><br>

				<input type="submit" name="agregar" value="AGREGAR">

				<a href="index.php">REGRESAR</a>
			</form>
		</div>
		<br><br><br>
</body>
</html>