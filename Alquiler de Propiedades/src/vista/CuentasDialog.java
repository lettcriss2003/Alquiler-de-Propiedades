/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import busqueda.controlador.LinealBinaria.BusquedaLinealBinaria;
import controlador.CuentasController;
import controlador.QuickSort.MetodoQuickSort;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import vista.Modelo.ModeloTablaCuentas;
import vista.Utilidades.Utilidades;

/**
 *
 * @author leomah
 */
public class CuentasDialog extends javax.swing.JDialog {
    private ModeloTablaCuentas mtc = new ModeloTablaCuentas();
    private CuentasController cuentasController = new CuentasController();
    /**
     * Creates new form CuentasDialog
     */
    public CuentasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationByPlatform(true);
<<<<<<< HEAD
        cargarCuentas();
        cargarTabla(cuentasController);
    }
        
    private void cargarCuentas(){
        try {
            this.cuentasController = Utilidades.cargarCuentas();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
=======
//        cargarCuentas();
        cargarTabla();
    }
        
//    private void cargarCuentas(){
//        try {
//            this.cuentasList = Utilidades.cargarCuentas();
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
//            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
>>>>>>> propiedad-contrato_Rojas
    
    private void cargarTabla(CuentasController cc){
        mtc.setCc(cc);
        tblCuentas.setModel(mtc);
        tblCuentas.updateUI();
    }
    
    private void buscar() throws AtributoNoEncontradoException, IllegalArgumentException, ListaVaciaException, PosicionNoEncontradaException, IllegalAccessException{
        if (!txtBusqueda.getText().isEmpty() && (rbtnID.isSelected() || rbtnEstado.isSelected() || rbtnUsuario.isSelected())) {
            BusquedaLinealBinaria blb = new BusquedaLinealBinaria();
            CuentasController ccAux = new CuentasController();
            ListaEnlazada<Integer> posAux = new ListaEnlazada<>();
            if(rbtnID.isSelected()) {
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), Integer.parseInt(txtBusqueda.getText()), "ID");
            }else if (rbtnUsuario.isSelected()){
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), txtBusqueda.getText(), "usuario");
            }else if (txtBusqueda.getText().equalsIgnoreCase("activo")) {
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), true, "estado");
            }else{
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), false, "estado");
            }
            for (int i = 0; i < posAux.getTamanio(); i++) {
                ccAux.getCuentaslList().insertar(cuentasController.getCuentaslList().obtener(posAux.obtener(i)));
            }
            cargarTabla(ccAux);
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, brinde toda la información \nsolicitada para la búsqueda");
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

        rbtngBusqueda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        rbtnID = new javax.swing.JRadioButton();
        rbtnUsuario = new javax.swing.JRadioButton();
        rbtnEstado = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnGuardar = new javax.swing.JMenuItem();
        btnCargar = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        btnIdAscendente = new javax.swing.JMenuItem();
        btnIdDescendente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnUsuarioAscendente = new javax.swing.JMenuItem();
        btnUsuarioDescendente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnEstadoAscendente = new javax.swing.JMenuItem();
        btnEstadoDescendente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, -1, -1));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, -1, -1));

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCuentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 820, 380));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("CUENTAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Buscar:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel2.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 230, -1));

        rbtngBusqueda.add(rbtnID);
        rbtnID.setText("ID");
        rbtnID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnIDActionPerformed(evt);
            }
        });
        jPanel2.add(rbtnID, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        rbtngBusqueda.add(rbtnUsuario);
        rbtnUsuario.setText("Usuario");
        jPanel2.add(rbtnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        rbtngBusqueda.add(rbtnEstado);
        rbtnEstado.setText("Estado");
        jPanel2.add(rbtnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, 820, 90));

        jMenu1.setText("Archivo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCargar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ordenar");

        jMenu3.setText("ID");

        btnIdAscendente.setText("Ascendente");
        btnIdAscendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdAscendenteActionPerformed(evt);
            }
        });
        jMenu3.add(btnIdAscendente);

        btnIdDescendente.setText("Descendente");
        btnIdDescendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdDescendenteActionPerformed(evt);
            }
        });
        jMenu3.add(btnIdDescendente);

        jMenu2.add(jMenu3);

        jMenu4.setText("Usuario");

        btnUsuarioAscendente.setText("Ascendente");
        btnUsuarioAscendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioAscendenteActionPerformed(evt);
            }
        });
        jMenu4.add(btnUsuarioAscendente);

        btnUsuarioDescendente.setText("Descendente");
        btnUsuarioDescendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioDescendenteActionPerformed(evt);
            }
        });
        jMenu4.add(btnUsuarioDescendente);

        jMenu2.add(jMenu4);

        jMenu5.setText("Estado");

        btnEstadoAscendente.setText("Ascendente");
        btnEstadoAscendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoAscendenteActionPerformed(evt);
            }
        });
        jMenu5.add(btnEstadoAscendente);

        btnEstadoDescendente.setText("Descendente");
        btnEstadoDescendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoDescendenteActionPerformed(evt);
            }
        });
        jMenu5.add(btnEstadoDescendente);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
