/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class ConexionDataBase {
    
    private static final String URL = "jdbc:mysql://localhost:3306/bdclientes";
    private static final String USER = "Editor";
    private static final String PASSWORD = "5839";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void actualizarDatosCliente(Dash_DatosClientes datos) {
        System.out.println("▶️ actualizandoDatosCliente(): " + datos.getRazonSocial());
        System.out.println("🔎 ID enviado a UPDATE: " + datos.getIdCliente());
        
        String sql = "UPDATE clientes SET Razon_Social=?, Tipo=?, Apodo=?, Rut=?, Contacto=?, " +
                     "Clave_facturacion=?, Tipo_Contabilidad=?, Inicio_Contabilidad=?, Honorarios=?, " +
                     "Fecha_Compra=?, Duracion=?, Banco_Empresa=?, Num_Cuenta=?, Tipo_Cuenta=? " +
                     "WHERE IDCliente=?";

        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, datos.getRazonSocial());
            stmt.setString(2, datos.getTipo());
            stmt.setString(3, datos.getApodo());
            stmt.setString(4, datos.getRut());
            stmt.setString(5, datos.getContacto());
            stmt.setString(6, datos.getClaveFacturacion());
            stmt.setString(7, datos.getTipoContabilidad());
            stmt.setString(8, datos.getInicioContabilidad());
            stmt.setDouble(9, datos.getHonorarios());
            if (datos.getFechaCompra() == null || datos.getFechaCompra().isBlank()) {
                stmt.setNull(10, Types.DATE);
            } else {
                stmt.setString(10, datos.getFechaCompra());
            }
            stmt.setString(11, datos.getDuracion());
            stmt.setString(12, datos.getBancoEmpresa());
            stmt.setString(13, datos.getNumCuenta());
            stmt.setString(14, datos.getTipoCuenta());
            stmt.setInt(15, datos.getIdCliente());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reemplazarDireccionesCliente(int idCliente, List<Dash_DireccionesClientes> direcciones) {
        System.out.println("▶️ reemplazarDireccionesCliente(): Total = " + direcciones.size() + " direcciones");

        String deleteSQL = "DELETE FROM direcciones_clientes WHERE IDCliente = ?";
        String insertSQL = "INSERT INTO direcciones_clientes (IDCliente, TIPO_DIRECCION, DIRECCION, NUM, LOCAL, COMUNA) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDataBase.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
                deleteStmt.setInt(1, idCliente);
                deleteStmt.executeUpdate();
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                for (Dash_DireccionesClientes dir : direcciones) {
                    insertStmt.setInt(1, idCliente);
                    insertStmt.setString(2, dir.getTipoDireccion());
                    insertStmt.setString(3, dir.getDireccion());
                    insertStmt.setString(4, dir.getNum());
                    insertStmt.setString(5, dir.getLocal());
                    insertStmt.setString(6, dir.getComuna());
                    insertStmt.addBatch();
                }
                insertStmt.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reemplazarRepresentantes(int idCliente, List<Dash_RepSoc> socios) {
        System.out.println("▶️ reemplazarRepresentantes(): Total = " + socios.size() + " socios");

        String deleteSQL = "DELETE FROM rep_soc WHERE IDCliente = ?";
        String insertSQL = "INSERT INTO rep_soc (IDCliente, TIPO, PARTICIPACION, NOMBRE, CORREO, CONTACTO, RUT, `CLAVE SII`, `CLAVE ÚNICA`, BANCO, `TIPO DE CUENTA`, `N° DE CUENTA`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDataBase.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
                deleteStmt.setInt(1, idCliente);
                deleteStmt.executeUpdate();
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                for (Dash_RepSoc rep : socios) {
                    insertStmt.setInt(1, idCliente);
                    insertStmt.setString(2, rep.getTipo());
                    insertStmt.setString(3, rep.getParticipacion());
                    insertStmt.setString(4, rep.getNombre());
                    insertStmt.setString(5, rep.getCorreo());
                    insertStmt.setString(6, rep.getContacto());
                    insertStmt.setString(7, rep.getRut());
                    insertStmt.setString(8, rep.getClaveSii());
                    insertStmt.setString(9, rep.getClaveUnica());
                    insertStmt.setString(10, rep.getBanco());
                    insertStmt.setString(11, rep.getTipoCuenta());
                    insertStmt.setString(12, rep.getNumCuenta());
                    insertStmt.addBatch();
                }
                insertStmt.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reemplazarClavesPOS(int idCliente, List<Dash_ClavesPOS> clavesPOS) {
        System.out.println("▶️ reemplazarClavesPOS(): Total = " + clavesPOS.size() + " POS");

        String deleteSQL = "DELETE FROM claves_pos WHERE IDCliente = ?";
        String insertSQL = "INSERT INTO claves_pos (IDCliente, Serv_Pos, USUARIO, CLAVE) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDataBase.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
                deleteStmt.setInt(1, idCliente);
                deleteStmt.executeUpdate();
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                for (Dash_ClavesPOS pos : clavesPOS) {
                    insertStmt.setInt(1, idCliente);
                    insertStmt.setString(2, pos.getServPos());
                    insertStmt.setString(3, pos.getUsuario());
                    insertStmt.setString(4, pos.getClave());
                    insertStmt.addBatch();
                }
                insertStmt.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    public void actualizarClavesPrincipales(Dash_ClavesPrincipales clave) {
        System.out.println("▶️ actualizarClavesPrincipales(): Usuario Previred = " + clave.getUsuarioPrevired());
        String sql = "UPDATE clientes SET Usuario_previred = ?, Clave_Previred = ? WHERE IDCliente = ?";

        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, clave.getUsuarioPrevired());
            stmt.setString(2, clave.getClavePrevired());
            stmt.setInt(3, clave.getIdCliente());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminarDireccionCliente(int idDireccion) {
    String sql = "DELETE FROM direcciones_clientes WHERE IDDireccion = ?";
    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idDireccion);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public static Connection conectar() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdclientes", "Editor", "5839");
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
    public void eliminarDireccion(int idDireccion) {
        String sql = "DELETE FROM direcciones_clientes WHERE idDireccion = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDireccion);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
