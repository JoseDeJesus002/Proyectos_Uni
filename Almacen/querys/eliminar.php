<?php
    include("conexion.php");
    $con = conectar();
    $id = $_GET['id'];
    $sql = "DELETE FROM productos WHERE id_productos = '$id' AND cantidad = 0";
    if (mysqli_query($con, $sql)) {
        echo '<script>alert("Producto eliminado correctamente")</script>';
        header("Location: ../index.php");

    } else {

        echo '<script>alert("No se puede eliminar el producto porque aún tiene stock")</script>';
        header("Location: ../index.php");
    }
    mysqli_close($con);
?>

