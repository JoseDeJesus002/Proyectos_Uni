<?php
include("querys/conexion.php");
$con = conectar();
$sql = "SELECT * FROM productos";
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
      <li><a href="index.php"class="active">Inventario</a></li>
      <li><a href="registro_proveedores.php">Registro de proveedores</a></li>
      <li><a href="pedidos.php">Pedidos</a></li>
      <li><a href="proveedores.php">Proveedores</a></li>
      <li>
      <form action="login/logout.php" method="post">
          <button type="submit">Cerrar sesión</button>
      </form>
      </li>
    </ul>

	<br>
	<br>
	<h1 class="title"align="center">Inventario</h1>
	<!-- Generacion de PDF -->
	<h2 align="center">Generar PDF entrada de productos</h2>
	<form align="center" action="pdf/pdf-entradas.php" method="post">
    Desde:
    <input type="date" value="<?php echo date('Y-m-d'); ?>" name="desde" id="desde"/>
    Hasta:
    <input type="date" value="<?php echo date('Y-m-d'); ?>" name="hasta" id="hasta"/>
    <td>
      <input type="submit"value="General PDF" style="padding: 10px; font-size: 10px;"></input>
    </td>
    </tr>
    </form>
	<!-- Barra de busquedas -->
	<form action="index.php" method="post">
		<div align="center">
			<label for="search-id"></label>Buscar Producto:
			<input type="text" id="search-id" name="id" style="padding: 10px; font-size: 10px; width: 50%; margin: 10px;">
			<input type="submit" value="Buscar" style="padding: 10px; font-size: 10px;">
		</div>
	</form>
	<?php
	if (isset($_POST['id'])) {
		$id = $_POST['id'];
		$sql = "SELECT * FROM productos WHERE id_productos = '$id' OR nombre = '$id'";
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
	<br><br>
	<table class="table" border="white">
		<thead>
      <tr>
      <input type="button" value="Agregar producto" onclick="location.href='agregar.php'">
		<br>
		<br>
		<input type="button" value="Productos agotados" onclick="location.href='productos_agotados.php'">
		<br>
		<br>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Categoria</th>
				<th>Imagen</th>
				<th>Fecha de registro</th>
				<th>Hora de registro</th>
				<th>Editar</th>
				<th>Agregar Unidades</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
		<br>
		
			<?php
			while ($row = mysqli_fetch_array($query)) {
			?>
				<tr class="contenido">
					<td><?php echo $row['id_productos'] ?></td>
					<td><?php echo $row['nombre'] ?></td>
					<td><?php echo $row['cantidad'] ?></td>
					<td><?php echo $row['precio'] ?></td>
					<td><?php echo $row['categoria']?></td>
					<td><img width="100"src="data:image/jpg;base64,<?php echo base64_encode($row['imagen']); ?>"></td>
					<td><?php echo $row['fecha_ingreso'] ?></td>
					<td><?php echo $row['hora_ingreso'] ?></td>
					<td><a href="actualizar.php?id=<?php echo $row['id_productos'] ?>">
							<img src="img/editar.png" width="30" height="30">
						</a></td>
					<td><a href="registro_pedidos.php?id=<?php echo $row['id_productos'] ?>"> <img src="img/plus.png" width="30" height="30"> </a></td>
					<td><a href="querys/eliminar_productos.php?id=<?php echo $row['id_productos']?>">
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