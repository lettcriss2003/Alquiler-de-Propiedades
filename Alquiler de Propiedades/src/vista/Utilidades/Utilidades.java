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
<<<<<<< HEAD
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;
=======
import java.text.DateFormat;
import java.text.SimpleDateFormat;
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
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

/**
 *
 * @author leomah
 */
public class Utilidades {
<<<<<<< HEAD
  

    private static String URL = "data";
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

public static CuentasController cargarCuentas() throws IOException{
        MapeoCuentas mapeo = new MapeoCuentas();
=======

    public static String DIRCARPDATA = "data";

    public static CuentasController cargarCuentas() throws IOException{

        Mapeo mapeo = new Mapeo();
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
        Reader lector = Files.newBufferedReader(Paths.get("cuentas.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, MapeoCuentas.class));
        return mapeo.getCc();
    }
<<<<<<< HEAD
    
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
=======

>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha


    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }
<<<<<<< HEAD

    
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
  
    public static JComboBox cargarCombo(JComboBox combo) {
=======
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
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
        combo.removeAllItems();
        for (MetodoPago Metodo : MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }
<<<<<<< HEAD

=======
    /**
     * <b>Permite definir un panel secundario en un panel principal</b>
     * Informacion: Se utiliza para paneles cambiantes en el que se desee insertar
     * un panel secundario en un panel principal
     */
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
    public static void InsertarPanel(JPanel panelPrincipal, JPanel panelSecundario) {
        panelSecundario.setSize(641, 290);
        panelSecundario.setLocation(0, 0);

        //panelPrincipal
        panelPrincipal.removeAll();
        panelPrincipal.add(panelSecundario, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
<<<<<<< HEAD

=======
    /**
     * <b>Bloquea otros tipos de datos a ingresar que no sean NUMEROS en un jTextField </b>
     */
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
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
<<<<<<< HEAD

=======
    /**
     * <b>Bloquea otros tipos de datos a ingresar que no sean TEXTO en un jTextField </b>
     */
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
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
<<<<<<< HEAD

=======
    /**
     * <b>Permite restringir el tamanio maximo de dijitos que se pueden ingresar en un TextField</b>
     */
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
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
<<<<<<< HEAD



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

=======
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
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
}
