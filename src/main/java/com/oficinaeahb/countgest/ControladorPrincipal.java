/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oficinaeahb.countgest;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.apache.commons.text.similarity.LevenshteinDistance;

import com.jfoenix.controls.JFXTreeTableView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javafx.animation.FadeTransition;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Pablo
 */
public class ControladorPrincipal {
    
    @FXML
    private JFXTreeTableView<Dash_TablaBusquedaInicial> ltClientes;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, Void> btnAbrir;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, Integer> ltID;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltNombre;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltTipo;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltRut;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltCalle;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltLocal;
    @FXML
    private JFXTreeTableColumn<Dash_TablaBusquedaInicial, String> ltRepSoc;
    @FXML
    private TextField ltBuscador;
    @FXML
    private BorderPane busClientes;
    @FXML
    private BorderPane clDashboard;
    @FXML
    private Label ID_ClientePerfil;
    @FXML
    private Label tipo_contabilidad;
    @FXML
    private Label nombre_empresa;
    @FXML
    private Label apodo;
    @FXML
    private Label rut;
    @FXML
    private Label contacto_empresa;
    @FXML
    private Label honorarios;
    @FXML
    private Label inicio_contabilidad;
    @FXML
    private Label direccion;
    @FXML
    private TextField banco_empresa_renta;
    @FXML
    private TextField num_cuenta_renta;
    @FXML
    private TextField tipo_cuenta_renta;
    @FXML
    private TextField clave_fact;
    @FXML
    private TextField fecha_comp;
    @FXML
    private TextField duracion;
    @FXML
    private TableView<Dash_DireccionesClientes> direcciones;
    @FXML
    private TableColumn<Dash_DireccionesClientes, String> colTipo_Direccion;
    @FXML
    private TableColumn<Dash_DireccionesClientes, String> colCalle;
    @FXML
    private TableColumn<Dash_DireccionesClientes, String> colNum;
    @FXML
    private TableColumn<Dash_DireccionesClientes, String> colLocal;
    @FXML
    private TableColumn<Dash_DireccionesClientes, String> colComuna;
    @FXML
    private Label rep_Tipo;
    @FXML
    private Label rep_participacion;
    @FXML
    private TextField rep_nombre;
    @FXML
    private TextField rep_correo;
    @FXML
    private TextField rep_contacto;
    @FXML
    private TextField rep_rut;
    @FXML
    private TextField rep_claveSii;
    @FXML
    private TextField rep_claveUnica;
    @FXML
    private TextField rep_banco;
    @FXML
    private TextField rep_tipoCuenta;
    @FXML
    private TextField rep_numcuenta;
    @FXML
    private HBox circleContainer; // Contenedor de los círculos
    @FXML
    private HBox circleContainerClaves; // Contenedor de los círculos claves
    @FXML
    private ComboBox<String> grupoComboBox;
    @FXML
    private TextField cl_usuario;
    @FXML
    private TextField cl_contrasena;
    @FXML
    private Label cl_servicio;
    @FXML
    private JFXButton Cop_Usuario;
    @FXML
    private JFXButton Cop_Clave;
    @FXML
    private JFXButton Cop_Rut;
    @FXML
    private JFXButton Cop_ClaveSII;
    @FXML
    private JFXButton Cop_ClaveUnica;
    //------ 28/02/2025
    @FXML
    private HBox hbDirecciones; // Contenedor donde se agregarán las direcciones dinámicas
    @FXML
    private VBox vbDirecciones;
    @FXML
    private JFXComboBox<String> txtTipo_direccion;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtNumero_calle;
    @FXML
    private TextField txtNumero_local;
    @FXML
    private JFXComboBox<String> txtcomuna;
    @FXML
    private JFXButton btnAgregar_direccion;
    @FXML
    private JFXButton btnEliminar_direccion;
    @FXML
    private VBox vbSocios;  // El contenedor principal para los socios
    @FXML
    private JFXButton btnAgregar_socio;
    @FXML
    private JFXButton btnEliminar_socio;
    @FXML
    private VBox vbPos;
    @FXML
    private JFXButton btnAgregar_pos;
    @FXML
    private JFXButton txtEliminar_pos;

    private final List<HBox> listaDirecciones = new ArrayList<>();
    
    @FXML
    private JFXComboBox<String> txtTipo_empresa;
    @FXML
    private JFXComboBox<String> txtTipo_direccion_cliente; // Nombre actualizado
    @FXML
    private JFXComboBox<String> txtComuna_cliente; // Nombre actualizado
    @FXML
    private JFXComboBox<String> txtTipo_socio;
    @FXML
    private JFXComboBox<String> txtServicio_pos;
    @FXML
    private JFXComboBox<String> txtTipo_cuenta_banco_socio;
    @FXML
    private JFXComboBox<String> txtTipo_contabilidad;
    @FXML
    private TextField txtHonorarios;
    @FXML
    private TextField txtApodo_empresa;
    @FXML
    private TextField txtRut_empresa;
    @FXML
    private TextField txtRazon_social;
    @FXML
    private TextField txtClave_sii;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtNombre_socio;
    @FXML
    private TextField txtRut_socio;
    @FXML
    private TextField txtClave_sii_socio;
    @FXML
    private TextField txtParticipacion_socio;
    @FXML
    private TextField txtContacto_socio;
    @FXML
    private TextField txtCorreo_socio;
    @FXML
    private TextField txtClave_unica_socio;
    @FXML
    private TextField txtBanco_socio;
    @FXML
    private TextField txtNumero_cuenta_banco_socio;
    @FXML
    private TextField txtUsuario_pos;
    @FXML
    private TextField txtClave_pos;
    @FXML
    private TextField txtObservacion_pos;
    @FXML
    private TextField txtUsuario_prev;
    @FXML
    private TextField txtClave_prev;
    @FXML
    private TextField txtClave_fact;
    @FXML
    private TextField txtDuracion_fact;
    @FXML
    private TextField txtFecha_fact;
    @FXML
    private JFXButton btnVolver_Formulario;
    @FXML
    private JFXButton btnGuardar_formulario;
    @FXML
    private JFXButton btnLimpiar_formulario;
    @FXML
    private BorderPane FormCliente;
    @FXML
    private JFXButton btnFormCliente;
    @FXML
    private JFXButton btn_eliminar_cliente;
    @FXML
    private JFXButton btn_inhabilitar_cliente;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private BorderPane bpClaves;
    @FXML
    private Pane pTituloClave;
    
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

    
    private final ConsultasDataBase consultas = new ConsultasDataBase();
    private ObservableList<Dash_TablaBusquedaInicial> datos;
    
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    
    @FXML
    public void initialize() {
        //Para Tabla busqueda clientes inicial
        configurarTabla();
        cargarDatos();
        Platform.runLater(() -> {
            ltClientes.getScene().getStylesheets().add(getClass().getResource("/com/oficinaeahb/countgest/material-table.css").toExternalForm());
        });
        //--
        // para buscador
        //█(Comentar JFoenix)█
        configurarBuscador();
        //botones
        //█(Comentar JFoenix)█
        configurarColumnaBoton();
        Platform.runLater(() -> {
            ltClientes.getScene().getStylesheets().add(getClass().getResource("/com/oficinaeahb/countgest/TablaBoton-mat-des.css").toExternalForm());
        });

        grupoComboBox.getItems().addAll("Claves Principales", "Claves POS");
        grupoComboBox.setValue("Claves Principales"); // Valor predeterminado
        grupoComboBox.setOnAction(event -> {
            String grupoSeleccionado = grupoComboBox.getValue();

            if ("Claves Principales".equals(grupoSeleccionado)) {
                cargarClavesPrincipales();
                cargarCírculosClavesPrincipales(); // importante para los círculos

                // Cambiar colores para Claves Principales
                bpClaves.setStyle("-fx-background-color: #0D47A1;");
                pTituloClave.setStyle("-fx-background-color: #002843; -fx-text-fill: white;");

            } else if ("Claves POS".equals(grupoSeleccionado)) {
                cargarClavesPOS();
                cargarCírculosClavesPOS(); // importante para los círculos

                // Cambiar colores para Claves POS
                bpClaves.setStyle("-fx-background-color: #B71C1C;");
                pTituloClave.setStyle("-fx-background-color: #5B0809; -fx-text-fill: white;");
            }
        });
        
        //Botones copiar
        setupCopyButton(Cop_Usuario, cl_usuario);
        setupCopyButton(Cop_Clave, cl_contrasena);
        setupCopyButton(Cop_Rut, rep_rut);
        setupCopyButton(Cop_ClaveSII, rep_claveSii);
        setupCopyButton(Cop_ClaveUnica, rep_claveUnica);
        
        setupHoverEffects(Cop_Usuario);
        setupHoverEffects(Cop_Clave);
        setupHoverEffects(Cop_Rut);
        setupHoverEffects(Cop_ClaveSII);
        setupHoverEffects(Cop_ClaveUnica);
        
        //Pantalla formulario ingreso clientes
        btnAgregar_direccion.setOnAction(event -> agregarDireccion());
        btnEliminar_direccion.setOnAction(event -> eliminarDireccion());
        // Deshabilitar el botón de eliminar dirección al inicio
        btnEliminar_direccion.setDisable(true);
        
        //BTN Socios
            // Vincular los botones con los métodos de agregar y eliminar socios
        btnAgregar_socio.setOnAction(event -> agregarSocio());
        btnEliminar_socio.setOnAction(event -> eliminarSocio());
        // Deshabilitar el botón de eliminar al inicio (para que no se pueda presionar si no hay socios adicionales)
        btnEliminar_socio.setDisable(true);
        
        //Btn Pos
        btnAgregar_pos.setOnAction(event -> agregarPos());
        txtEliminar_pos.setOnAction(event -> eliminarPos());

        // Deshabilitar el botón de eliminar al inicio
        txtEliminar_pos.setDisable(true);
        
        //boton para guardar datos del formulario
        btnGuardar_formulario.setOnAction(event -> guardarFormulario());
        
        configurarComboBoxes();
        
        btnVolver_Formulario.setOnAction(event -> volverFormulario());
        
        //Boton volver formulario
        btnFormCliente.setOnAction(event -> {
            limpiarFormulario(); // Método para limpiar los campos
            abrirFormulario(); // Método para cambiar la pantalla con animación
        });
        
        //configurar formato de fecha de factura
        configurarFechaAutomatica();
        
        btnLimpiar_formulario.setOnAction(event -> limpiarFormulario());
        
        //boton eliminar cliente
        btn_eliminar_cliente.setOnAction(event -> eliminarCliente());
        //boton inhabilitar
        btn_inhabilitar_cliente.setOnAction(event -> alternarEstadoCliente());
        
        //Boton estado de dashboard
        btn_inhabilitar_cliente.setOnAction(event -> alternarEstadoCliente());
        
        //Boton editar (dashboard)
        btnEditar.setOnAction(event -> abrirVentanaPanelEditar());
        
        
    }
    
//►►► PANTALLA DE INICIO
    