<<<<<<< HEAD
        try {
            // TODO add your handling code here:
            Utilidades.guardarCuentas(cuentasController);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
=======
//        try {
//            // TODO add your handling code here:
//            Utilidades.guardarCuentas(cuentasList);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }
>>>>>>> propiedad-contrato_Rojas
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (tblCuentas.getSelectedRow() >= 0) {
            CuentaDialog cd = new CuentaDialog(null, true, tblCuentas.getSelectedRow(), cuentasController);
            cd.setVisible(true);
            cargarCuentas();
            cargarTabla(cuentasController);
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un elemento");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        cargarCuentas();
        cargarTabla(cuentasController);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tblCuentas.getSelectedRow() >= 0) {
            try {
                cuentasController.getCuentaslList().eliminarPosicion(tblCuentas.getSelectedRow());
                Utilidades.guardarCuentas(cuentasController);
                cargarCuentas();
                cargarTabla(cuentasController);
            } catch (ListaVaciaException ex) {
                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un elemento");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        cargarCuentas();
        cargarTabla(cuentasController);
=======
//        cargarCuentas();
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        // TODO add your handling code here:
//        if (tblCuentas.getSelectedRow() >= 0) {
//            try {
//                cuentasList.eliminarPosicion(tblCuentas.getSelectedRow());
//                Utilidades.guardarCuentas(cuentasList);
//                cargarCuentas();
//                cargarTabla();
//            } catch (ListaVaciaException ex) {
//                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (PosicionNoEncontradaException ex) {
//                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            JOptionPane.showMessageDialog(this, "Seleccione un elemento");
//        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
//        cargarCuentas();
        cargarTabla();
>>>>>>> propiedad-contrato_Rojas
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnIdDescendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdDescendenteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "ID", MetodoQuickSort.DESCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIdDescendenteActionPerformed

    private void btnIdAscendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdAscendenteActionPerformed
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "ID", MetodoQuickSort.ASCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIdAscendenteActionPerformed

    private void btnUsuarioAscendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioAscendenteActionPerformed
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "usuario", MetodoQuickSort.ASCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuarioAscendenteActionPerformed

    private void btnUsuarioDescendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioDescendenteActionPerformed
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "usuario", MetodoQuickSort.DESCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuarioDescendenteActionPerformed

    private void btnEstadoAscendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoAscendenteActionPerformed
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "estado", MetodoQuickSort.DESCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEstadoAscendenteActionPerformed

    private void btnEstadoDescendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoDescendenteActionPerformed
        try {
            // TODO add your handling code here:
            MetodoQuickSort mqs = new MetodoQuickSort();
            cuentasController.setCuentaslList(mqs.quickSort(cuentasController.getCuentaslList(), "estado", MetodoQuickSort.ASCENDENTE));
            cargarTabla(cuentasController);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEstadoDescendenteActionPerformed

    private void rbtnIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnIDActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaVaciaException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CuentasDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(CuentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CuentasDialog dialog = new CuentasDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JCheckBoxMenuItem btnCargar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JMenuItem btnEstadoAscendente;
    private javax.swing.JMenuItem btnEstadoDescendente;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnIdAscendente;
    private javax.swing.JMenuItem btnIdDescendente;
    private javax.swing.JButton btnModificar;
    private javax.swing.JMenuItem btnUsuarioAscendente;
    private javax.swing.JMenuItem btnUsuarioDescendente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnEstado;
    private javax.swing.JRadioButton rbtnID;
    private javax.swing.JRadioButton rbtnUsuario;
    private javax.swing.ButtonGroup rbtngBusqueda;
    private javax.swing.JTable tblCuentas;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
