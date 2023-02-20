/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Modelo;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Propiedad;

/**
 *
 * @author Dennys
 */
public class ModeloTablaPagos extends AbstractTableModel {

    ListaEnlazada<Propiedad> lista = new ListaEnlazada<>();

    public ListaEnlazada<Propiedad> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Propiedad> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getTamanio()-1;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    /**
     * Presenta los valores de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return Objetc
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Propiedad e = lista.obtener(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (e != null) ? e.getId() : "NO DEFINIDO";
                case 1:
                    return (e != null) ? e.getContrato().getNroDias() : "NO DEFINIDO";
                case 2:
                    return (e != null) ? e.getContrato().getPago().getEstadoPago() : "NO DEFINIDO";
                case 3:
                    return (e != null) ? e.getContrato().getPago().getTipoDePago() : "NO DEFINIDO";
                case 4:
                    return (e != null) ? e.getContrato().getPago().getMetodoPago() : "NO DEFINIDO";
                default:
                    return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Genera las columnas de la tabla
     * @param column
     * @return String
     */
    @Override
    public String getColumnName(int column) {
        try {
            switch (column) {
                case 0:
                    return "ID";
                case 1:
                    return "Dias de Alquiler";
                case 2:
                    return "Pago";
                case 3:
                    return "Tipo de Pago";
                case 4:
                    return "Metodo de Pago";
                default:
                    return null;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}


