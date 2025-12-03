/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Exceptions.CampoVacioException;
import Exceptions.FechaInvalidaException;
import Exceptions.NumeroNegativoException;
import Models.EEtiquetasEcologias;
import Models.ETiposAdvertencias;
import Models.ETiposProductos;
import Models.Producto;
import Models.ProductoEcologico;
import Models.ProductoQuimico;
import Util.Alerta;
import Util.Ventana;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class VentanaCuestionarioController implements Initializable {
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnConfirmar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtConcentracion;
    @FXML
    private TextField txtFechaVencimiento;
    @FXML
    private ChoiceBox<ETiposProductos> cbTipoProducto;
    @FXML
    private ChoiceBox <ETiposAdvertencias> cbTipoAdvertencia;
    @FXML
    private ChoiceBox<EEtiquetasEcologias> cbEtiquetaEcologica;
    
    private Producto productoAModificar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbTipoProducto.getItems().addAll(ETiposProductos.ECOLOGICO,ETiposProductos.QUIMICO);
        this.cbTipoAdvertencia.getItems().addAll(ETiposAdvertencias.CORROSIVO, ETiposAdvertencias.DELICADO, ETiposAdvertencias.INFLAMABLE,ETiposAdvertencias.TOXICO);
        this.cbEtiquetaEcologica.getItems().addAll(EEtiquetasEcologias.APROBADO_POR_INTA,EEtiquetasEcologias.BIODEGRADABLE,EEtiquetasEcologias.SIN_PARABENOS);
        this.cbTipoAdvertencia.setVisible(false);
        this.cbEtiquetaEcologica.setVisible(false);
        this.cbTipoProducto.setOnAction(e->{
            switch (this.cbTipoProducto.getValue()) {
                case ECOLOGICO:
                    this.cbTipoAdvertencia.setVisible(false);
                    this.cbEtiquetaEcologica.setVisible(true);
                    break;
                case QUIMICO:
                    this.cbTipoAdvertencia.setVisible(true);
                    this.cbEtiquetaEcologica.setVisible(false);
            }});
    }
    
    @FXML
    private void cancelar(){
        Ventana.cerrarVentana(btnCancelar);
    }
    
    @FXML
    private void confirmar(){
        try {
            String nombre = this.txtNombre.getText();
            int concentracion = Integer.parseInt(this.txtConcentracion.getText());
            int fechaVencimiento = Integer.parseInt(this.txtFechaVencimiento.getText());
            ETiposProductos tipo = this.cbTipoProducto.getValue();
            switch (tipo) {
                case ECOLOGICO:
                    EEtiquetasEcologias etiquetaEcologica = this.cbEtiquetaEcologica.getValue();
                    this.productoAModificar = new ProductoEcologico(tipo, nombre, concentracion, fechaVencimiento, etiquetaEcologica);
                    break;
                case QUIMICO:
                    ETiposAdvertencias tipoAdvertencia = this.cbTipoAdvertencia.getValue();
                    this.productoAModificar = new ProductoQuimico(tipo, nombre, concentracion, fechaVencimiento, tipoAdvertencia);
            }
            
        Ventana.cerrarVentana(btnConfirmar);
        }catch(NullPointerException e){
            Alert alerta = Alerta.crearAlerta("Error critico, debe poner un tipo de producto ", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        catch (NumeroNegativoException|FechaInvalidaException|CampoVacioException e) {
            Alert alerta = Alerta.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
            alerta.showAndWait();
        }catch(NumberFormatException e){
            Alert alerta = Alerta.crearAlerta("Un campo numerico esta incompleto o tiene Caracteres", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    public Producto getProductoAModificar() {
        return this.productoAModificar;
    }

    public void setProductoAModificar(Producto productoAModificar) {
        if(productoAModificar != null){
            this.productoAModificar = productoAModificar;
            this.txtNombre.setText(this.getProductoAModificar().getNombre());
            this.txtConcentracion.setText(String.valueOf(this.getProductoAModificar().getConcentracion()));
            this.txtFechaVencimiento.setText(String.valueOf(this.getProductoAModificar().getFechaVencimiento()));
            this.cbTipoProducto.setValue(this.getProductoAModificar().getTipoProducto());
            switch (this.cbTipoProducto.getValue()) {
                case ECOLOGICO:
                    ProductoEcologico ecologico = (ProductoEcologico)productoAModificar;
                    this.cbEtiquetaEcologica.setValue(ecologico.getTipoEtiquetaEcologica());
                    break;
                case QUIMICO:
                    ProductoQuimico quimico = (ProductoQuimico) productoAModificar;
                    this.cbTipoAdvertencia.setValue(quimico.getTipoAdvertencia());
            }
        }
        
    }
    
    
    
    
    
    
}
