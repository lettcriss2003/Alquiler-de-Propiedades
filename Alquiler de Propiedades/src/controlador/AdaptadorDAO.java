/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import controlador.listas.ListaEnlazada;
import controlador.utiles.Utilidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author leomah
 */
public class AdaptadorDAO <T> implements InterfazDAO<T> {
    
    private String URL = "data"+File.separatorChar;
    private Class<T> clazz;

    public AdaptadorDAO(Class<T> clazz) {
        this.clazz = clazz;
        URL+=this.clazz.getSimpleName()+".xml";
    }
       
    @Override
    public void guardar(T dato) throws FileNotFoundException, JAXBException{
        ListaEnlazada<T> lista = listar();
        lista.insertar(dato);
        FileOutputStream file = new FileOutputStream(URL);
        JAXBContext jabxc = JAXBContext.newInstance(new Class[]{ListaEnlazada.class, this.clazz});
        Marshaller marshaller = jabxc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lista, file);
    }

    //todo
    @Override
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException{
        ListaEnlazada<T> Lista=listar();
        try {
            Lista.modificarPoscicion(dato, pos);
            FileOutputStream file=new FileOutputStream(URL);
            JAXBContext jaxb=JAXBContext.newInstance(new Class[]{ListaEnlazada.class,this.clazz});
            Marshaller marshaller=jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(Lista,file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(URL);
            NodeList datos = doc.getElementsByTagName(this.clazz.getSimpleName().toLowerCase());
            for (int i = 0; i < datos.getLength(); i++) {
                Node n1 = datos.item(i);
                NodeList nodo1 = n1.getChildNodes();
                
                T obj = this.clazz.newInstance();
                
                for (int j = 0; j < nodo1.getLength(); j++) {
                    Node dato = nodo1.item(j);
                    if(dato.getNodeName() != null && !dato.getNodeName().equalsIgnoreCase("") && dato.getTextContent() != null &&
                            !dato.getTextContent().equalsIgnoreCase("") && !dato.getNodeName().equalsIgnoreCase("#text")){
                        Method metodo = null;
                        for(Method met: this.clazz.getMethods()){
                            if(met.getName().equalsIgnoreCase(("set" + Utilidades.capitalizar(dato.getNodeName())))){
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

    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    

    @Override
    public void eliminar(Integer pos) {
        ListaEnlazada<T> Lista=listar();
        try {
            Lista.eliminarPosicion(pos);
            FileOutputStream file=new FileOutputStream(URL);
            JAXBContext jaxb=JAXBContext.newInstance(new Class[]{ListaEnlazada.class,this.clazz});
            Marshaller marshaller=jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(Lista,file);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}