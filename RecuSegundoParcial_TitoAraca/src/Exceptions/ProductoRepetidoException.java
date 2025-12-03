/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Alexander
 */
public class ProductoRepetidoException extends Exception{

    public ProductoRepetidoException() {
        super("EL producto ya existe en el sistema");
    }
    
}
