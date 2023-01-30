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
import modelo.TipoIdentificacion;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

    public static CuentasController cargarCuentas() throws IOException{

        Mapeo mapeo = new Mapeo();
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, Mapeo.class));
        return mapeo.getCc();
    }


    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }
    /**
     * <b>Permite mostrar en un Jlabel una imagen por medio de su ruta </b>
     */
    public static void DefinirImagenLabel(JLabel label, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        label.repaint();
    }
    /**
     * <b>Permite mostrar en un JComboBox un Enum en este caso de Metodo de pago </b>
     */
    public static JComboBox cargarComboMetodoDePago(JComboBox combo) {
        combo.removeAllItems();
        for (MetodoPago Metodo : MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }
    /**
     * <b>Permite definir un panel secundario en un panel principal</b>
     * Informacion: Se utiliza para paneles cambiantes en el que se desee insertar
     * un panel secundario en un panel principal
     */
    public static void InsertarPanel(JPanel panelPrincipal, JPanel panelSecundario) {
        panelSecundario.setSize(641, 290);
        panelSecundario.setLocation(0, 0);

        //panelPrincipal
        panelPrincipal.removeAll();
        panelPrincipal.add(panelSecundario, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    /**
     * <b>Bloquea otros tipos de datos a ingresar que no sean NUMEROS en un jTextField </b>
     */
    public static void permitirSoloNumTxt(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    /**
     * <b>Bloquea otros tipos de datos a ingresar que no sean TEXTO en un jTextField </b>
     */
    public static void permitirSoloLetrasTxt(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    /**
     * <b>Permite restringir el tamanio maximo de dijitos que se pueden ingresar en un TextField</b>
     */
    public static void limitarTamanioTxt(JTextField txt, Integer tamanio) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (txt.getText().length() >= tamanio) {
                    e.consume();
                    JOptionPane.showMessageDialog(txt, "Solo se permiten " + tamanio + " caracteres");
                }
            }
        });
    }
    /**
     * <b>Permite obtener la fecha actual, y retorna un String con la Fecha formateada </b>
     */
    public static String obtenerFechaActual() {
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        String fecha = dateFormat.format(new Date());
        return fecha;
    }
    /**
     * <b>Permite obtener la hora actual, y retorna un String con la Hora formateada</b>
     */
    public static String obtenerHoraActual() {
        Calendar calendario = new GregorianCalendar();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String horaActual = hora + ":" + minutos;
        return horaActual;
    }
    /**
     * <b>Verificador de Tarjeta</b><br>
     * <b>Información:</b> Permite verificar que la tarjeta de crédito sea valida
     * por medio del algoritmo de <b>LUHN</b>, metodo necesita del String del número
     * de Tarjeta y retorna un Boolean dependiendo de la validez de la tarjeta
     */
    public static Boolean verificarNumeroDeTarjeta(String NumTarjeta) {
        //112423425370
        if (NumTarjeta.length() >= 11) {
            Integer total = 0;
            boolean alternarPosicion = false;
            for (int i = NumTarjeta.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(NumTarjeta.substring(i, i + 1));
                if (alternarPosicion) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                total += n;
                alternarPosicion = !alternarPosicion;
            }
            return (total % 10 == 0);
        }else{
            return false;
        }
    }
    /**
     * <b>Permite calcular el valor de la cuota dependiendo de la taza de interez, el valor total y los meses plazo</b>
     */
    public static Double calcularValorCuota(Double tazaDeInterez, Double valorTotal, Integer mesesPlazo) {
        return (valorTotal / mesesPlazo) + ((valorTotal / mesesPlazo) * tazaDeInterez);
    }

     /**
     * <b>Permite calcular la fecha de pago máximo dependiendo del dia en el que se encuentre</b>
     */
    public static String calcularFechaDePago() {
        Date fechaDePago = new Date();
        if (fechaDePago.getDate() <= 28) {
            DateFormat dateFormat = new SimpleDateFormat("d");
            String fecha = dateFormat.format(fechaDePago);
            return fecha;
        } else {
            fechaDePago.setDate(28);
            DateFormat dateFormat = new SimpleDateFormat("d");
            String fecha = dateFormat.format(fechaDePago);
            return fecha;
        }
    }
     /**
     * <b>Permite calcular la fecha de pago maximo dependiendo de los meses plazo que sean enviados</b>
     */
    public static Date calcularFechaDePagoMaximo(Integer mesesPlazo) {
        Date fechaDePago = new Date();
        if (fechaDePago.getDate() <= 28) {
            fechaDePago.setMonth(fechaDePago.getMonth() + mesesPlazo);
            return fechaDePago;
        } else {
            fechaDePago.setDate(28);
            fechaDePago.setMonth(fechaDePago.getMonth() + mesesPlazo);
            return fechaDePago;
        }

    }
}
