/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CuentaDAO;
import controlador.CuentasController;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.loginExcepciones.datoIncorrectoException;
import controlador.loginExcepciones.intentoExcedidoException;
import controlador.loginExcepciones.usuarioNoExisteException;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import vista.Utilidades.Utilidades;

/**
 *
 * @author LENOVO
 */
public class FrmLogin extends javax.swing.JFrame {

    public CuentasController cc;

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        cargarJSon();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/favicon.png")).getImage());
        setLocationRelativeTo(null);
        //cc.getCuentadao().getCuentas().imprimir();
        ///cc.getCuentaslList().imprimir();
        //System.out.println();
    }

    /**
     * Carga el campo de contraseña a predeterminado
     */
    
    private void cargarCampoC() {
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(Color.gray);
        }
        if (String.valueOf(txtContrasenia.getPassword()).equals("Contrasenia")) {
            txtContrasenia.setText("");
            txtContrasenia.setForeground(Color.black);
        }
    }

    /**
     * Carga el campo de usuario a predeterminado
     */
    private void cargarCampoU() {
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(txtContrasenia.getPassword()).isEmpty()) {
            txtContrasenia.setText("Contrasenia");
            txtContrasenia.setForeground(Color.gray);
        }
    }

    /**
     * Actualiza los campos de la interfaz de inicion de sesion de manera
     * predeterminada
     */
    
    public void actualizarCampos() {
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtContrasenia.setText("Contrasenia");
        txtUsuario.setForeground(Color.gray);
        txtContrasenia.setForeground(Color.gray);
    }


    /**
     * Compara los campos de usuario y contrasenia
     * @return  boolean
     */
    public Boolean compararCampos() {
        Boolean valido = true;
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")
                && String.valueOf(txtContrasenia.getPassword()).equals("Contrasenia")) {
            valido = false;
        }
        return valido;
    }

    /**
     * Validar si las credenciales son correctas para iniciar sesion
     * @throws intentoExcedidoException
     * @throws datoIncorrectoException
     * @throws usuarioNoExisteException
     * @throws AtributoNoEncontradoException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws Exception 
     */
    public void iniciarSesion() throws intentoExcedidoException, datoIncorrectoException, usuarioNoExisteException, AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException, ListaVaciaException, PosicionNoEncontradaException, Exception {
        if (!txtUsuario.getText().isEmpty() && !txtContrasenia.getText().isEmpty() && compararCampos()) {
            if (cc.autentificar(txtUsuario.getText().trim(), txtContrasenia.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Inicio de sesion exitoso", "Bienvendido", JOptionPane.INFORMATION_MESSAGE);
                FrmPrincipal frmPrincipal = new FrmPrincipal(cc.obtener(txtUsuario.getText().trim()));
                frmPrincipal.setVisible(true);

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene campos usuario y/o contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            actualizarCampos();
        }
    }

    /**
     * Carga los usuarios que han sido registrados y guardados en un archivo
     * tipo .json
     */
    
    private void cargarJSon() {
        try {
            CuentaDAO cd = Utilidades.cargarJson();
            this.cc = new CuentasController();
            cc.setCuentadao(cd);
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        chkMostrarContrasenia = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AIRBNB");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ALQUILER DE PROPIEDADES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 230, 20));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jlFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/CIUDAD.jpg"))); // NOI18N
        jPanel1.add(jlFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 230, 400));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 250, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 320, 10));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CONTRASEÑA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 320, 10));

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        txtContrasenia.setText("Contrasenia");
        txtContrasenia.setBorder(null);
        txtContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseniaMousePressed(evt);
            }
        });
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 320, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("AIRBNB");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        chkMostrarContrasenia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkMostrarContrasenia.setText("Mostrar Contraseña");
        chkMostrarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(chkMostrarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(153, 153, 153));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        btnIngresar.setBackground(new java.awt.Color(30, 99, 208));
        btnIngresar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Iniciar Sesión");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 320, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        FrmRegistro frmRegistro = new FrmRegistro(this, true);
        frmRegistro.setVisible(true);
        actualizarCampos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            cargarJSon();
            iniciarSesion();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void chkMostrarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContraseniaActionPerformed
        if (chkMostrarContrasenia.isSelected()) {
            txtContrasenia.setEchoChar((char) 0);
        } else {
            txtContrasenia.setEchoChar('*');
        }
    }//GEN-LAST:event_chkMostrarContraseniaActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        cargarCampoU();
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseniaMousePressed
        cargarCampoC();
    }//GEN-LAST:event_txtContraseniaMousePressed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox chkMostrarContrasenia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
