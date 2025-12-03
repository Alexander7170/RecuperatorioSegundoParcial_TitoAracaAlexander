/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

/**
 *
 * @author Alexander
 */
public class Alerta {
    private Alerta(){}
    public static Alert crearAlerta(String cabecera, AlertType tipoAlerta){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(Alerta.getTitulo(tipoAlerta));
        alerta.setHeaderText(cabecera);
        return alerta;
    }
    
    public static Alert crearAlertaNingunItemSeleccionado(String nombreItem){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(Alerta.getTitulo(AlertType.ERROR));
        alerta.setHeaderText("No a seleccionado ningun " + nombreItem);
        return alerta;
    }
    
    private static String getTitulo(AlertType tipoAlerta){
        String titulo = "";
        switch (tipoAlerta){
            case ERROR:
                titulo = "Alerta: Error en tiempo de ejecucion";
                break;
            case CONFIRMATION:
                titulo = "Alerta: Se necesista confirmacion";
                break;
            case INFORMATION:
                titulo = "Alerta: Informacion que debe saber";
                break;
            case WARNING:
                titulo = "Alerta: Es posible que se ocacione un peligro";
        }
        return titulo;
    }
        
}
