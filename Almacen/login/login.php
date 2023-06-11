<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
            body {
        background-color: #f1f1f1;
        font-family: Arial, sans-serif;
    }

    .login-form {
        background-color: white;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: auto;
    }

    h1 {
        font-size: 28px;
        margin-bottom: 20px;
        text-align: center;
    }

    label {
        display: block;
        font-size: 16px;
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
        width: 95%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 15px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 10px;
    }

    input[type="submit"]:hover {
        background-color: #3e8e41;
    }

    a {
        display: block;
        text-align: center;
        margin-top: 20px;
    }
    </style>
<title>Acceso de usuario</title>
</head>
<body>
    <br>
    <br>
    <br>
    <div class="login-form">
        <form action="validar_login.php" method="post">
            <h1>INICIO DE SESIÓN</h1>
            <label for="usuario">Usuario:</label>
            <input type="text" name="usuario" id="usuario" required>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" required>
        <input type="submit" value="Ingresar">
    </form>
    <a href="registro_login.php">Registrarse</a>
</div>
</body>
</html>