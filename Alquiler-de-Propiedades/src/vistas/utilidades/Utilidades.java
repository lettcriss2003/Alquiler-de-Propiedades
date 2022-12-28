/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas.utilidades;

import com.google.gson.Gson;
import controlador.CuentaController;
import controlador.dao.CuentaDAO;
import controlador.listas.ListaEnlazada;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JComboBox;
import modelo.Cuenta;
import modelo.enums.TipoIdentificacion;

/**
 *
 * @author LENOVO
 */
public class Utilidades {

    public static String DIRCARPDATA = "data";

    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }

    public static boolean guardarJSON(CuentaDAO cuentas) {
        Gson gson = new Gson();
        String json = gson.toJson(cuentas);

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(DIRCARPDATA + File.separatorChar + "datos.json"))) {
            bw.write(json);
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }

    }
}
