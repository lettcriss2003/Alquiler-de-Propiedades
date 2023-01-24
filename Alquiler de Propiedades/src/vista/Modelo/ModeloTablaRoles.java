/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Modelo;

import controlador.RolesController;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Rol;

/**
 *
 * @author leomah
 */
public class ModeloTablaRoles extends AbstractTableModel{
    private RolesController rc;

    public RolesController getRc() {
        return rc;
    }

    public void setRc(RolesController rc) {
        this.rc = rc;
    }    
    
    @Override
    public int getColumnCount(){
        return 2;
    }
    
    @Override 
    public int getRowCount(){
        return rc.getListaRoles().getTamanio();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Nombre";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rol r = null;
        try {
            r = rc.getListaRoles().obtener(rowIndex);
        } catch (ListaVaciaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(columnIndex){
            case 0:
                return (r != null) ? r.getId() : "No definido";
            case 1:
                return (r != null) ? r.getNombre() : "No definido";
            default:
                return null;
        }
    }
}
