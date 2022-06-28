/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ModeloTablas;

import controlador.tda.lista.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;

/**
 *
 * @author sebastian
 */
public class TablaEstudiantes extends AbstractTableModel {

    private ListaEnlazadaServices<Estudiante> lista;

    public ListaEnlazadaServices<Estudiante> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazadaServices<Estudiante> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombres";
            case 1:
                return "Apellidos";
            case 2:
                return "Cedula";
            case 3:
                return "Nota";
            case 4:
                return "Estado";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Estudiante persona = lista.obtenerDato(arg0);
        switch (arg1) {
            case 0:
                return persona.getNombre();
            case 1:
                return persona.getApellido();
            case 2:
                return persona.getCedula();
            case 3:
                return persona.getNota();
            case 4:
                return persona.getEstado();
            default:
                return null;
        }
    }

}
