 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Modelo;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Propiedad;

/**
 *
 * @author Core i7-W11
 */
public class ModeloTablaFavoritos extends AbstractTableModel{
    private ListaEnlazada<Propiedad> lista = new ListaEnlazada<>();

    public ListaEnlazada<Propiedad> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Propiedad> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    @Override 
    public int getRowCount(){
        return lista.getTamanio();
    }
    
    /**
     * Genera las columnas de la tabla
     * @param column
     * @return Strin 
     */
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Dirección";
            case 2: return "Anfitrión";
            default: return null;
        }
    }

    /**
     * Presenta los valores de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Propiedad p = null;
        try {
            p = lista.obtener(rowIndex);
            
        } catch (ListaVaciaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(columnIndex){
            case 0:
                return (p != null) ? p.getId() : "No definido";
            case 1:
                return (p != null) ? p.getCiudad() + "; " + p.getCalleP() : "No definido";
            case 2:
                return (p != null) ? p.getAnfitrion().getUsuario() : "No definido";
            default:
                return null;
        }
    }
}
