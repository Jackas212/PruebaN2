/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import com.thoughtworks.xstream.security.TypePermission;
import controlador.DAO.InterfazDao;
import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.ListaEnlazadaServices;
import controlador.utiles.Utilidades;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author sebastian
 * @param <T>
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    private XStream xstream;
    private Class<T> clazz;
    private String URL = "datos" + File.separatorChar;

    public AdaptadorDao(Class<T> clazz) {
        this.clazz = clazz;
        URL += this.clazz.getSimpleName() + ".json";
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.alias("lista", ListaEnlazada.class);
        xstream.setMode(XStream.NO_REFERENCES);

        xstream.addPermission(AnyTypePermission.ANY);

        xstream.addPermission(NullPermission.NULL);   // allow "null"
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive types
    }

    @Override
    public void guardar(T dato) throws Exception {
        ListaEnlazadaServices<T> lista = listar();
        // xstream.alias(clazz.getSimpleName().toLowerCase(), clazz);
        if (lista.getSize() != 0) {
            lista.insertar(dato, lista.getSize() - 1);
        } else {
            lista.insertar(dato, 0);
        }
        xstream.toXML(lista.getLista(), new FileOutputStream(URL));
    }

    @Override
    public void modificar(T dato, Integer pos) throws Exception {
        ListaEnlazadaServices<T> lista = listar();
        lista.getLista().modificarDato(pos, dato);
        xstream.toXML(lista.getLista(), new FileOutputStream(URL));
    }

    @Override
    public ListaEnlazadaServices<T> listar() {
        
        ListaEnlazadaServices<T> listaAux = new ListaEnlazadaServices<T>();
        try {
            listaAux.setLista((ListaEnlazada)xstream.fromXML(new FileReader(URL)));
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
        return listaAux;
    }
}
