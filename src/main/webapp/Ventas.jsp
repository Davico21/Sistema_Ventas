<%@ include file="Principal.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="card">
                <div class="card-body">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="font-monospace text-center">Lista de Ventas</h3>
                                <table class="table table-sm">
                                    <thead>
                                        <tr>
                                            <th>IdVenta</th>
                                            <th>Cliente</th>
                                            <th>Empleado</th>
                                            <th>Sucursal</th>
                                            <th>Factura</th>
                                            <th>Fecha</th>
                                            <th>Monto</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${venta}">
                                            <tr>
                                                <td>${item.getId()}</td>
                                                <td>${item.getNomCliente()}</td>
                                                <td>${item.getNomEmpleado()}</td>
                                                <td>${item.getDireccion()}</td>
                                                <td>${item.getNroFactura()}</td>
                                                <td>${item.getFecha()}</td>
                                                <td>${item.getMonto()}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
