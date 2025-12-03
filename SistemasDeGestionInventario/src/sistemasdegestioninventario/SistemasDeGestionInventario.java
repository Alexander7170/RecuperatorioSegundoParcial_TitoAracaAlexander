
package sistemasdegestioninventario;
import Entidades.*;
/*
Crear un sistema de reservas de vuelos:
- Clase abstracta Vuelo con métodos abstractos reservarAsiento() y cancelarReserva().
- Interfaz Reservable con métodos confirmarReserva().
- Subclases VueloNacional y VueloInternacional con sus particularidades.
- Excepción personalizada AsientoNoDisponibleException.
- Simular reservas, lanzar excepciones y gestionar con bloques try-catch.
- Aplicar polimorfismo al trabajar con una lista de vuelos de diferentes tipos.

*/

import java.util.Scanner;
public class SistemasDeGestionInventario {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        Opcion opcion1 = new Opcion(1,"Añadir coso");
        Opcion opcion2 = new Opcion(1,"Añadir coso");
        Opcion opcion3 = new Opcion(2,"Añadir coso");
        Opcion opcion4 = new Opcion(4,"Salir menu");
        try {
            menu.añadirOpcion(null);
        } catch (NullPointerException e) {
            for(StackTraceElement stackTraceElement: e.getStackTrace()){
                System.out.println(stackTraceElement);
            }
            System.out.println(e.getMessage());
        }

        /*try {
            menu.añadirOpcion(opcion1);
            menu.añadirOpcion(opcion2);
            menu.añadirOpcion(null);
            menu.añadirOpcion(opcion4);
        } catch (NullPointerException exepcion) {
            System.out.println(exepcion.getMessage());
        }
        */
        boolean correr = true;
        
        while(correr){
            System.out.println(menu.toString());
            System.out.println("Tu opcion: ");
            int opcion = scan.nextInt();
            if(opcion == 4){
                correr = false;
            }
            
        }
    }
    
}
