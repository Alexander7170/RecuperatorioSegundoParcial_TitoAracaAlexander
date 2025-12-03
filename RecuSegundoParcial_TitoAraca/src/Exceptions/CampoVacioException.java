/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Alexander
 */
public class CampoVacioException extends Exception{

    public CampoVacioException(String message) {
        super("Usted a dejado un campo sin llenar, ese campo es el: " + message + ". LLenelo para proseguir");
    }
    
}
