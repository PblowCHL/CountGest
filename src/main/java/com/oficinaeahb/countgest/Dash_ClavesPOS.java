/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */
public class Dash_ClavesPOS {
    private String servPos;
    private String usuario;
    private String clave;
    private String observacion;

    public Dash_ClavesPOS(String servPos, String usuario, String clave) {
        this.servPos = servPos;
        this.usuario = usuario;
        this.clave = clave;
    }

    // Getters
    public String getServPos() { return servPos; }
    public String getUsuario() { return usuario; }
    public String getClave() { return clave; }

    Object getClaveSII() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int idCliente;
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }
    
    public Dash_ClavesPOS() {
    // Constructor vacío requerido para usar setters
    }
    
    public void setServPos(String servPos) {
        this.servPos = servPos;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}

