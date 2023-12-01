<%@ include file="Principal.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="detalles" value="${det}" />
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
                                            <th>Fecha y Hora</th>
                                            <th>Monto</th>
                                            <th>Detalle Venta</th>
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
                                                <td>
                                                    <a class="btn btn-warning" href="Controlador?menu=Ventas&accion=View&id=${item.getId()}" target="miFrame">
                                                        <i class="bi bi-eye-fill"></i>
                                                    </a>

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
            <div class="card mt-4 col-6 ms-auto me-auto">
                <h4 class="font-monospace text-center">Detalle de Venta</h4>
            </div>
            <div class="card col-6 ms-auto me-auto" style="height: 150px">

                <iframe name="miFrame" style="height: 100%; width: 100%"></iframe>
            </div>
        </div>

    </body>

</html>
