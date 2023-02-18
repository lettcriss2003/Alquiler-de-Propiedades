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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Propiedad;
import vista.Utilidades.Utilidades;

/**
 *
 * @author lettc
 */
public class FrmPropiedadImagen extends javax.swing.JFrame {

    PropiedadDao propiedadDao = new PropiedadDao();
    Propiedad aux = new Propiedad();
    Integer iterador = 0;
    private ListaEnlazada<Propiedad> listaPropiedades;
    public static ListaEnlazada<Propiedad> PropiedadDatos = new ListaEnlazada<>();

    /**
     * Creates new form FrmPropiedad
     */
    public FrmPropiedadImagen() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        btnSiguiente.requestFocus();
    }

    public FrmPropiedadImagen(Integer id) {
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
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        btnSiguiente.requestFocus();
    }

    /**
     * Carga las imagenes en los label
     */
    private void CargarImagen() {

        JFileChooser archivo = new JFileChooser();
        int seleccion = archivo.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = archivo.getSelectedFile();
            switch (iterador) {
                case 0:
                    aux.setImg(fichero.getAbsolutePath());
                    System.out.println(aux.getImg());
                    Utilidades.DefinirImagenLabel(lblImagenIcon, aux.getImg());
                    break;
                case 1:
                    aux.setImg1(fichero.getAbsolutePath());
                    Utilidades.DefinirImagenLabel(lblImagenIcon1, aux.getImg1());
                    break;
                case 2:
                    aux.setImg2(fichero.getAbsolutePath());
                    Utilidades.DefinirImagenLabel(lblImagenIcon2, aux.getImg2());
                    break;
                case 3:
                    aux.setImg3(fichero.getAbsolutePath());
                    Utilidades.DefinirImagenLabel(lblImagenIcon3, aux.getImg3());
                    break;
                case 4:
                    aux.setImg4(fichero.getAbsolutePath());
                    Utilidades.DefinirImagenLabel(lblImagenIcon4, aux.getImg4());
                    break;
                case 5:
                    aux.setImg5(fichero.getAbsolutePath());
                    Utilidades.DefinirImagenLabel(lblImagenIcon5, aux.getImg5());
                    break;
                default:
                    throw new AssertionError();
            }
            fichero = null;
        }

        iterador++;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagenIcon1 = new javax.swing.JLabel();
        lblImagenIcon2 = new javax.swing.JLabel();
        lblImagenIcon3 = new javax.swing.JLabel();
        lblImagenIcon = new javax.swing.JLabel();
        lblImagenIcon5 = new javax.swing.JLabel();
        lblImagenIcon4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnAgregarImg = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR IMAGEN DE PROPIEDAD");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblImagenIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagenIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagenIcon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagenIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagenIcon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblImagenIcon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblImagenIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblImagenIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImagenIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblImagenIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblImagenIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblImagenIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImagenIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagenIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
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

        btnAgregarImg.setText("AGREGAR IMAGEN");
        btnAgregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImgActionPerformed(evt);
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarImg)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente)
                        .addGap(12, 12, 12))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgregarImg)
                    .addComponent(btnSiguiente))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImgActionPerformed

        CargarImagen();
        
        try {
            listaPropiedades.modificarPoscicion(aux, aux.getId()-1);
            Utilidades.guardarPropiedades(listaPropiedades);
        } catch (IOException ex) {
            Logger.getLogger(Frmservicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        try {
//            propiedadDao.modificar(aux, aux.getId());
//
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_btnAgregarImgActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        FrmDescripcionPropiedad Propiedadprincipal = new FrmDescripcionPropiedad();
        Propiedadprincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO Anadir your handling code here:
        FrmIngresoPropiedad direccion = new FrmIngresoPropiedad(aux.getId());
        direccion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (aux.getImg() != null && aux.getImg1() != null && aux.getImg2() != null && aux.getImg3() != null && aux.getImg4() != null && aux.getImg5() != null) {
            JOptionPane.showMessageDialog(null, "Propiedad guardada");
            //FrmDescripcionPropiedad siguiente = new FrmDescripcionPropiedad();
            //siguiente.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Ingrese todas las imagenes para seguir con el ingreso de la propiedad", "Error", JOptionPane.ERROR_MESSAGE);
        }

//        
//        for (int i = 0; i < PropiedadDatos.getTamanio(); i++) {
//            System.out.println(PropiedadDatos.get(i) + " ");
//        }
//        
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPropiedadImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPropiedadImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPropiedadImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPropiedadImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPropiedadImagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImg;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblImagenIcon;
    private javax.swing.JLabel lblImagenIcon1;
    private javax.swing.JLabel lblImagenIcon2;
    private javax.swing.JLabel lblImagenIcon3;
    private javax.swing.JLabel lblImagenIcon4;
    private javax.swing.JLabel lblImagenIcon5;
    // End of variables declaration//GEN-END:variables
}
