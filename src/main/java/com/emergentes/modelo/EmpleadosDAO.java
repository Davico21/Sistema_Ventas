package com.emergentes.modelo;

import com.emergentes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleados validar(String usuario, String password) {
        Empleados em = new Empleados();
        String sql = "select * from empleados where user = ? and password = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("idEmpleado"));
                em.setNombres(rs.getString("nombres"));
                em.setApellidos(rs.getString("apellidos"));
                em.setUser(rs.getString("user"));
                em.setPass(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario:" + e.getMessage());
        }
        cn.desconetar();
        return em;

    }

    public List listar() {
        String sql = "select * from empleados";
        List<Empleados> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados em = new Empleados();
                em.setId(rs.getInt("idEmpleado"));
                em.setCi(rs.getString("ci"));
                em.setNombres(rs.getString("nombres"));
                em.setApellidos(rs.getString("apellidos"));
                em.setTelefono(rs.getString("telefono"));
                em.setDireccion(rs.getString("direccion"));
                em.setUser(rs.getString("user"));
                em.setPass(rs.getString("password"));
                lista.add(em);
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }

    public void insert(Empleados em) {
        String sql = "insert into empleados(ci,nombres,apellidos,telefono,direccion,user,password) values(?,?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, em.getCi());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getDireccion());
            ps.setString(6, em.getUser());
            ps.setString(7, em.getPass());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al insert:" + e.getMessage());
        }
        cn.desconetar();
    }

    public Empleados listarId(int id) {
        Empleados em = new Empleados();
        String sql = "select * from empleados where idEmpleado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("idEmpleado"));
                em.setCi(rs.getString("ci"));
                em.setNombres(rs.getString("nombres"));
                em.setApellidos(rs.getString("apellidos"));
                em.setTelefono(rs.getString("telefono"));
                em.setDireccion(rs.getString("direccion"));
                em.setUser(rs.getString("user"));
                em.setPass(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return em;
    }

    public void update(Empleados em) {
        String sql = "update empleados set ci=?,nombres=?,apellidos=?,telefono=?,direccion=?,user=?,password=? where idEmpleado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, em.getCi());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getDireccion());
            ps.setString(6, em.getUser());
            ps.setString(7, em.getPass());
            ps.setInt(8, em.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al actualizar:" + e.getMessage());
        }
        cn.desconetar();
    }

    public void delete(int id) {
        String sql = "delete from empleados where idEmpleado = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al eliminar:" + e.getMessage());
        }
        cn.desconetar();
    }

}
