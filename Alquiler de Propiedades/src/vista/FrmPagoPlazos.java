/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.listas.ListaEnlazada;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Propiedad;
import vista.Utilidades.Utilidades;

/**
 *
 * @author Dennys
 */
public class FrmPagoPlazos extends javax.swing.JFrame {

    Propiedad aux = new Propiedad();
    private ListaEnlazada<Propiedad> listaPropiedades;
    FrmPagos fpagos = new FrmPagos();
    public static Boolean verificador;

    /**
     * Creates new form FrmPagoPlazos
     */
    public FrmPagoPlazos() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        cargarDatos();
        cambiarColorBtn();
        this.setLocationRelativeTo(null);
    }

    /**
     * Crea un nuevo FrmPagoPlazos con un id para hacer referencia al Pago
     * guardado en especifico
     * @param id
     */
    public FrmPagoPlazos(Integer id) {
        try {
            listaPropiedades = Utilidades.cargarPropiedades();
            aux = listaPropiedades.obtener(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        cargarDatos();
        cambiarColorBtn();
        this.setLocationRelativeTo(null);
    }

    /**
     * Crea un nuevo FrmPagoPlazos con un id para hacer referencia al Pago
     * guardado en especifico
     */
    public void cambiarColorBtn() {
        if (verificador != null) {
            if (verificador) {
                BtnAgregarMetodoDePago.setBackground(new Color(121, 189, 154));
            }
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
        BtnAgregarMetodoDePago = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxMesesPlazo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPagoPorMes = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateFechaPagoTotal = new com.toedter.calendar.JDateChooser();
        txtDiaDePago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 310));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion a Plazos"));
        jPanel1.setMinimumSize(new java.awt.Dimension(580, 300));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Selección a Plazos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 20, 290, 28);

        BtnAgregarMetodoDePago.setText("Agregar Método de Pago");
        BtnAgregarMetodoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMetodoDePagoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregarMetodoDePago);
        BtnAgregarMetodoDePago.setBounds(21, 66, 190, 33);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Total:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 70, 60, 25);
        jPanel1.add(txtTotal);
        txtTotal.setBounds(350, 70, 100, 30);

        jLabel3.setText("Seleccione los meses plazo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(21, 120, 160, 16);

        cbxMesesPlazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMesesPlazo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMesesPlazoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxMesesPlazo);
        cbxMesesPlazo.setBounds(180, 110, 80, 30);

        jLabel4.setText("Pago por mes:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 160, 90, 16);
        jPanel1.add(txtPagoPorMes);
        txtPagoPorMes.setBounds(110, 160, 150, 30);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(180, 200, 96, 49);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(300, 200, 100, 49);

        jLabel5.setText("Día de pago mensual:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 120, 150, 16);

        jLabel6.setText("Fecha esperada de pago total:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 160, 190, 16);
        jPanel1.add(dateFechaPagoTotal);
        dateFechaPagoTotal.setBounds(450, 160, 140, 30);
        jPanel1.add(txtDiaDePago);
        txtDiaDePago.setBounds(450, 110, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarMetodoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMetodoDePagoActionPerformed
        cambiarColorBtn();
        Color fondo = new Color(121, 189, 154);
        Color aux = BtnAgregarMetodoDePago.getBackground();
        if (aux.toString().equalsIgnoreCase(fondo.toString())) {
            JOptionPane.showMessageDialog(null, "Metodo de Pago ya seleccionado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            fpagos.setAlwaysOnTop(true);
            fpagos.setVisible(true);
            fpagos.toFront();
        }
    }//GEN-LAST:event_BtnAgregarMetodoDePagoActionPerformed

    private void cbxMesesPlazoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMesesPlazoItemStateChanged
        dateFechaPagoTotal.setDate(Utilidades.calcularFechaDePagoMaximo(Integer.valueOf(cbxMesesPlazo.getSelectedItem().toString())));
        System.out.println(aux.getPrecio());
        System.out.println(aux.getContrato().getNroDias());
        txtPagoPorMes.setText(String.valueOf(Utilidades.calcularValorCuota(0.12, Double.valueOf(aux.getPrecio()) * aux.getContrato().getNroDias(), Integer.valueOf(cbxMesesPlazo.getSelectedItem().toString()))));
    }//GEN-LAST:event_cbxMesesPlazoItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (verificador != null) {
            if (verificador) {
                JOptionPane.showMessageDialog(null, "TODO CORRECTO", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                guardarDatosPago();
            } else {
                JOptionPane.showMessageDialog(null, "Vuelva a Intentar el pago por Favor", "Atencion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes Seleccione un Método de Pago", "Atencion", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Permite cargar los datos del pago seleccionado en especifico
     */
    public void cargarDatos() {
        txtTotal.setText(Double.valueOf(aux.getPrecio()) * aux.getContrato().getNroDias() + "");
        txtDiaDePago.setText("Día " + Utilidades.calcularFechaDePago() + " de cada mes");
        txtDiaDePago.setEnabled(false);
        dateFechaPagoTotal.setEnabled(false);
        txtTotal.setEnabled(false);
        txtPagoPorMes.setEnabled(false);
    }

    /**
     * Permite guardar los datos del pago seleccionado en especifico
     */
    private void guardarDatosPago() {
        try {
            aux.getContrato().getPago().setMesesPlazo(Integer.valueOf(cbxMesesPlazo.getSelectedItem().toString()));
            aux.getContrato().getPago().setCuotaPorMes(Double.valueOf(txtPagoPorMes.getText()));
//            System.out.println(cont);
//            aux.setContrato(cont);
            System.out.println(aux.getContrato());
            listaPropiedades.modificarPoscicion(aux, aux.getId()-1);
            Utilidades.guardarPropiedades(listaPropiedades);
        } catch (Exception e) {
            System.out.println(e);
        }
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
            java.util.logging.Logger.getLogger(FrmPagoPlazos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPagoPlazos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPagoPlazos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPagoPlazos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPagoPlazos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMetodoDePago;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbxMesesPlazo;
    private com.toedter.calendar.JDateChooser dateFechaPagoTotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDiaDePago;
    private javax.swing.JTextField txtPagoPorMes;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
