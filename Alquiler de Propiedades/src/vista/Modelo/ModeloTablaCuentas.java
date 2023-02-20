/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Modelo;

import controlador.CuentasController;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class ModeloTablaCuentas extends AbstractTableModel{
    private CuentasController cc = new CuentasController();

    public CuentasController getCc() {
        return cc;
    }

    public void setCc(CuentasController cc) {
        this.cc = cc;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override 
    public int getRowCount(){
        return cc.getCuentadao().getCuentas().getTamanio();
    }
    
    /**
     * Presentar columnas 
     * @param column
     * @return String
     */
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Id";
            case 1: return "Usuario";
            case 2: return "Estado";
            case 3: return "Rol";
            default: return null;
        }
    }
    
    /**
     * Presentar valores tabla
     * @param rowIndex
     * @param columnIndex
     * @return object 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = null;
        try {
            c = cc.getCuentadao().getCuentas().obtener(rowIndex);
            
        } catch (ListaVaciaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(ModeloTablaCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(columnIndex){
            case 0:
                return (c != null) ? c.getId() : "No definido";
            case 1:
                return (c != null) ? c.getUsuario() : "No definido";
            case 2:
                if (c != null){
                    if (c.getEstado()) {
                        return "Activo";
                    }else{
                        return "Inactivo";
                    }
                }else{
                    return "No definido";
                }
            case 3: 
                return (c != null) ? c.getRol() : "No definido";
            default:
                return null;
        }
    }
}
