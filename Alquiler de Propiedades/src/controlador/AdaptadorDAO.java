/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controlador.utiles.Utilidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import controlador.listas.ListaEnlazada;
<<<<<<< HEAD
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dennys
 */
<<<<<<< HEAD
public class AdaptadorDao<T> implements InterfazDAO<T> {
=======
public class AdaptadorDao<T> implements InterfazDao<T> {
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha

    private String URL = "data/XML" + File.separatorChar;
    private String URL2 = "data/JSON" + File.separatorChar;
    private Class<T> clazz;

    public AdaptadorDao(Class<T> clazz) {
        this.clazz = clazz;
        URL += this.clazz.getSimpleName() + ".xml";
        URL2 += this.clazz.getSimpleName() + ".json";
<<<<<<< HEAD

    }
    /**
     * 
     * @param dato
     * @throws FileNotFoundException
     * @throws JAXBException 
     */

=======
    }

    /**
     * <b>Este método es utilizado para guardar los datos enviados desde las
     * clases </b>
     * <b>Información:</b> Este método guarda todo tipo de objeto en un archivo
     * json y xml ambos utilizados para poder acceder a la información
     */
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
    @Override
    public void guardar(T dato) throws FileNotFoundException, JAXBException {
        listar().imprimir();
        ListaEnlazada<T> lista = listar();
        lista.insertar(dato);
<<<<<<< HEAD


        try (PrintWriter out = new PrintWriter(new FileWriter(URL))) {
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = prettyGson.toJson(lista);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException{
        ListaEnlazada<T> lista=listar();
        try (PrintWriter out = new PrintWriter(new FileWriter(URL))){
            lista.modificarPoscicion(dato, pos);
            FileOutputStream file = new FileOutputStream(URL);
            JAXBContext jabxc = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
            Marshaller marshaller = jabxc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(lista, file);
        } catch (IOException ex) {
            Logger.getLogger(AdaptadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
//        ObjectMapper JSON_MAPPER = new ObjectMapper();
//        try {
//            JSON_MAPPER.writeValue(new File(URL2), lista);
//        } catch (Exception e) {
//        }
=======
        FileOutputStream file = new FileOutputStream(URL);
        JAXBContext jabxc = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
        Marshaller marshaller = jabxc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lista, file);
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
        try ( PrintWriter out = new PrintWriter(new FileWriter(URL2))) {
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = prettyGson.toJson(lista);
            out.write(jsonString);
        } catch (Exception e) {
            System.out.println(e);
        }
    }   
    
//    //todo
//    @Override
//    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException {
//        ListaEnlazada<T> lista = listar();
//        lista.modificarPoscicion(dato, pos-1);
//        FileOutputStream file = new FileOutputStream(URL);
//        JAXBContext jabxc = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
//        Marshaller marshaller = jabxc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(lista, file);
//        try ( PrintWriter out = new PrintWriter(new FileWriter(URL2))) {
//            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//            String jsonString = prettyGson.toJson(lista);
//            out.write(jsonString);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }

    /**
     * <b>Este método es utilizado para modificar los datos enviados desde las
     * clases</b> ´<br>
     * <b>Información:</b> Este método necesita de un T dato cualquiera y la
     * posición dentro de la lista, este método remplaza el dato en la posición
     * seleccionada para posteriormente volver a crear los archivos json y xml
     * esto con el objetivo de actualizar la lista
     */
    @Override
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException {
        ListaEnlazada<T> lista = listar();
        lista.modificarPoscicion(dato, pos);
        FileOutputStream file = new FileOutputStream(URL);
        JAXBContext jabxc = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
        Marshaller marshaller = jabxc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lista, file);
        try ( PrintWriter out = new PrintWriter(new FileWriter(URL2))) {
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = prettyGson.toJson(lista);
            out.write(jsonString);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * <b>Este método es utilizado para listar los datos guardados dentro de los
     * archivos json y xml </b>
     * <b>Información:</b> Lo que hace este método es obtener los datos que se
     * guardaron anteriormente en el archivo, estos datos los guarda en una
     * Lista Enlazada para que estos puedan ser accesibles para ser utilizados
     */
    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
//            String result = new String(Files.readAllBytes(Paths.get(URL2)));  
//            String xml = Utilidades.convertToXML(result, "root"); 
//            FileWriter file = new FileWriter(xml);
            Document doc = db.parse(URL);
            NodeList datos = doc.getElementsByTagName(this.clazz.getSimpleName().toLowerCase());
            for (int i = 0; i < datos.getLength(); i++) {
                Node n1 = datos.item(i);
                NodeList nodo1 = n1.getChildNodes();

                T obj = this.clazz.newInstance();

                for (int j = 0; j < nodo1.getLength(); j++) {
                    Node dato = nodo1.item(j);
                    if (dato.getNodeName() != null && !dato.getNodeName().equalsIgnoreCase("") && dato.getTextContent() != null
                            && !dato.getTextContent().equalsIgnoreCase("") && !dato.getNodeName().equalsIgnoreCase("#text")) {
                        Method metodo = null;
                        for (Method met : this.clazz.getMethods()) {
                            if (met.getName().equalsIgnoreCase(("set" + Utilidades.capitalizar(dato.getNodeName())))) {
                                metodo = met;
                                break;
                            }
                        }
                        metodo.invoke(obj, Utilidades.transformarDato(Utilidades.obtenerAtributos(clazz, dato.getNodeName()), dato.getTextContent()));
                    }
                }
                
                lista.insertar(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    /**
     * <b>Este método es utilizado para obtener el dato en particular dentro del
     * archivo </b>
     * <b>Información:</b> Este método genera una lista enlazada nueva y llama
     * al método listar y mediante el id único llamar y obtener al objeto
     * deseado presente dentro de la <b>Lista Enlazada</b>
     */
    @Override
    public T obtener(Integer id) {
        ListaEnlazada<T> lista = listar();
        try {
<<<<<<< HEAD
            T dato = lista.obtener(id-1);
=======
            T dato = lista.obtener(id - 1);
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
            return dato;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
<<<<<<< HEAD
//
//    @Override
//    public void eliminar(Integer pos) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

=======
}
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
