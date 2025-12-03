/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemasdegestioninventario.Entidades;

/**
 *
 * @author Alexander
 */
public interface IVendible {
    public void vender(int cantidad)throws StockInsuficienteExepcion;
}
