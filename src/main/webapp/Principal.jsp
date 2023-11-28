
<%@page import="com.emergentes.modelo.Empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e2d9f3">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item ">
                            <a class="nav-link text-dark" href="Inicio.jsp"><i class="bi bi-house-fill"></i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Productos&accion=Listar">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Clientes&accion=Listar">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Empleados&accion=Listar">Empleados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=NuevaVenta&accion=Default">Nueva Venta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=Ventas&accion=Listar">Ventas</a>
                        </li>
                    </ul>
                    <div class="dropdown ms-auto">
                        <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            ${usuario.getNombres()}
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#"><img src="img/user.jpg" alt="60" width="60"/></a></li>
                            <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li>
                                <form action="Validar" method="POST">
                                    <button class="dropdown-item" name="accion" value="Salir">Salir</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <!-- Bootstrap JS (necesario para el funcionamiento del navbar) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
