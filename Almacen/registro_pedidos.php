<?php
	include("querys/conexion.php");
	$con = conectar();

	date_default_timezone_set('America/Mexico_City');
	$fecha=date("Y/m/d");
	$hora=date('h:i:s');
	$id=$_GET['id'];
	$sql = "SELECT * FROM productos WHERE id_productos = '$id'";
	$query = mysqli_query($con,$sql);
	$row = mysqli_fetch_array($query);
    $sql2 = "SELECT * FROM pedidos";
    $query = mysqli_query($con,$sql2);
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Agregar stock</title>
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
        input[type=text], input[type=file], input[type=datetime], input[type=number] {
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
<div>
    <a href="index.php">Inicio</a>
    <a href="agregar.php">Nuevo Registro</a>
    <h1 align="center">Registrar un Pedido</h1>

    <form action="querys/agregar_stock.php" method="POST">
        <div>
                <input type="text" name="id_pedido" maxlength="11" hidden><br>

                <label>Id del producto</label><br>
                <input type="text" name="id_productos" maxlength="11" value="<?php echo $row['id_productos']?>" readonly><br><br>

                <label>Nombre del producto</label><br>
                <input type="text" name="nombre" maxlength="30" value="<?php echo $row['nombre']?>" readonly><br><br>

                <label>Cantidad</label><br>
				<input type="number" placeholder="Ingresa la cantidad" name="cantidad" maxlength="11" required><br><br>

                <label>Total del pedido</label><br>
                <input type="text" name="total" required><br><br>
               
                <label>Fecha de ingreso</label><br>
                <input type="text" name="fecha_ingreso" value="<?= $fecha?>"readonly><br><br>

                <label>Hora de ingreso</label><br>
                <input type="text" name="hora_ingreso" value="<?= $hora?>" readonly><br><br>
                
                <label>proveedor</label><br>
                <select name="proveedor" required>
                <option value="">Selecciona un proveedor</option>
                <output label="proveedores">
                    <?php
                    $categoria = "SELECT * FROM proveedores";
					$resultado=mysqli_query($con,$categoria);
					while ($row = mysqli_fetch_array($resultado)) 
					{
						echo '<option value="'.$row['id_proveedor'].'">'.$row['nombre'].'</option>';
					}
                    ?>
                </output>
                </select>
                <br><br>

                <input type="submit" name="" value="Actualizar">
                <a href="index.php">REGRESAR</a>
        </div>
</form>