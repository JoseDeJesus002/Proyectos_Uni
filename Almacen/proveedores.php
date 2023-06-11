<?php
include("querys/conexion.php");
$con = conectar();
$sql = "SELECT * FROM proveedores";
$query = mysqli_query($con, $sql);
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
	<style>
      /* Estilos para el menú */
      *{
    margin: 0;
}
      .menu {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: auto;
        background-color: #333;
      }
      .menu li {
        float: left;
      }
      .menu li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
      }
      .menu li a:hover {
        background-color: #111;
      }
      .menu .active {
        background-color: #4CAF50;
      }
      
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

  /* Estilo para los enlaces */
  a {
    text-decoration: none;
    color: black;
  }

  a:hover {
    color: #4CAF50;
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
  input[type="button"],
  input[type="submit"] {
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
<ul class="menu">
      <li><a href="main.php">Menu</a></li>
      <li><a href="index.php">Inventario</a></li>
      <li><a href="registro_proveedores.php">Registro de proveedores</a></li>
      <li><a href="pedidos.php">Pedidos</a></li>
      <li><a href="proveedores.php"class="active">Proveedores</a></li>
      <li>
      <form action="login/logout.php" method="post">
          <button type="submit">Cerrar sesión</button>
      </form>
      </li>
    </ul>
</div>
<h1 class="title" align="center">Proveedores</h1>
<!-- Generacion de PDF -->
<h2 align="center">Generar PDF entrada de productos</h2>
	<form align="center" action="pdf/pdf-provedores.php" method="post">
    Desde:
    <input type="date" value="<?php echo date('Y-m-d'); ?>" name="desde" id="desde"/>
    Hasta:
    <input type="date" value="<?php echo date('Y-m-d'); ?>" name="hasta" id="hasta"/>
    <td>
      <input type="submit"value="General PDF" style="padding: 10px; font-size: 10px;"></input>
    </td>
    </tr>
    </form>
<br><br><br>

	<!-- Barra de busquedas -->
	<form action="proveedores.php" method="post">
		<div align="center">
			<label for="search-id"></label>Buscar Proveedor:
			<input type="text" id="search-id" name="id" style="padding: 10px; font-size: 10px; width: 50%; margin: 10px;">
			<input type="submit" value="Buscar" style="padding: 10px; font-size: 10px;">
		</div>
	</form>
	<?php
	if (isset($_POST['id'])) {
		$id = $_POST['id'];
		$sql = "SELECT * FROM proveedores WHERE id_proveedor = '$id' OR nombre = '$id'";
		$query = mysqli_query($con, $sql);
	}

	// verificar si hay productos por debajo del stock minimo
	$cant = "SELECT nombre,cantidad FROM productos where cantidad <= 5";
	$querys = mysqli_query($con, $cant);
	//si hay productos por debajo del stock minimo, se mostrara un mensaje
	if (mysqli_num_rows($querys) > 0) {
		echo '<script language="javascript">alert("Algunos productos necesitan reabastecerse");</script>';
	}

	while ($row = mysqli_fetch_array($querys)) {
		echo "<h3 align='center'>El producto " . $row['nombre'] . " se encuentra por debajo del stock minimo</h3>";
	}

	?>
	<br>
	<table class="table" border="white">
		<thead>
			<tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Fotografia</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>Rubro</th>
                <th>Correo Electronico</th>
                <th>Actualizar</th>
                <th>Eliminar</th>
			</tr>

		</thead>
		<tbody>
			<?php
			while ($row = mysqli_fetch_array($query)) {
			?>
				<tr class="contenido">
					<td><?php echo $row['id_proveedor'] ?></td>
					<td><?php echo $row['nombre'] ?></td>
					<td><img width="100"src="data:image/jpg;base64,<?php echo base64_encode($row['fotografia']); ?>"></td>
          <td><?php echo $row['direccion'] ?></td>
					<td><?php echo $row['telefono'] ?></td>
					<td><?php echo $row['rubro']?></td>
					<td><?php echo $row['correo_electronico'] ?></td>
					<td><a href="actualizar.php?id=<?php echo $row['id_proveedor'] ?>">
							<img src="img/editar.png" width="30" height="30">
						</a></td>
					<td><a href="querys/eliminar.php?id=<?php echo $row['id_proveedor']?>">
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