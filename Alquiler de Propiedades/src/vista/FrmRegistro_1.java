/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.CuentaDAO;
import controlador.CuentasController;
import controlador.listas.ListaEnlazada;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import modelo.Persona;
import vista.Utilidades.Utilidades;

/**
 *
 * @author LENOVO
 */
public class FrmRegistro_1 extends javax.swing.JDialog {

    private ListaEnlazada<Cuenta> cuentas = new ListaEnlazada<>();
    private CuentasController cc = new CuentasController();
    private static CuentaDAO cuentadao = new CuentaDAO();

    /**
     * Creates new form JdialogRegistro
     */
    public FrmRegistro_1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombos();
        setLocationRelativeTo(this);
    }

    private void cargarCombos() {
        Utilidades.cargarTipoIndentificacion(cbxIndentificacion);
    }

    private void limpiar() {
        cargarCombos();

        txtIdR.setText("");
        txtUsuario.setText("");
        txtNombreR.setText("");
        txtApellidoR.setText("");
        txtFechaNac.setText("");
        txtIndentificacionR.setText("");
        txtContraseniaR.setText("");
        txtContraseniaR1.setText("");
        txtCorreoR.setText("");
        txtEstadoCuenR.setText("");
        txtEstadoPerR.setText("");

    }

    public void registrar() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (!txtIdR.getText().isEmpty() && !txtUsuario.getText().isEmpty()
                && !txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty()
                && !txtFechaNac.getText().isEmpty() && !txtIndentificacionR.getText().isEmpty()
                && !txtContraseniaR.getText().isEmpty() && !txtContraseniaR1.getText().isEmpty()
                && !txtCorreoR.getText().isEmpty() && !txtEstadoCuenR.getText().isEmpty()
                && !txtEstadoPerR.getText().isEmpty()) {
            try {
                Date dtf = formato.parse(txtFechaNac.getText());
                Persona personar = new Persona(Integer.valueOf(txtIdR.getText()), txtNombreR.getText(),
                        txtApellidoR.getText(), dtf, txtIndentificacionR.getText(),
                        Utilidades.obtenerTipoIdentificacion(cbxIndentificacion),
                        true, txtCorreoR.getText());

                Cuenta cuenta = new Cuenta(txtUsuario.getText(), txtContraseniaR.getText(), personar, Integer.valueOf(txtIdR.getText()), true);
                if (CuentasController.insertar(cuenta)) {
                    JOptionPane.showMessageDialog(this, "El usuario se ha registrado de manera correcta", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ListaVaciaException | PosicionNoEncontradaException | NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "?????", JOptionPane.ERROR_MESSAGE);

            }
        }
        

    }

    public void modificar() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (!txtIdR.getText().isEmpty() && !txtUsuario.getText().isEmpty()
                && !txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty()
                && !txtFechaNac.getText().isEmpty() && !txtIndentificacionR.getText().isEmpty()
                && !txtContraseniaR.getText().isEmpty() && !txtContraseniaR1.getText().isEmpty()
                && !txtCorreoR.getText().isEmpty() && !txtEstadoCuenR.getText().isEmpty()
                && !txtEstadoPerR.getText().isEmpty()) {
            try {
                Date dtf = formato.parse(txtFechaNac.getText());
                Persona personar = new Persona(Integer.valueOf(txtIdR.getText()), txtNombreR.getText(),
                        txtApellidoR.getText(), dtf, txtIndentificacionR.getText(),
                        Utilidades.obtenerTipoIdentificacion(cbxIndentificacion),
                        true, txtCorreoR.getText());

                Cuenta cuenta = new Cuenta(txtUsuario.getText(), txtContraseniaR.getText(), personar, Integer.valueOf(txtIdR.getText()), true);
                if (CuentasController.modificar(cuenta)) {
                    JOptionPane.showMessageDialog(this, "El usuario se ha modificado de manera correcta", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ListaVaciaException | PosicionNoEncontradaException | NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "?????", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void eliminar() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (!txtUsuario.getText().isEmpty()) {

            try {
                if (CuentasController.eliminar(txtUsuario.getText())) {
                    JOptionPane.showMessageDialog(this, "El usuario ha sido eliminado de manera correcta", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El usuario no se ha podido eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ListaVaciaException | PosicionNoEncontradaException | HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "?????", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    public void guardarjson() {


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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtIdR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreR = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtApellidoR = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIndentificacionR = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtCorreoR = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        cbxIndentificacion = new javax.swing.JComboBox<>();
        txtContraseniaR = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txtEstadoCuenR = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txtEstadoPerR = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        chkMostrarContrasenia = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtContraseniaR1 = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        chkMostrarContrasenia1 = new javax.swing.JCheckBox();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("AIRBNB");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("REGISTRO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 240, 10));

        txtIdR.setBackground(new java.awt.Color(255, 255, 255));
        txtIdR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdR.setForeground(new java.awt.Color(153, 153, 153));
        txtIdR.setText("Ingrese su ID");
        txtIdR.setBorder(null);
        txtIdR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdRMousePressed(evt);
            }
        });
        jPanel1.add(txtIdR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 210, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtNombreR.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreR.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreR.setText("Ingrese su nombre");
        txtNombreR.setBorder(null);
        txtNombreR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreRMousePressed(evt);
            }
        });
        jPanel1.add(txtNombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 210, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 240, 10));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("APELLIDO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        txtApellidoR.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellidoR.setForeground(new java.awt.Color(153, 153, 153));
        txtApellidoR.setText("Ingrese su apellido");
        txtApellidoR.setBorder(null);
        txtApellidoR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoRMousePressed(evt);
            }
        });
        txtApellidoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoRActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 210, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 240, 10));

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("FECHA NACIMIENTO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        txtFechaNac.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNac.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNac.setText("dd/MM/aaaa");
        txtFechaNac.setBorder(null);
        txtFechaNac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacMousePressed(evt);
            }
        });
        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 210, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 240, 10));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TIPO IDENTIFICACION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("IDENTIFICACION");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        txtIndentificacionR.setBackground(new java.awt.Color(255, 255, 255));
        txtIndentificacionR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIndentificacionR.setForeground(new java.awt.Color(153, 153, 153));
        txtIndentificacionR.setText("Ingrese su identificación");
        txtIndentificacionR.setBorder(null);
        txtIndentificacionR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIndentificacionRMousePressed(evt);
            }
        });
        txtIndentificacionR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndentificacionRActionPerformed(evt);
            }
        });
        jPanel1.add(txtIndentificacionR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 210, -1));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 240, 10));

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CONTRASEÑA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 240, 10));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CORREO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        txtCorreoR.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreoR.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreoR.setText("Ingrese su correo");
        txtCorreoR.setBorder(null);
        txtCorreoR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoRMousePressed(evt);
            }
        });
        jPanel1.add(txtCorreoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 210, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 240, 10));

        cbxIndentificacion.setBackground(new java.awt.Color(255, 255, 255));
        cbxIndentificacion.setForeground(new java.awt.Color(153, 153, 153));
        cbxIndentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxIndentificacion.setBorder(null);
        jPanel1.add(cbxIndentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 240, -1));

        txtContraseniaR.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseniaR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContraseniaR.setForeground(new java.awt.Color(153, 153, 153));
        txtContraseniaR.setText("Contrasenia");
        txtContraseniaR.setBorder(null);
        txtContraseniaR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseniaRMousePressed(evt);
            }
        });
        jPanel1.add(txtContraseniaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 240, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("ESTADO CUENTA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        txtEstadoCuenR.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoCuenR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEstadoCuenR.setForeground(new java.awt.Color(153, 153, 153));
        txtEstadoCuenR.setText("Ingrese el estado de cuenta");
        txtEstadoCuenR.setBorder(null);
        txtEstadoCuenR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEstadoCuenRMousePressed(evt);
            }
        });
        txtEstadoCuenR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoCuenRActionPerformed(evt);
            }
        });
        jPanel1.add(txtEstadoCuenR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 210, -1));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 240, 10));

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("ESTADO PERSONA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));

        txtEstadoPerR.setBackground(new java.awt.Color(255, 255, 255));
        txtEstadoPerR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEstadoPerR.setForeground(new java.awt.Color(153, 153, 153));
        txtEstadoPerR.setText("Ingrese el estado de persona");
        txtEstadoPerR.setBorder(null);
        txtEstadoPerR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEstadoPerRMousePressed(evt);
            }
        });
        txtEstadoPerR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoPerRActionPerformed(evt);
            }
        });
        jPanel1.add(txtEstadoPerR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 210, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 240, 10));

        chkMostrarContrasenia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkMostrarContrasenia.setText("Mostrar Contraseña");
        chkMostrarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(chkMostrarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("CONTRASEÑA");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        txtContraseniaR1.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseniaR1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContraseniaR1.setForeground(new java.awt.Color(153, 153, 153));
        txtContraseniaR1.setText("Contrasenia");
        txtContraseniaR1.setBorder(null);
        txtContraseniaR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseniaR1MousePressed(evt);
            }
        });
        jPanel1.add(txtContraseniaR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 240, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 240, 10));

        chkMostrarContrasenia1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkMostrarContrasenia1.setText("Mostrar Contraseña");
        chkMostrarContrasenia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContrasenia1ActionPerformed(evt);
            }
        });
        jPanel1.add(chkMostrarContrasenia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(30, 99, 208));
        btnEliminar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(30, 99, 208));
        btnRegistrar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, -1));

        btnModificar.setBackground(new java.awt.Color(30, 99, 208));
        btnModificar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USUARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 240, 10));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingrese su nombre de Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoRActionPerformed

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void txtIndentificacionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndentificacionRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndentificacionRActionPerformed

    private void txtContraseniaRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseniaRMousePressed
        txtContraseniaR.setText("");
        txtContraseniaR.setForeground(Color.BLACK);

    }//GEN-LAST:event_txtContraseniaRMousePressed

    private void txtIdRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdRMousePressed
        txtIdR.setText("");
        txtIdR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtIdRMousePressed

    private void txtNombreRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreRMousePressed
        txtNombreR.setText("");
        txtNombreR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNombreRMousePressed

    private void txtApellidoRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoRMousePressed
        txtApellidoR.setText("");
        txtApellidoR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtApellidoRMousePressed

    private void txtFechaNacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacMousePressed
        txtFechaNac.setText("");
        txtFechaNac.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtFechaNacMousePressed

    private void txtIndentificacionRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIndentificacionRMousePressed
        txtIndentificacionR.setText("");
        txtIndentificacionR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtIndentificacionRMousePressed

    private void txtCorreoRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoRMousePressed
        txtCorreoR.setText("");
        txtCorreoR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtCorreoRMousePressed

    private void chkMostrarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContraseniaActionPerformed
        if (chkMostrarContrasenia.isSelected()) {
            txtContraseniaR.setEchoChar((char) 0);
        } else {
            txtContraseniaR.setEchoChar('*');

        }
    }//GEN-LAST:event_chkMostrarContraseniaActionPerformed

    private void txtContraseniaR1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseniaR1MousePressed
        txtContraseniaR1.setText("");
        txtContraseniaR1.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtContraseniaR1MousePressed

    private void chkMostrarContrasenia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContrasenia1ActionPerformed
        if (chkMostrarContrasenia1.isSelected()) {
            txtContraseniaR1.setEchoChar((char) 0);
        } else {
            txtContraseniaR1.setEchoChar('*');

        }
    }//GEN-LAST:event_chkMostrarContrasenia1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrar();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        txtUsuario.setText("");
        txtUsuario.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtEstadoPerRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoPerRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoPerRActionPerformed

    private void txtEstadoPerRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEstadoPerRMousePressed
        txtEstadoPerR.setText("");
        txtEstadoPerR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtEstadoPerRMousePressed

    private void txtEstadoCuenRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoCuenRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoCuenRActionPerformed

    private void txtEstadoCuenRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEstadoCuenRMousePressed
        txtEstadoCuenR.setText("");
        txtEstadoCuenR.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtEstadoCuenRMousePressed

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
            java.util.logging.Logger.getLogger(FrmRegistro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistro_1 dialog = new FrmRegistro_1(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxIndentificacion;
    private javax.swing.JCheckBox chkMostrarContrasenia;
    private javax.swing.JCheckBox chkMostrarContrasenia1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtApellidoR;
    private javax.swing.JPasswordField txtContraseniaR;
    private javax.swing.JPasswordField txtContraseniaR1;
    private javax.swing.JTextField txtCorreoR;
    private javax.swing.JTextField txtEstadoCuenR;
    private javax.swing.JTextField txtEstadoPerR;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtIdR;
    private javax.swing.JTextField txtIndentificacionR;
    private javax.swing.JTextField txtNombreR;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
