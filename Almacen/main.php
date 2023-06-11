<?php
  session_start();
  if (!isset($_SESSION['usuario'])) {
    header('Location: login/login.php');
    exit();
  }
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Menu inicial</title>
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
      
      /* Estilos para el botón de cerrar sesión */
      .logout-btn {
        background-color: #f44336;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 20px;
        margin-left: auto;
        margin-right: 20px;
        display: block;
      }
      .logout-btn:hover {
        background-color: #d32f2f;
      }
      .servicios{
    display: flex;
    flex-wrap: wrap;
    margin-bottom: 50px;
    margin: auto;
    max-width: 1100px;
    padding: 20px;
  }
  /* estilo servicio */
  .servicios .col{
    text-align: center;
  }
  .servicios .col .card{
    border: 1px solid black;
    height: 300px;
    width: 250px;
    background-color: black;
    padding: 30px;
    color: white;
    border-radius: 20px;
    margin: 20px;
  }
  .servicios .col .card p{
    padding: 20px;
  }
  .servicios .icono{
    width: 50px;
    height: 50px;
    margin: auto;
    border-radius: 70%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 30px;
}
.servicios .icono .circulo{
    justify-content: center;
    align-items: center;
    color: white;
    font-size: 45px;
}
    </style>
  </head>
  <body>
    <ul class="menu">
      <li><a href="main.php" class="active">Menu</a></li>
      <li><a href="index.php">Inventario</a></li>
      <li><a href="registro_proveedores.php">Registro de proveedores</a></li>
      <li><a href="pedidos.php">Pedidos</a></li>
      <li><a href="proveedores.php">Proveedores</a></li>
      <div class="derecha">
      <form action="login/logout.php" method="post">
          <button type="submit">Cerrar sesión</button>
      </form>
      </div>
    </ul>
    <br>
    <br>
    <h1 class="title">Bienvenido <?php echo $_SESSION['usuario']; ?></h1>
    <br>
    <br>
    <div class="servicios" align="center">
        <div class="col">
          <div class="card">
            <div class="icono color1">
              <div class="circulo">
                <i class="fa-solid fa-warehouse" style="color: #ffffff;"></i>
              </div>
            </div>
            <h3>Vizualizacion de Inventario</h3>
            <p>La visualización de inventario es la capacidad que tiene el usuario de ver de manera clara y organizada los productos disponibles.</p>
          </div>
        </div>
          <div class="col">
            <div class="card">
              <div class="icono color2">
                <div class="circulo">
                <i class="fa-solid fa-box-open"></i>
                </div>
              </div>
              <h3>Registro Entrada y Salida Productos</h3>
              <p>El usuario puede registrar el ingreso de nuevos productos al inventario, ya sea a través de compras, así como también puede registrar la salida de productos, ya sea por ventas.</p>
            </div>
          </div>
          <div class="col">       
            <div class="card">
              <div class="icono color4">
                <div class="circulo">
                <i class="fa-solid fa-user" style="color: #ffffff;"></i>
                </div>
              </div>
              <h3>Agregar Usuarios</h3>
              <p>Tiene la capacidad de crear nuevas cuentas o perfiles de usuario en una plataforma para sus empleados.</p>
            </div>
          </div>
          <div class="col">     
            <div class="card">
              <div class="icono color5">
                <div class="circulo">
                <i class="fa-solid fa-file-pdf" style="color: #ffffff;"></i>
                </div>
              </div>
              <h3>Generar PDF</h3>
              <p>Tiene acceso a un servicio que le permite generar archivos PDF que contienen reportes del estado actual del almacén.</p>
            </div>
</div>
  </body>
</html>
