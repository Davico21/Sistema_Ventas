<%@ include file="Principal.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Empleados"%>
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
                            <h3 class="font-monospace text-center">Empleado</h3>
                            <form action="Controlador?menu=Empleados" method="POST">
                                <div class="row mb-3 ">
                                    <div class="col">
                                        <label for="ci" class="form-label">CI:</label>
                                        <input type="text" id="ci" value="${emp.getCi()}" name="txtCi" class="form-control">
                                    </div>
                                    <div class="col">
                                        <label for="suc" class="form-label">Sucursal:</label>
                                        <input type="number" id="suc" value="${emp.getIdSucursal()}" name="txtSucursal" class="form-control">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col">
                                        <label for="nombres" class="form-label">Nombres:</label>
                                        <input type="text" id="nombres" value="${emp.getNombres()}" name="txtNombres" class="form-control">
                                    </div>
                                    <div class="col">
                                        <label for="apellidos" class="form-label">Apellidos:</label>
                                        <input type="text" id="apellidos" value="${emp.getApellidos()}" name="txtApellidos" class="form-control">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col">
                                        <label for="telefono" class="form-label">Telefono:</label>
                                        <input type="text" id="telefono" value="${emp.getTelefono()}" name="txtTelefono" class="form-control">
                                    </div>
                                    <div class="col">
                                        <label for="direccion" class="form-label">Direccion:</label>
                                        <input type="text" id="direccion" value="${emp.getDireccion()}" name="txtDireccion" class="form-control">
                                    </div>
                                </div>   

                                <div class="row mb-3">
                                    <div class="col">
                                        <label for="user" class="form-label">User:</label>
                                        <input type="text" id="user" value="${emp.getUser()}" name="txtUser" class="form-control">
                                    </div>
                                    <div class="col">
                                        <label for="pass" class="form-label">Password:</label>
                                        <input type="password" id="pass" value="${emp.getPass()}" name="txtPass" class="form-control">
                                    </div>
                                </div>

                                <div class="d-flex gap-3">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-secondary">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="font-monospace text-center">Lista Empleados</h3>
                            <table class="table table-sm">
                                <thead>
                                    <tr>
                                        <th>IdEmp</th>
                                        <th>Ci</th>
                                        <th>Sucursal</th>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>Telefono</th>
                                        <th>Direccion</th>
                                        <th>User</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${empleado}">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getCi()}</td>
                                            <td>${item.getNomSucursal()}</td>
                                            <td>${item.getNombres()}</td>
                                            <td>${item.getApellidos()}</td>
                                            <td>${item.getTelefono()}</td>
                                            <td>${item.getDireccion()}</td>
                                            <td>${item.getUser()}</td>
                                            <td>
                                                <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Editar&id=${item.getId()}"><i class="bi bi-pencil-square"></i></a>
                                                <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&id=${item.getId()}" onclick="return confirm('Estas Seguro?')"><i class="bi bi-trash-fill"></i></a>
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



        <!-- Button trigger modal -->

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Aviso</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label>Seguro que quiere eliminar al empleado???</label>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Eliminar&id=${item.getId()}"><i class="bi bi-trash-fill"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
