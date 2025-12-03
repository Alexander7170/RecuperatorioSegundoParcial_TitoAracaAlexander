/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Alexander
 */
public class NumeroNegativoException extends Exception{

    public NumeroNegativoException(String message) {
        super("Usted a puesto un numero negativo invalido en el campo: " + message + ". Pongo un numero positivo para proseguir");
    }
    
}
