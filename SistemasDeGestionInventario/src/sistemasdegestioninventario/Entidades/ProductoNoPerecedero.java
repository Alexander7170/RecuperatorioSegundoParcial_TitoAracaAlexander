/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemasdegestioninventario.Entidades;

/**
 *
 * @author Alexander
 */
public class ProductoNoPerecedero extends Producto implements IVendible{

    public ProductoNoPerecedero(String nombreString, double precion, int cantidad) {
        super(nombreString, precion,  cantidad);
    }
    @Override
    public void vender(int cantidad)throws StockInsuficienteExepcion{
        if(super.getCantidad() - cantidad < 0){
            throw new StockInsuficienteExepcion("Stock insuficiente");
        }
        else{super.setCantidad(super.getCantidad() - cantidad);}
    }
}
