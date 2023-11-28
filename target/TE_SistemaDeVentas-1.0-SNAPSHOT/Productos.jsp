<%@ include file="Principal.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="css/style.css"/>
    <body>
        <div class="container mt-3">
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="font-monospace text-center">Producto</h3>
                            <form action="Controlador?menu=Productos" method="POST">
                                <div class="row mb-3">
                                    <div class="col mb-3">
                                        <label for="txtNombre" class="form-label">Nombre:</label>
                                        <input type="text" value="${pro.getNombres()}" name="txtNombre" class="form-control">
                                    </div>
                                    <div class="col mb-3">
                                        <label for="txtPrecio" class="form-label">Precio:</label>
                                        <input type="number" value="${pro.getPrecio()}" name="txtPrecio" class="form-control">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col mb-3">
                                        <label for="txtStock" class="form-label">Stock:</label>
                                        <input type="number" value="${pro.getStock()}" name="txtStock" class="form-control">
                                    </div>
                                    <div class="col mb-3">
                                        <label for="txtEstado" class="form-label">Estado:</label>
                                        <input type="text" value="${pro.getEstado()}" name="txtEstado"class="form-control">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col mb-3">
                                        <select class="form-control" name="txtCat">
                                            <option value="" selected>Categoria</option>
                                            <c:forEach var="opcion" items="${cat}">
                                                <option value="${opcion.getId()}">${opcion.getNombres()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col mb-3">
                                        <select class="form-control" name="txtMarca">
                                            <option value="" selected>Marca</option>
                                            <c:forEach var="opcion" items="${marca}">
                                                <option value="${opcion.getId()}">${opcion.getNombres()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
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
                            <h3 class="font-monospace text-center">Lista de Productos</h3>
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th>IdProd</th>
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th>Stock</th>
                                        <th>Estado</th>
                                        <th>Categ</th>
                                        <th>Marca</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${producto}">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getNombres()}</td>
                                            <td>${item.getPrecio()}</td>
                                            <td>${item.getStock()}</td>
                                            <td>${item.getEstado()}</td>
                                            <td>${item.getIdCat()}</td>
                                            <td>${item.getIdMarca()}</td>
                                            <td>
                                                <a class="btn btn-warning btn-sm" href="Controlador?menu=Productos&accion=Editar&id=${item.getId()}"><i class="bi bi-pencil-square"></i></a>
                                                <a class="btn btn-danger btn-sm" href="Controlador?menu=Productos&accion=Eliminar&id=${item.getId()}"><i class="bi bi-trash-fill"></i></a>
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
