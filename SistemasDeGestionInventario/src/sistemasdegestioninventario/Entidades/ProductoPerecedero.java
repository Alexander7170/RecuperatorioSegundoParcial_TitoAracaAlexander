
package sistemasdegestioninventario.Entidades;

/**
 *
 * @author Alexander
 */
public class ProductoPerecedero extends Producto implements IVendible{

    public ProductoPerecedero(String nombreString, double precion, int cantidad) {
        super(nombreString, precion, cantidad);
    }
    @Override
    public void vender(int cantidad)throws StockInsuficienteExepcion{
        if(super.getCantidad() - cantidad < 0){
            throw new StockInsuficienteExepcion("Stock insuficiente");
        }
        else{super.setCantidad(super.getCantidad() - cantidad);}
    }
}