    //Para Tabla busqueda clientes inicial
    private void configurarTabla() {
        ltID.setCellValueFactory(param -> param.getValue().getValue().idProperty().asObject());
        ltNombre.setCellValueFactory(param -> param.getValue().getValue().razonSocialProperty());
        ltTipo.setCellValueFactory(param -> param.getValue().getValue().tipoProperty());
        ltRut.setCellValueFactory(param -> param.getValue().getValue().rutProperty());
        ltCalle.setCellValueFactory(param -> param.getValue().getValue().direccionProperty());
        ltLocal.setCellValueFactory(param -> param.getValue().getValue().localProperty());
        ltRepSoc.setCellValueFactory(param -> param.getValue().getValue().representanteProperty());
    }
    private void cargarDatos() {
        // Obtener los datos
        datos = FXCollections.observableArrayList(consultas.obtenerDatos());

        // Crear un nodo raíz
        TreeItem<Dash_TablaBusquedaInicial> root = new TreeItem<>(new Dash_TablaBusquedaInicial(0, "Root", "", "", "", "", ""));
        root.setExpanded(true); // Para que los nodos estén expandidos por defecto

        // Agregar cada elemento como un hijo del nodo raíz
        for (Dash_TablaBusquedaInicial item : datos) {
            TreeItem<Dash_TablaBusquedaInicial> treeItem = new TreeItem<>(item);
            root.getChildren().add(treeItem);
        }

        // Asignar el nodo raíz al JFXTreeTableView
        ltClientes.setRoot(root);
        ltClientes.setShowRoot(false); // Si no deseas mostrar el nodo raíz

        // Imprimir la cantidad de datos cargados
        System.out.println("Datos cargados: " + datos.size());
    }
    //---
    //Buscador de cliente inicial
    //█(comentar JFoenix)█
    private void configurarBuscador() {
    // Crear un listener para el buscador
    ltBuscador.textProperty().addListener((observable, oldValue, newValue) -> {
        // Filtrar y regenerar los datos
        filtrarYActualizarTabla(newValue);
    });
    }
    private void filtrarYActualizarTabla(String textoBusqueda) {
        TreeItem<Dash_TablaBusquedaInicial> root = new TreeItem<>(new Dash_TablaBusquedaInicial(0, "Root", "", "", "", "", ""));
        root.setExpanded(true);

        String textoBusquedaLower = textoBusqueda != null ? textoBusqueda.toLowerCase() : "";
        String[] palabrasClave = textoBusquedaLower.split("\\s+");

        for (Dash_TablaBusquedaInicial registro : datos) {
            if (textoBusquedaLower.isEmpty() || cumpleFiltroAvanzado(registro, palabrasClave)) {
                TreeItem<Dash_TablaBusquedaInicial> treeItem = new TreeItem<>(registro);
                root.getChildren().add(treeItem);
            }
        }

        ltClientes.setRoot(root);
        ltClientes.setShowRoot(false);
    }
    private boolean cumpleFiltroAvanzado(Dash_TablaBusquedaInicial registro, String[] palabrasClave) {
        // Método para filtrar utilizando múltiples palabras clave con búsqueda flexible
        for (String palabra : palabrasClave) {
            // Verificar si la palabra coincide de forma aproximada en cualquiera de las propiedades relevantes
            if (!esCoincidenciaFlexible(getSafeLower(registro.getRazonSocial()), palabra) &&
                !esCoincidenciaFlexible(getSafeLower(registro.getRut()), palabra) &&
                !esCoincidenciaFlexible(getSafeLower(registro.getTipo()), palabra) &&
                !esCoincidenciaFlexible(getSafeLower(registro.getDireccion()), palabra) &&
                !esCoincidenciaFlexible(getSafeLower(registro.getLocal()), palabra) &&
                !esCoincidenciaFlexible(getSafeLower(registro.getRepresentante()), palabra)) {
                return false; // Si ninguna coincidencia, devolver false
            }
        }
        return true;
    }
    private String getSafeLower(String value) {
    // Método auxiliar para manejar nulos y convertir a minúsculas
        return value != null ? value.toLowerCase() : "";
    }
    private boolean esCoincidenciaFlexible(String texto, String palabraClave) {
        // Método auxiliar para búsqueda flexible
        texto = texto.toLowerCase();
        palabraClave = palabraClave.toLowerCase();

        // Verificar coincidencia exacta o similar (basado en Levenshtein)
        return texto.contains(palabraClave) || distanciaLevenshtein(texto, palabraClave) <= 2;
    }
    private int distanciaLevenshtein(String s1, String s2) {
        // Algoritmo de distancia de Levenshtein
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                    );
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
   //---

