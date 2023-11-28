package com.emergentes.modelo;

import com.emergentes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Clientes buscarCi(String ci) {
        Clientes cli = new Clientes();
        String sql = "select * from clientes where ci = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ci);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("idCliente"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("error al buscar ci:" + e.getMessage());
        }
        cn.desconetar();
        return cli;
    }

    public List listar() {
        String sql = "select * from clientes";
        List<Clientes> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("idCliente"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setTelefono(rs.getString("telefono"));
                lista.add(cli);
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }

    public void insert(Clientes cli) {
        String sql = "insert into clientes(ci,nombres,apellidos,telefono) values(?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, cli.getCi());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getApellidos());
            ps.setString(4, cli.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al insert:" + e.getMessage());
        }
        cn.desconetar();
    }

    public Clientes listarId(int id) {
        Clientes cli = new Clientes();
        String sql = "select * from clientes where idCliente = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("idCliente"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return cli;
    }

    public void update(Clientes cli) {
        String sql = "update clientes set ci=?,nombres=?,apellidos=?,telefono=? where idCliente = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, cli.getCi());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getApellidos());
            ps.setString(4, cli.getTelefono());
            ps.setInt(5, cli.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al actualizar:" + e.getMessage());
        }
        cn.desconetar();
    }

    public void delete(int id) {
        String sql = "delete from clientes where idCliente = ?";
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
