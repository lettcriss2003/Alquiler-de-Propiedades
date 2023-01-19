/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.CuentasController;
import controlador.listas.ListaEnlazada;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import vista.Utilidades.Utilidades;

/**
 *
 * @author leomah
 */
public class CuentaDialog extends javax.swing.JDialog {
    private CuentasController cuentaController = new CuentasController();
    private ListaEnlazada<CuentasController> cuentasList = new ListaEnlazada<>();
    private Integer posicion;

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public ListaEnlazada<CuentasController> getCuentasList() {
        return cuentasList;
    }

    public void setCuentasList(ListaEnlazada<CuentasController> cuentasList) {
        this.cuentasList = cuentasList;
    }

    public CuentasController getCuentaController() {
        return cuentaController;
    }

    public void setCuentaController(CuentasController cuentaController) {
        this.cuentaController = cuentaController;
    }

    /**
     * Creates new form CuentaDialog
     */
    public CuentaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationByPlatform(true);
    }
    
    public void cargarDatos(){
        if (cuentaController != null) {
            txtId.setText(String.valueOf(cuentaController.getCuenta().getId()));
            txtUsuario.setText(cuentaController.getCuenta().getUsuario());
            txtContrasenia.setText(cuentaController.getCuenta().getContrasenia());
            if (cuentaController.getCuenta().getEstado()) {
                rbtnSi.doClick();
            }else{
                rbtnNo.doClick();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        rbtnNo = new javax.swing.JRadioButton();
        rbtnSi = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Cuenta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 270, -1));
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 250, -1));

        jLabel4.setText("Activo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel5.setText("ID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 290, -1));

        buttonGroup1.add(rbtnNo);
        rbtnNo.setText("NO");
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        buttonGroup1.add(rbtnSi);
        rbtnSi.setText("SI");
        rbtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSiActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnNoActionPerformed

    private void rbtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnSiActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!txtId.getText().isEmpty() && !txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty() && (rbtnSi.isSelected() || rbtnNo.isSelected())) {
            Cuenta c = new Cuenta();
            c.setId(Integer.parseInt(txtId.getText()));
            c.setUsuario(txtUsuario.getText());
            c.setContrasenia(txtContrasenia.getText());
            if (rbtnSi.isSelected()) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            cuentaController.setCuenta(c);
            cuentasList.modificarPoscicion(cuentaController, posicion);
            try {
                Utilidades.guardarCuentas(cuentasList);
                JOptionPane.showMessageDialog(this, "Recuerde actualizar el listado");
                this.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CuentaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CuentaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuentaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuentaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuentaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CuentaDialog dialog = new CuentaDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnSi;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}