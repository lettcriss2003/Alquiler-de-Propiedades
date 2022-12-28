/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.JComboBox;
import modelo.TipoPropiedad;

/**
 *
 * @author lettc
 */
public class Utilidades {
    
    /**
     *
     * @param cbx
     */
    public static void cargarTipoPropiedad(JComboBox cbx){
            for(TipoPropiedad tipo: TipoPropiedad.values()){
                 cbx.addItem(tipo);
            }
    }
    
    public static TipoPropiedad obtenerTipoPropiedad(JComboBox cbx){
        return (TipoPropiedad) cbx.getSelectedItem();
    }
    
    
}
