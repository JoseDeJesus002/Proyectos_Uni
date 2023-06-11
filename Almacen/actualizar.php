<?php
	include("querys/conexion.php");
	$con = conectar();

	date_default_timezone_set('America/Mexico_City');
	$fecha=date("d/m/Y");
	$hora=date('h:i:s');
	$id=$_GET['id'];
	$sql = "SELECT * FROM productos WHERE id_productos = '$id'";
	$query = mysqli_query($con,$sql);
	$row = mysqli_fetch_array($query);
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Actualizar Producto</title>
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
		<div>
			<form action="querys/update.php" method="POST" enctype="multipart/form-data">
				<label>Id del producto</label><br>
				<input type="text" name="id_productos" maxlength="11" value="<?php echo $row['id_productos']?>" readonly><br><br>

				<label>Nombre</label><br>
				<input type="text" name="nombre" maxlength="30" value="<?php echo $row['nombre']?>"><br><br>
				
				<label>Cantidad</label><br>
				<input type="text" name="cantidad" maxlength="11" value="<?php echo $row['cantidad']?>"><br><br>

				<label>Precio</label><br>
				<input type="text" name="precio" maxlength="5" value="<?php echo $row['precio']?>"><br><br>

				<label>Imagen</label><br>
				<img width="100"src="data:image/jpg;base64,<?php echo base64_encode($row['imagen']); ?>"> <br><br>
				<br><br>

				<label>Fecha de atualizacion</label><br>
				<input type="text" name="fecha_ingreso" value="<?= $fecha?>"readonly><br><br>

				<label>Hora de actualizacion</label><br>
				<input type="text" name="hora_ingreso" value="<?= $hora?>" readonly><br><br>

				<label for="categoria">Categoría:</label>
				<select name="categoria" required>
					<?php
					$categorias = "SELECT categorias.id_categoria,categorias.categoria FROM productos INNER JOIN categorias ON categorias.id_categoria = productos.categoria WHERE productos.id_productos = '$id'";
					$resultado=mysqli_query($con,$categorias);

					while ($row = mysqli_fetch_array($resultado)) 
					{
						echo '<option value="'.$row['id_categoria'].'">'.$row['categoria'].'</option>';
					}
					?>
				</select>
				<br><br>

				<input type="submit" name="" value="Actualizar">

				<a href="index.php">REGRESAR</a>
			</form>
		</div>
</body>
</html>
