/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.CuentasController;
import controlador.listas.ListaEnlazada;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class Utilidades {
    public static ListaEnlazada<CuentasController> cargarCuentas() throws IOException{
        Mapeo mapeo = new Mapeo();
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, Mapeo.class));
        return mapeo.getCuentaList();
    }
    
    public static void guardarCuentas(ListaEnlazada<CuentasController> cuentaControllerLista) throws FileNotFoundException{
        Mapeo mapeo = new Mapeo(cuentaControllerLista);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(mapeo);
        try {
            PrintWriter escritor = new PrintWriter(new File("cuentas.json"));
            escritor.write(json);
            escritor.flush();
            escritor.close();
            JOptionPane.showMessageDialog(null, "Se guardó");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
            System.out.println(e);
        }        
    }
}
