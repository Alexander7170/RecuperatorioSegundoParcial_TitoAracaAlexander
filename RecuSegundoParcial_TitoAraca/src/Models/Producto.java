/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Exceptions.CampoVacioException;
import Exceptions.FechaInvalidaException;
import Exceptions.NumeroNegativoException;
import java.time.LocalDate;

/**
 *
 * @author Alexander
 */
public abstract class Producto implements SerializableJson{
    private ETiposProductos tipoProducto;
    private String nombre;
    private int concentracion;
    private int fechaVencimiento;
    public static int fechaHoy = 0;
    private static final String separador = " // ";
    public Producto(ETiposProductos tipoProducto,String nombre, int concentracion, int fechaVencimiento)
        throws CampoVacioException,FechaInvalidaException, NumeroNegativoException {
        this.tipoProducto = tipoProducto;
        this.setNombre(nombre);
        this.setConcentracion(concentracion);
        this.setFechaVencimiento(fechaVencimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CampoVacioException{
        if(nombre.isEmpty()){
            throw new CampoVacioException("nombre");
        }
        else{
            this.nombre = nombre;
        }
    }

    public int getConcentracion() {
        return concentracion;
    }
    
    public ETiposProductos getTipoProducto(){
        return this.tipoProducto;
    }

    public void setConcentracion(int concentracion) throws NumeroNegativoException{
        if(concentracion < 0){
            throw new NumeroNegativoException("Concentracion");
        }
        else{
            this.concentracion = concentracion;
        }
    }

    public int getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(int fechaVencimiento)throws FechaInvalidaException {
        if(fechaVencimiento <= Producto.fechaHoy){
            throw new FechaInvalidaException(String.valueOf(fechaHoy));
        }
        else{
            this.fechaVencimiento = fechaVencimiento;
        }
    }
    public boolean estaVenciendo(){
        return (fechaHoy + 60) >= this.getFechaVencimiento();
    }
    
    public static void setFechaHoy(int fecha){
        Producto.fechaHoy = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.getNombre()).append(Producto.separador);
        sb.append("Concentracion: ").append(String.valueOf(this.getConcentracion())).append(Producto.separador);
        sb.append("FechaVencimiento: ").append(String.valueOf(this.getFechaVencimiento())).append(Producto.separador);
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;
        if(!(obj instanceof Producto)) return false;
        Producto otro = (Producto)obj;
        return this.getNombre().equals(otro.getNombre()) && this.getConcentracion() == otro.getConcentracion() 
                && this.getFechaVencimiento() == otro.getFechaVencimiento();
    }
}
