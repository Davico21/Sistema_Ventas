<%@ include file="Principal.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="container mt-3">
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="font-monospace text-center">Cliente</h3>
                            <form action="Controlador?menu=Clientes" method="POST">
                                <div class="mb-3">
                                    <label for="txtCi" class="form-label">CI:</label>
                                    <input type="text" value="${cli.getCi()}" name="txtCi" id="txtCi" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label for="txtNombres" class="form-label">Nombres:</label>
                                    <input type="text" value="" name="txtNombres" id="txtNombres" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label for="txtApellidos" class="form-label">Apellidos:</label>
                                    <input type="text" value="" name="txtApellidos" id="txtApellidos" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label for="txtTelefono" class="form-label">Telefono:</label>
                                    <input type="text" value="" name="txtTelefono" id="txtTelefono" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="font-monospace text-center">Lista de Clientes</h3>
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th>IdCliente</th>
                                        <th>Ci</th>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>Telefono</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${cliente}">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getCi()}</td>
                                            <td>${item.getNombres()}</td>
                                            <td>${item.getApellidos()}</td>
                                            <td>${item.getTelefono()}</td>
                                            <td>
                                                <a class="btn btn-warning btn-sm" href="Controlador?menu=Clientes&accion=Editar&id=${item.getId()}"><i class="bi bi-pencil-square"></i></a>
                                                <a class="btn btn-danger btn-sm" href="Controlador?menu=Clientes&accion=Eliminar&id=${item.getId()}"><i class="bi bi-trash-fill"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
