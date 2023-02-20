/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.CuentaDAO;
import controlador.CuentasController;
import controlador.QuickSort.MetodoQuickSort;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.loginExcepciones.cedulaNovalidaException;
import controlador.loginExcepciones.contraseniaNoCoincideException;
import controlador.loginExcepciones.correoNoValidoException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import modelo.Persona;
import modelo.Rol;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import vista.Utilidades.Utilidades;

/**
 *
 * @author LENOVO
 */
public class FrmRegistro extends javax.swing.JDialog {

    private static CuentaDAO cuentadao = new CuentaDAO();
    private CuentasController cc = new CuentasController();

    /**
     * Creates new form JdialogRegistro
     */
    public FrmRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombos();
        cargarJSon();
        setLocationRelativeTo(this);
    }

    /**
     * Cargar el combo con el tipo de identificacion
     */
    private void cargarCombos() {
        Utilidades.cargarTipoIndentificacion(cbxIndentificacion);
    }

    /**
     * Actualizar los campos de la interfaz de registro
     */
    private void actualizarCamposRegistro() {
        cargarCombos();
        cbxIndentificacion.setForeground(Color.gray);
        txtUsuario.setText("Ingrese su nombre de Usuario");
        txtUsuario.setForeground(Color.gray);
        txtNombreR.setText("Ingrese su nombre");
        txtNombreR.setForeground(Color.gray);
        txtApellidoR.setText("Ingrese su apellido");
        txtApellidoR.setForeground(Color.gray);
        txtFechaNac.setText("dd/MM/aaaa");
        txtFechaNac.setForeground(Color.gray);
        txtIndentificacionR.setText("Ingrese su identificación");
        txtIndentificacionR.setForeground(Color.gray);
        txtCont.setText("Contrasenia");
        txtCont.setForeground(Color.gray);
        txtCont1.setText("Contrasenia");
        txtCont1.setForeground(Color.gray);
        txtCorreoR.setText("Ingrese su correo");
        txtCorreoR.setForeground(Color.gray);

    }

    /**
     * Compara los campos de cuenta y usuario
     *
     * @return boolean
     */
    public Boolean compararCampos() {
        Boolean valido = true;
        if (txtUsuario.getText().equals("Ingrese su nombre de Usuario")
                && txtNombreR.getText().equals("Ingrese su nombre")
                && txtApellidoR.getText().equals("Ingrese su apellido")
                && txtFechaNac.getText().equals("dd/MM/aaaa")
                && txtIndentificacionR.getText().equals("Ingrese su identificación")
                && txtCont.getText().equals("Contrasenia")
                && txtCont1.getText().equals("Contrasenia")
                && txtCorreoR.getText().equals("Ingrese su correo")) {
            valido = false;
        }
        return valido;
    }

    /**
     * Comprabar que la cedula ingresada sea valida
     *
     * @return boolean
     * @throws cedulaNovalidaException
     */
    private Boolean validarCedula() throws cedulaNovalidaException {
        Boolean verificar = false;
        if (cbxIndentificacion.getSelectedItem().toString().equalsIgnoreCase("PASAPORTE")) {
            verificar = true;
        } else if (!(cbxIndentificacion.getSelectedItem().toString().equalsIgnoreCase("PASAPORTE"))
                && Utilidades.validadorDeCedula(txtIndentificacionR.getText())) {
            verificar = true;
        } else {
            verificar = false;
            JOptionPane.showMessageDialog(null, "Cedula no válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return verificar;
    }

    /**
     * Comprobar si los campos estan compleatados
     *
     * @return boolean
     */
    private Boolean campoCompletado() {
        Boolean vacio = false;
        if (!txtUsuario.getText().isEmpty()
                && !txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty()
                && !txtFechaNac.getText().isEmpty() && !txtIndentificacionR.getText().isEmpty()
                && !txtCont.getText().isEmpty() && !txtCont1.getText().isEmpty()
                && !txtCorreoR.getText().isEmpty()) {
            vacio = true;
        }
        return vacio;
    }


    /**
     * Ordena las cuentas en orden ascedente con el atributo de "usuario"
     * @return boolean
     * @throws IllegalAccessException
     * @throws AtributoNoEncontradoException 
     */
    private Boolean ordenarCuentas() throws IllegalAccessException, AtributoNoEncontradoException {
        try {
            MetodoQuickSort mqs = new MetodoQuickSort();
            cc.getCuentadao().setCuentas(mqs.quickSort(cc.getCuentadao().getCuentas(), "usuario", MetodoQuickSort.ASCENDENTE));
        } catch (IllegalAccessException | IllegalArgumentException | AtributoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }


    /**
     * Registrar una nueva cuenta con los datos que el usuario ingrese
     * @throws cedulaNovalidaException
     * @throws contraseniaNoCoincideException
     * @throws correoNoValidoException 
     */
    public void registrar() throws cedulaNovalidaException, contraseniaNoCoincideException, correoNoValidoException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (campoCompletado() && compararCampos()) {
            try {
                if (validarCedula()
                        && Utilidades.validarContrasenia(txtCont.getText(), txtCont1.getText())
                        && Utilidades.validarCorreo(txtCorreoR.getText())) {
                    Date dtf = formato.parse(txtFechaNac.getText().trim());
                    Persona personar = new Persona(cc.getCuentadao().getCuentas().getTamanio() + 1,
                            txtNombreR.getText(),
                            txtApellidoR.getText(), dtf, txtIndentificacionR.getText().trim(),
                            Utilidades.obtenerTipoIdentificacion(cbxIndentificacion),
                            true, txtCorreoR.getText());
                    Cuenta cuenta = new Cuenta(txtUsuario.getText().trim(), Utilidades.encriptarContrasenia(txtCont.getText().trim()), personar, generarId(), true, Rol.USUARIO);
                    if (cc.insertar(cuenta)) {
                        ordenarCuentas();
                        actualizarCamposRegistro();
                        JOptionPane.showMessageDialog(this, "El usuario se ha registrado de manera correcta", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(this, "El usuario ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor rellene los campos", "Error", JOptionPane.ERROR_MESSAGE);
            actualizarCamposRegistro();
        }
    }
    
    
    /**
     * Genera un id para la nueva cuenta a registrar
     * @return Integer
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException 
     */
    private Integer generarId() throws ListaVaciaException, PosicionNoEncontradaException{
        Integer id = new Integer(0);
        
        for (int i = 0; i < cc.getCuentadao().getCuentas().getTamanio(); i++) {
            if (id < cc.getCuentadao().getCuentas().obtener(i).getId()) {
                id = cc.getCuentadao().getCuentas().obtener(i).getId();
            }
        }
        id++;
        return id;
    }


    /**
     * Modificar las cuentas del usuario, solo para administradores
     * @throws AtributoNoEncontradoException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws Exception 
     */
    public void modificar() throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException, Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (!txtUsuario.getText().isEmpty()
                && !txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty()
                && !txtFechaNac.getText().isEmpty() && !txtIndentificacionR.getText().isEmpty()
                && !txtCont.getText().isEmpty() && !txtCont1.getText().isEmpty()
                && !txtCorreoR.getText().isEmpty()) {
            try {
                Date dtf = formato.parse(txtFechaNac.getText());
                Persona personar = new Persona(cc.getCuentadao().getCuentas().getTamanio() + 1, txtNombreR.getText(),
                        txtApellidoR.getText(), dtf, txtIndentificacionR.getText(),
                        Utilidades.obtenerTipoIdentificacion(cbxIndentificacion),
                        true, txtCorreoR.getText());

                Cuenta cuenta = new Cuenta(txtUsuario.getText(), txtCont.getText(), personar, cc.getCuentadao().getCuentas().getTamanio() + 1, true, Rol.USUARIO);
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

 
    
    /**
     * Eliminar cuentas de usuario, solo para administradores
     * @throws AtributoNoEncontradoException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    public void eliminar() throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException {
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

    /**
     * Carga los usuarios que han sido registrados y guardados en un archivo
     * tipo .json
     */
    private void cargarJSon() {
        try {
            CuentaDAO cd = new CuentaDAO();
            cd = Utilidades.cargarJson();
            cc.setCuentadao(cd);

        } catch (Exception e) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        txtCont = new javax.swing.JPasswordField();
        chkMostrarContrasenia = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtCont1 = new javax.swing.JPasswordField();
        jSeparator11 = new javax.swing.JSeparator();
        chkMostrarContrasenia1 = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();

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
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

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
        txtNombreR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRKeyTyped(evt);
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
        txtApellidoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoRKeyTyped(evt);
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
        txtFechaNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaNacKeyTyped(evt);
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
        txtIndentificacionR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndentificacionRKeyTyped(evt);
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
        cbxIndentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxIndentificacionMousePressed(evt);
            }
        });
        jPanel1.add(cbxIndentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 240, -1));

        txtCont.setBackground(new java.awt.Color(255, 255, 255));
        txtCont.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCont.setForeground(new java.awt.Color(153, 153, 153));
        txtCont.setText("Contrasenia");
        txtCont.setBorder(null);
        txtCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContMousePressed(evt);
            }
        });
        jPanel1.add(txtCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 240, -1));

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

        txtCont1.setBackground(new java.awt.Color(255, 255, 255));
        txtCont1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCont1.setForeground(new java.awt.Color(153, 153, 153));
        txtCont1.setText("Contrasenia");
        txtCont1.setBorder(null);
        txtCont1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCont1MousePressed(evt);
            }
        });
        jPanel1.add(txtCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 240, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 240, 10));

        chkMostrarContrasenia1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkMostrarContrasenia1.setText("Mostrar Contraseña");
        chkMostrarContrasenia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContrasenia1ActionPerformed(evt);
            }
        });
        jPanel1.add(chkMostrarContrasenia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(30, 99, 208));
        btnRegistrar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 100, -1));

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

        btnAtras.setBackground(new java.awt.Color(30, 99, 208));
        btnAtras.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoRActionPerformed

    private void txtIndentificacionRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndentificacionRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndentificacionRActionPerformed

    private void txtContMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContMousePressed
        if (txtCont.getText().equalsIgnoreCase("Contrasenia")) {
            txtCont.setText("");
            txtCont.setForeground(Color.BLACK);
        }


    }//GEN-LAST:event_txtContMousePressed

    private void txtNombreRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreRMousePressed
        if (txtNombreR.getText().equals("Ingrese su nombre")) {
            txtNombreR.setText("");
            txtNombreR.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtNombreRMousePressed

    private void txtApellidoRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoRMousePressed
        if (txtApellidoR.getText().equals("Ingrese su apellido")) {
            txtApellidoR.setText("");
            txtApellidoR.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtApellidoRMousePressed

    private void txtFechaNacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacMousePressed

        if (txtFechaNac.getText().equals("dd/MM/aaaa")) {
            txtFechaNac.setText("");
            txtFechaNac.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtFechaNacMousePressed

    private void txtIndentificacionRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIndentificacionRMousePressed
        if (txtIndentificacionR.getText().equals("Ingrese su identificación")) {
            txtIndentificacionR.setText("");
            txtIndentificacionR.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtIndentificacionRMousePressed

    private void txtCorreoRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoRMousePressed
        if (txtCorreoR.getText().equals("Ingrese su correo")) {
            txtCorreoR.setText("");
            txtCorreoR.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtCorreoRMousePressed

    private void chkMostrarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContraseniaActionPerformed
        if (chkMostrarContrasenia.isSelected()) {
            txtCont.setEchoChar((char) 0);
        } else {
            txtCont.setEchoChar('*');

        }
    }//GEN-LAST:event_chkMostrarContraseniaActionPerformed

    private void txtCont1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCont1MousePressed
        if (txtCont1.getText().equals("Contrasenia")) {
            txtCont1.setText("");
            txtCont1.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtCont1MousePressed

    private void chkMostrarContrasenia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContrasenia1ActionPerformed
        if (chkMostrarContrasenia1.isSelected()) {
            txtCont1.setEchoChar((char) 0);
        } else {
            txtCont1.setEchoChar('*');

        }
    }//GEN-LAST:event_chkMostrarContrasenia1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            registrar();
            Utilidades.guardar(cc.getCuentadao());
        } catch (cedulaNovalidaException | contraseniaNoCoincideException | correoNoValidoException | IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su nombre de Usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtUsuarioMousePressed

    private void cbxIndentificacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxIndentificacionMousePressed
        cbxIndentificacion.setForeground(Color.black);
    }//GEN-LAST:event_cbxIndentificacionMousePressed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtNombreRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtNombreRKeyTyped

    private void txtApellidoRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoRKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtApellidoRKeyTyped

    private void txtFechaNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtFechaNacKeyTyped

    private void txtIndentificacionRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndentificacionRKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtIndentificacionRKeyTyped

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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistro dialog = new FrmRegistro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxIndentificacion;
    private javax.swing.JCheckBox chkMostrarContrasenia;
    private javax.swing.JCheckBox chkMostrarContrasenia1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField txtApellidoR;
    private javax.swing.JPasswordField txtCont;
    private javax.swing.JPasswordField txtCont1;
    private javax.swing.JTextField txtCorreoR;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtIndentificacionR;
    private javax.swing.JTextField txtNombreR;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
