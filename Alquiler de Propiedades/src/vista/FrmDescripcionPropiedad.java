/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PropiedadDao;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static vista.FrmPropiedadImagen.PropiedadDatos;
import modelo.Propiedad;
import modelo.TipoPropiedad;
import static vista.FrmIngresoPropiedad.dateDisponibilidadDesde;
import static vista.FrmIngresoPropiedad.dateDisponibilidadHasta;
import vista.Utilidades.Utilidades;

/**
 *
 * @author lettc
 */
public class FrmDescripcionPropiedad extends javax.swing.JFrame {

    PropiedadDao propiedadDao = new PropiedadDao();

    private Integer iterador = 1;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmDescripcionPropiedad() {
        initComponents();
        //cargarDatos();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        btnNuevaPropiedad.requestFocus();
        cargarDatos();
    }
    
    /**
     * Craga los datos al frm
     */

    public void cargarDatos() {
        Propiedad aux = new Propiedad();
        aux=propiedadDao.obtenerPropiedad(iterador);
        if ( aux== null) {
            System.out.println("YA NO HAY MAS");
        } else {
            if (aux.getImg() != null) {
                Utilidades.DefinirImagenLabel(lblImagen, aux.getImg());
            }
            if (aux.getImg1() != null) {
                Utilidades.DefinirImagenLabel(lblImagen1, aux.getImg1());
            }
            if (aux.getImg2() != null) {
                Utilidades.DefinirImagenLabel(lblImagen2, aux.getImg2());
            }
            if (aux.getImg3() != null) {
                Utilidades.DefinirImagenLabel(lblImagen3, aux.getImg3());
            }
            if (aux.getImg4() != null) {
                Utilidades.DefinirImagenLabel(lblImagen4, aux.getImg4());
            }
            if (aux.getImg5() != null) {
                Utilidades.DefinirImagenLabel(lblImagen5, aux.getImg5());
            }
            //System.out.println(aux);

            txtPrecio.setText((aux.getPrecio() != null) ? aux.getPrecio() : "No definido");
            txtCiudad.setText((aux.getCiudad() != null) ? aux.getCiudad() : "No definido");
            txtProvincia.setText((aux.getProvincia() != null) ? aux.getProvincia() : "No definido");
            txtCallePrincipal.setText((aux.getCalleP() != null) ? aux.getCalleP() : "No definido");
            txtCalleSegundaria.setText((aux.getCalleS() != null) ? aux.getCalleS() : "No definido");
            txtCodigoPostal.setText((aux.getCodigoP() != null) ? aux.getCodigoP() : "No definido");
            txtDescripcion.setText((aux.getDescripcion() != null) ? aux.getDescripcion() : "No definido");
            txtNumeroPropiedad.setText((aux.getNumeroPropiedad() != null) ? aux.getNumeroPropiedad() : "No definido");
            txtHabitaciones.setText((aux.getHabitaciones() != null) ? aux.getHabitaciones() : "No definido");
            txtBanios.setText((aux.getBanios() != null) ? aux.getBanios() : "No definido");
            txtHuespedes.setText((aux.getHuesped() != null) ? aux.getHuesped() : "No definido");
            txtCamas.setText((aux.getCamas() != null) ? aux.getCamas() : "No definido");
            txtWifi.setText((aux.getWifi() != null) ? (aux.getWifi() == true)?"no":"si" : "no definido"); 
            txtTV.setText((aux.getTV() != null) ? (aux.getTV()== true)?"no":"si" : "no definido");
            txtLavadora.setText((aux.getLavadora() != null) ?  (aux.getLavadora() == true)?"no":"si"  : "no definido");
            txtSecadora.setText((aux.getSecadora() != null) ?  (aux.getSecadora() == true)?"no":"si" : "no");
            txtAireAcondicionado.setText((aux.getAireAcondicionado() != null) ?  (aux.getAireAcondicionado() == true)?"no":"si"  : "no definido");
            txtAguaCaliente.setText((aux.getAguaCaliente() != null) ? (aux.getAguaCaliente()== true)? "no":"si" : "no");
            txtCocina.setText((aux.getCocina() != null) ? (aux.getCocina() == true)?"no":"si": "no");
            txtEstacionamiento.setText((aux.getEstacionamiento() != null) ? (aux.getEstacionamiento() == true)?"no":"si" : "no");
            txtPicina.setText((aux.getPicina() != null) ?(aux.getPicina()== true)?"no":"si" : "no");
            txtJacuzzi.setText((aux.getJacuzzi() != null) ? (aux.getJacuzzi()== true)?"no":"si" : "no");
            txtParrilla.setText((aux.getParrilla() != null) ?(aux.getParrilla()== true)?"no":"si" : "no");
            txtPatio.setText((aux.getPatio() != null) ? (aux.getPatio()== true)?"no":"si": "no");
            txtComedor.setText((aux.getComedor() != null) ? (aux.getComedor()== true)?"no":"si" : "no");
            txtSalaJuegos.setText((aux.getSalaJuegos() != null) ? (aux.getSalaJuegos()== true)?"no":"si" : "no");
            txtOtros.setText((aux.getOtros() != null) ? (aux.getOtros()== true)?"no":"si" : "no");
            txtFechaI.setText(aux.getFechaIngreso());
            txtFechaF.setText(aux.getFechaSalida());

            System.out.println(aux);
            iterador++;
        }
        

    }
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtCallePrincipal = new javax.swing.JTextField();
        txtCalleSegundaria = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNumeroPropiedad = new javax.swing.JTextField();
        txtHabitaciones = new javax.swing.JTextField();
        txtBanios = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        txtHuespedes = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtCamas = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtWifi = new javax.swing.JTextField();
        txtTV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtAireAcondicionado = new javax.swing.JTextField();
        txtAguaCaliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblImagen1 = new javax.swing.JLabel();
        lblImagen2 = new javax.swing.JLabel();
        lblImagen5 = new javax.swing.JLabel();
        lblImagen4 = new javax.swing.JLabel();
        lblImagen3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtLavadora = new javax.swing.JTextField();
        txtSecadora = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCocina = new javax.swing.JTextField();
        txtEstacionamiento = new javax.swing.JTextField();
        txtPicina = new javax.swing.JTextField();
        txtJacuzzi = new javax.swing.JTextField();
        txtParrilla = new javax.swing.JTextField();
        txtPatio = new javax.swing.JTextField();
        txtComedor = new javax.swing.JTextField();
        txtSalaJuegos = new javax.swing.JTextField();
        txtOtros = new javax.swing.JTextField();
        btnNuevaPropiedad = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnVerSiguientePropiedad = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtFechaI = new javax.swing.JTextField();
        txtFechaF = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmUsuario = new javax.swing.JMenuItem();
        jmAnfitrion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS DE LA PROPIEDAD");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DIRECCION");

        jLabel5.setText("Ciudad:");

        jLabel4.setText("Provincia:");

        jLabel6.setText("Calle principal");

        jLabel7.setText("Calle segundaria");

        jLabel8.setText("Codigo postal");

        txtCiudad.setEditable(false);
        txtCiudad.setBackground(new java.awt.Color(255, 255, 255));
        txtCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCiudad.setFocusable(false);

        txtProvincia.setEditable(false);
        txtProvincia.setBackground(new java.awt.Color(255, 255, 255));
        txtProvincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProvincia.setFocusable(false);

        txtCallePrincipal.setEditable(false);
        txtCallePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        txtCallePrincipal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCallePrincipal.setFocusable(false);

        txtCalleSegundaria.setEditable(false);
        txtCalleSegundaria.setBackground(new java.awt.Color(255, 255, 255));
        txtCalleSegundaria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCalleSegundaria.setFocusable(false);

        txtCodigoPostal.setEditable(false);
        txtCodigoPostal.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoPostal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoPostal.setFocusable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(txtProvincia)
                            .addComponent(txtCallePrincipal)
                            .addComponent(txtCalleSegundaria)
                            .addComponent(txtCodigoPostal))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCalleSegundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("TIPO DE PROPIEDAD");

        jLabel30.setText("Descripcion");

        jLabel31.setText("Numero de propiedad");

        jLabel32.setText("Habitaciones");

        jLabel33.setText("Baños");

        txtNumeroPropiedad.setEditable(false);
        txtNumeroPropiedad.setBackground(new java.awt.Color(255, 255, 255));
        txtNumeroPropiedad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroPropiedad.setFocusable(false);

        txtHabitaciones.setEditable(false);
        txtHabitaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtHabitaciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHabitaciones.setFocusable(false);

        txtBanios.setEditable(false);
        txtBanios.setBackground(new java.awt.Color(255, 255, 255));
        txtBanios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBanios.setFocusable(false);

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setFocusable(false);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel36.setText("Huespedes");

        txtHuespedes.setEditable(false);
        txtHuespedes.setBackground(new java.awt.Color(255, 255, 255));
        txtHuespedes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHuespedes.setFocusable(false);

        jLabel37.setText("Camas");

        txtCamas.setEditable(false);
        txtCamas.setBackground(new java.awt.Color(255, 255, 255));
        txtCamas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCamas.setFocusable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHabitaciones)
                            .addComponent(txtNumeroPropiedad)
                            .addComponent(txtBanios)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCamas)
                            .addComponent(txtHuespedes))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNumeroPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtBanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("CONECTIVIDAD");

        jLabel11.setText("WIFI");

        jLabel12.setText("TV");

        txtWifi.setEditable(false);
        txtWifi.setBackground(new java.awt.Color(255, 255, 255));
        txtWifi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWifi.setFocusable(false);

        txtTV.setEditable(false);
        txtTV.setBackground(new java.awt.Color(255, 255, 255));
        txtTV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTV.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SERVICIOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWifi)
                            .addComponent(txtTV)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtWifi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 51));
        jLabel26.setText("AMBIENTACION");

        jLabel27.setText("Aire acondicionado");

        jLabel28.setText("Agua caliente");

        txtAireAcondicionado.setEditable(false);
        txtAireAcondicionado.setBackground(new java.awt.Color(255, 255, 255));
        txtAireAcondicionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAireAcondicionado.setFocusable(false);

        txtAguaCaliente.setEditable(false);
        txtAguaCaliente.setBackground(new java.awt.Color(255, 255, 255));
        txtAguaCaliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAguaCaliente.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAireAcondicionado, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtAguaCaliente))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtAireAcondicionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(txtAguaCaliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagen5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagen4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagen3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setText("SERVICIOS DE LIMPIEZA");

        jLabel23.setText("Lavadora");

        jLabel24.setText("Secadora");

        txtLavadora.setEditable(false);
        txtLavadora.setBackground(new java.awt.Color(255, 255, 255));
        txtLavadora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLavadora.setFocusable(false);

        txtSecadora.setEditable(false);
        txtSecadora.setBackground(new java.awt.Color(255, 255, 255));
        txtSecadora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSecadora.setFocusable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLavadora)
                            .addComponent(txtSecadora))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtLavadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtSecadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("AREAS");

        jLabel14.setText("Cocina");

        jLabel15.setText("Estacionamiento");

        jLabel16.setText("Picina");

        jLabel17.setText("Jacuzzi");

        jLabel18.setText("Parrilla");

        jLabel19.setText("Patio");

        jLabel20.setText("Comedor al aire");

        jLabel21.setText("Sala de juegos");

        jLabel2.setText("Otros");

        txtCocina.setEditable(false);
        txtCocina.setBackground(new java.awt.Color(255, 255, 255));
        txtCocina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCocina.setFocusable(false);

        txtEstacionamiento.setEditable(false);
        txtEstacionamiento.setBackground(new java.awt.Color(255, 255, 255));
        txtEstacionamiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstacionamiento.setFocusable(false);

        txtPicina.setEditable(false);
        txtPicina.setBackground(new java.awt.Color(255, 255, 255));
        txtPicina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPicina.setFocusable(false);

        txtJacuzzi.setEditable(false);
        txtJacuzzi.setBackground(new java.awt.Color(255, 255, 255));
        txtJacuzzi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJacuzzi.setFocusable(false);

        txtParrilla.setEditable(false);
        txtParrilla.setBackground(new java.awt.Color(255, 255, 255));
        txtParrilla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtParrilla.setFocusable(false);

        txtPatio.setEditable(false);
        txtPatio.setBackground(new java.awt.Color(255, 255, 255));
        txtPatio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPatio.setFocusable(false);

        txtComedor.setEditable(false);
        txtComedor.setBackground(new java.awt.Color(255, 255, 255));
        txtComedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtComedor.setFocusable(false);

        txtSalaJuegos.setEditable(false);
        txtSalaJuegos.setBackground(new java.awt.Color(255, 255, 255));
        txtSalaJuegos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalaJuegos.setFocusable(false);

        txtOtros.setEditable(false);
        txtOtros.setBackground(new java.awt.Color(255, 255, 255));
        txtOtros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCocina)
                            .addComponent(txtEstacionamiento)
                            .addComponent(txtPicina)
                            .addComponent(txtJacuzzi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtParrilla, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPatio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtComedor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSalaJuegos)
                            .addComponent(txtOtros))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCocina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtJacuzzi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtParrilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtComedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtSalaJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevaPropiedad.setText("CREAR NUEVA PROPIEDAD");
        btnNuevaPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPropiedadActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnVerSiguientePropiedad.setText("VER SIGUIENTE");
        btnVerSiguientePropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSiguientePropiedadActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setForeground(new java.awt.Color(0, 0, 51));
        jLabel25.setText("DISPONIBILIDAD");

        jLabel34.setText("Fecha Inicio");

        jLabel35.setText("Fecha final");

        txtFechaI.setEditable(false);
        txtFechaI.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtFechaF.setEditable(false);
        txtFechaF.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaF))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaI)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel38.setText("Precio por noche");

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevaPropiedad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVerSiguientePropiedad))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnNuevaPropiedad)
                            .addComponent(btnVerSiguientePropiedad)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jmUsuario.setText("Usuario");
        jmUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmUsuario);

        jmAnfitrion.setText("Anfitrion");
        jMenu1.add(jmAnfitrion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FrmPrincipal regresar = new FrmPrincipal();
        regresar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevaPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPropiedadActionPerformed
        FrmIngresoDireccion btndireccion = new FrmIngresoDireccion();
        btndireccion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNuevaPropiedadActionPerformed

    private void btnVerSiguientePropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSiguientePropiedadActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_btnVerSiguientePropiedadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDescripcionPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDescripcionPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDescripcionPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDescripcionPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDescripcionPropiedad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaPropiedad;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerSiguientePropiedad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmAnfitrion;
    private javax.swing.JMenuItem jmUsuario;
    public static javax.swing.JLabel lblImagen;
    public static javax.swing.JLabel lblImagen1;
    public static javax.swing.JLabel lblImagen2;
    public static javax.swing.JLabel lblImagen3;
    public static javax.swing.JLabel lblImagen4;
    public static javax.swing.JLabel lblImagen5;
    public static javax.swing.JTextField txtAguaCaliente;
    public static javax.swing.JTextField txtAireAcondicionado;
    public static javax.swing.JTextField txtBanios;
    public static javax.swing.JTextField txtCallePrincipal;
    public static javax.swing.JTextField txtCalleSegundaria;
    public static javax.swing.JTextField txtCamas;
    public static javax.swing.JTextField txtCiudad;
    public static javax.swing.JTextField txtCocina;
    public static javax.swing.JTextField txtCodigoPostal;
    public static javax.swing.JTextField txtComedor;
    public static javax.swing.JTextArea txtDescripcion;
    public static javax.swing.JTextField txtEstacionamiento;
    public static javax.swing.JTextField txtFechaF;
    public static javax.swing.JTextField txtFechaI;
    public static javax.swing.JTextField txtHabitaciones;
    public static javax.swing.JTextField txtHuespedes;
    public static javax.swing.JTextField txtJacuzzi;
    public static javax.swing.JTextField txtLavadora;
    public static javax.swing.JTextField txtNumeroPropiedad;
    public static javax.swing.JTextField txtOtros;
    public static javax.swing.JTextField txtParrilla;
    public static javax.swing.JTextField txtPatio;
    public static javax.swing.JTextField txtPicina;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtProvincia;
    public static javax.swing.JTextField txtSalaJuegos;
    public static javax.swing.JTextField txtSecadora;
    public static javax.swing.JTextField txtTV;
    public static javax.swing.JTextField txtWifi;
    // End of variables declaration//GEN-END:variables
}
