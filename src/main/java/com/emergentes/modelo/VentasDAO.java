package com.emergentes.modelo;

import com.emergentes.config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public String idVentas() {
        String idVen = "";
        String sql = "select max(idVenta) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVen = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener max: " + e.getMessage());
        }
        cn.desconetar();
        return idVen;
    }

    public void guardarVenta(Ventas ve) {
        String sql = "insert into ventas(idCliente,idEmpleado,IdSucursal,factura,fecha,monto) values (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdCliente());
            ps.setInt(2, ve.getIdEmpleado());
            ps.setInt(3, ve.getIdSucursal());
            ps.setString(4, ve.getNroFactura());
            ps.setString(5, ve.getFecha());
            ps.setDouble(6, ve.getMonto());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
        }
        cn.desconetar();
    }

    public void guardarDetalleVentas(Ventas venta) {
        String sql = "insert into detalle_ventas(idVenta,idProducto,cantidad,precio) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle venta: " + e.getMessage());
        }
        cn.desconetar();
    }

    public String generarFactura() {
        String nroFac = "";
        String sql = "select max(factura) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nroFac = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener max: " + e.getMessage());
        }
        cn.desconetar();
        return nroFac;
    }

    public List listar() {
        String sql = "select v.idVenta,c.nombres,e.nombres,s.direccion,v.factura,v.fecha,v.monto\n"
                + "from clientes c, empleados e, sucursales s, ventas v\n"
                + "where c.idCliente = v.idCliente and e.idEmpleado = v.idEmpleado and s.idSucursal = v.idSucursal;";
        List<Ventas> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ventas ve = new Ventas();
                ve.setId(rs.getInt(1));
                ve.setNomCliente(rs.getString(2));
                ve.setNomEmpleado(rs.getString(3));
                ve.setDireccion(rs.getString(4));
                ve.setNroFactura(rs.getString(5));
                ve.setFecha(rs.getString(6));
                ve.setMonto(rs.getDouble(7));
                lista.add(ve);
            }
        } catch (SQLException e) {
            System.out.println("error al listar venta:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }
}
