/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controllers.VentanaPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class RecuSegundoParcial_TitoAraca extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/VentanaPrincipal.fxml"));
            stage.setTitle("Ventana principal Productos De limpieza");
            Parent root = loader.load();
            Scene escena = new Scene(root);
            stage.setScene(escena);
            VentanaPrincipalController controlador = loader.getController();
            stage.setOnCloseRequest(e ->{
                controlador.guardarProgreso();
            });
            stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
