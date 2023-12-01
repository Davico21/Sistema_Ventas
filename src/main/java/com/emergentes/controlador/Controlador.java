package com.emergentes.controlador;

import com.emergentes.config.GenerarFactura;
import com.emergentes.modelo.Clientes;
import com.emergentes.modelo.ClientesDAO;
import com.emergentes.modelo.Empleados;
import com.emergentes.modelo.EmpleadosDAO;
import com.emergentes.modelo.Productos;
import com.emergentes.modelo.ProductosDAO;
import com.emergentes.modelo.Ventas;
import com.emergentes.modelo.VentasDAO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    Empleados e;
    Empleados em = new Empleados();
    EmpleadosDAO edao = new EmpleadosDAO();
    Clientes c;
    Clientes cl = new Clientes();
    ClientesDAO cdao = new ClientesDAO();
    Productos p;
    Productos pro = new Productos();
    ProductosDAO pdao = new ProductosDAO();
    int ide;
    int idc;
    int idp;
    int indiceEliminar;
    int idv;

    Ventas ve = new Ventas();
    VentasDAO vdao = new VentasDAO();
    List<Ventas> listave = new ArrayList<>();
    int item;
    double totalPagar;
    String nroFactura;

    List<Productos> cat = pdao.listarCategorias();
    List<Productos> marca = pdao.listarMarcas();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();

        switch (menu) {
            case "Inicio":
                request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                break;
            case "Productos":
                switch (accion) {
                    case "Listar":
                        List listapro = pdao.listar();
                        request.setAttribute("producto", listapro);
                        request.setAttribute("marca", marca);
                        request.setAttribute("cat", cat);

                        break;
                    case "Agregar":
                        pro.setNombres(request.getParameter("txtNombre"));
                        pro.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
                        pro.setStock(Integer.parseInt(request.getParameter("txtStock")));
                        pro.setEstado(request.getParameter("txtEstado"));
                        pro.setIdCat(Integer.parseInt(request.getParameter("txtCat")));
                        pro.setIdMarca(Integer.parseInt(request.getParameter("txtMarca")));
                        pdao.insert(pro);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        p = pdao.listarId(idp);
                        request.setAttribute("pro", p);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        pro.setNombres(request.getParameter("txtNombre"));
                        pro.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
                        pro.setStock(Integer.parseInt(request.getParameter("txtStock")));
                        pro.setEstado(request.getParameter("txtEstado"));
                        pro.setIdCat(Integer.parseInt(request.getParameter("txtCat")));
                        pro.setIdMarca(Integer.parseInt(request.getParameter("txtMarca")));
                        pro.setId(idp);
                        pdao.update(pro);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
            case "Clientes":
                switch (accion) {
                    case "Listar":
                        List listacli = cdao.listar();
                        request.setAttribute("cliente", listacli);
                        break;
                    case "Agregar":
                        cl.setCi(request.getParameter("txtCi"));
                        cl.setNombres(request.getParameter("txtNombres"));
                        cl.setApellidos(request.getParameter("txtApellidos"));
                        cl.setTelefono(request.getParameter("txtTelefono"));
                        cdao.insert(cl);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        c = cdao.listarId(idc);
                        request.setAttribute("cli", c);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        cl.setCi(request.getParameter("txtCi"));
                        cl.setNombres(request.getParameter("txtNombres"));
                        cl.setApellidos(request.getParameter("txtApellidos"));
                        cl.setTelefono(request.getParameter("txtTelefono"));
                        cl.setId(idc);
                        cdao.update(cl);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "Empleados":
                switch (accion) {
                    case "Listar":
                        List listaemp = edao.listar();
                        request.setAttribute("empleado", listaemp);
                        break;
                    case "Agregar":
                        em.setCi(request.getParameter("txtCi"));
                        em.setNombres(request.getParameter("txtNombres"));
                        em.setApellidos(request.getParameter("txtApellidos"));
                        em.setTelefono(request.getParameter("txtTelefono"));
                        em.setDireccion(request.getParameter("txtDireccion"));
                        em.setUser(request.getParameter("txtUser"));
                        em.setPass(request.getParameter("txtPass"));
                        em.setIdSucursal(Integer.parseInt(request.getParameter("txtSucursal")));
                        edao.insert(em);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        e = edao.listarId(ide);
                        request.setAttribute("emp", e);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        em.setCi(request.getParameter("txtCi"));
                        em.setNombres(request.getParameter("txtNombres"));
                        em.setApellidos(request.getParameter("txtApellidos"));
                        em.setTelefono(request.getParameter("txtTelefono"));
                        em.setDireccion(request.getParameter("txtDireccion"));
                        em.setUser(request.getParameter("txtUser"));
                        em.setPass(request.getParameter("txtPass"));
                        em.setId(ide);
                        edao.update(em);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                }
                request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                break;
            case "NuevaVenta":
                switch (accion) {
                    case "BuscarCliente":
                        request.setAttribute("totalPagar", totalPagar);
                        String ci = request.getParameter("codigoCliente");
                        cl.setCi(ci);
                        c = cdao.buscarCi(ci);
                        request.setAttribute("cli", c);
                        request.setAttribute("lista", listave);
                        request.setAttribute("nro", nroFactura);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;
                    case "BuscarProducto":

                        request.setAttribute("cli", c);
                        int id = Integer.parseInt(request.getParameter("codigoProducto"));
                        p = pdao.listarId(id);
                        request.setAttribute("pro", p);
                        request.setAttribute("lista", listave);
                        request.setAttribute("totalPagar", totalPagar);
                        request.setAttribute("nro", nroFactura);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;
                    case "Agregar":

                        request.setAttribute("cli", c);
                        totalPagar = 0;
                        item = item + 1;
                        ve = new Ventas();
                        ve.setItem(item);
                        ve.setIdProducto(p.getId());
                        ve.setDescripcionP(request.getParameter("nombreProducto"));
                        ve.setPrecio(Double.parseDouble(request.getParameter("precio")));
                        ve.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                        ve.setSubTotal(Double.parseDouble(request.getParameter("precio")) * Integer.parseInt(request.getParameter("cantidad")));
                        listave.add(ve);
                        for (int i = 0; i < listave.size(); i++) {
                            totalPagar = totalPagar + listave.get(i).getSubTotal();
                        }
                        request.setAttribute("totalPagar", totalPagar);
                        request.setAttribute("lista", listave);
                        request.setAttribute("nro", nroFactura);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;

                    case "GenerarVenta":
                        //actualizar stock
                        for (int i = 0; i < listave.size(); i++) {
                            Productos pr = new Productos();
                            int cantidad = listave.get(i).getCantidad();
                            int idProducto = listave.get(i).getIdProducto();
                            ProductosDAO prdao = new ProductosDAO();
                            pr = prdao.listarId(idProducto);
                            int stock_actual = pr.getStock() - cantidad;
                            prdao.actualizarStock(idProducto, stock_actual);

                        }

                        //Guardar venta
                        Empleados usuario = (Empleados) session.getAttribute("usuario");
                        ve.setIdCliente(c.getId());
                        ve.setIdEmpleado(usuario.getId());
                        ve.setNroFactura(nroFactura);
                        ve.setFecha(LocalDateTime.now().toString());
                        ve.setMonto(totalPagar);
                        vdao.guardarVenta(ve);

                        //Guardar detalle venta
                        int idv = Integer.parseInt(vdao.idVentas());
                        for (int i = 0; i < listave.size(); i++) {
                            ve = new Ventas();
                            ve.setId(idv);
                            ve.setIdProducto(listave.get(i).getIdProducto());
                            ve.setCantidad(listave.get(i).getCantidad());
                            ve.setPrecio(listave.get(i).getPrecio());
                            vdao.guardarDetalleVentas(ve);
                        }
                        request.setAttribute("nro", nroFactura);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;
                    case "Eliminar":
                        indiceEliminar = Integer.parseInt(request.getParameter("id"));
                        if (indiceEliminar >= 0 && indiceEliminar < listave.size()) {
                            // Elimina el elemento de la lista
                            listave.remove(indiceEliminar);

                            // Recalcula el totalPagar
                            totalPagar = 0;
                            for (int i = 0; i < listave.size(); i++) {
                                totalPagar = totalPagar + listave.get(i).getSubTotal();
                            }

                            request.setAttribute("totalPagar", totalPagar);
                            request.setAttribute("lista", listave);
                            request.setAttribute("nro", nroFactura);
                        }
                        item = item - 1;
                        ve.setItem(item);
                        request.setAttribute("nro", nroFactura);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;
                    default:
                        nroFactura = vdao.generarFactura();

                        if (nroFactura == null) {
                            nroFactura = "00000001";
                            request.setAttribute("nro", nroFactura);
                        } else {
                            int incrementar = Integer.parseInt(nroFactura);
                            GenerarFactura gf = new GenerarFactura();
                            nroFactura = gf.NroFactura(incrementar);
                            request.setAttribute("nro", nroFactura);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        break;
                }
                break;
            case "Ventas":
                List listav = null;
                List listad = null;
                switch (accion) {
                    case "Listar":
                        listav = vdao.listar();
                        request.setAttribute("venta", listav);
                        request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                        break;
                    case "View":
                        idv = Integer.parseInt(request.getParameter("id"));
                        listad = vdao.listarDetalle(idv);
                        request.setAttribute("det", listad);
                        request.getRequestDispatcher("DetalleVenta.jsp").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
