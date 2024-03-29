/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PropiedadDao;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Propiedad;
import static vista.FrmIngresoDireccion.txtCallePrincipal;
import static vista.FrmIngresoDireccion.txtCalleSecundaria;
import static vista.FrmIngresoDireccion.txtCiudad;
import static vista.FrmIngresoDireccion.txtCodigoPostal;
import static vista.FrmIngresoDireccion.txtProvincia;
import vista.Utilidades.Utilidades;




/**
 *
 * @author lettc
 */
public class FrmIngresoPropiedad extends javax.swing.JFrame {
    PropiedadDao propiedadDao = new PropiedadDao();
    Propiedad aux = new Propiedad();
    private ListaEnlazada<Propiedad> listaPropiedades;
    
    /**
     * Creates new form IngresoPropiedad
     */
    public FrmIngresoPropiedad() {
        //cargarCombos();
        /*limpiar();
        setLocationRelativeTo(this);*/
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        cargarRestriciones();
        //dateDisponibilidadDesde.setMinSelectableDate(new Date());
        //dateDisponibilidadHasta.setMinSelectableDate(new Date());
        btnSiguiente.requestFocus();
        
    }
    
    public FrmIngresoPropiedad(Integer id) {
        //cargarCombos();
        /*limpiar();
        setLocationRelativeTo(this);*/
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        try {
            listaPropiedades = Utilidades.cargarPropiedades();
            aux = listaPropiedades.obtener(id-1);
        } catch (IOException ex) {
            Logger.getLogger(Frmservicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaVaciaException ex) {
            Logger.getLogger(Frmservicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(Frmservicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarDatos();
        cargarRestriciones();
        btnSiguiente.requestFocus();
//        dateDisponibilidadDesde.setMinSelectableDate(new Date());
//        dateDisponibilidadHasta.setMinSelectableDate(new Date());
    }
    
    private void cargarDatos(){
        vista.Utilidades.Utilidades.permitirSoloNumTxt(txtPrecio);
        cbxTipoPropiedad.setSelectedItem(aux.getTipoPropiedad());
        txtDescripcion.setText(aux.getDescripcion());
        txtPrecio.setText(aux.getPrecio());
        txtNumeroPropiedad.setText(aux.getNumeroPropiedad());
    }
    
    /**
     * Va a cargar las restricciones
     */
    private void cargarRestriciones(){
    //vista.Utilidades.Utilidades.permitirSoloNumTxt(txtNumeroPropiedad);

    }
    
    /**
     * guarda los datos de la propiedad
     */
    private void guardarDATOS() {
        
        aux.setTipoPropiedad(cbxTipoPropiedad.getSelectedItem().toString());
        aux.setDescripcion(txtDescripcion.getText());
        aux.setNumeroPropiedad(txtNumeroPropiedad.getText());
        aux.setHuesped(spinHuespedes.getValue().toString());
        aux.setHabitaciones(spinHabitaciones.getValue().toString());
        aux.setCamas(spinCamas.getValue().toString());
        aux.setBanios(spinBanios.getValue().toString());
        aux.setPrecio(txtPrecio.getText());
        aux.setFechaIngreso(vista.Utilidades.Utilidades.obtenerFechaFormateada(dateDisponibilidadDesde.getDate()));
        //aux.setFechaIngreso(dateDisponibilidadDesde.getDate().toString());
        aux.setFechaSalida(vista.Utilidades.Utilidades.obtenerFechaFormateada(dateDisponibilidadHasta.getDate()));
//        aux.setFechaSalida(dateDisponibilidadHasta.getDate().toString());
        

        try {
            listaPropiedades.modificarPoscicion(aux, aux.getId()-1);
            Utilidades.guardarPropiedades(listaPropiedades);
        } catch (IOException ex) {
            Logger.getLogger(Frmservicio.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            propiedadDao.modificar(aux, aux.getId());
//            propiedadDao.listar();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

    }
    
   
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        lblnroprodiedad = new javax.swing.JLabel();
        lblbanios = new javax.swing.JLabel();
        lblhuespedes = new javax.swing.JLabel();
        lblrecamaras = new javax.swing.JLabel();
        lblcamas = new javax.swing.JLabel();
        lbltipopropiedad = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoPropiedad = new javax.swing.JComboBox<>();
        spinHuespedes = new javax.swing.JSpinner();
        txtNumeroPropiedad = new javax.swing.JTextField();
        spinHabitaciones = new javax.swing.JSpinner();
        spinCamas = new javax.swing.JSpinner();
        spinBanios = new javax.swing.JSpinner();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblDisponibilidad = new javax.swing.JLabel();
        txtNombrePropiedad = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblDisponibilidad1 = new javax.swing.JLabel();
        dateDisponibilidadDesde = new com.toedter.calendar.JDateChooser();
        dateDisponibilidadHasta = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDescripcion.setText("Descripcion:");

        lblnroprodiedad.setText("Numero de Propiedad:");

        lblbanios.setText("Baños");

        lblhuespedes.setText("Huespedes");

        lblrecamaras.setText("Habitaciones");

        lblcamas.setText("Camas");

        lbltipopropiedad.setText("Tipo de Propiedad: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Datos Propiedad");

        cbxTipoPropiedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vivienda", "Finca", "Departamento"}));
        cbxTipoPropiedad.setSelectedItem(null);

        spinHuespedes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinHuespedes.setEditor(new javax.swing.JSpinner.NumberEditor(spinHuespedes, ""));
        spinHuespedes.setRequestFocusEnabled(false);

        txtNumeroPropiedad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroPropiedadActionPerformed(evt);
            }
        });

        spinHabitaciones.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spinCamas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinBanios.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblPrecio.setText("Precio por noche:");

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        lblDisponibilidad.setText("Entrada ");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtNombrePropiedad.setViewportView(txtDescripcion);

        lblDisponibilidad1.setText("Salida");

        dateDisponibilidadDesde.setMinSelectableDate(new java.util.Date(-62135747885000L));
        dateDisponibilidadDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDisponibilidadDesdePropertyChange(evt);
            }
        });

        dateDisponibilidadHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDisponibilidadHastaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDisponibilidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblrecamaras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblhuespedes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblDisponibilidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcamas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblbanios, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrecio))))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinHuespedes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinBanios, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinCamas, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinHabitaciones, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateDisponibilidadDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateDisponibilidadHasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbltipopropiedad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblnroprodiedad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombrePropiedad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cbxTipoPropiedad, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE)
                            .addComponent(txtNumeroPropiedad))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipopropiedad)
                    .addComponent(cbxTipoPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnroprodiedad)
                            .addComponent(txtNumeroPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhuespedes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblrecamaras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcamas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinBanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbanios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateDisponibilidadDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisponibilidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateDisponibilidadHasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDisponibilidad1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar)
                        .addGap(30, 30, 30)
                        .addComponent(btnSiguiente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegresar)
                    .addComponent(btnSiguiente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroPropiedadActionPerformed

    }//GEN-LAST:event_txtNumeroPropiedadActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmDescripcionPropiedad Propiedadprincipal = new FrmDescripcionPropiedad();
        Propiedadprincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Frmservicio servicio = new Frmservicio(aux.getId());
        servicio.setVisible(true);
        //this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int Huesped = (int)spinHuespedes.getValue();
        int Habitacio = (int)spinHabitaciones.getValue();
        int Camas = (int)spinCamas.getValue();
        int Banos = (int)spinBanios.getValue();
        if(cbxTipoPropiedad.getSelectedItem()==null || txtDescripcion.getText().isEmpty()
            || txtNumeroPropiedad.getText().isEmpty() || txtPrecio.getText().isEmpty()
            || Huesped == 0 || Habitacio== 0|| Camas== 0||Banos== 0){//|| dateDisponibilidadDesde.getDate()==null || dateDisponibilidadHasta.getDate()==null){
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }else{
            guardarDATOS();
            FrmPropiedadImagen btndireccion = new FrmPropiedadImagen(aux.getId());
            btndireccion.setVisible(true);
            this.setVisible(false); 
          
        }
        

        //        System.out.println(""+dateDisponibilidadDesde.getDate().toString());
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void dateDisponibilidadDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDisponibilidadDesdePropertyChange
        Date fechaActual=new Date();
        if (dateDisponibilidadDesde.getDate()!=null) {
            if (dateDisponibilidadDesde.getDate().before(fechaActual)) {
                JOptionPane.showMessageDialog(null, "La fecha debe ser mayor a la actual","Error",JOptionPane.ERROR_MESSAGE);
                dateDisponibilidadDesde.setDate(null);
            }
        }
    }//GEN-LAST:event_dateDisponibilidadDesdePropertyChange

    private void dateDisponibilidadHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDisponibilidadHastaPropertyChange
        Date fechaActual=new Date();
        if (dateDisponibilidadHasta.getDate()!=null) {
            if (dateDisponibilidadHasta.getDate().before(fechaActual)) {
                JOptionPane.showMessageDialog(null, "La fecha debe ser mayor a la actual","Error",JOptionPane.ERROR_MESSAGE);
                dateDisponibilidadHasta.setDate(null);
            }
        }
    }//GEN-LAST:event_dateDisponibilidadHastaPropertyChange

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
            java.util.logging.Logger.getLogger(FrmIngresoPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIngresoPropiedad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    public static javax.swing.JComboBox<String> cbxTipoPropiedad;
    public static com.toedter.calendar.JDateChooser dateDisponibilidadDesde;
    public static com.toedter.calendar.JDateChooser dateDisponibilidadHasta;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblDisponibilidad1;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblbanios;
    private javax.swing.JLabel lblcamas;
    private javax.swing.JLabel lblhuespedes;
    private javax.swing.JLabel lblnroprodiedad;
    private javax.swing.JLabel lblrecamaras;
    private javax.swing.JLabel lbltipopropiedad;
    public static javax.swing.JSpinner spinBanios;
    public static javax.swing.JSpinner spinCamas;
    public static javax.swing.JSpinner spinHabitaciones;
    public static javax.swing.JSpinner spinHuespedes;
    public static javax.swing.JTextArea txtDescripcion;
    private javax.swing.JScrollPane txtNombrePropiedad;
    public static javax.swing.JTextField txtNumeroPropiedad;
    public static javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    
}
