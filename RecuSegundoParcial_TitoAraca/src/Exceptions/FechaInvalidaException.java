/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Alexander
 */
public class FechaInvalidaException extends Exception{

    public FechaInvalidaException(String message) {
        super("Error, la fecha es invalida, tiene que ser mayor a: " + message);
    }
    
}
