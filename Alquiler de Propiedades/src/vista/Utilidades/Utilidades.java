/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.CuentasController;
import controlador.RolesController;
import controlador.listas.ListaEnlazada;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import modelo.TipoIdentificacion;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.MetodoPago;

/**
 *
 * @author leomah
 */
public class Utilidades {
    public static String DIRCARPDATA = "data";
    
<<<<<<< HEAD
    public static CuentasController cargarCuentas() throws IOException{
        MapeoCuentas mapeo = new MapeoCuentas();
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, MapeoCuentas.class));
        return mapeo.getCc();
    }
    
    public static void guardarCuentas(CuentasController cc) throws FileNotFoundException{
        MapeoCuentas mapeo = new MapeoCuentas(cc);
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
    
    public static RolesController cargarRoles() throws IOException{
        RolesController rc = new RolesController();
        Reader lector = Files.newBufferedReader(Paths.get("roles.json"));
        Gson gson = new Gson();
        rc = (gson.fromJson(lector, RolesController.class));
        return rc;
    }
    
    public static void guardarRoles(RolesController rc) throws FileNotFoundException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(rc);
        try {
            PrintWriter escritor = new PrintWriter(new File("roles.json"));
            escritor.write(json);
            escritor.flush();
            escritor.close();
            JOptionPane.showMessageDialog(null, "Se guardó");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
            System.out.println(e);
        }        
    }
=======
//    public static CuentasController cargarCuentas() throws IOException{
//        Mapeo mapeo = new Mapeo();
//        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
//        Gson gson = new Gson();
//        mapeo = (gson.fromJson(lector, Mapeo.class));
//        return mapeo.getCc();
//    }
//    
//    public static void guardarCuentas(CuentasController cc) throws FileNotFoundException{
//        Mapeo mapeo = new Mapeo(cc);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(mapeo);
//        try {
//            PrintWriter escritor = new PrintWriter(new File("cuentas.json"));
//            escritor.write(json);
//            escritor.flush();
//            escritor.close();
//            JOptionPane.showMessageDialog(null, "Se guardó");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al guardar");
//            System.out.println(e);
//        }        
//    }
>>>>>>> propiedad-contrato_Rojas

    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }
    
//    public static void guardar(Object expresiones[]) throws IOException {
//        Gson json = new Gson();
//        Integer ocupados = ultimoIndiceOcupado(expresiones);
//
//        Object[] expresionesCompletas = new Object[ocupados];
//        System.arraycopy(expresiones, 0, expresionesCompletas, 0, expresionesCompletas.length);
//
//        String jsons = json.toJson(expresionesCompletas);
//        FileWriter fw = new FileWriter("ObjectsArray" + ".json");
//        fw.write(jsons);
//        fw.flush();
//    }
//
//    public static int cargar(Object expresiones[]) {
//        int counter = 0;
//
//        try {
//            Gson json = new Gson();
//            FileReader fr = new FileReader("ObjectsArray" + ".json");
//            StringBuilder jsons = new StringBuilder();
//            int valor = fr.read();
//            while (valor != -1) {
//                jsons.append((char) valor);
//                valor = fr.read();
//            }
//            Object[] aux = json.fromJson(jsons.toString(), Object[].class);
//            for (int i = 0; i < aux.length; i++) {
//                expresiones[i] = aux[i];
//                counter += 1;
//            }
//
//        } catch (Exception e) {
//            System.out.println("No se encontraron objetos guardados en el json!");
//        } finally {
//            return counter;
//        }
//    }
/*
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
*/
    public static void DefinirImagenLabel(JLabel label,String ruta){
        ImageIcon image=new ImageIcon(ruta);
        Icon icon=new ImageIcon( image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        label.repaint();
    }
    
    public static void DefinirImagenBoton(JButton btn, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT));
        btn.setIcon(icon);
        btn.repaint();
    }
    public static JComboBox cargarCombo(JComboBox combo){
        combo.removeAllItems();
        for(MetodoPago Metodo: MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }
    public static void InsertarPanel(JPanel panelPrincipal,JPanel panelSecundario){
        panelSecundario.setSize(641,290 );
        panelSecundario.setLocation(0, 0);
        
        //panelPrincipal
        panelPrincipal.removeAll();
        panelPrincipal.add(panelSecundario,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    public static void permitirSoloNumTxt(JTextField txt){
        txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c =e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    
    public static void permitirSoloLetrasTxt(JTextField txt){
        txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c =e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    
    public static void limitarTamanioTxt(JTextField txt,Integer tamanio){
        txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if (txt.getText().length()>=tamanio) {
                    e.consume();
                    JOptionPane.showMessageDialog(txt, "Solo se permiten "+tamanio+" caracteres");
                }
            }
        });
    }
    
       public static String obtenerFechaActual(){
        Date fechaActual=new Date();
        int anio=fechaActual.getYear()+1900;
        int mes=fechaActual.getMonth()+1;
        int dia=fechaActual.getDay()+25;
        String fechaFormateada=dia+"/"+mes+"/"+anio;
        return fechaFormateada;
    }
    
    public static String obtenerHoraActual(){
        Calendar calendario=new GregorianCalendar();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String horaActual=hora+":"+minutos;
        return horaActual;
    }
    
    /**
     * Sirve para parsear el date de jcalendarr
     * 
     * @param fecha
     * @return 
     */
    public static String obtenerFechaFormateada(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        String fechaFormateada = dateFormat.format(fecha);
        return fechaFormateada;
    }
    
    
}
