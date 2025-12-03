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
public class ProductoEcologico extends Producto {
    private EEtiquetasEcologias tipoEtiquetaEcologica;

    public ProductoEcologico(ETiposProductos tipoProducto, String nombre, int concentracion, int fechaVencimiento, EEtiquetasEcologias tipoEtiquetaEcologica) 
            throws CampoVacioException, FechaInvalidaException, NumeroNegativoException {
        super(tipoProducto, nombre, concentracion, fechaVencimiento);
        this.setTipoEtiquetaEcologico(tipoEtiquetaEcologica);
    }

    public EEtiquetasEcologias getTipoEtiquetaEcologica() {
        return tipoEtiquetaEcologica;
    }
    public void setTipoEtiquetaEcologico(EEtiquetasEcologias tipoEEtiquetaEcologia)throws CampoVacioException{
        if(tipoEEtiquetaEcologia == null){
            throw new CampoVacioException("Tipo de etiqueta ecologica");
        }
        else{
            this.tipoEtiquetaEcologica = tipoEEtiquetaEcologia;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Tipo Etiqueta Ecologica: ").append(this.getTipoEtiquetaEcologica());
        return sb.toString();
    }
    
    @Override
    public String getNombreClase() {
        return this.getClass().getCanonicalName();
    }
}

