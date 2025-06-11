/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */
public class Dash_DireccionesClientes {
    private String tipoDireccion;
    private String direccion;
    private String num;
    private String local;
    private String comuna;

    // Constructor con todos los argumentos
    public Dash_DireccionesClientes(String tipoDireccion, String direccion, String num, String local, String comuna) {
        this.tipoDireccion = tipoDireccion;
        this.direccion = direccion;
        this.num = num;
        this.local = local;
        this.comuna = comuna;
    }

    // Getters y setters
    public String getTipoDireccion() {
        return tipoDireccion;
    }
    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getComuna() {
        return comuna;
    }
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    private int idCliente;
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }
    
    public Dash_DireccionesClientes() {
    // Constructor vacío necesario para uso con setters
    }
    
    private Integer idDireccion;
    public Integer getIdDireccion() {
        return idDireccion;
    }
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }


}


