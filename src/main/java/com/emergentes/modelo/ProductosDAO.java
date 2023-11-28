package com.emergentes.modelo;

import com.emergentes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        String sql = "select * from productos";
        List<Productos> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("idProducto"));
                pro.setNombres(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setEstado(rs.getString("estado"));
                pro.setIdCat(rs.getInt("idCat"));
                pro.setIdMarca(rs.getInt("idMarca"));

                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }

    public void insert(Productos pro) {
        String sql = "insert into productos(nombre,precio,stock,estado,idCat,idMarca) values(?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getIdCat());
            ps.setInt(6, pro.getIdMarca());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al insert:" + e.getMessage());
        }
        cn.desconetar();
    }

    public Productos listarId(int id) {
        Productos pro = new Productos();
        String sql = "select * from productos where idProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt("idProducto"));
                pro.setNombres(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setStock(rs.getInt("stock"));
                pro.setEstado(rs.getString("estado"));
                pro.setIdCat(rs.getInt("idCat"));
                pro.setIdMarca(rs.getInt("idMarca"));
            }
        } catch (SQLException e) {
            System.out.println("error al listar por id:" + e.getMessage());
        }
        cn.desconetar();
        return pro;
    }

    public void update(Productos pro) {
        String sql = "update productos set nombre=?,precio=?,stock=?,estado=?,idCat=?,idMarca=? where idProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, pro.getNombres());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getIdCat());
            ps.setInt(6, pro.getIdMarca());
            ps.setInt(7, pro.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error al actualizar:" + e.getMessage());
        }
        cn.desconetar();
    }

    public void delete(int id) {
        String sql = "delete from productos where idProducto = ?";
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

    public void actualizarStock(int id, int stock) {
        String sql = "update productos set stock = ? where idProducto =?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock: " + e.getMessage());
        }
        cn.desconetar();
    }
    
    
    public List listarMarcas() {
        String sql = "select * from marcas";
        List<Productos> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("idMarca"));
                pro.setNombres(rs.getString("nombre"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("error al listar marca:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }
    
    public List listarCategorias() {
        String sql = "select * from categorias";
        List<Productos> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("idCat"));
                pro.setNombres(rs.getString("nombre"));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("error al listar marca:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }
}
