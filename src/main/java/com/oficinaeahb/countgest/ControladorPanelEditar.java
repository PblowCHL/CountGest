/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.oficinaeahb.countgest;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXComboBox;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ControladorPanelEditar {
    
    //panel editar (en dashboard)
    
    @FXML private BorderPane PanelEditar;

    // ----- DATOS PRINCIPALES -----
    @FXML private TextField Razon_SocialED;
    @FXML private JFXComboBox<String> TipoEDP;
    @FXML private TextField RutED;
    @FXML private TextField Clave_SIIED;
    @FXML private TextField HonorariosED;
    @FXML private TextField ApodoED;
    @FXML private TextField ContactoED;
    @FXML private JFXComboBox<String> Tipo_ContabilidadED;
    @FXML private TextField Inicio_ContabilidadED;

    // ----- DIRECCIONES -----
    @FXML private JFXComboBox<String> TIPO_DIRECCIONED;
    @FXML private TextField DIRECCIONED;
    @FXML private TextField NUMED;
    @FXML private TextField LOCALED;
    @FXML private JFXComboBox<String> COMUNAED;

    // ----- REPRESENTANTES Y SOCIOS -----
    @FXML private JFXComboBox<String> TIPOED;
    @FXML private TextField NOMBREED;
    @FXML private TextField RUTED;
    @FXML private TextField CLAVE_SIIED;
    @FXML private TextField PARTICIPACIONED;
    @FXML private TextField CONTACTOED;
    @FXML private TextField CORREOED;
    @FXML private TextField CLAVE_UNICAED;
    @FXML private TextField RBANCOED;
    @FXML private JFXComboBox<String> RTIPO_CUENTAED;
    @FXML private TextField RN_DE_CUENTAED;

    // ----- PAGOS ELECTRONICOS (POS) -----
    @FXML private JFXComboBox<String> Serv_PosED;
    @FXML private TextField USUARIOED;
    @FXML private TextField CLAVEED;
    @FXML private TextField ObservacionED;

    // ----- CLAVES PREVIRED Y FACTURACION -----
    @FXML private TextField Usuario_previredED;
    @FXML private TextField Clave_PreviredED;
    @FXML private TextField Clave_facturacionED;
    @FXML private TextField Fecha_CompraED;
    @FXML private TextField DuracionED;

    // ----- BANCO EMPRESA -----
    @FXML private TextField Banco_EmpresaED;
    @FXML private TextField Num_CuentaED;
    @FXML private TextField Tipo_CuentaED;
    
    @FXML private JFXButton btnAGDirecciones;
    @FXML private JFXButton btnAGRepSoc;
    @FXML private JFXButton btnAGPos;

    @FXML private VBox vbDireccionesED;
    @FXML private VBox vbSociosED;
    @FXML private VBox vbPosED;
    
    @FXML private JFXButton btnGuardarED;
    @FXML private JFXButton btnCancelarED;
    
    @FXML
    private JFXButton btnEliminarDireccionED;
    private boolean direccionBaseEliminada = false;
    
    private final List<Integer> direccionesEliminadas = new ArrayList<>();
    
    public void cargarTodo(
        Dash_DatosClientes datos,
        List<Dash_RepSoc> listaSocios,
        List<Dash_DireccionesClientes> listaDirecciones,
        String usuarioPrevired,
        String clavePrevired,
        List<String> servicioPOS,
        List<String> usuarioPOS,
        List<String> clavePOS,
        List<String> observacionPOS
    ) {
        // ----- DATOS PRINCIPALES -----
        Razon_SocialED.setText(datos.getRazonSocial());
        TipoEDP.setValue(datos.getTipo());
        ApodoED.setText(datos.getApodo());
        RutED.setText(datos.getRut());
        ContactoED.setText(datos.getContacto());
        Clave_SIIED.setText(datos.getClaveFacturacion());
        Tipo_ContabilidadED.setValue(datos.getTipoContabilidad());
        Inicio_ContabilidadED.setText(datos.getInicioContabilidad());
        HonorariosED.setText(String.valueOf(datos.getHonorarios()));
        Clave_facturacionED.setText(datos.getClaveFacturacion());
        Fecha_CompraED.setText(datos.getFechaCompra());
        DuracionED.setText(datos.getDuracion());
        Banco_EmpresaED.setText(datos.getBancoEmpresa());
        Num_CuentaED.setText(datos.getNumCuenta());
        Tipo_CuentaED.setText(datos.getTipoCuenta());

        // ----- CLAVES PREVIRED -----
        if (usuarioPrevired != null) {
            Usuario_previredED.setText(usuarioPrevired);
        }
        if (clavePrevired != null) {
            Clave_PreviredED.setText(clavePrevired);
        }

        // ----- DIRECCIONES DINÁMICAS -----
        if (!listaDirecciones.isEmpty()) {
            // Primera dirección → a los campos no dinámicos
            Dash_DireccionesClientes primera = listaDirecciones.get(0);
            TIPO_DIRECCIONED.setValue(primera.getTipoDireccion());
            DIRECCIONED.setText(primera.getDireccion());
            NUMED.setText(primera.getNum());
            LOCALED.setText(primera.getLocal());
            COMUNAED.setValue(primera.getComuna());

            // Las siguientes → como nodos dinámicos
            for (int i = 1; i < listaDirecciones.size(); i++) {
                Dash_DireccionesClientes d = listaDirecciones.get(i);
                HBox nodo = crearNodoDireccion(d);
                vbDireccionesED.getChildren().add(nodo);
            }
        }

        // ----- REPRESENTANTES DINÁMICOS -----
        if (listaSocios != null && !listaSocios.isEmpty()) {
            System.out.println("🧾 Socios encontrados: " + listaSocios.size());

            // Cargar el primer socio en los campos no dinámicos
            Dash_RepSoc primero = listaSocios.get(0);
            TIPOED.setValue(primero.getTipo());
            NOMBREED.setText(primero.getNombre());
            RUTED.setText(primero.getRut());
            CLAVE_SIIED.setText(primero.getClaveSii());
            PARTICIPACIONED.setText(primero.getParticipacion());
            CONTACTOED.setText(primero.getContacto());
            CORREOED.setText(primero.getCorreo());
            CLAVE_UNICAED.setText(primero.getClaveUnica());
            RBANCOED.setText(primero.getBanco());
            RTIPO_CUENTAED.setValue(primero.getTipoCuenta());
            RN_DE_CUENTAED.setText(primero.getNumCuenta());

            // Limpiar nodos dinámicos antiguos
            vbSociosED.getChildren().removeIf(n -> n instanceof VBox);

            // Si hay más de uno, agregar dinámicamente
            if (listaSocios.size() > 1) {
                for (int i = 1; i < listaSocios.size(); i++) {
                    VBox nodo = crearNodoSocio(listaSocios.get(i));
                    vbSociosED.getChildren().add(nodo);
                }
            }
        }


        // ----- CLAVES POS DINÁMICAS -----
            for (int i = 0; i < servicioPOS.size(); i++) {
                VBox nodo = crearNodoPOS(
                    servicioPOS.get(i),
                    usuarioPOS.get(i),
                    clavePOS.get(i),
                    observacionPOS.get(i)
                );
                vbPosED.getChildren().add(nodo);
            }
}
    
    private HBox crearNodoDireccion(Dash_DireccionesClientes dir) {
        HBox fila = new HBox(10);
        fila.setAlignment(Pos.CENTER_LEFT);

        JFXComboBox<String> tipo = new JFXComboBox<>();
        tipo.getItems().addAll("Domicilio", "Sucursal");
        tipo.setValue(dir.getTipoDireccion());
        tipo.setPrefWidth(124);
        tipo.setPrefHeight(25);

        TextField calle = new TextField(dir.getDireccion());
        calle.setPromptText("Calle");
        calle.setPrefWidth(200);
        calle.setPrefHeight(25);

        TextField numero = new TextField(dir.getNum());
        numero.setPromptText("Número");
        numero.setPrefWidth(83);
        numero.setPrefHeight(25);

        TextField local = new TextField(dir.getLocal());
        local.setPromptText("N° Local");
        local.setPrefWidth(75);
        local.setPrefHeight(25);

        JFXComboBox<String> comuna = new JFXComboBox<>();
        comuna.getItems().addAll(COMUNAS);
        comuna.setValue(dir.getComuna());
        comuna.setPrefWidth(150);
        comuna.setPrefHeight(25);

        JFXButton btnEliminar = new JFXButton("Eliminar");
        btnEliminar.setRipplerFill(Paint.valueOf("RED"));
        btnEliminar.setStyle("-fx-background-color: #DC001A;");
        btnEliminar.setTextFill(Paint.valueOf("WHITE"));

        ImageView icono = new ImageView(new Image(getClass().getResourceAsStream("/com/oficinaeahb/countgest/images/ELIMINAReditar.png")));
        btnEliminar.setGraphic(icono);
        btnEliminar.setCursor(Cursor.HAND);
        btnEliminar.setOnAction(e -> {
            vbDireccionesED.getChildren().remove(fila);
            if (dir.getIdDireccion() != null) {
                direccionesEliminadas.add(dir.getIdDireccion());
            }
        });

        fila.getChildren().addAll(tipo, calle, numero, local, comuna, btnEliminar);
        return fila;
    }

    private VBox crearNodoSocio(Dash_RepSoc socio) {
    VBox contenedor = new VBox(5);

    // --- Fila 1: Tipo, Nombre, Rut + Botón Eliminar ---
    HBox fila1 = new HBox(10);
    JFXComboBox<String> tipo = new JFXComboBox<>();
    tipo.getItems().addAll("Representante", "Socio");
    tipo.setValue(socio.getTipo());
    tipo.setPrefWidth(150);

    TextField nombre = new TextField(socio.getNombre());
    nombre.setPromptText("Nombre");
    nombre.setPrefWidth(200);

    TextField rut = new TextField(socio.getRut());
    rut.setPromptText("RUT");
    rut.setPrefWidth(150);

    JFXButton btnEliminar = new JFXButton("Eliminar");
    btnEliminar.setStyle("-fx-background-color: #DC001A; -fx-text-fill: white;");
    btnEliminar.setCursor(Cursor.HAND);
    btnEliminar.setOnAction(e -> vbSociosED.getChildren().remove(contenedor));  // 🗑 Elimina el socio visualmente

    fila1.getChildren().addAll(tipo, nombre, rut, btnEliminar);

    // --- Fila 2 ---
    HBox fila2 = new HBox(10);
    TextField contacto = new TextField(socio.getContacto());
    contacto.setPromptText("Contacto");
    contacto.setPrefWidth(150);

    TextField correo = new TextField(socio.getCorreo());
    correo.setPromptText("Correo");
    correo.setPrefWidth(200);

    TextField claveSii = new TextField(socio.getClaveSii());
    claveSii.setPromptText("Clave SII");
    claveSii.setPrefWidth(120);

    TextField claveUnica = new TextField(socio.getClaveUnica());
    claveUnica.setPromptText("Clave Única");
    claveUnica.setPrefWidth(120);

    fila2.getChildren().addAll(contacto, correo, claveSii, claveUnica);

    // --- Fila 3 ---
    HBox fila3 = new HBox(10);
    TextField participacion = new TextField(socio.getParticipacion());
    participacion.setPromptText("Participación");
    participacion.setPrefWidth(100);

    TextField banco = new TextField(socio.getBanco());
    banco.setPromptText("Banco");
    banco.setPrefWidth(150);

    JFXComboBox<String> tipoCuenta = new JFXComboBox<>();
    tipoCuenta.getItems().addAll("Cuenta corriente", "Cuenta vista", "Cuenta RUT", "Chequera electrónica", "Cuenta de ahorro");
    tipoCuenta.setValue(socio.getTipoCuenta());
    tipoCuenta.setPrefWidth(150);

    TextField numCuenta = new TextField(socio.getNumCuenta());
    numCuenta.setPromptText("N° Cuenta");
    numCuenta.setPrefWidth(150);

    fila3.getChildren().addAll(participacion, banco, tipoCuenta, numCuenta);

    // --- Agregar todo al contenedor ---
    contenedor.getChildren().addAll(fila1, fila2, fila3);
    return contenedor;
}
    
    private VBox crearNodoPOS(String servicio, String usuario, String clave, String observacion) {
        VBox contenedor = new VBox();
        contenedor.setSpacing(5);

        HBox fila = new HBox();
        fila.setSpacing(10);

        JFXComboBox<String> comboServicio = new JFXComboBox<>();
        comboServicio.getItems().addAll("Transbank", "Getnet", "SumUp", "Redelcom", "Compraquí", "TUU", "Mercado Pago", "BCI Pagos", "Klap", "Fudo", "Kushki", "Vessi");
        comboServicio.setValue(servicio);
        comboServicio.setEditable(true);
        comboServicio.setPrefWidth(120);

        TextField txtUsuario = new TextField(usuario);
        txtUsuario.setPrefWidth(150);

        TextField txtClave = new TextField(clave);
        txtClave.setPrefWidth(150);

        TextField txtObservacion = new TextField(observacion);
        txtObservacion.setPrefWidth(200);

        fila.getChildren().addAll(comboServicio, txtUsuario, txtClave, txtObservacion);
        contenedor.getChildren().add(fila);
        return contenedor;
    }
    
    public void inicializarComboBoxesEditar() {
        TipoEDP.getItems().clear();
        TipoEDP.getItems().addAll("SPA", "LTDA", "EIRL", "S.A.");

        Tipo_ContabilidadED.getItems().clear();
        Tipo_ContabilidadED.getItems().addAll(
            "Pro Pyme General (14D)", "Pro Pyme Transparente (14D N°8)",
            "Regimen General", "Renta Presunta", "No sujeto al 14 de la LIR"
        );

        TIPO_DIRECCIONED.getItems().clear();
        TIPO_DIRECCIONED.getItems().addAll("Domicilio", "Sucursal");

        COMUNAED.getItems().clear();
        COMUNAED.getItems().addAll(COMUNAS);

        TIPOED.getItems().clear();
        TIPOED.getItems().addAll("Representante", "Socio");

        RTIPO_CUENTAED.getItems().clear();
        RTIPO_CUENTAED.getItems().addAll("Cuenta RUT", "Cuenta corriente", "Cuenta vista", "Chequera electrónica", "Cuenta de ahorro");

        Serv_PosED.getItems().clear();
        Serv_PosED.getItems().addAll(POS_SERVICIOS);
    }
    
    @FXML
    public void initialize() {
        inicializarComboBoxesEditar();
        inicializarEventosEditar();
        
        btnGuardarED.setOnAction(e -> guardarCambios());
        btnCancelarED.setOnAction(e -> cerrarPanelEditar());
        
        btnEliminarDireccionED.setOnAction(e -> eliminarDireccionBase());

    }
    
    private void inicializarEventosEditar() {
        btnAGDirecciones.setOnAction(e -> agregarDireccionED());
        btnAGRepSoc.setOnAction(e -> agregarSocioED());
        btnAGPos.setOnAction(e -> agregarPosED());
    }
    private void agregarDireccionED() {
        HBox fila = new HBox(10);
        fila.setAlignment(Pos.CENTER_LEFT);

        JFXComboBox<String> tipo = new JFXComboBox<>();
        tipo.getItems().addAll("Domicilio", "Sucursal");
        tipo.setPromptText("Tipo");
        tipo.setPrefWidth(124);
        tipo.setPrefHeight(25);

        TextField calle = new TextField();
        calle.setPromptText("Calle");
        calle.setPrefWidth(200);
        calle.setPrefHeight(25);

        TextField numero = new TextField();
        numero.setPromptText("Número");
        numero.setPrefWidth(83);
        numero.setPrefHeight(25);

        TextField local = new TextField();
        local.setPromptText("N° Local");
        local.setPrefWidth(75);
        local.setPrefHeight(25);

        JFXComboBox<String> comuna = new JFXComboBox<>();
        comuna.getItems().addAll(COMUNAS);
        comuna.setPromptText("Comuna");
        comuna.setPrefWidth(150);
        comuna.setPrefHeight(25);

        JFXButton btnEliminar = new JFXButton("Eliminar");
        btnEliminar.setRipplerFill(Paint.valueOf("RED"));
        btnEliminar.setStyle("-fx-background-color: #DC001A;");
        btnEliminar.setTextFill(Paint.valueOf("WHITE"));
        btnEliminar.setCursor(Cursor.HAND);

        InputStream iconStream = getClass().getResourceAsStream("/com/oficinaeahb/countgest/images/ELIMINAReditar.png");
        if (iconStream != null) {
            ImageView icono = new ImageView(new Image(iconStream));
            btnEliminar.setGraphic(icono);
        }

        btnEliminar.setOnAction(e -> vbDireccionesED.getChildren().remove(fila));

        fila.getChildren().addAll(tipo, calle, numero, local, comuna, btnEliminar);
        vbDireccionesED.getChildren().add(fila);
    }
    private void agregarSocioED() {
        // Crear un objeto socio vacío
        Dash_RepSoc socioVacio = new Dash_RepSoc();
        // Usar el método que ya tienes definido y que es compatible con guardarCambios()
        VBox nodo = crearNodoSocio(socioVacio);
        // Agregar al VBox principal
        vbSociosED.getChildren().add(nodo);
    }
    private void agregarPosED() {
        VBox nuevoPos = new VBox(5);

        // Servicio POS
        JFXComboBox<String> servicio = new JFXComboBox<>();
        servicio.getItems().addAll(POS_SERVICIOS);
        servicio.setPromptText("Servicio");
        servicio.setPrefWidth(150);

        JFXButton btnEliminar = new JFXButton("Eliminar");
        btnEliminar.setOnAction(e -> vbPosED.getChildren().remove(nuevoPos));

        HBox fila1 = new HBox(10, servicio, btnEliminar);

        TextField usuario = new TextField(); usuario.setPromptText("Usuario");
        TextField clave = new TextField(); clave.setPromptText("Clave");
        TextField observacion = new TextField(); observacion.setPromptText("Observación");

        nuevoPos.getChildren().addAll(fila1, usuario, clave, observacion);
        vbPosED.getChildren().add(nuevoPos);
    }

    private static final List<String> COMUNAS = Arrays.asList(
        "Santiago", "Estación Central", "Independencia", "Recoleta", "Quinta Normal", "Quilicura",
        "Providencia", "Cerro Navia", "Lo Prado", "Pudahuel", "Cerrillos", "Conchalí",
        "El Bosque", "Huechuraba", "La Cisterna", "La Florida", "La Granja", "La Pintana",
        "La Reina", "Las Condes", "Lo Barnechea", "Lo Espejo", "Macul", "Maipú", "Ñuñoa",
        "Pedro Aguirre Cerda", "Peñalolén", "Renca", "San Joaquín", "San Miguel", "San Ramón", "Vitacura"
    );

    private static final List<String> POS_SERVICIOS = Arrays.asList(
        "Transbank", "Getnet", "SumUp", "Redelcom", "Compraquí", "TUU",
        "Mercado Pago", "BCI Pagos", "Klap", "Fudo", "Kushki", "Vessi"
    );

    private int idCliente;
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    private void guardarCambios() {
        System.out.println("🔧 MÉTODO guardarCambios() llamado");
        
        try {
            // --- Datos principales del cliente ---
            Dash_DatosClientes datos = new Dash_DatosClientes(
                this.idCliente,
                Tipo_ContabilidadED.getValue(),
                Razon_SocialED.getText(),
                TipoEDP.getValue(),
                ApodoED.getText(),
                RutED.getText(),
                ContactoED.getText(),
                Double.parseDouble(HonorariosED.getText()),
                Inicio_ContabilidadED.getText(),
                Banco_EmpresaED.getText(),
                Num_CuentaED.getText(),
                Tipo_CuentaED.getText(),
                Clave_facturacionED.getText(),
                Fecha_CompraED.getText(),
                DuracionED.getText()
            );

            // --- Claves principales ---
            Dash_ClavesPrincipales claves = new Dash_ClavesPrincipales(
                idCliente,
                null,
                null,
                Usuario_previredED.getText(),
                Clave_PreviredED.getText()
            );

            // --- Direcciones dinámicas ---
            // ➤ Dirección base (no dinámica)
            List<Dash_DireccionesClientes> direcciones = new ArrayList<>();

            // ➤ Direcciones adicionales (dinámicas)
            for (Node node : vbDireccionesED.getChildren()) {
                if (node instanceof HBox) {
                    HBox fila = (HBox) node;

                    JFXComboBox<String> tipo = (JFXComboBox<String>) fila.getChildren().get(0);
                    TextField direccion = (TextField) fila.getChildren().get(1);
                    TextField numero = (TextField) fila.getChildren().get(2);
                    TextField local = (TextField) fila.getChildren().get(3);
                    JFXComboBox<String> comuna = (JFXComboBox<String>) fila.getChildren().get(4);

                    Dash_DireccionesClientes dirExtra = new Dash_DireccionesClientes();
                    dirExtra.setIdCliente(idCliente);
                    dirExtra.setTipoDireccion(tipo.getValue());
                    dirExtra.setDireccion(direccion.getText());
                    dirExtra.setNum(numero.getText());
                    dirExtra.setLocal(local.getText());
                    dirExtra.setComuna(comuna.getValue());

                    direcciones.add(dirExtra);
                }
            }
                List<Dash_RepSoc> socios = new ArrayList<>();
                // ✅ Agregar socio base (no dinámico)
                if (TIPOED.getValue() != null && !NOMBREED.getText().isBlank()) {
                    boolean yaExiste = socios.stream().anyMatch(rep ->
                        rep.getRut() != null && rep.getRut().equalsIgnoreCase(RUTED.getText())
                    );

                    if (!yaExiste) {
                        Dash_RepSoc socioBase = new Dash_RepSoc();
                        socioBase.setIdCliente(idCliente);
                        socioBase.setTipo(TIPOED.getValue());
                        socioBase.setNombre(NOMBREED.getText());
                        socioBase.setRut(RUTED.getText());
                        socioBase.setClaveSii(CLAVE_SIIED.getText());
                        socioBase.setParticipacion(PARTICIPACIONED.getText());
                        socioBase.setContacto(CONTACTOED.getText());
                        socioBase.setCorreo(CORREOED.getText());
                        socioBase.setClaveUnica(CLAVE_UNICAED.getText());
                        socioBase.setBanco(RBANCOED.getText());
                        socioBase.setTipoCuenta(RTIPO_CUENTAED.getValue());
                        socioBase.setNumCuenta(RN_DE_CUENTAED.getText());

                        socios.add(socioBase);
                    }
                }
            
                // --- Representantes dinámicos ---
                for (Node node : vbSociosED.getChildren()) {
                    if (node instanceof VBox) {
                        VBox vb = (VBox) node;

                        // Accedemos a las filas (HBox)
                        HBox fila1 = (HBox) vb.getChildren().get(0);
                        HBox fila2 = (HBox) vb.getChildren().get(1);
                        HBox fila3 = (HBox) vb.getChildren().get(2);

                        // Campos de fila 1
                        JFXComboBox<String> tipo = (JFXComboBox<String>) fila1.getChildren().get(0);
                        TextField nombre = (TextField) fila1.getChildren().get(1);
                        TextField rut = (TextField) fila1.getChildren().get(2);

                        // Campos de fila 2
                        TextField contacto = (TextField) fila2.getChildren().get(0);
                        TextField correo = (TextField) fila2.getChildren().get(1);
                        TextField claveSii = (TextField) fila2.getChildren().get(2);
                        TextField claveUnica = (TextField) fila2.getChildren().get(3);

                        // Campos de fila 3
                        TextField participacion = (TextField) fila3.getChildren().get(0);
                        TextField banco = (TextField) fila3.getChildren().get(1);
                        JFXComboBox<String> tipoCuenta = (JFXComboBox<String>) fila3.getChildren().get(2);
                        TextField numCuenta = (TextField) fila3.getChildren().get(3);

                        // Construcción del objeto representante
                        Dash_RepSoc rep = new Dash_RepSoc();
                        rep.setIdCliente(idCliente);
                        rep.setTipo(tipo.getValue());
                        rep.setNombre(nombre.getText());
                        rep.setRut(rut.getText());
                        rep.setContacto(contacto.getText());
                        rep.setCorreo(correo.getText());
                        rep.setClaveSii(claveSii.getText());
                        rep.setClaveUnica(claveUnica.getText());
                        rep.setParticipacion(participacion.getText());
                        rep.setBanco(banco.getText());
                        rep.setTipoCuenta(tipoCuenta.getValue());
                        rep.setNumCuenta(numCuenta.getText());

                        socios.add(rep);
                    }
                }


            // --- POS dinámicos ---
            List<Dash_ClavesPOS> posList = new ArrayList<>();
            for (Node node : vbPosED.getChildren()) {
                if (node instanceof VBox) {
                VBox vb = (VBox) node;  
                    HBox fila1 = (HBox) vb.getChildren().get(0);
                    JFXComboBox<String> servicio = (JFXComboBox<String>) fila1.getChildren().get(0);

                    Dash_ClavesPOS pos = new Dash_ClavesPOS();
                    pos.setIdCliente(idCliente);
                    pos.setServPos(servicio.getValue());
                    pos.setUsuario(((TextField) vb.getChildren().get(1)).getText());
                    pos.setClave(((TextField) vb.getChildren().get(2)).getText());
                    pos.setObservacion(((TextField) vb.getChildren().get(3)).getText());

                    posList.add(pos);
                }
            }

            // --- Guardar en la base de datos ---
            ConexionDataBase db = new ConexionDataBase();
            db.actualizarDatosCliente(datos);
            db.actualizarClavesPrincipales(claves);
            db.reemplazarDireccionesCliente(idCliente, direcciones);
            db.reemplazarRepresentantes(idCliente, socios);
            db.reemplazarClavesPOS(idCliente, posList);

            // --- Confirmación y cierre ---
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Guardado");
            alerta.setHeaderText(null);
            alerta.setContentText("Los datos se han guardado correctamente.");
            alerta.showAndWait();

            cerrarPanelEditar();
            
            // Eliminar direcciones marcadas
            if (!direccionesEliminadas.isEmpty()) {
                for (int id : direccionesEliminadas) {
                    db.eliminarDireccion(id); // usar la instancia ya creada
                }
                System.out.println("🗑 Direcciones eliminadas: " + direccionesEliminadas.size());
                direccionesEliminadas.clear(); // Limpia la lista
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo guardar");
            alerta.setContentText("Ocurrió un error al intentar guardar los cambios.");
            alerta.showAndWait();
        }
    }
    
    private void cerrarPanelEditar() {
        // Cierra la ventana del PanelEditar
        Stage stage = (Stage) PanelEditar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void eliminarDireccionBase() {
        System.out.println("🗑 Se presionó el botón para eliminar dirección base.");
        // Opcional: ocultar o deshabilitar los campos
        TIPO_DIRECCIONED.setDisable(true);
        DIRECCIONED.setDisable(true);
        NUMED.setDisable(true);
        LOCALED.setDisable(true);
        COMUNAED.setDisable(true);

        // También podrías limpiar los campos si lo deseas:
        /*
        TIPO_DIRECCIONED.setValue(null);
        DIRECCIONED.clear();
        NUMED.clear();
        LOCALED.clear();
        COMUNAED.setValue(null);
        */

        // Marca que no se debe guardar esta dirección base
        direccionBaseEliminada = true;
    }
    
}
