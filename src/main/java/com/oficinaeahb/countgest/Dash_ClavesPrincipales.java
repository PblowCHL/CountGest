/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

/**
 *
 * @author Contabilidad
 */
public class Dash_ClavesPrincipales {
    private final int idCliente;
    private final String rut;
    private final String claveSII;
    private final String usuarioPrevired;
    private final String clavePrevired;

    public Dash_ClavesPrincipales(int idCliente, String rut, String claveSII, String usuarioPrevired, String clavePrevired) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.claveSII = claveSII;
        this.usuarioPrevired = usuarioPrevired;
        this.clavePrevired = clavePrevired;
    }

    // Getters
    public int getIdCliente() { return idCliente; }
    public String getRut() { return rut; }
    public String getClaveSII() { return claveSII; }
    public String getUsuarioPrevired() { return usuarioPrevired; }
    public String getClavePrevired() { return clavePrevired; }
}

