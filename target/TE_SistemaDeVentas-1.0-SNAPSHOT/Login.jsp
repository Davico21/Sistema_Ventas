
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div></div>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="POST">
                        <div>
                            <%-- Verifica si hay un error de login y muestra una alerta --%>
                            <% if (request.getAttribute("errorLogin") != null) {%>
                            <div class="alert alert-danger" role="alert">
                                <%= request.getAttribute("errorLogin")%>
                            </div>
                            <% }%>
                        </div>
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/logo.png" alt="70" width="170"/>
                            <label>Binevenidos al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">

                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="text" name="txtpass" class="form-control">
                        </div>
                        <div class="form-group p-3 d-flex justify-content-center">
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
