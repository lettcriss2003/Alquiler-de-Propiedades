/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilites;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.MetodoPago;

/**
 *
 * @author Dennys
 */
public class UtilidadesVista {
    public static void DefinirImagenLabel(JLabel label,String ruta){
        ImageIcon image=new ImageIcon(ruta);
        Icon icon=new ImageIcon( image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        label.repaint();
    }
    public static JComboBox cargarCombo(JComboBox combo){
        combo.removeAllItems();
        for(MetodoPago Metodo: MetodoPago.values()) {
            combo.addItem(Metodo);
        }
        return combo;
    }
    public static void InsertarPanel(JPanel panelPrincipal,JPanel panelSecundario){
        panelSecundario.setSize(641,290 );
        panelSecundario.setLocation(0, 0);
        
        //panelPrincipal
        panelPrincipal.removeAll();
        panelPrincipal.add(panelSecundario,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    public static void permitirSoloNumTxt(JTextField txt){
        txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c =e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
        }
    });
    }
    
    public static void permitirSoloLetrasTxt(JTextField txt){
            txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c =e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
        }
    });
    }
    
    public static void limitarTamanioTxt(JTextField txt,Integer tamanio){
            txt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if (txt.getText().length()>=tamanio) {
                    e.consume();
                    JOptionPane.showMessageDialog(txt, "Solo se permiten "+tamanio+" caracteres");
                }
        }
    });
    }
    
    public static String obtenerFechaActual(){
        Date fechaActual=new Date();
        int anio=fechaActual.getYear()+1900;
        int mes=fechaActual.getMonth()+1;
        int dia=fechaActual.getDay()+25;
        String fechaFormateada=dia+"/"+mes+"/"+anio;
        return fechaFormateada;
    }
    
    public static String obtenerHoraActual(){
        Calendar calendario=new GregorianCalendar();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        String horaActual=hora+":"+minutos;
        return horaActual;
    }
    
}
