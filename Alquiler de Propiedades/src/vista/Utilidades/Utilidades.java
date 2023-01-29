/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.CuentaDAO;
import controlador.CuentasController;
import controlador.listas.ListaEnlazada;
import controlador.loginExcepciones.cedulaNovalidaException;
import controlador.loginExcepciones.contraseniaNoCoincideException;
import controlador.loginExcepciones.correoNoValidoException;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private static String URL = "data";

    public static CuentasController cargarCuentas() throws IOException {
        Mapeo mapeo = new Mapeo();
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, Mapeo.class));
        return mapeo.getCc();
    }

    public static void guardarCuentas(CuentasController cc) throws FileNotFoundException {
        Mapeo mapeo = new Mapeo(cc);
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

    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }

    public static void DefinirImagenLabel(JLabel label, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        label.repaint();
    }

    public static JComboBox cargarCombo(JComboBox combo) {
        combo.removeAllItems();
        for (MetodoPago Metodo : MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }

    public static void InsertarPanel(JPanel panelPrincipal, JPanel panelSecundario) {
        panelSecundario.setSize(641, 290);
        panelSecundario.setLocation(0, 0);

        //panelPrincipal
        panelPrincipal.removeAll();
        panelPrincipal.add(panelSecundario, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

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

    public static String obtenerFechaActual() {
        Date fechaActual = new Date();
        int anio = fechaActual.getYear() + 1900;
        int mes = fechaActual.getMonth() + 1;
        int dia = fechaActual.getDay() + 25;
        String fechaFormateada = dia + "/" + mes + "/" + anio;
        return fechaFormateada;
    }

    public static String obtenerHoraActual() {
        Calendar calendario = new GregorianCalendar();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String horaActual = hora + ":" + minutos;
        return horaActual;
    }

    /**
     * Permite encriptar constrasenias mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return
     */
    public static String encriptarContrasenia(String dato) {
        if (dato != null) {
            return Base64.getEncoder().encodeToString(dato.getBytes());
        }
        return "";
    }

    /**
     * Validar cedula ecuatoriana
     *
     * @param cedula
     * @return
     */
    public static boolean validadorDeCedula(String cedula) throws cedulaNovalidaException {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length() == 13) ? cedula.substring(0, 10) : cedula;
        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
        }
        return cedulaCorrecta;
    }

    /**
     * Validar correo del usuario
     *
     * @param correo
     * @return
     * @throws correoNoValidoException
     */
    public static Boolean validarCorreo(String correo) throws correoNoValidoException {
        Boolean correoValido = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            correoValido = true;
        } else {
            throw new correoNoValidoException();
        }
        return correoValido;
    }

    /**
     * Validar si las contraseñas son iguales
     *
     * @param contrasenia1
     * @param contrasenia2
     * @return
     * @throws contraseniaNoCoincideException
     */
    public static Boolean validarContrasenia(String contrasenia1, String contrasenia2) throws contraseniaNoCoincideException {
        Boolean contraseniaCoincide = false;
        if (contrasenia1.equals(contrasenia2)) {
            contraseniaCoincide = true;
        } else {
            throw new contraseniaNoCoincideException();
        }
        return contraseniaCoincide;
    }

    /**
     * Guardar la cuentas registradas en un archivo de tipo .json
     *
     * @param dato
     * @return
     * @throws IOException
     */
    public static Boolean guardar(CuentaDAO dato) throws IOException {
        Parse parse = new Parse(dato);
        Gson gson = new Gson();
        String json = gson.toJson(parse);
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(URL + File.separatorChar + "datos.json"))) {
            bw.write(json);
            bw.flush();
            bw.close();
            System.out.println("Se guardo perrin");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Cargar las cuentas que hayan sido registradas de un archivo .json
     *
     * @return
     * @throws FileNotFoundException
     */
    public static CuentaDAO cargarJson() throws FileNotFoundException {
        Parse parse = new Parse();
        String json = "";
        Gson gson = new Gson();
        try ( BufferedReader br = new BufferedReader(new FileReader(URL + File.separatorChar + "datos.json"))) {

            String linea = "";
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        parse = (gson.fromJson(json, Parse.class));

        return parse.getCd();
    }

}
