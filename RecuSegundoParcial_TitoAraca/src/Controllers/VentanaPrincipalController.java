/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Exceptions.ProductoRepetidoException;
import Models.Inventario;
import Models.Producto;
import Persistencia.DatosJson;
import Util.Alerta;
import Util.Ventana;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnVerProductosAVencer;
    @FXML
    private ListView<Producto> listaProductos;
    @FXML Button btnGuardarFecha;
    
    @FXML
    private TextField txtFechaHoy;
    
    private Inventario inventario;
    private DatosJson<Producto> datos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inventario = new Inventario();
        this.datos = new DatosJson<Producto>(Producto.class, "DatosProductos.json");
        if(! getDatos().estaVacioArchivo()){
            this.getInventario().setListaProductos(datos.cargarJson());
            refrescarLista();
        };
    }
    
    @FXML
    private void agregar(){
        Producto nuevoProducto = verVentanaCuestionario(null);
        if(nuevoProducto != null){
                try{
                    this.getInventario().agregar(nuevoProducto);
                    this.refrescarLista();
                } catch (ProductoRepetidoException e) {
                    Alert alerta =  Alerta.crearAlerta(e.getMessage(),Alert.AlertType.ERROR);
                    alerta.showAndWait();
            }
        }
    }
    @FXML
    private void modificar()throws IOException{
        Producto viejoProducto = this.listaProductos.getSelectionModel().getSelectedItem();
        if(viejoProducto != null){
            Producto nuevoProducto = verVentanaCuestionario(viejoProducto);
            this.getInventario().modificar(viejoProducto, nuevoProducto);
            this.refrescarLista();
        }
        else{
            Alert alerta = Alerta.crearAlertaNingunItemSeleccionado("Producto");
            alerta.showAndWait();
        }
    }
    @FXML
    private void eliminar(){
        Producto productoEliminar = this.listaProductos.getSelectionModel().getSelectedItem();
        if(productoEliminar != null){
            Alert alerta = Alerta.crearAlerta("Estas seguro que quiere eliminar el producto: " + productoEliminar.toString(), Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> botonTocado = alerta.showAndWait();
            if(botonTocado.isPresent() && botonTocado.get() == ButtonType.OK){
                this.getInventario().eliminar(productoEliminar);
                this.refrescarLista();
            }
        }
        else{
            Alert alerta = Alerta.crearAlertaNingunItemSeleccionado("Producto");
            alerta.showAndWait();
        }
    }
    @FXML
    private void verProductosAVencer(){
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/VentanaProductosAVencer.fxml"));
            Stage stage = Ventana.ConfigurarVentana(loader, "Productos a punto de vencer", Modality.APPLICATION_MODAL);
            VentanaProductosAVencerController controlador = loader.getController();
            controlador.añadirProductosAVencer(this.getInventario().getProductosAVencer());
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void guardarFecha(){
        try {
            Producto.setFechaHoy(Integer.parseInt(this.txtFechaHoy.getText()));
            Alert alerta = Alerta.crearAlerta("Fecha guardada sin errores", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
            
        } catch (NumberFormatException e) {
            Alert alerta = Alerta.crearAlerta("No se pudo guardar la fecha, ponga un numero entero", Alert.AlertType.ERROR);
            alerta.showAndWait();
            txtFechaHoy.clear();
            txtFechaHoy.setText(String.valueOf(Producto.fechaHoy));
        }
    }
    private Producto verVentanaCuestionario(Producto p){
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/VentanaCuestionario.fxml"));
            Stage stage = Ventana.ConfigurarVentana(loader, "Cuestionario Producto", Modality.APPLICATION_MODAL);
            VentanaCuestionarioController controlador = loader.getController();
            controlador.setProductoAModificar(p);
            stage.showAndWait();
            return controlador.getProductoAModificar();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void refrescarLista(){
        this.listaProductos.getItems().clear();
        this.listaProductos.getItems().addAll(this.getInventario().getListaProductos());
    }
    
    public void guardarProgreso(){
        this.getDatos().guardarJson(this.getInventario().getListaProductos());
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }

    public DatosJson<Producto> getDatos() {
        return this.datos;
    }
    
    
}
