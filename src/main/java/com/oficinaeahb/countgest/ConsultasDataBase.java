/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Contabilidad
 */
public class ConsultasDataBase {
    
// Para tabla de busqueda de clientes del INICIO
    public List<Dash_TablaBusquedaInicial> obtenerDatos() {
        List<Dash_TablaBusquedaInicial> registros = new ArrayList<>();
        String sql = "SELECT " +
             "c.IDCliente AS IDCliente, " +
             "c.Razon_Social AS Razon_Social, " +
             "c.Tipo AS Tipo, " +
             "c.Rut AS Rut, " +
             "CONCAT(d.DIRECCION, ' ', d.NUM) AS DireccionCompleta, " +
             "d.LOCAL AS Local, " +
             "r.NOMBRE AS Representante " +
             "FROM " +
             "clientes c " +
             "LEFT JOIN direcciones_clientes d ON c.IDCliente = d.IDCliente " +
             "LEFT JOIN rep_soc r ON c.IDCliente = r.IDCliente;";

        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                registros.add(new Dash_TablaBusquedaInicial(
                    rs.getInt("IDCliente"),
                    rs.getString("Razon_Social"),
                    rs.getString("Tipo"),
                    rs.getString("Rut"),
                    rs.getString("DireccionCompleta"),
                    rs.getString("Local"),
                    rs.getString("Representante")
                ));
            }

        } catch (Exception e) {
        }

        return registros;
    }
//---
    
