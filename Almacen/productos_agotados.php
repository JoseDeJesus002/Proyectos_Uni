<?php
include("querys/conexion.php");
$con = conectar();
$sql = "SELECT * FROM productos_agotados";
$query = mysqli_query($con, $sql);
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos Agotados</title>
	<style>
		   /* Estilos para el título */
		   .title {
        text-align: center;
        font-size: 36px;
        font-weight: bold;
      }
	    /* Estilo para la tabla */
  table {
    border-collapse: collapse;
    margin: 0 auto;
  }

  th,
  td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
  }

  .contenido:hover {
    background-color: #f5f5f5;
  }
  /* Estilo para los formularios */
  form {
    margin-bottom: 20px;
  }

  /* Estilo para los mensajes de alerta */
  .alert {
    padding: 20px;
    background-color: #f44336;
    color: white;
    margin-bottom: 15px;
  }

  /* Estilo para los títulos */
  h1,
  h2,
  h3 {
    text-align: center;
    font-family: Arial, Helvetica, sans-serif;
  }

  /* Estilo para las etiquetas */
  label {
    display: block;
    margin-bottom: 5px;
  }

  /* Estilo para los inputs */
  input[type="text"],
  input[type="date"] {
    padding: 10px;
    font-size: 15px;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin: 5px;
    width: 20%;
    box-sizing: border-box;
  }
  input[type="submit"],
  input[type="button"] {
    padding: 10px;
    font-size: 14px;
    border-radius: 5px;
    border: none;
    background-color: #4CAF50;
    color: white;
  }
	</style>
  </head>
<div>
	<input type="button" value="Regresar" onclick="location.href='index.php'">
	<br><br><br>
	<h1 class="title"align="center">Productos agotados</h1>
	<form action="index.php" method="post">
		<div align="center">
			<label for="search-id"></label>Buscar por ID:
			<input type="text" id="search-id" name="id" style="padding: 10px; font-size: 10px; width: 50%; margin: 10px;">
			<input type="submit" value="Buscar" style="padding: 10px; font-size: 10px;">
		</div>
	</form>
	<?php
	if (isset($_POST['id'])) {
		$id = $_POST['id'];
		$sql = "SELECT * FROM productos_agotados WHERE id_productos = '$id'";
		$query = mysqli_query($con, $sql);
	}
	?>
	<br>
	<table class="table" border="white">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Imagen</th>
				<th>Fecha de salida</th>
				<th>Hora de salida</th>
				<th>Eliminar</th>
			</tr>

		</thead>
		<tbody>
			<?php
			while ($row = mysqli_fetch_array($query)) {


			?>
				<tr class="contenido">
					<td><?php echo $row['id_productos'] ?></td>
					<td><?php echo $row['nombre'] ?></td>
					<td><?php echo $row['cantidad'] ?></td>
					<td><?php echo $row['precio'] ?></td>
					<td><img width="100"src="data:image/jpg;base64,<?php echo base64_encode($row['imagen']); ?>"></td>
					<td><?php echo $row['fecha_salida'] ?></td>
					<td><?php echo $row['hora_salida'] ?></td>
					<td><a href="querys/eliminar_productos_descontinuados.php?id=<?php echo $row['id_productos'] ?>">
							<img src="img/eliminar.png" width="30" height="30">
						</a></td>
				</tr>

			<?php
			}
			?>
		</tbody>
</div>
</body>

</html>