    public List<String> buscarPalabras(String input, List<String> datos) {
        List<String> resultados = new ArrayList<>();
        LevenshteinDistance levenshtein = new LevenshteinDistance();

        for (String dato : datos) {
            int distancia = levenshtein.apply(input.toLowerCase(), dato.toLowerCase());
            if (dato.contains(input) || distancia <= 2) { // Permitir errores de hasta 2 caracteres
                resultados.add(dato);
            }
        }
        return resultados;
    }
    //---
    //█Boton de la tabla (comentar JFoenix)█
    private void configurarColumnaBoton() {
        btnAbrir.setCellFactory(param -> new TreeTableCell<>() {
            private final JFXButton btnAbrirRegist = new JFXButton();

            {
                // Agregar estilo Material Design (clase CSS personalizada)
                btnAbrirRegist.getStyleClass().add("jfx-button");
                btnAbrirRegist.getStyleClass().add("md-button");

                // Configurar acción del botón
                btnAbrirRegist.setOnAction(event -> {
                    Dash_TablaBusquedaInicial registro = getTreeTableView().getTreeItem(getIndex()).getValue();

                    if (registro != null) {
                        int idCliente = registro.getId();
                        ID_ClientePerfil.setText(String.valueOf(idCliente));
                        System.out.println("ID Cliente seleccionado: " + idCliente);
                        
                        // ✅ Verificar si el cliente está inactivo y mostrar advertencia
                        try (Connection conn = ConexionDataBase.getConnection();
                             PreparedStatement stmt = conn.prepareStatement("SELECT Inactivo FROM clientes WHERE IDCliente = ?")) {

                            stmt.setInt(1, idCliente);
                            ResultSet rs = stmt.executeQuery();

                            if (rs.next() && rs.getBoolean("Inactivo")) {
                                Alert alerta = new Alert(Alert.AlertType.WARNING);
                                alerta.setTitle("Cliente inactivo");
                                alerta.setHeaderText(null);
                                alerta.setContentText("No hacer trabajos.");
                                alerta.showAndWait();
                            }

                        } catch (SQLException e) {
                            System.err.println("❌ Error al verificar estado del cliente: " + e.getMessage());
                        }
                        // Ocultar panel de búsqueda con transición
                        FadeTransition fadeOut = new FadeTransition(Duration.millis(200), busClientes);
                        fadeOut.setFromValue(1.0);
                        fadeOut.setToValue(0.0);
                        fadeOut.setOnFinished(e -> {
                            busClientes.setVisible(false);
                            clDashboard.setOpacity(0.0);
                            clDashboard.setVisible(true);

                            FadeTransition fadeIn = new FadeTransition(Duration.millis(200), clDashboard);
                            fadeIn.setFromValue(0.0);
                            fadeIn.setToValue(1.0);
                            fadeIn.play();
                        });
                        fadeOut.play();

                        // Cargar datos del cliente
                        cargarDatosCliente(idCliente);
                        cargarDatosRepresentante(idCliente);
                        configurarTabla();
                        configurarTablaDirecciones();

                        // 🔄 ACTUALIZAR ESTADO DEL BOTÓN
                        actualizarEstadoBotonInhabilitar();

                        // Cargar claves según grupo seleccionado
                        String grupoSeleccionado = grupoComboBox.getValue();
                        if ("Claves Principales".equals(grupoSeleccionado)) {
                            cargarClavesPrincipales();
                            cargarCírculosClavesPrincipales();
                        } else if ("Claves POS".equals(grupoSeleccionado)) {
                            cargarClavesPOS();
                            cargarCírculosClavesPOS();
                        }
                    } else {
                        System.err.println("No se seleccionó ningún cliente.");
                    }
                });

            }
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        Dash_TablaBusquedaInicial registro = getTreeTableView().getTreeItem(getIndex()).getValue();

                        if (registro != null) {
                            int idCliente = registro.getId();

                            // Valor por defecto (cliente ACTIVO)
                            String iconPath = "/com/oficinaeahb/countgest/images/IDCARD.png";

                            // Consultar estado del cliente en BD
                            String sql = "SELECT Inactivo FROM clientes WHERE IDCliente = ?";
                            try (Connection conn = ConexionDataBase.getConnection();
                                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                                stmt.setInt(1, idCliente);
                                ResultSet rs = stmt.executeQuery();

                                if (rs.next() && rs.getBoolean("Inactivo")) {
                                    // Si está inactivo, cambia el ícono
                                    iconPath = "/com/oficinaeahb/countgest/images/IDCARD2.png";
                                }

                            } catch (SQLException e) {
                                System.err.println("⚠️ Error al consultar estado del cliente: " + e.getMessage());
                            }

                            // Aplicar el ícono correspondiente
                            Image icon = new Image(getClass().getResourceAsStream(iconPath));
                            ImageView iconView = new ImageView(icon);
                            iconView.setFitHeight(24);
                            iconView.setFitWidth(24);
                            btnAbrirRegist.setGraphic(iconView);
                        }

                        setGraphic(btnAbrirRegist);
                    }
                }

        });
        
    }
    @FXML
    private void abrirFormulario() {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), busClientes);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            busClientes.setVisible(false);
            FormCliente.setOpacity(0.0);
            FormCliente.setVisible(true);

            FadeTransition fadeIn = new FadeTransition(Duration.millis(300), FormCliente);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });

        fadeOut.play();
    }
    private void limpiarFormulario() {
        // Limpiar campos de texto
        txtRazon_social.clear();
        txtApodo_empresa.clear();
        txtRut_empresa.clear();
        txtClave_sii.clear();
        txtContacto.clear();
        txtHonorarios.clear();
        txtCalle.clear();
        txtNumero_calle.clear();
        txtNumero_local.clear();
        txtNombre_socio.clear();
        txtRut_socio.clear();
        txtClave_sii_socio.clear();
        txtParticipacion_socio.clear();
        txtContacto_socio.clear();
        txtCorreo_socio.clear();
        txtClave_unica_socio.clear();
        txtBanco_socio.clear();
        txtNumero_cuenta_banco_socio.clear();
        txtUsuario_pos.clear();
        txtClave_pos.clear();
        txtObservacion_pos.clear();
        txtUsuario_prev.clear();
        txtClave_prev.clear();
        txtClave_fact.clear();
        txtFecha_fact.clear();
        txtDuracion_fact.clear();

        // Limpiar ComboBox (selección vacía)
        txtTipo_empresa.setValue(null);
        txtTipo_contabilidad.setValue(null);
        txtTipo_direccion_cliente.setValue(null);
        txtComuna_cliente.setValue(null);
        txtTipo_socio.setValue(null);
        txtTipo_cuenta_banco_socio.setValue(null);
        txtServicio_pos.setValue(null);

        // Limpiar direcciones dinámicas (manteniendo el primer nodo)
        if (vbDirecciones.getChildren().size() > 1) {
            vbDirecciones.getChildren().remove(1, vbDirecciones.getChildren().size());
        }

        // Limpiar socios dinámicos (manteniendo los primeros nodos originales)
        if (vbSocios.getChildren().size() > 3) {
            vbSocios.getChildren().remove(3, vbSocios.getChildren().size());
        }

        // Limpiar POS dinámicos (manteniendo el primer nodo)
        if (vbPos.getChildren().size() > 1) {
            vbPos.getChildren().remove(1, vbPos.getChildren().size());
        }
    }

//--------------------------------------------------
    
