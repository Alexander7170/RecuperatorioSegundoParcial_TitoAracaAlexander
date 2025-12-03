/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Alexander
 */
public class Ventana {
    private Ventana(){}
    public static Stage ConfigurarVentana(FXMLLoader loader, String nombreVentana, Modality modalidad) throws IOException{
        Stage stage = new Stage();
        stage.setTitle(nombreVentana);
        stage.initModality(modalidad);
        Parent root = loader.load();
        Scene escena = new Scene(root);
        stage.setScene(escena);
        return stage;
    }
    
    public static void cerrarVentana(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
}
