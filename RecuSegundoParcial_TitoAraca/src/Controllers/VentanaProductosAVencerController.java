/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Producto;
import Persistencia.DatosJson;
import Util.Alerta;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class VentanaProductosAVencerController implements Initializable {
    @FXML
    private ListView<Producto> listaProductosAVencer;
    @FXML 
    private Button btnGuardarEnJson;
    
    private DatosJson<Producto> datos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.datos = new DatosJson<>(Producto.class, "ProductosAVencer.json");
    }
    
    @FXML
    private void guardar(){
        datos.guardarJson(this.listaProductosAVencer.getItems());
        Alert alerta = Alerta.crearAlerta("Se a guardado correctamente con nombre de: " + this.datos.getFile().getName(), Alert.AlertType.INFORMATION);
        alerta.showAndWait();
    }

    public void añadirProductosAVencer(List<Producto> lista){
        this.listaProductosAVencer.getItems().addAll(lista);
        
    }
    
    
    
}