// Para Pantalla Dashboard
    public Dash_DatosClientes obtenerDatosCliente(int idClientePerfil) {
    String sql = "SELECT Tipo_Contabilidad, Razon_Social, Tipo, Apodo, Rut, Contacto, Honorarios, " +
                 "Inicio_Contabilidad, Banco_Empresa, Num_Cuenta, Tipo_Cuenta, Clave_facturacion, " +
                 "Fecha_Compra, Duracion FROM clientes WHERE IDCliente = ?;";

    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idClientePerfil);
        System.out.println("Consulta SQL: " + stmt);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Dash_DatosClientes( 
                    idClientePerfil, // ID que recibiste por parámetro
                    rs.getString("Tipo_Contabilidad"),
                    rs.getString("Razon_Social"),
                    rs.getString("Tipo"),
                    rs.getString("Apodo"),
                    rs.getString("Rut"),
                    rs.getString("Contacto"),
                    rs.getDouble("Honorarios"),
                    rs.getString("Inicio_Contabilidad"),
                    rs.getString("Banco_Empresa"),
                    rs.getString("Num_Cuenta"),
                    rs.getString("Tipo_Cuenta"),
                    rs.getString("Clave_facturacion"),
                    rs.getDate("Fecha_Compra") != null ? rs.getDate("Fecha_Compra").toString() :"",
                    rs.getString("Duracion")
                );
            } else {
                System.out.println("No se encontraron datos para el cliente con ID: " + idClientePerfil);
                return null; // Si no hay resultados, devolvemos null
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener datos del cliente: " + e.getMessage());
        e.printStackTrace();
        return null; // En caso de error, también devolvemos null
    }
    }
    public String obtenerDireccionDomicilio(int idClientePerfil) {
    String sql = "SELECT CONCAT(DIRECCION, ', ', NUM, ', L-', LOCAL, ', ', COMUNA) AS DireccionCompleta " +
             "FROM direcciones_clientes " +
             "WHERE IDCliente = ? AND TIPO_DIRECCION = 'Domicilio';";


    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idClientePerfil);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("DireccionCompleta");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return "No disponible"; // Si no se encuentra dirección
    }
    public List<Dash_DireccionesClientes> obtenerDirecciones(int idClientePerfil) {
    List<Dash_DireccionesClientes> direcciones = new ArrayList<>();
    String sql = "SELECT TIPO_DIRECCION, DIRECCION, NUM, LOCAL, COMUNA " +
             "FROM direcciones_clientes " +
             "WHERE IDCliente = ?;";

    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idClientePerfil);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            direcciones.add(new Dash_DireccionesClientes(
                rs.getString("TIPO_DIRECCION"),
                rs.getString("DIRECCION"),
                rs.getString("NUM"),
                rs.getString("LOCAL"),
                rs.getString("COMUNA")
            ));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return direcciones;
    }
    // representante
    public Dash_RepSoc obtenerDatosRepresentante(int idClientePerfil) {
    String sql = "SELECT TIPO, PARTICIPACION, NOMBRE, CORREO, CONTACTO, RUT, " +
             "`CLAVE SII`, `CLAVE ÚNICA`, BANCO, `TIPO DE CUENTA`, `N° DE CUENTA` " +
             "FROM rep_soc " +
             "WHERE IDCliente = ?;";

    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idClientePerfil);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Dash_RepSoc(
                rs.getString("TIPO"),
                rs.getString("PARTICIPACION"),
                rs.getString("NOMBRE"),
                rs.getString("CORREO"),
                rs.getString("CONTACTO"),
                rs.getString("RUT"),
                rs.getString("CLAVE SII"),
                rs.getString("CLAVE ÚNICA"),
                rs.getString("BANCO"),
                rs.getString("TIPO DE CUENTA"),
                rs.getString("N° DE CUENTA")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Retorna null si no encuentra el representante
    }
    public List<Dash_RepSoc> obtenerRepresentantes(int idCliente) {
    List<Dash_RepSoc> representantes = new ArrayList<>();
    String query = "SELECT * FROM rep_soc WHERE IDCliente = ?";

    try (Connection connection = ConexionDataBase.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setInt(1, idCliente);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Dash_RepSoc representante = new Dash_RepSoc(
                resultSet.getString("TIPO"),
                resultSet.getString("PARTICIPACION"),
                resultSet.getString("NOMBRE"),
                resultSet.getString("CORREO"),
                resultSet.getString("CONTACTO"),
                resultSet.getString("RUT"),
                resultSet.getString("CLAVE SII"),
                resultSet.getString("CLAVE ÚNICA"),
                resultSet.getString("BANCO"),
                resultSet.getString("TIPO DE CUENTA"),
                resultSet.getString("N° DE CUENTA")
            );
            representantes.add(representante);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return representantes;
}

    //claves Pos
    public List<Dash_ClavesPrincipales> obtenerClavesPrincipales(int idClientePerfil) {
        List<Dash_ClavesPrincipales> claves = new ArrayList<>();
        String sql = "SELECT Rut, Clave_SII, Usuario_previred, Clave_Previred FROM clientes WHERE IDCliente = ?";

        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idClientePerfil);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Agregar el registro de Rut y Clave_SII
                if (rs.getString("Rut") != null && rs.getString("Clave_SII") != null) {
                    claves.add(new Dash_ClavesPrincipales(
                        idClientePerfil,                         // IDCliente
                        rs.getString("Rut"),                     // Rut
                        rs.getString("Clave_SII"),               // Clave_SII
                        null,                                    // Usuario_previred
                        null                                     // Clave_previred
                    ));

                }

                // Agregar el registro de Usuario_Previred y Clave_Previred
                if (rs.getString("Usuario_previred") != null && rs.getString("Clave_Previred") != null) {
                    claves.add(new Dash_ClavesPrincipales(
                        idClientePerfil,
                        null, null,                              // Rut y Clave_SII no aplican
                        rs.getString("Usuario_previred"),
                        rs.getString("Clave_Previred")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Cantidad de claves encontradas: " + claves.size());
        for (int i = 0; i < claves.size(); i++) {
            Dash_ClavesPrincipales clave = claves.get(i);
            System.out.println("Clave " + (i + 1) + ": Rut = " + clave.getRut() +
                    ", Clave_SII = " + clave.getClaveSII() +
                    ", Usuario_Previred = " + clave.getUsuarioPrevired() +
                    ", Clave_Previred = " + clave.getClavePrevired());
        }

        return claves;
    }
    public List<Dash_ClavesPOS> obtenerClavesPOS(int idClientePerfil) {
    List<Dash_ClavesPOS> claves = new ArrayList<>();
    String sql = "SELECT Serv_Pos, USUARIO, CLAVE FROM claves_pos WHERE IDCliente = ?";

    try (Connection conn = ConexionDataBase.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idClientePerfil);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            claves.add(new Dash_ClavesPOS(
                rs.getString("Serv_Pos"),
                rs.getString("USUARIO"),
                rs.getString("CLAVE")
            ));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return claves;
    }

    
}
