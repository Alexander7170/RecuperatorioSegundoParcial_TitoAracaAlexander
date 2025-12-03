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
public class ProductoQuimico extends Producto{
    
    private ETiposAdvertencias tipoAdvertencia;

    public ProductoQuimico(ETiposProductos tipoProducto, String nombre, int concentracion, int fechaVencimiento, ETiposAdvertencias tipoAdvertencia) 
            throws CampoVacioException, FechaInvalidaException, NumeroNegativoException {
        super(tipoProducto, nombre, concentracion, fechaVencimiento);
        this.setTipoAdvertencia(tipoAdvertencia);
    }

    public ETiposAdvertencias getTipoAdvertencia() {
        return tipoAdvertencia;
    }

    public void setTipoAdvertencia(ETiposAdvertencias tipoAdvertencia) throws CampoVacioException{
        if(tipoAdvertencia == null){
            throw new CampoVacioException("Tipo advertencia");
        }
        this.tipoAdvertencia = tipoAdvertencia;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Tipo de advertencia: ").append(this.getTipoAdvertencia().name());
        return sb.toString();
    }
    
    @Override
    public String getNombreClase() {
        return this.getClass().getCanonicalName();
    }
}
