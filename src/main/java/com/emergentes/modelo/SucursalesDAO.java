package com.emergentes.modelo;

import com.emergentes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalesDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        String sql = "select * from sucursales";
        List<Sucursales> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sucursales suc = new Sucursales();
                suc.setId(rs.getInt("idSucursal"));
                suc.setDireccion(rs.getString("direccion"));
                suc.setTelefono(rs.getString("telefono"));
                lista.add(suc);
            }
        } catch (SQLException e) {
            System.out.println("error al listar:" + e.getMessage());
        }
        cn.desconetar();
        return lista;
    }
}
