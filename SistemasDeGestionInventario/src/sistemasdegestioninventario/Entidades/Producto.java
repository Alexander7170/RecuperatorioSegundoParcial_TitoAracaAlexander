/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemasdegestioninventario.Entidades;

/**
 *
 * @author Alexander
 */
public abstract class Producto {
    protected String nombreString;
    protected double precio;
    protected int cantidad;

    public Producto(String nombreString, double precion, int cantidad) {
        this.nombreString = nombreString;
        this.precio = precion;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
