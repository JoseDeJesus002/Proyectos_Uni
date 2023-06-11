<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registro de proveedores</title>
  <style>
    /* Estilos para el menú */
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

    input[type=text],
    input[type=file] {
      width: 97%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      margin-bottom: 20px;
      font-size: 16px;
    }

    input[type=submit],
    a {
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

    input[type=submit]:hover,
    a:hover {
      background-color: #3e8e41;
    }
  </style>
</head>

<body>
  <?php
  include("querys/conexion.php");
  $con = conectar();
  ?>
  <br><br><br>
  <h1>Registro de proveedores</h1>
  <br><br><br>
  <div>
    <form action="querys/insertar_proveedores.php" method="POST" enctype="multipart/form-data">

      <label>Nombre</label><br>
      <input type="text" name="nombre" maxlength="30" required><br>

      <label>Fotografia</label><br>
      <input type="file" name="imagen" required><br>

      <label>Direccion</label><br>
      <input type="text" name="direccion" maxlength="30" required><br>

      <label>Telefono</label><br>
      <input type="text" name="telefono" maxlength="30" required><br>

      <label>Rubro</label><br>
      <input type="text" name="rubro" maxlength="30" required><br>

      <label>Correo</label><br>
      <input type="text" name="correo" required><br>

      <input type="submit" name="agregar" value="AGREGAR">

      <a href="index.php">REGRESAR</a>
    </form>
  </div>
  <br><br><br>
</body>

</html>