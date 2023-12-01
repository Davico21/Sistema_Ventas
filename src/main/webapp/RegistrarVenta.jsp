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
                <div class="col-md-4 parte1">
                    <div class="card">
                        <div class="card-body">

                            <form action="Controlador?menu=NuevaVenta" method="POST">
                                
                                <h5 class="card-title">Datos del Cliente</h5>
                                <div class="mb-3 d-flex col-6">
                                    <input type="text" name="codigoCliente" value="${cli.getCi()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-secondary"><i class="bi bi-search"></i></button>
                                </div>
                                <div class="mb-3">
                                    <input type="text" name="nombresCliente" value="${cli.getNombres()}" class="form-control" placeholder="Nombres">
                                </div>
                                <h5 class="card-title">Datos Producto</h5>
                                <div class="mb-3 d-flex col-6">
                                    <input type="text" name="codigoProducto" value="${pro.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-secondary"><i class="bi bi-search"></i></button>
                                </div>
                                <div class="mb-3">
                                    <input type="text" name="nombreProducto" value="${pro.getNombres()}" class="form-control" placeholder="Producto">
                                </div>
                                <div class="mb-3 d-flex">
                                    <input type="number" name="precio" value="${pro.getPrecio()}" class="form-control" placeholder="$/.0.00">
                                    <input type="number" name="cantidad" value="1" class="form-control ms-2" placeholder="Cantidad">
                                    <input type="number" name="stock" value="${pro.getStock()}" class="form-control ms-2" placeholder="Stock" readonly>
                                </div>
                                <div class="mt-3">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-secondary">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-body">

                            <div class="d-flex col-6 ms-auto">
                                <label class="p-2">NroFactura:</label>
                                <input type="text" name="txtNroFac" value="${nro}" class="form-control">
                            </div>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>SubTotal</th>
                                        <th class="accion">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${lista}" varStatus="loop">
                                        <tr>
                                            <td>${item.getItem()}</td>
                                            <td>${item.getIdProducto()}</td>
                                            <td>${item.getDescripcionP()}</td>
                                            <td>${item.getPrecio()}</td>
                                            <td>${item.getCantidad()}</td>
                                            <td>${item.getSubTotal()}</td>
                                            <td>
                                                <a class="btn btn-danger btn-sm" href="Controlador?menu=NuevaVenta&accion=Eliminar&id=${loop.index}" onclick="return confirm('Estas Seguro?')"><i class="bi bi-trash-fill"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-footer d-flex">
                            
                            <div class="col-6">
                                
                                <a class="btn btn-success" onclick="print()" href="Controlador?menu=NuevaVenta&accion=GenerarVenta">Generar Venta</a>
                            </div>
                            <div class="col-3 ms-auto">
                                <input type="text" name="txtTotal" value="Bs/. ${totalPagar}0" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
