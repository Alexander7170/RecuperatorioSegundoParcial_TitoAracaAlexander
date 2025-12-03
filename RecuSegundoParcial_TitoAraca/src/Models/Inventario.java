/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Exceptions.ProductoRepetidoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class Inventario {
    private List<Producto> listaProductos;
    
    public Inventario(){
        this.listaProductos = new ArrayList<>();
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void agregar(Producto p) throws ProductoRepetidoException{
        if(this.getListaProductos().contains(p)){
            throw new ProductoRepetidoException();
        }
        else{
            this.getListaProductos().add(p);
        }
    }
    public void modificar(Producto viejoProducto, Producto nuevoProducto){
        this.getListaProductos().set(this.getListaProductos().indexOf(viejoProducto), nuevoProducto);
    }
    
    public void eliminar(Producto p){
        this.getListaProductos().remove(p);
    }
    
    public List<Producto> getProductosAVencer(){
         List<Producto> productosAVencer = new ArrayList<>();
         for(Producto p: this.getListaProductos()){
             if(p.estaVenciendo()){
                 productosAVencer.add(p);
             }
         }
         return productosAVencer;
    }
    
}
