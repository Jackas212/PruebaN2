/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import modelo.Estudiante;

/**
 *
 * @author Gigabyte
 */
public class EstudianteDao extends AdaptadorDao<Estudiante> {

    private Estudiante estudiante;

    public EstudianteDao() {
        super(Estudiante.class);
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

    public Boolean guardar() throws Exception {
        guardar(estudiante);
        return true;
    }
}
