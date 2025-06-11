/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Pablo
 */
public class Dash_TablaBusquedaInicial extends RecursiveTreeObject<Dash_TablaBusquedaInicial> {

    // Propiedades observables para usar en JFXTreeTableView
    private final IntegerProperty id;
    private final StringProperty razonSocial;
    private final StringProperty tipo;
    private final StringProperty rut;
    private final StringProperty direccion;
    private final StringProperty local;
    private final StringProperty representante;

    // Constructor que inicializa las propiedades
    public Dash_TablaBusquedaInicial(int id, String razonSocial, String tipo, String rut, String direccion, String local, String representante) {
        this.id = new SimpleIntegerProperty(id);
        this.razonSocial = new SimpleStringProperty(razonSocial);
        this.tipo = new SimpleStringProperty(tipo);
        this.rut = new SimpleStringProperty(rut);
        this.direccion = new SimpleStringProperty(direccion);
        this.local = new SimpleStringProperty(local);
        this.representante = new SimpleStringProperty(representante);
    }

    // Getters para propiedades observables
    public IntegerProperty idProperty() { return id; }
    public StringProperty razonSocialProperty() { return razonSocial; }
    public StringProperty tipoProperty() { return tipo; }
    public StringProperty rutProperty() { return rut; }
    public StringProperty direccionProperty() { return direccion; }
    public StringProperty localProperty() { return local; }
    public StringProperty representanteProperty() { return representante; }

    // Getters para valores (opcional, si necesitas usar los valores directamente)
    public int getId() { return id.get(); }
    public String getRazonSocial() { return razonSocial.get(); }
    public String getTipo() { return tipo.get(); }
    public String getRut() { return rut.get(); }
    public String getDireccion() { return direccion.get(); }
    public String getLocal() { return local.get(); }
    public String getRepresentante() { return representante.get(); }

    // Setters (opcional, si necesitas modificar las propiedades)
    public void setId(int id) { this.id.set(id); }
    public void setRazonSocial(String razonSocial) { this.razonSocial.set(razonSocial); }
    public void setTipo(String tipo) { this.tipo.set(tipo); }
    public void setRut(String rut) { this.rut.set(rut); }
    public void setDireccion(String direccion) { this.direccion.set(direccion); }
    public void setLocal(String local) { this.local.set(local); }
    public void setRepresentante(String representante) { this.representante.set(representante); }
}

//--
