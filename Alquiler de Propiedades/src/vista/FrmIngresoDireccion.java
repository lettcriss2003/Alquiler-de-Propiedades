/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PropiedadDao;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Propiedad;

/**
 *
 * @author lettc
 */
public class FrmIngresoDireccion extends javax.swing.JFrame {

    PropiedadDao propiedadDao = new PropiedadDao();
    Propiedad aux = new Propiedad();

    /**
     * Creates new form IngresoDireccion
     */
    public FrmIngresoDireccion() {
        // limpiar();
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        btnOk.requestFocus();
        cargarRestriciones();
    }
    
    /**
     * Guarda los datos inggresados
     */

    private void guardarDATOS() {

        propiedadDao.getPropiedad().setCiudad(txtCiudad.getText());
        propiedadDao.getPropiedad().setProvincia(txtProvincia.getText());
        propiedadDao.getPropiedad().setCalleP(txtCallePrincipal.getText());
        propiedadDao.getPropiedad().setCalleS(txtCalleSecundaria.getText());
        propiedadDao.getPropiedad().setCodigoP(txtCodigoPostal.getText());

    }

    /* private void limpiar(){
    txtCallePrincipal.setText("");
    txtCalleSecundaria.setText("");
    txtCiudad.setText("");
    txtCodigoPostal.setText("");
    txtProvincia.setText("");
    }
     */
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
        lblprovincia = new javax.swing.JLabel();
        lblciudad = new javax.swing.JLabel();
        lblcalleprincipal = new javax.swing.JLabel();
        lblcallesecundaria = new javax.swing.JLabel();
        lblcodigopostal = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtCalleSecundaria = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        txtCallePrincipal = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dirección");

        lblprovincia.setText("Ciudad");

        lblciudad.setText("Provincia");

        lblcalleprincipal.setText("Calle Principal:");

        lblcallesecundaria.setText("Calle Secundaria:");

        lblcodigopostal.setText("Codigo Postal:");

        txtCiudad.setBackground(null);
        txtCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        txtProvincia.setBackground(null);
        txtProvincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCalleSecundaria.setBackground(null);
        txtCalleSecundaria.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodigoPostal.setBackground(null);
        txtCodigoPostal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });

        txtCallePrincipal.setBackground(null);
        txtCallePrincipal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcalleprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcallesecundaria)
                            .addComponent(lblcodigopostal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(txtCiudad)
                            .addComponent(txtCodigoPostal)
                            .addComponent(txtCallePrincipal)
                            .addComponent(txtCalleSecundaria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprovincia)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblciudad)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcalleprincipal)
                    .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcallesecundaria)
                    .addComponent(txtCalleSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigopostal)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnOk.setText("SIGUIENTE");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegresar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        if (txtCiudad.getText().isEmpty() || txtProvincia.getText().isEmpty() || txtCallePrincipal.getText().isEmpty() || txtCalleSecundaria.getText().isEmpty() || txtCodigoPostal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
<<<<<<< HEAD
        }else{
            Frmservicio btndireccion = new Frmservicio();
        btndireccion.setVisible(true);
        this.setVisible(false);
=======
        } else {
            try {
                guardarDATOS();
                propiedadDao.guardar();
                if (propiedadDao.listar().getTamanio() == 0) {
                    aux=propiedadDao.obtenerPropiedad(0);
                    System.out.println(aux.getId());
                } else {
                    aux=propiedadDao.obtenerPropiedad(propiedadDao.listar().getTamanio()-1);
                    System.out.println(aux.getId());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
            Frmservicio btndireccion = new Frmservicio(aux.getId()+1);

            btndireccion.setVisible(true);
            this.setVisible(false);
>>>>>>> propiedad-contrato_Rojas
        }


    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmDescripcionPropiedad Propiedadprincipal = new FrmDescripcionPropiedad();
        Propiedadprincipal.setVisible(true);
        this.dispose();
//        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO Anadir your handling code here:
        FrmDescripcionPropiedad Propiedadprincipal = new FrmDescripcionPropiedad();
        Propiedadprincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed

    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO Anadir your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void cargarRestriciones() {
        vista.Utilidades.Utilidades.permitirSoloNumTxt(txtCodigoPostal);
        vista.Utilidades.Utilidades.permitirSoloLetrasTxt(txtCallePrincipal);
        vista.Utilidades.Utilidades.permitirSoloLetrasTxt(txtCalleSecundaria);
        vista.Utilidades.Utilidades.permitirSoloLetrasTxt(txtCiudad);
        vista.Utilidades.Utilidades.permitirSoloLetrasTxt(txtProvincia);

    }

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
            java.util.logging.Logger.getLogger(FrmIngresoDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIngresoDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIngresoDireccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcalleprincipal;
    private javax.swing.JLabel lblcallesecundaria;
    private javax.swing.JLabel lblciudad;
    private javax.swing.JLabel lblcodigopostal;
    private javax.swing.JLabel lblprovincia;
    public static javax.swing.JTextField txtCallePrincipal;
    public static javax.swing.JTextField txtCalleSecundaria;
    public static javax.swing.JTextField txtCiudad;
    public static javax.swing.JTextField txtCodigoPostal;
    public static javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables
}
