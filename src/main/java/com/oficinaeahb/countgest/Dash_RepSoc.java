/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */
public class Dash_RepSoc {
    private String tipo;
    private String participacion;
    private String nombre;
    private String correo;
    private String contacto;
    private String rut;
    private String claveSii;
    private String claveUnica;
    private String banco;
    private String tipoCuenta;
    private String numCuenta;

    public Dash_RepSoc(String tipo, String participacion, String nombre, String correo, String contacto, 
                  String rut, String claveSii, String claveUnica, String banco, String tipoCuenta, String numCuenta) {
        this.tipo = tipo;
        this.participacion = participacion;
        this.nombre = nombre;
        this.correo = correo;
        this.contacto = contacto;
        this.rut = rut;
        this.claveSii = claveSii;
        this.claveUnica = claveUnica;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.numCuenta = numCuenta;
    }

    // Getters
    public String getTipo() { return tipo; }
    public String getParticipacion() { return participacion; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContacto() { return contacto; }
    public String getRut() { return rut; }
    public String getClaveSii() { return claveSii; }
    public String getClaveUnica() { return claveUnica; }
    public String getBanco() { return banco; }
    public String getTipoCuenta() { return tipoCuenta; }
    public String getNumCuenta() { return numCuenta; }
    private int idCliente;
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }
    
    public Dash_RepSoc() {
        // Constructor vacío necesario para poder usar: new Dash_RepSoc()
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setClaveSii(String claveSii) {
        this.claveSii = claveSii;
    }
    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setClaveUnica(String claveUnica) {
        this.claveUnica = claveUnica;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }


}

