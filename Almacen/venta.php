<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registro de venta</title>
  </head>
  <body>
    <?php
    include("querys/conexion.php");
$con = conectar();
if (isset($_POST['agregar_venta'])) {
  // Obtenemos los datos del formulario
  $id_productos = $_POST['id_productos'];
  $cantidad = $_POST['cantidad'];
  // Verificamos que la cantidad de productos a vender no sea mayor que la cantidad disponible en inventario
  $query = "SELECT cantidad FROM productos WHERE id_productos = $id_productos";
  $result = mysqli_query($con, $query);
  $row = mysqli_fetch_array($result);

  if ($cantidad > $row['cantidad']) {
    echo "Error: la cantidad a vender es mayor que la cantidad disponible en inventario.";
  } else {
    $query = "INSERT INTO ventas (id_producto, cantidad) VALUES ($id_productos, $cantidad)";
    mysqli_query($con, $query);

    // Actualizamos la cantidad disponible en inventario
    $nueva_cantidad = $row['cantidad'] - $cantidad;
    $query = "UPDATE productos SET cantidad = $nueva_cantidad WHERE id_productos = $id_productos";
    mysqli_query($con, $query);

    // Mostramos un mensaje de éxito
    echo "La venta ha sido registrada exitosamente.";
  }
}
?>

<div>
  <form action="venta.php" method="POST">
    <label>Id del producto</label><br>
    <input type="text" name="id_producto" maxlength="11"><br>

    <label>Cantidad</label><br>
    <input type="text" name="cantidad" maxlength="11"><br>

    <input type="submit" name="agregar_venta" value="AGREGAR VENTA">

    <a href="index.php">REGRESAR</a>
  </form>
</div>
  </body>
</html>


