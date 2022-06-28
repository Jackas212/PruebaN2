/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Persona;

import controlador.DAO.AdaptadorDao;
import controlador.tda.lista.ListaEnlazadaServices;
import java.util.Random;
import modelo.Estudiante;

/**
 *
 * @author Gigabyte
 */
public class EstudianteController extends AdaptadorDao<Estudiante> {

    private Estudiante estudiante;
    private ListaEnlazadaServices<Estudiante> listaEstudiante;

    public EstudianteController() {
        super(Estudiante.class);
        listado();
    }

    public Estudiante getEstudiante() {
        if (estudiante == null) {
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ListaEnlazadaServices<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ListaEnlazadaServices<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public Boolean guardar() {
        try {
            getEstudiante().setId(listaEstudiante.getSize() + 1);
            guardar(getEstudiante());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Estudiante" + e);
        }
        return false;
    }

    public Boolean modificar(Integer pos) {
        try {

            modificar(getEstudiante(), pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar Estudiante" + e);
        }
        return false;
    }

    public ListaEnlazadaServices<Estudiante> listado() {
        setListaEstudiante(listar());
        return listaEstudiante;
    }

}