//►►►Pantalla Dashboard
    
    //aqui cargan los datos a los labels y textfields (antes del primer else)
    private void cargarDatosCliente(int idClientePerfil) {
    // Obtener datos del cliente desde la base de datos
    Dash_DatosClientes cliente = consultas.obtenerDatosCliente(idClientePerfil);
    if (cliente != null) {
        tipo_contabilidad.setText(cliente.getTipoContabilidad());
        
        String tipo = cliente.getTipo() != null ? cliente.getTipo() : "";
        nombre_empresa.setText(cliente.getRazonSocial() + (tipo.isEmpty() ? "" : " " + tipo));
        
        apodo.setText(cliente.getApodo());
        rut.setText(cliente.getRut());
        contacto_empresa.setText(cliente.getContacto());
        
        String honorariosFormateados = decimalFormat.format(cliente.getHonorarios());
        honorarios.setText(honorariosFormateados);
        
        inicio_contabilidad.setText(cliente.getInicioContabilidad());
        banco_empresa_renta.setText(cliente.getBancoEmpresa());
        num_cuenta_renta.setText(cliente.getNumCuenta());
        tipo_cuenta_renta.setText(cliente.getTipoCuenta());
        clave_fact.setText(cliente.getClaveFacturacion());
        fecha_comp.setText(cliente.getFechaCompra());
        duracion.setText(cliente.getDuracion());
        
        // Cargar dirección de domicilio
        String direccionDomicilio = consultas.obtenerDireccionDomicilio(idClientePerfil);
        direccion.setText(direccionDomicilio);
        
        // Cargar direcciones en el TableView
        ObservableList<Dash_DireccionesClientes> listaDirecciones = FXCollections.observableArrayList(consultas.obtenerDirecciones(idClientePerfil));
        direcciones.setItems(listaDirecciones);
        
        //cargar datos representantes
        cargarCirculosDinamicos(idClientePerfil);
        
    } else {
        System.out.println("No se encontraron datos para el cliente con ID: " + idClientePerfil);
        // Opcional: limpia los campos si no hay datos
        limpiarCampos();

    // Obtener y asignar la dirección del tipo "Domicilio"
    String direccionDomicilio = consultas.obtenerDireccionDomicilio(idClientePerfil);
    if (direccionDomicilio != null && !direccionDomicilio.isEmpty()) {
        direccion.setText(direccionDomicilio);
    } else {
        direccion.setText("No disponible");
    }

    // Cargar las direcciones en el TableView "direcciones"
    ObservableList<Dash_DireccionesClientes> listaDirecciones = FXCollections.observableArrayList(consultas.obtenerDirecciones(idClientePerfil));
    direcciones.setItems(listaDirecciones);
    }
    }
    private void limpiarCampos() {
    // Limpiar Labels
    tipo_contabilidad.setText("");
    nombre_empresa.setText("");
    apodo.setText("");
    rut.setText("");
    contacto_empresa.setText("");
    honorarios.setText("");
    inicio_contabilidad.setText("");

    // Limpiar TextFields
    banco_empresa_renta.setText("");
    num_cuenta_renta.setText("");
    tipo_cuenta_renta.setText("");
    clave_fact.setText("");
    fecha_comp.setText("");
    duracion.setText("");
    }
    private void configurarTablaDirecciones() {
    colTipo_Direccion.setCellValueFactory(new PropertyValueFactory<>("tipoDireccion"));
    colCalle.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    colNum.setCellValueFactory(new PropertyValueFactory<>("num"));
    colLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
    colComuna.setCellValueFactory(new PropertyValueFactory<>("comuna"));
}
    
    //representantes y circulos dinamicos repsoc
    @FXML
    private void cargarDatosRepresentante(int idClientePerfil) {
        Dash_RepSoc representante = consultas.obtenerDatosRepresentante(idClientePerfil);

        if (representante != null) {
            rep_Tipo.setText(representante.getTipo());
            rep_participacion.setText(representante.getParticipacion());
            rep_nombre.setText(representante.getNombre());
            rep_correo.setText(representante.getCorreo());
            rep_contacto.setText(representante.getContacto());
            rep_rut.setText(representante.getRut());
            rep_claveSii.setText(representante.getClaveSii());
            rep_claveUnica.setText(representante.getClaveUnica());
            rep_banco.setText(representante.getBanco());
            rep_tipoCuenta.setText(representante.getTipoCuenta());
            rep_numcuenta.setText(representante.getNumCuenta());
        } else {
            limpiarCamposRepresentante(); // Limpia los cuadros si no hay datos
        }
    }
    private void limpiarCamposRepresentante() {
    rep_Tipo.setText("");
    rep_participacion.setText("");
    rep_nombre.setText("");
    rep_correo.setText("");
    rep_contacto.setText("");
    rep_rut.setText("");
    rep_claveSii.setText("");
    rep_claveUnica.setText("");
    rep_banco.setText("");
    rep_tipoCuenta.setText("");
    rep_numcuenta.setText("");
    }
    // los dos siguientes controlan los circulos dinamicos de repsoc
    private void cargarCirculosDinamicos(int idClientePerfil) {
    // Obtener los registros de los representantes asociados al cliente
    List<Dash_RepSoc> representantes = consultas.obtenerRepresentantes(idClientePerfil);
    System.out.println("Representantes encontrados: " + representantes.size());

    // Limpiar el contenedor de círculos antes de agregar nuevos
    circleContainer.getChildren().clear();

    // Crear un círculo por cada representante
    for (int i = 0; i < representantes.size(); i++) {
        int index = i; // Necesitamos un índice final para usar dentro de la lambda
        Dash_RepSoc representante = representantes.get(i);
        Circle circle = new Circle(7); // Tamaño del círculo con radio 10
        circle.setFill(Color.color(1.0, 1.0, 1.0, 0.3 )); // Color de relleno inicial
        circle.setStroke(Color.color(1.0, 1.0, 1.0, 0.3)); // Color del borde
        circle.setStrokeWidth(1); // Ancho del borde

        // Cambiar el cursor a una mano cuando el mouse pasa sobre el círculo
        circle.setOnMouseEntered(event -> circle.setCursor(Cursor.HAND));
        circle.setOnMouseExited(event -> circle.setCursor(Cursor.DEFAULT));

        // Agregar evento de clic al círculo
        circle.setOnMouseClicked(event -> {
            System.out.println("Círculo clickeado: Registro " + index);

            // Resaltar el círculo seleccionado
            for (int j = 0; j < circleContainer.getChildren().size(); j++) {
                ((Circle) circleContainer.getChildren().get(j)).setFill(Color.color(1.0, 1.0, 1.0, 0.3));
            }
            circle.setFill(Color.color(0.0, 0.0, 0.0, 0.4));

            // Cargar los datos del representante correspondiente
            cargarDatosRepresentanteSeleccionado(representante);
        });

        // Resaltar el primer círculo por defecto
        if (i == 0) {
            circle.setFill(Color.color(0.0, 0.0, 0.0, 0.4));
            // Mostrar los datos del primer representante al cargar
            cargarDatosRepresentanteSeleccionado(representante);
        }

        // Agregar el círculo al contenedor
        circleContainer.getChildren().add(circle);
    }

    // Verificar si no se encontraron representantes
    if (representantes.isEmpty()) {
        System.out.println("No se encontraron representantes para el cliente con ID: " + idClientePerfil);
    }
}
    private void cargarDatosRepresentanteSeleccionado(Dash_RepSoc representante) {
    // Método auxiliar para cargar los datos del representante seleccionado
    if (representante != null) {
        rep_Tipo.setText(representante.getTipo());
        rep_participacion.setText(representante.getParticipacion());
        rep_nombre.setText(representante.getNombre());
        rep_correo.setText(representante.getCorreo());
        rep_contacto.setText(representante.getContacto());
        rep_rut.setText(representante.getRut());
        rep_claveSii.setText(representante.getClaveSii());
        rep_claveUnica.setText(representante.getClaveUnica());
        rep_banco.setText(representante.getBanco());
        rep_tipoCuenta.setText(representante.getTipoCuenta());
        rep_numcuenta.setText(representante.getNumCuenta());
    } else {
        System.out.println("El representante seleccionado es nulo");
    }
}
    //------
    
    
    //Claves Pos y Princ
    private void cargarClavesPrincipales() {
    int idClientePerfil = Integer.parseInt(ID_ClientePerfil.getText());
    List<Dash_ClavesPrincipales> claves = consultas.obtenerClavesPrincipales(idClientePerfil);
    circleContainerClaves.getChildren().clear();

    for (int i = 0; i < claves.size(); i++) {
        Dash_ClavesPrincipales clave = claves.get(i);
        Circle circle = new Circle(7, (Color.color(1.0, 1.0, 1.0, 0.3 )));

        int index = i; // Necesario para usar dentro del lambda
        circle.setOnMouseClicked(event -> {
            // Restablecer el color de todos los círculos a gris
            for (Node nodo : circleContainerClaves.getChildren()) {
                if (nodo instanceof Circle) {
                    ((Circle) nodo).setFill(Color.color(1.0, 1.0, 1.0, 0.3 ));
                }
            }
            // Resaltar el círculo seleccionado
            circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));

            // Mostrar los datos correspondientes al círculo seleccionado
            mostrarDatosClavesPrincipales(claves.get(index));
        });

        if (i == 0) {
            // Seleccionar y mostrar el primer registro por defecto
            circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
            mostrarDatosClavesPrincipales(clave);
        }
        
        circle.setOnMouseEntered(event -> circle.setCursor(Cursor.HAND));
        circle.setOnMouseExited(event -> circle.setCursor(Cursor.DEFAULT));

        // Agregar el círculo al contenedor
        circleContainerClaves.getChildren().add(circle);
    }
    }
    private void mostrarDatosClavesPrincipales(Dash_ClavesPrincipales clave) {
    if (clave.getRut() != null && clave.getClaveSII() != null) {
        cl_usuario.setText(clave.getRut());
        cl_contrasena.setText(clave.getClaveSII());
        cl_servicio.setText("SII");
    } else if (clave.getUsuarioPrevired() != null && clave.getClavePrevired() != null) {
        cl_usuario.setText(clave.getUsuarioPrevired());
        cl_contrasena.setText(clave.getClavePrevired());
        cl_servicio.setText("Previred");
    } else {
        cl_usuario.setText(""); // Limpia los campos si no hay datos
        cl_contrasena.setText("");
        cl_servicio.setText("");
    }
}
    private void cargarClavesPOS() {
        int idClientePerfil = Integer.parseInt(ID_ClientePerfil.getText());
        List<Dash_ClavesPOS> claves = consultas.obtenerClavesPOS(idClientePerfil);
        circleContainerClaves.getChildren().clear();
        
        if (claves.isEmpty()) {
        // Si no hay claves, vaciar los nodos
        cl_usuario.setText("");
        cl_contrasena.setText("");
        cl_servicio.setText("");
        System.out.println("No se encontraron claves POS para el cliente con ID: " + idClientePerfil);
        return;
        }
        for (int i = 0; i < claves.size(); i++) {
            int index = i;
            Dash_ClavesPOS clave = claves.get(i);
            Circle circle = new Circle(7, (Color.color(1.0, 1.0, 1.0, 0.3 )));

            circle.setOnMouseClicked(event -> {
                for (int j = 0; j < circleContainerClaves.getChildren().size(); j++) {
                    ((Circle) circleContainerClaves.getChildren().get(j)).setFill(Color.color(1.0, 1.0, 1.0, 0.3 ));
                }
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
                mostrarDatosClavesPOS(clave);
            });

            if (i == 0) {
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
                mostrarDatosClavesPOS(clave);
            }
            
            circle.setOnMouseEntered(event -> circle.setCursor(Cursor.HAND));
            circle.setOnMouseExited(event -> circle.setCursor(Cursor.DEFAULT));

            circleContainerClaves.getChildren().add(circle);
        }
    }
    private void mostrarDatosClavesPOS(Dash_ClavesPOS clave) {
        if (clave.getUsuario() != null) {
            cl_usuario.setText(clave.getUsuario());
        } else {
            cl_usuario.setText(""); // Dejar vacío si es nulo
        }

        if (clave.getClave() != null) {
            cl_contrasena.setText(clave.getClave());
        } else {
            cl_contrasena.setText(""); // Dejar vacío si es nulo
        }

        // Manejar el Label cl_servicio con Serv_Pos
        if (clave.getServPos() != null) {
            cl_servicio.setText(clave.getServPos());
        } else {
            cl_servicio.setText(""); // Dejar vacío si es nulo
        }
    }
    private void cargarCírculosClavesPrincipales() {
        int idClientePerfil = Integer.parseInt(ID_ClientePerfil.getText());
        List<Dash_ClavesPrincipales> claves = consultas.obtenerClavesPrincipales(idClientePerfil);

        // Limpia el contenedor de claves antes de agregar nuevos círculos
        circleContainerClaves.getChildren().clear();

        for (int i = 0; i < claves.size(); i++) {
            Dash_ClavesPrincipales clave = claves.get(i);
            Circle circle = new Circle(7, (Color.color(1.0, 1.0, 1.0, 0.3 )));

            // Acción al hacer clic en un círculo
            circle.setOnMouseClicked(event -> {
                for (Node nodo : circleContainerClaves.getChildren()) {
                    if (nodo instanceof Circle) {
                        ((Circle) nodo).setFill(Color.color(1.0, 1.0, 1.0, 0.3 ));
                    }
                }

                // Destacar el círculo seleccionado
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));

                // Mostrar los datos de la clave seleccionada
                mostrarDatosClavesPrincipales(clave);
            });

            // Si es el primer registro, seleccionarlo por defecto
            if (i == 0) {
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
                mostrarDatosClavesPrincipales(clave);
            }
            
            circle.setOnMouseEntered(event -> circle.setCursor(Cursor.HAND));
            circle.setOnMouseExited(event -> circle.setCursor(Cursor.DEFAULT));

            // Agregar el círculo al contenedor
            circleContainerClaves.getChildren().add(circle);
        }
    }
    private void cargarCírculosClavesPOS() {
        int idClientePerfil = Integer.parseInt(ID_ClientePerfil.getText());
        List<Dash_ClavesPOS> claves = consultas.obtenerClavesPOS(idClientePerfil);

        // Limpia el contenedor de claves antes de agregar nuevos círculos
        circleContainerClaves.getChildren().clear();

        for (int i = 0; i < claves.size(); i++) {
            Dash_ClavesPOS clave = claves.get(i);
            Circle circle = new Circle(7, (Color.color(1.0, 1.0, 1.0, 0.3 )));

            // Acción al hacer clic en un círculo
            circle.setOnMouseClicked(event -> {
                for (Node nodo : circleContainerClaves.getChildren()) {
                    if (nodo instanceof Circle) {
                        ((Circle) nodo).setFill(Color.color(1.0, 1.0, 1.0, 0.3 ));
                    }
                }
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
                mostrarDatosClavesPOS(clave);
            });

            if (i == 0) {
                circle.setFill(Color.color(0.0, 0.0, 0.0, 0.3 ));
                mostrarDatosClavesPOS(clave);
            }
            
            circle.setOnMouseEntered(event -> circle.setCursor(Cursor.HAND));
            circle.setOnMouseExited(event -> circle.setCursor(Cursor.DEFAULT));

            circleContainerClaves.getChildren().add(circle);
        }
    }

    //Boton volver (se usa aunque diga que no)
    @FXML
    private void handleBtnVolver() {
        // Transición de desvanecimiento para ocultar "clDashboard"
            FadeTransition fadeOut = new FadeTransition(Duration.millis(200), clDashboard);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> { // Cambiar "event" a "e" para evitar conflictos
                clDashboard.setVisible(false); // Ocultar después del desvanecimiento

                // Transición de desvanecimiento para mostrar "busClientes"
                busClientes.setOpacity(0.0); // Asegurarse de que empiece transparente
                busClientes.setVisible(true);
                FadeTransition fadeIn = new FadeTransition(Duration.millis(200), busClientes);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });

            fadeOut.play();

        // Limpia el valor del TextField ltBuscador
        ltBuscador.setText(null);
        
        // Selecciona el grupo "Claves Principales" en grupoComboBox
        grupoComboBox.getSelectionModel().select("Claves Principales"); 
    }
    
    //Boton Copiar
    private void setupCopyButton(JFXButton button, TextField textField) {
        button.setOnAction(event -> copyToClipboard(textField.getText()));
    }
    private void copyToClipboard(String text) {
        javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
    private void setupHoverEffects(JFXButton button) {
        button.setOnMouseEntered((MouseEvent event) -> {
            button.setStyle("-fx-background-color: #d3d3d350; -fx-cursor: hand;");
        });
        button.setOnMouseExited((MouseEvent event) -> {
            button.setStyle(""); // Restablecer estilo predeterminado
        });
    }
    
    //eliminar clientes
    private void eliminarCliente() {
        // Obtener el ID del cliente seleccionado
        String idCliente = ID_ClientePerfil.getText();
        if (idCliente == null || idCliente.isEmpty()) {
            System.out.println("⚠ No hay un cliente seleccionado para eliminar.");
            return;
        }

        // Primer mensaje de confirmación
        Alert confirmacionInicial = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacionInicial.setTitle("Confirmar Eliminación");
        confirmacionInicial.setHeaderText("¿Está seguro de que desea eliminar este cliente?");
        confirmacionInicial.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> resultadoInicial = confirmacionInicial.showAndWait();
        if (!(resultadoInicial.isPresent() && resultadoInicial.get() == ButtonType.OK)) {
            return;
        }

        // Segundo mensaje de advertencia
        Alert confirmacionFinal = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacionFinal.setTitle("Advertencia");
        confirmacionFinal.setHeaderText("Se eliminarán todos los datos relacionados con este cliente.");
        confirmacionFinal.setContentText("¿Desea continuar?");

        Optional<ButtonType> resultadoFinal = confirmacionFinal.showAndWait();
        if (!(resultadoFinal.isPresent() && resultadoFinal.get() == ButtonType.OK)) {
            return;
        }

        // Eliminar el cliente de la base de datos
        String query = "DELETE FROM clientes WHERE IDCliente = ?";
        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idCliente);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Cliente eliminado exitosamente: ID " + idCliente);

                // Mostrar mensaje de cliente eliminado
                Alert mensajeEliminado = new Alert(Alert.AlertType.INFORMATION);
                mensajeEliminado.setTitle("Cliente Eliminado");
                mensajeEliminado.setHeaderText(null);
                mensajeEliminado.setContentText("El cliente ha sido eliminado exitosamente.");
                mensajeEliminado.showAndWait();

                // Volver a la pantalla principal después de aceptar el mensaje
                volverFormulario();
            } else {
                System.out.println("⚠ No se encontró el cliente con ID: " + idCliente);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar el cliente: " + e.getMessage());
        }
    }
    
    //Boton editar datos
    public void abrirVentanaPanelEditar() {
    try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/oficinaeahb/countgest/PanelEditar.fxml"));
        Parent root = loader.load();
        
        // ✅ 1. Obtener ID del cliente desde el dashboard
        int idCliente = Integer.parseInt(ID_ClientePerfil.getText().trim());

        // ✅ 2. Obtener el controlador y pasarle el ID
        ControladorPanelEditar controlador = loader.getController();
        controlador.setIdCliente(idCliente);
        controlador.inicializarComboBoxesEditar();

        // 4. Obtener los datos desde la base de datos
        ConsultasDataBase db = new ConsultasDataBase();
        Dash_DatosClientes datosCliente = db.obtenerDatosCliente(idCliente);
        List<Dash_RepSoc> listaSocios = db.obtenerRepresentantes(idCliente);
        List<Dash_DireccionesClientes> direccionesCliente = db.obtenerDirecciones(idCliente);
        List<Dash_ClavesPrincipales> clavesPrincipales = db.obtenerClavesPrincipales(idCliente);
        List<Dash_ClavesPOS> clavesPOS = db.obtenerClavesPOS(idCliente);

        // 6. Extraer claves previred (solo 1)
        String usuarioPrevired = null;
        String clavePrevired = null;
        for (Dash_ClavesPrincipales clave : clavesPrincipales) {
            if (clave.getUsuarioPrevired() != null) usuarioPrevired = clave.getUsuarioPrevired();
            if (clave.getClavePrevired() != null) clavePrevired = clave.getClavePrevired();
        }
        
        // 7. Extraer datos POS (solo 1)
        String servicioPOS = null;
        String usuarioPOS = null;
        String clavePOS = null;
        String observacionPOS = null;
        if (!clavesPOS.isEmpty()) {
            Dash_ClavesPOS pos = clavesPOS.get(0);
            servicioPOS = pos.getServPos();
            usuarioPOS = pos.getUsuario();
            clavePOS = pos.getClave();
            observacionPOS = ""; // puedes reemplazar si luego agregas este campo
        }

        // 8. Cargar todo en PanelEditar
        List<Dash_DireccionesClientes> listaDireccionesCliente = direccionesCliente;
        List<String> listaServicios = (servicioPOS != null) ? Arrays.asList(servicioPOS) : new ArrayList<>();
        List<String> listaUsuariosPOS = (usuarioPOS != null) ? Arrays.asList(usuarioPOS) : new ArrayList<>();
        List<String> listaClavesPOS = (clavePOS != null) ? Arrays.asList(clavePOS) : new ArrayList<>();
        List<String> listaObservacionesPOS = (observacionPOS != null) ? Arrays.asList(observacionPOS) : new ArrayList<>();

        controlador.cargarTodo(
            datosCliente,
            listaSocios,
            listaDireccionesCliente,
            usuarioPrevired,
            clavePrevired,
            listaServicios,
            listaUsuariosPOS,
            listaClavesPOS,
            listaObservacionesPOS
        );
        

        // 9. Mostrar ventana de edición
        Stage stage = new Stage();
        stage.setTitle("Editar Cliente");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.showAndWait();

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al abrir PanelEditar.fxml");
    } catch (NumberFormatException e) {
        System.out.println("ID de cliente no válido");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    //-----------------------------------------------------------------------
    
    //►►►Pantalla Formulario de ingreso clientes 28/02/2025
    
    //Datos principales
    @FXML
    private void agregarDireccion() {
        HBox nuevaDireccion = new HBox(10); // Espaciado de 10 como en el original
        nuevaDireccion.setPrefHeight(8.0);
        nuevaDireccion.setPrefWidth(882.0);
        nuevaDireccion.setAlignment(Pos.CENTER_LEFT);

        // Crear nuevos campos con los mismos tamaños del FXML
        JFXComboBox<String> nuevoTipo = new JFXComboBox<>();
        copiarOpcionesComboBox(txtTipo_direccion_cliente, nuevoTipo); // Mantiene opciones
        nuevoTipo.setPromptText("Tipo");
        nuevoTipo.setPrefHeight(25.0);
        nuevoTipo.setPrefWidth(149.0);

        TextField nuevaCalle = new TextField();
        nuevaCalle.setPromptText("Calle");
        nuevaCalle.setPrefHeight(25.0);
        nuevaCalle.setPrefWidth(330.0);
        HBox.setHgrow(nuevaCalle, Priority.ALWAYS); // Permitir crecimiento como en el FXML

        TextField nuevoNumero = new TextField();
        nuevoNumero.setPromptText("Número");
        nuevoNumero.setPrefHeight(25.0);
        nuevoNumero.setPrefWidth(69.0);

        TextField nuevoLocal = new TextField();
        nuevoLocal.setPromptText("N° Local");
        nuevoLocal.setPrefHeight(25.0);
        nuevoLocal.setPrefWidth(71.0);

        JFXComboBox<String> nuevaComuna = new JFXComboBox<>();
        copiarOpcionesComboBox(txtComuna_cliente, nuevaComuna); // Mantiene opciones
        nuevaComuna.setPromptText("Comuna");
        nuevaComuna.setPrefHeight(25.0);
        nuevaComuna.setPrefWidth(149.0);

        // Agregar los nuevos campos al HBox
        nuevaDireccion.getChildren().addAll(nuevoTipo, nuevaCalle, nuevoNumero, nuevoLocal, nuevaComuna);

        // Guardar la referencia de la nueva dirección agregada
        listaDirecciones.add(nuevaDireccion);

        // ✅ Agregar el nuevo HBox dentro de vbDirecciones para que se organice verticalmente
        vbDirecciones.getChildren().add(nuevaDireccion);

        // Habilitar el botón de eliminar dirección
        btnEliminar_direccion.setDisable(false);
    }
    @FXML
    private void eliminarDireccion() {
        if (!listaDirecciones.isEmpty()) {
            HBox ultimaDireccion = listaDirecciones.remove(listaDirecciones.size() - 1);
            vbDirecciones.getChildren().remove(ultimaDireccion);
        }

        // Deshabilitar el botón si ya no quedan direcciones adicionales
        if (listaDirecciones.isEmpty()) {
            btnEliminar_direccion.setDisable(true);
        }
    }

    //Socios
    @FXML
    private void agregarSocio() {
        // Crear una línea separadora
        Separator separador = new Separator();
        separador.setPrefWidth(767.0); // Mismo ancho que los HBox
        separador.setStyle("-fx-background-color: #cccccc; -fx-padding: 5px;"); // Color gris claro

        // Crear copias de los tres HBox
        HBox nuevoSocio1 = crearHBoxSocio1();
        HBox nuevoSocio2 = crearHBoxSocio2();
        HBox nuevoSocio3 = crearHBoxSocio3();
        
        copiarOpcionesComboBox(txtTipo_socio, (JFXComboBox<String>) nuevoSocio1.getChildren().get(0));
        copiarOpcionesComboBox(txtTipo_cuenta_banco_socio, (JFXComboBox<String>) nuevoSocio3.getChildren().get(1));

        // Agregar los elementos al VBox principal
        vbSocios.getChildren().addAll(separador, nuevoSocio1, nuevoSocio2, nuevoSocio3);

        // ✅ Habilitar el botón de eliminar ya que hay elementos adicionales
        btnEliminar_socio.setDisable(false);
    }
    @FXML
    private void eliminarSocio() {
        int count = vbSocios.getChildren().size();

        if (count > 4) { // Asegurar que haya elementos adicionales para eliminar
            vbSocios.getChildren().remove(count - 1); // Elimina el último hbSocios3
            vbSocios.getChildren().remove(count - 2); // Elimina el último hbSocios2
            vbSocios.getChildren().remove(count - 3); // Elimina el último hbSocios1
            vbSocios.getChildren().remove(count - 4); // Elimina el separador
        }

        // ✅ Si solo quedan los elementos originales, deshabilitar el botón
        if (vbSocios.getChildren().size() <= 3) {
            btnEliminar_socio.setDisable(true);
        }
    }
    private HBox crearHBoxSocio1() {
        HBox hbox = new HBox(10);
        hbox.setPrefHeight(17.0);
        hbox.setPrefWidth(767.0);

        JFXComboBox<String> tipo = new JFXComboBox<>();
        tipo.setPrefHeight(25.0);
        tipo.setPrefWidth(102.0);
        tipo.setPromptText("Tipo");

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");
        HBox.setHgrow(nombre, Priority.ALWAYS);

        TextField rut = new TextField();
        rut.setPromptText("Rut");

        TextField claveSii = new TextField();
        claveSii.setPromptText("Clave SII");

        hbox.getChildren().addAll(tipo, nombre, rut, claveSii);
        return hbox;
    }
    private HBox crearHBoxSocio2() {
        HBox hbox = new HBox(10);
        hbox.setPrefHeight(17.0);
        hbox.setPrefWidth(767.0);

        TextField participacion = new TextField();
        participacion.setPrefHeight(25.0);
        participacion.setPrefWidth(88.0);
        participacion.setPromptText("Participación");

        TextField contacto = new TextField();
        contacto.setPrefHeight(25.0);
        contacto.setPrefWidth(231.0);
        contacto.setPromptText("Contacto");
        HBox.setHgrow(contacto, Priority.ALWAYS);

        TextField correo = new TextField();
        correo.setPrefHeight(25.0);
        correo.setPrefWidth(285.0);
        correo.setPromptText("Correo");

        TextField claveUnica = new TextField();
        claveUnica.setPrefHeight(25.0);
        claveUnica.setPrefWidth(154.0);
        claveUnica.setPromptText("Clave Única");

        hbox.getChildren().addAll(participacion, contacto, correo, claveUnica);
        return hbox;
    }
    private HBox crearHBoxSocio3() {
        HBox hbox = new HBox(10);
        hbox.setPrefHeight(17.0);
        hbox.setPrefWidth(767.0);

        TextField banco = new TextField();
        banco.setPrefHeight(25.0);
        banco.setPrefWidth(282.0);
        banco.setPromptText("Banco");
        HBox.setHgrow(banco, Priority.ALWAYS);

        JFXComboBox<String> tipoCuenta = new JFXComboBox<>();
        tipoCuenta.setPrefHeight(25.0);
        tipoCuenta.setPrefWidth(171.0);
        tipoCuenta.setPromptText("Tipo de cuenta");

        TextField numCuenta = new TextField();
        numCuenta.setPrefHeight(25.0);
        numCuenta.setPrefWidth(242.0);
        numCuenta.setPromptText("Número de cuenta");

        hbox.getChildren().addAll(banco, tipoCuenta, numCuenta);
        return hbox;
    }

    //POS
    @FXML
    private void agregarPos() {
        // Crear un nuevo HBox con el mismo formato que el original
        HBox nuevoPos = new HBox(10);
        nuevoPos.setPrefHeight(17.0);
        nuevoPos.setPrefWidth(767.0);

        // Crear los nuevos elementos manteniendo el formato original
        JFXComboBox<String> servicio = new JFXComboBox<>();
        copiarOpcionesComboBox(txtServicio_pos, servicio);
        servicio.setPrefHeight(25.0);
        servicio.setPrefWidth(102.0);
        servicio.setPromptText("Servicio");

        TextField usuario = new TextField();
        usuario.setPrefHeight(25.0);
        usuario.setPrefWidth(130.0);
        usuario.setPromptText("Usuario");
        HBox.setHgrow(usuario, Priority.ALWAYS);

        TextField clave = new TextField();
        clave.setPrefHeight(25.0);
        clave.setPrefWidth(188.0);
        clave.setPromptText("Clave");

        TextField observacion = new TextField();
        observacion.setPrefHeight(25.0);
        observacion.setPrefWidth(264.0);
        observacion.setPromptText("Observación");

        // Agregar los elementos al nuevo HBox
        nuevoPos.getChildren().addAll(servicio, usuario, clave, observacion);

        // Agregar el nuevo HBox a vbPos
        vbPos.getChildren().add(nuevoPos);

        // ✅ Habilitar el botón de eliminar porque ahora hay elementos adicionales
        txtEliminar_pos.setDisable(false);
    }
    @FXML
    private void eliminarPos() {
        int count = vbPos.getChildren().size();

        if (count > 1) { // Asegurar que haya elementos adicionales para eliminar
            vbPos.getChildren().remove(count - 1);
        }

        // ✅ Deshabilitar el botón si solo queda el elemento original
        if (vbPos.getChildren().size() == 1) {
            txtEliminar_pos.setDisable(true);
        }
    }
    
    //Combobox
    private void configurarComboBoxes() {
    // Opciones para cada ComboBox
    txtTipo_empresa.getItems().addAll("SPA", "LTDA", "EIRL", "S.A.");
    txtTipo_direccion_cliente.getItems().addAll("Domicilio", "Sucursal"); // Nombre actualizado
    txtTipo_socio.getItems().addAll("Representante", "Socio");
    txtServicio_pos.getItems().addAll("Transbank", "Getnet", "SumUp", "Redelcom", "Compraquí", "TUU",
                                      "Mercado Pago", "BCI Pagos", "Klap", "Fudo", "Kushki", "Vessi");

    // Opciones de comunas para clientes (nombre actualizado)
    List<String> comunasCliente = Arrays.asList(
        "Santiago", "Estación Central", "Independencia", "Recoleta", "Quinta Normal", "Quilicura",
        "Providencia", "Cerro Navia", "Lo Prado", "Pudahuel", "Cerrillos", "Conchalí",
        "El Bosque", "Huechuraba", "La Cisterna", "La Florida", "La Granja", "La Pintana",
        "La Reina", "Las Condes", "Lo Barnechea", "Lo Espejo", "Macul", "Maipú", "Ñuñoa",
        "Pedro Aguirre Cerda", "Peñalolén", "Renca", "San Joaquín", "San Miguel", "San Ramón", "Vitacura"
    );
    txtComuna_cliente.getItems().addAll(comunasCliente); // Nombre actualizado

    // Opciones para tipo de cuenta bancaria del socio
    txtTipo_cuenta_banco_socio.getItems().addAll(
        "Cuenta RUT", "Cuenta corriente", "Cuenta vista", "Chequera electrónica", "Cuenta de ahorro"
    );

    // Hacer txtServicio_pos editable
    txtServicio_pos.setEditable(true);

    // Evento para agregar nuevas opciones sin duplicados (ignorando mayúsculas/minúsculas)
    txtServicio_pos.setOnAction(event -> {
        String newOption = txtServicio_pos.getEditor().getText().trim();

        if (!newOption.isEmpty()) {
            boolean exists = txtServicio_pos.getItems().stream()
                .anyMatch(option -> option.equalsIgnoreCase(newOption));

            if (!exists) {
                txtServicio_pos.getItems().add(newOption);
            }
        }

        // Limpiar el texto después de agregar
        txtServicio_pos.getEditor().clear();
    });

    // Evento para eliminar elementos al presionar la tecla "Delete"
    txtServicio_pos.setOnKeyPressed(event -> {
        if (event.getCode().toString().equals("DELETE")) {
            String selectedItem = txtServicio_pos.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                txtServicio_pos.getItems().remove(selectedItem);
            }
        }
    });
    
    // Tipo de contabilidad
    txtTipo_contabilidad.getItems().addAll("Pro Pyme General (14D)", "Pro Pyme Transparente (14D N°8)", "Regimen General", "Renta Presunta", "No sujeto al 14 de la LIR");
    }   
    private void copiarOpcionesComboBox(JFXComboBox<String> original, JFXComboBox<String> nuevo) {
        nuevo.getItems().setAll(original.getItems()); // Copia todas las opciones del ComboBox original
        nuevo.setEditable(original.isEditable()); // Mantiene la configuración de edición
    }
    
    //Botones
    @FXML
    private void guardarFormulario() {
        // 🔹 Validación de campos obligatorios
        if (txtApodo_empresa.getText().trim().isEmpty() || txtRut_empresa.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "Los campos 'Apodo Empresa' y 'RUT Empresa' son obligatorios.");
            return;
        }
        if (!txtRazon_social.getText().trim().isEmpty() && txtTipo_empresa.getValue() == null) {
            mostrarAlerta("Error", "Si se ingresa Razón Social, también debe seleccionar un Tipo de Empresa.");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;

        try {
            conn = ConexionDataBase.getConnection();
            conn.setAutoCommit(false); // 🔹 Desactivar autocommit para manejar transacción

            // 🔹 Validar y convertir valores
            Integer honorariosValue = parseInteger(txtHonorarios.getText().trim());
            Timestamp fechaCompraValue = parseTimestamp(txtFecha_fact.getText().trim());

            // 🔹 Insertar en clientes
            String sqlClientes = "INSERT INTO clientes (Razon_Social, Tipo, Apodo, Rut, Clave_SII, Contacto, Tipo_Contabilidad, Honorarios, Usuario_previred, Clave_Previred, Clave_facturacion, Fecha_Compra, Duracion) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sqlClientes, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, emptyToNull(txtRazon_social.getText()));
            stmt.setString(2, emptyToNull(txtTipo_empresa.getValue()));
            stmt.setString(3, txtApodo_empresa.getText().trim());
            stmt.setString(4, txtRut_empresa.getText().trim());
            stmt.setString(5, emptyToNull(txtClave_sii.getText()));
            stmt.setString(6, emptyToNull(txtContacto.getText()));
            stmt.setString(7, emptyToNull(txtTipo_contabilidad.getValue()));
            stmt.setObject(8, honorariosValue, java.sql.Types.INTEGER);
            stmt.setString(9, emptyToNull(txtUsuario_prev.getText()));
            stmt.setString(10, emptyToNull(txtClave_prev.getText()));
            stmt.setString(11, emptyToNull(txtClave_fact.getText()));
            stmt.setObject(12, fechaCompraValue, java.sql.Types.TIMESTAMP);
            stmt.setString(13, emptyToNull(txtDuracion_fact.getText()));
            stmt.executeUpdate();

            // 🔹 Obtener el ID generado
            generatedKeys = stmt.getGeneratedKeys();
            int idCliente = -1;
            if (generatedKeys.next()) {
                idCliente = generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el ID del nuevo cliente.");
            }

            // 🔹 Insertar direcciones, socios y servicios POS
            insertarDirecciones(conn, idCliente);
            insertarSocios(conn, idCliente);
            insertarServiciosPOS(conn, idCliente);

            conn.commit(); // 🔄 Confirmar la transacción si todo está correcto
            mostrarAlerta("Éxito", "Datos guardados correctamente.");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // 🚨 Deshacer cambios si hay un error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            mostrarAlerta("Error", "No se pudo guardar los datos en la base de datos.");
            e.printStackTrace();
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Método auxiliar para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private Integer parseInteger(String value) {
    if (value == null || value.isEmpty()) {
        return null; // Si está vacío, devuelve NULL en lugar de ''
    }
    try {
        return Integer.parseInt(value);
    } catch (NumberFormatException e) {
        System.err.println("⚠ Error: '" + value + "' no es un número válido.");
        return null; // Si no es un número válido, devuelve NULL
    }
}
    // 🔹 Convierte automáticamente "20032025" a "20/03/2025" en tiempo real
    private void configurarFechaAutomatica() {
        txtFecha_fact.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.matches("\\d{8}")) { // Si el usuario ingresa 8 números (ej: 20032025)
                    String formattedDate = newValue.substring(0, 2) + "/" + 
                                           newValue.substring(2, 4) + "/" + 
                                           newValue.substring(4, 8);
                    txtFecha_fact.setText(formattedDate); // Actualiza el nodo con el formato 20/03/2025
                }
            }
        });
    }
    private Timestamp parseTimestamp(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            // Si ya tiene el formato correcto "YYYY-MM-DD HH:MM:SS"
            return Timestamp.valueOf(value);
        } catch (IllegalArgumentException e) {
            try {
                // Si tiene el formato "DD/MM/YYYY", convertir a "YYYY-MM-DD HH:MM:SS"
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate date = LocalDate.parse(value, inputFormatter);
                return Timestamp.valueOf(date.atStartOfDay().format(outputFormatter));
            } catch (DateTimeParseException ex) {
                mostrarAlerta("Error", "El formato de la fecha debe ser 'DD/MM/YYYY' o 'YYYY-MM-DD HH:MM:SS'.");
                return null;
            }
        }
    }
    private String emptyToNull(String value) {
    return (value == null || value.trim().isEmpty()) ? null : value.trim();
}
    private void insertarDirecciones(Connection conn, int idCliente) throws SQLException {
    String sql = "INSERT INTO direcciones_clientes (IDCliente, TIPO_DIRECCION, DIRECCION, NUM, LOCAL, COMUNA) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        for (Node node : vbDirecciones.getChildren()) {
            if (node instanceof HBox) {
                HBox hbox = (HBox) node;
                JFXComboBox<String> tipoDireccion = (JFXComboBox<String>) hbox.getChildren().get(0);
                TextField calle = (TextField) hbox.getChildren().get(1);
                TextField numero = (TextField) hbox.getChildren().get(2);
                TextField local = (TextField) hbox.getChildren().get(3);
                JFXComboBox<String> comuna = (JFXComboBox<String>) hbox.getChildren().get(4);

                // Convertir el número a Integer o dejarlo como NULL si está vacío
                Integer numValue = parseInteger(numero.getText().trim());

                System.out.println("📌 Insertando dirección:");
                System.out.println("   - Tipo: " + tipoDireccion.getValue());
                System.out.println("   - Dirección: " + calle.getText().trim());
                System.out.println("   - Número: " + numValue);
                System.out.println("   - Local: " + local.getText().trim());
                System.out.println("   - Comuna: " + comuna.getValue());

                stmt.setInt(1, idCliente);
                stmt.setString(2, emptyToNull(tipoDireccion.getValue()));
                stmt.setString(3, emptyToNull(calle.getText()));
                if (numValue != null) {
                    stmt.setInt(4, numValue);
                } else {
                    stmt.setNull(4, java.sql.Types.INTEGER);
                }
                stmt.setString(5, emptyToNull(local.getText()));
                stmt.setString(6, emptyToNull(comuna.getValue()));

                stmt.executeUpdate();
            }
        }
    } catch (SQLException e) {
        System.err.println("❌ Error al insertar dirección: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void insertarSocios(Connection conn, int idCliente) throws SQLException {
    System.out.println("🔍 Iniciando inserción de socios para el cliente ID: " + idCliente);
    
    String sql = "INSERT INTO rep_soc (IDCliente, TIPO, NOMBRE, RUT, `CLAVE SII`, PARTICIPACION, CONTACTO, CORREO, `CLAVE ÚNICA`, BANCO, `TIPO DE CUENTA`, `N° DE CUENTA`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        for (int i = 0; i < vbSocios.getChildren().size(); i++) { // No saltamos 4, revisamos cada nodo
            if (vbSocios.getChildren().get(i) instanceof Separator) {
                continue; // Saltamos los separadores
            }

            if (i + 2 < vbSocios.getChildren().size() &&
                vbSocios.getChildren().get(i) instanceof HBox &&
                vbSocios.getChildren().get(i + 1) instanceof HBox &&
                vbSocios.getChildren().get(i + 2) instanceof HBox) {

                System.out.println("➡ Procesando socio en índice: " + i);

                HBox hbSocios1 = (HBox) vbSocios.getChildren().get(i);
                HBox hbSocios2 = (HBox) vbSocios.getChildren().get(i + 1);
                HBox hbSocios3 = (HBox) vbSocios.getChildren().get(i + 2);

                JFXComboBox<String> tipoSocio = (JFXComboBox<String>) hbSocios1.getChildren().get(0);
                TextField nombre = (TextField) hbSocios1.getChildren().get(1);
                TextField rut = (TextField) hbSocios1.getChildren().get(2);
                TextField claveSii = (TextField) hbSocios1.getChildren().get(3);

                TextField participacion = (TextField) hbSocios2.getChildren().get(0);
                TextField contacto = (TextField) hbSocios2.getChildren().get(1);
                TextField correo = (TextField) hbSocios2.getChildren().get(2);
                TextField claveUnica = (TextField) hbSocios2.getChildren().get(3);

                TextField banco = (TextField) hbSocios3.getChildren().get(0);
                JFXComboBox<String> tipoCuenta = (JFXComboBox<String>) hbSocios3.getChildren().get(1);
                TextField numCuenta = (TextField) hbSocios3.getChildren().get(2);

                // Print para verificar los valores antes de la inserción
                System.out.println("📌 Datos del socio:");
                System.out.println("   - Tipo: " + tipoSocio.getValue());
                System.out.println("   - Nombre: " + nombre.getText().trim());
                System.out.println("   - RUT: " + rut.getText().trim());
                System.out.println("   - Clave SII: " + claveSii.getText().trim());
                System.out.println("   - Participación: " + participacion.getText().trim());
                System.out.println("   - Contacto: " + contacto.getText().trim());
                System.out.println("   - Correo: " + correo.getText().trim());
                System.out.println("   - Clave Única: " + claveUnica.getText().trim());
                System.out.println("   - Banco: " + banco.getText().trim());
                System.out.println("   - Tipo de Cuenta: " + tipoCuenta.getValue());
                System.out.println("   - Número de Cuenta: " + numCuenta.getText().trim());

                stmt.setInt(1, idCliente);
                stmt.setString(2, tipoSocio.getValue());
                stmt.setString(3, nombre.getText().trim());
                stmt.setString(4, rut.getText().trim());
                stmt.setString(5, claveSii.getText().trim());
                stmt.setString(6, participacion.getText().trim());
                stmt.setString(7, contacto.getText().trim());
                stmt.setString(8, correo.getText().trim());
                stmt.setString(9, claveUnica.getText().trim());
                stmt.setString(10, banco.getText().trim());
                stmt.setString(11, tipoCuenta.getValue());
                stmt.setString(12, numCuenta.getText().trim());

                int filasAfectadas = stmt.executeUpdate();
                System.out.println("✅ Filas insertadas: " + filasAfectadas);
                
                // Saltamos al siguiente grupo de 3 HBox
                i += 2; 
            }
        }
    } catch (SQLException e) {
        System.err.println("❌ Error al insertar socio: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void insertarServiciosPOS(Connection conn, int idCliente) throws SQLException {
        String sql = "INSERT INTO claves_pos (IDCliente, SERV_POS, USUARIO, CLAVE, OBSERVACION) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Node node : vbPos.getChildren()) {
                if (node instanceof HBox) {
                    HBox hbox = (HBox) node;
                    JFXComboBox<String> servicioPos = (JFXComboBox<String>) hbox.getChildren().get(0);
                    TextField usuario = (TextField) hbox.getChildren().get(1);
                    TextField clave = (TextField) hbox.getChildren().get(2);
                    TextField observacion = (TextField) hbox.getChildren().get(3);

                    stmt.setInt(1, idCliente);
                    stmt.setString(2, servicioPos.getValue());
                    stmt.setString(3, usuario.getText().trim());
                    stmt.setString(4, clave.getText().trim());
                    stmt.setString(5, observacion.getText().trim());

                    stmt.executeUpdate();
                }
            }
        }
    }

    @FXML
    private void volverFormulario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root = loader.load();

            // Obtener la escena actual y recargarla
            Stage stage = (Stage) FormCliente.getScene().getWindow();
            stage.getScene().setRoot(root);

            // 🔹 Asegurar que `busClientes` esté visible después de la recarga
            Platform.runLater(() -> {
                Node busClientes = root.lookup("#busClientes");
                Node formCliente = root.lookup("#FormCliente");

                if (busClientes != null && formCliente != null) {
                    formCliente.setVisible(false);
                    busClientes.setVisible(true);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo actualizar la tabla de clientes.");
        }
    }
    public void actualizarTablaClientes() {
        // 🔄 Crear un nuevo nodo raíz para evitar problemas de actualización
        TreeItem<Dash_TablaBusquedaInicial> root = new TreeItem<>(new Dash_TablaBusquedaInicial(0, "Root", "", "", "", "", ""));
        root.setExpanded(true);

        String sql = "SELECT " +
                     "c.IDCliente AS IDCliente, " +  // Evitar ambigüedad con alias
                     "c.Razon_Social, " +
                     "c.Tipo, " +
                     "c.Rut, " +
                     "CONCAT(d.DIRECCION, ' ', d.NUM) AS DireccionCompleta, " +
                     "d.LOCAL AS Local, " +
                     "r.NOMBRE AS Representante " +
                     "FROM clientes c " +
                     "LEFT JOIN direcciones_clientes d ON c.IDCliente = d.IDCliente " +
                     "LEFT JOIN rep_soc r ON c.IDCliente = r.IDCliente;";

        ObservableList<TreeItem<Dash_TablaBusquedaInicial>> listaClientes = FXCollections.observableArrayList();

        try (Connection conn = ConexionDataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dash_TablaBusquedaInicial clienteData = new Dash_TablaBusquedaInicial(
                    rs.getInt("IDCliente"),
                    rs.getString("Razon_Social"),
                    rs.getString("Tipo"),
                    rs.getString("Rut"),
                    rs.getString("DireccionCompleta"),
                    rs.getString("Local"),
                    rs.getString("Representante")
                );

                TreeItem<Dash_TablaBusquedaInicial> treeItem = new TreeItem<>(clienteData);
                listaClientes.add(treeItem);
            }

            // 🔄 Asegurar que la actualización ocurra en el hilo de JavaFX
            Platform.runLater(() -> {
                root.getChildren().setAll(listaClientes);
                ltClientes.setRoot(root);
                ltClientes.setShowRoot(false);
            });

        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudo actualizar la lista de clientes.");
            e.printStackTrace();
        }
    }
    
    private void actualizarEstadoBotonInhabilitar() {
        String idCliente = ID_ClientePerfil.getText();
        if (idCliente == null || idCliente.isEmpty()) {
            System.err.println("⚠ No hay ID de cliente para verificar estado.");
            return;
        }

        String consultaEstado = "SELECT Inactivo FROM clientes WHERE IDCliente = ?";
        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(consultaEstado)) {

            stmt.setString(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                boolean inactivo = rs.getBoolean("Inactivo");
                System.out.println("🔎 Verificando estado del cliente con ID: " + idCliente);
                System.out.println("🧩 Estado obtenido desde la BD (Inactivo): " + inactivo);
                System.out.println("🔄 Actualizando botón según estado...");

                if (inactivo) {
                    btn_inhabilitar_cliente.setText("INACTIVO");
                    btn_inhabilitar_cliente.setStyle("-fx-background-color: #FF7043; -fx-text-fill: white;");
                    System.out.println("🔘 Cliente está INACTIVO. Botón configurado para mostrar 'INACTIVO'.");
                } else {
                    btn_inhabilitar_cliente.setText("ACTIVO");
                    btn_inhabilitar_cliente.setStyle("-fx-background-color: #66BB6A; -fx-text-fill: white;");
                    System.out.println("🟢 Cliente está ACTIVO. Botón configurado para mostrar 'ACTIVO'.");
                }

                btn_inhabilitar_cliente.applyCss();
                btn_inhabilitar_cliente.layout();
                System.out.println("🎨 Estilo aplicado con applyCss() y layout().");
            } else {
                System.err.println("❌ No se encontró cliente con ID: " + idCliente);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar estado del cliente: " + e.getMessage());
        }
    }
    @FXML
    private void alternarEstadoCliente() {
        String idCliente = ID_ClientePerfil.getText();
        if (idCliente == null || idCliente.isEmpty()) {
            return;
        }

        String consultaEstado = "SELECT Inactivo FROM clientes WHERE IDCliente = ?";
        String actualizarEstado = "UPDATE clientes SET Inactivo = ? WHERE IDCliente = ?";

        try (Connection conn = ConexionDataBase.getConnection();
             PreparedStatement stmtConsulta = conn.prepareStatement(consultaEstado);
             PreparedStatement stmtActualizacion = conn.prepareStatement(actualizarEstado)) {

            stmtConsulta.setString(1, idCliente);
            ResultSet rs = stmtConsulta.executeQuery();

            if (rs.next()) {
                // ✅ Leer valor bit(1) como boolean
                boolean inactivo = rs.getBoolean("Inactivo");

                // ✅ Invertir el estado (1 ↔ 0)
                int nuevoEstado = inactivo ? 0 : 1;

                // ✅ Aplicar el nuevo valor a la base de datos
                stmtActualizacion.setInt(1, nuevoEstado);
                stmtActualizacion.setString(2, idCliente);
                stmtActualizacion.executeUpdate();

                // ✅ Usar el método actualizado
                actualizarEstadoBotonInhabilitar();

                System.out.println("✅ Estado del cliente actualizado a: " + (nuevoEstado == 1 ? "INACTIVO" : "ACTIVO"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al cambiar estado del cliente: " + e.getMessage());
        }
    }

}