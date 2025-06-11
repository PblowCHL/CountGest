/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */
public class Dash_DatosClientes {
    private int idCliente;
    private final String tipoContabilidad;
    private final String razonSocial;
    private final String tipo;
    private final String apodo;
    private final String rut;
    private final String contacto;
    private final double honorarios;
    private final String inicioContabilidad;
    private final String bancoEmpresa;
    private final String numCuenta;
    private final String tipoCuenta;
    private final String claveFacturacion;
    private final String fechaCompra;
    private final String duracion;

    // Constructor con todos los argumentos
    public Dash_DatosClientes(int idCliente,String tipoContabilidad, String razonSocial, String tipo, String apodo, String rut,
                    String contacto, double honorarios, String inicioContabilidad, String bancoEmpresa,
                    String numCuenta, String tipoCuenta, String claveFacturacion, String fechaCompra,
                    String duracion) {
        this.idCliente = idCliente;
        this.tipoContabilidad = tipoContabilidad;
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.apodo = apodo;
        this.rut = rut;
        this.contacto = contacto;
        this.honorarios = honorarios;
        this.inicioContabilidad = inicioContabilidad;
        this.bancoEmpresa = bancoEmpresa;
        this.numCuenta = numCuenta;
        this.tipoCuenta = tipoCuenta;
        this.claveFacturacion = claveFacturacion;
        this.fechaCompra = fechaCompra;
        this.duracion = duracion;
    }

    // Getters y setters
    
    public int getIdCliente() {
        return idCliente;
    }
    public String getTipoContabilidad() {
        return tipoContabilidad;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public String getTipo() {
        return tipo;
    }
    public String getApodo() {
        return apodo;
    }
    public String getRut() {
        return rut;
    }
    public String getContacto() {
        return contacto;
    }
    public double getHonorarios() {
        return honorarios;
    }
    public String getInicioContabilidad() {
        return inicioContabilidad;
    }
    public String getBancoEmpresa() {
        return bancoEmpresa;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public String getClaveFacturacion() {
        return claveFacturacion;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public String getDuracion() {
        return duracion;
    }
}


