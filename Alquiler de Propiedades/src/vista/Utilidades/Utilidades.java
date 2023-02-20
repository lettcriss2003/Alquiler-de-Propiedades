/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.CuentaDAO;
import controlador.CuentasController;
import controlador.RolesController;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.MetodoPago;
import modelo.Propiedad;
import modelo.Rol;

/**
 *
 * @author leomah
 */
public class Utilidades {

    private static String URL = "data";

    /**
     * Cargar roles
     * @param cbx
     * @return rol
     * @throws IOException 
     */
    public static JComboBox cargarRoles(JComboBox cbx) throws IOException {
        cbx.removeAllItems();
        for (Rol rol : Rol.values()) {
            cbx.addItem(rol);
        }
        return cbx;
    }

    /**
     * Obtener fecha 
     * @param fechaString
     * @return date
     * @throws ParseException 
     */
    public static Date obtenerDateofString(String fechaString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
        Date date = formatter.parse(fechaString);
        return date;
    }

    /**
     * Guarda los roles
     * @param rc
     * @throws FileNotFoundException 
     */
    public static void guardarRoles(RolesController rc) throws FileNotFoundException {
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

    /**
     * Carga cuenta
     * @return cuenta
     * @throws IOException 
     */
    public static CuentasController cargarCuentas() throws IOException {
        MapeoCuentas mapeo = new MapeoCuentas();
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, MapeoCuentas.class));
        return mapeo.getCc();
    }

    /**
     * Guardar cuenta
     * @param cc
     * @throws FileNotFoundException 
     */
    public static void guardarCuentas(CuentasController cc) throws FileNotFoundException {
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

    /**
     * Carga propiedades
     * @return lista de propiedades
     * @throws IOException 
     */
    public static ListaEnlazada<Propiedad> cargarPropiedades() throws IOException {
        MapeoPropiedades mapeo = new MapeoPropiedades();
        Reader lector = Files.newBufferedReader(Paths.get(URL + File.separatorChar + "Propiedad.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, MapeoPropiedades.class));
        if (mapeo == null) {
            mapeo = new MapeoPropiedades();
        }
        return mapeo.getListaPropiedades();
    }

    /**
     * Guarda las propiedades
     * @param lista
     * @throws FileNotFoundException 
     */
    public static void guardarPropiedades(ListaEnlazada<Propiedad> lista) throws FileNotFoundException {
        MapeoPropiedades mapeo = new MapeoPropiedades(lista);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(mapeo);
        try {
            PrintWriter escritor = new PrintWriter(new File(URL + File.separatorChar + "Propiedad.json"));
            escritor.write(json);
            escritor.flush();
            escritor.close();
            JOptionPane.showMessageDialog(null, "Se guardó");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
            System.out.println(e);
        }
    }

    /**
     * Carga el tipo de identificacion
     * @param cbx 
     */
    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    /**
     * Obtiene el tipo de identificacion
     * @param cbx
     * @return identificacion
     */
    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }

/**
 * Carga el json
 * @param expresiones
 * @return Integer
 */
    public static int cargar(Object expresiones[]) {
        int counter = 0;

        try {
            Gson json = new Gson();
            FileReader fr = new FileReader("ObjectsArray" + ".json");
            StringBuilder jsons = new StringBuilder();
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Object[] aux = json.fromJson(jsons.toString(), Object[].class);
            for (int i = 0; i < aux.length; i++) {
                expresiones[i] = aux[i];
                counter += 1;
            }

        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados en el json!");
        } finally {
            return counter;
        }
    }

    /**
     * Definir imagenes en los label
     * @param label
     * @param ruta 
     */
    public static void DefinirImagenLabel(JLabel label, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        label.repaint();
    }

    /**
     * Define las imagenes en el boton
     * @param btn
     * @param ruta 
     */
    public static void DefinirImagenBoton(JButton btn, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT));
        btn.setIcon(icon);
        btn.repaint();
    }

    /**
     * Carga el combo del metodo de pago
     * @param combo
     * @return metodo de pago
     */
    public static JComboBox cargarCombo(JComboBox combo) {
        combo.removeAllItems();
        for (MetodoPago Metodo : MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }


    /**
     * Permite calcular el valor de la cuota dependiendo de la taza de
     * interez, el valor total y los meses plazo
     * @param tazaDeInterez
     * @param valorTotal
     * @param mesesPlazo
     * @return double
     */
    public static Double calcularValorCuota(Double tazaDeInterez, Double valorTotal, Integer mesesPlazo) {
        return (valorTotal / mesesPlazo) + ((valorTotal / mesesPlazo) * tazaDeInterez);
    }


    /**
     * Permite calcular la fecha de pago máximo dependiendo del dia en el que
     * se encuentre
     * @return fecha
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
     * Permite calcular la fecha de pago maximo dependiendo de los meses
     * plazo que sean enviados
     * @param mesesPlazo
     * @return fecha de pago
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


    /**
     * Permite mostrar en un JComboBox un Enum en este caso de Metodo de pago
     * @param combo
     * @return metodo de pago
     */
    public static JComboBox cargarComboMetodoDePago(JComboBox combo) {
        combo.removeAllItems();
        for (MetodoPago Metodo : MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }

    /**
     * <b>Verificador de Tarjeta</b><br>
     * <b>Información:</b> Permite verificar que la tarjeta de crédito sea
     * valida por medio del algoritmo de <b>LUHN</b>, metodo necesita del String
     * del número de Tarjeta y retorna un Boolean dependiendo de la validez de
     * la tarjeta
     */
    /**
     * Verificador de Tarjeta
     * @param NumTarjeta
     * @return boolean
     * Permite verificar que la tarjeta de crédito sea
     * valida por medio del algoritmo de LUHN, metodo necesita del String
     * del número de Tarjeta y retorna un Boolean dependiendo de la validez de
     * la tarjeta
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
        } else {
            return false;
        }
    }

    /**
     * Insertar panel
     * @param panelPrincipal
     * @param panelSecundario 
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
     * Permite solo numeros en los txt
     * @param txt 
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
     * Permite solo letras en los txt
     * @param txt 
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
     * limita tamanio
     * @param txt
     * @param tamanio 
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
     * Obtiene la fecha actual
     * @return fecha actual
     */
    public static String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActualStr = fechaActual.format(formatter);
        return fechaActualStr;
    }

    /**
     * Sirve para obtener la hora actual
     *
     * @return hora actual
     */
    public static String obtenerHoraActual() {
        Calendar calendario = new GregorianCalendar();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String horaActual = hora + ":" + minutos;
        return horaActual;
    }

    /**
     * Sirve para parsear el date de jcalendarr
     *
     * @param fecha
     * @return fecha en string
     */
    public static String obtenerFechaFormateada(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
        String fechaFormateada = dateFormat.format(fecha);
        return fechaFormateada;
    }

    /**
     * Permite encriptar constrasenias mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return contrasenia encriptada
     */
    public static String encriptarContrasenia(String dato) {
        if (dato != null) {
            return Base64.getEncoder().encodeToString(dato.getBytes());
        }
        return "";
    }

    /**
     * Permiute desencriptar la contrasenia
     * @param dato
     * @return contrasenia desencriptada
     */
    public static String desEncriptarContrasenia(String dato) {
        if (dato != null) {
            return new String(Base64.getDecoder().decode(dato));
        }
        return "";
    }

    /**
     * Validar cedula ecuatoriana
     *
     * @param cedula
     * @return boolean
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
     * @return boolean
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
     * @return boolean
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
     * @return json
     * @throws IOException
     */
    public static Boolean guardar(CuentaDAO dato) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dato);
        try {
            PrintWriter escritor = new PrintWriter(new File(URL + File.separatorChar + "datos.json"));
            escritor.write(json);
            escritor.flush();
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    /**
     * Cargar las cuentas que hayan sido registradas de un archivo .json
     *
     * @return jason cuenta
     * @throws FileNotFoundException
     */
    public static CuentaDAO cargarJson() throws FileNotFoundException, IOException {
        CuentaDAO mapeo = new CuentaDAO();
        Reader lector = Files.newBufferedReader(Paths.get(URL + File.separatorChar + "datos.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, CuentaDAO.class));
        return mapeo;

    }

}
