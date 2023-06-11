<?php
include("conexion.php");
$con=conectar();

$nombre=$_POST['nombre'];
$fotografia = addslashes(file_get_contents($_FILES['imagen']['tmp_name']));
$direccion=$_POST['direccion'];
$telefono=$_POST['telefono'];
$rubro=$_POST['rubro'];
$correo=$_POST['correo'];
if($nombre!=null||$fotografia!=null||$direccion!=null||$telefono!=null||$rubro!=null||$correo!=null)
{
	$sql="insert into proveedores(id_proveedor,nombre,fotografia,direccion,telefono,rubro,correo_electronico)values('".$id_proveedor."', '".$nombre."','".$fotografia."','".$direccion."','".$telefono."','".$rubro."','".$correo."')";
	mysqli_query($con,$sql);
	if($user=1)
	{
		echo '<script language="javascript">alert("Registrado correctamente");  window.location="../index.php"</script>';
	}
}
?>