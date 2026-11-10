import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class gestorTablaClasificacion
{
    public static void crearXML(String ruta)
    {
    try
    {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        
        fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            //Crear el lector XML
        DocumentBuilder contructor = fabrica.newDocumentBuilder();

            //Crear el documento 
        Document documento = contructor.newDocument();

        Element raiz = documento.createElement("clasificacion");

        documento.appendChild(raiz);

        Element heroe = documento.createElement("heroe");
        heroe.setAttribute("id", "1");
        raiz.appendChild(heroe);

        Element nombre = documento.createElement("nombre");
        nombre.setTextContent("Armando");
        heroe.appendChild(nombre);
            
        Element puntuacion = documento.createElement("puntuacion");
        puntuacion.setTextContent("100");
        heroe.appendChild(puntuacion);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource origen = new DOMSource(documento);

        StreamResult destino = new StreamResult(new File("new_clasificacion.xml"));

        transformer.transform(origen, destino);

        System.out.println("XML generado correctamente");
    }
    catch(Exception e)
    {

    }
    }

    public static void leerXML()
    {
        try
        {

            File archivo = new File(String ruta);
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("alumno");
            System.out.println("Total de alumnos: " + lista.getLength());

            for (int i = 0; i < lista.getLength(); i++) {
                Element alumno = (Element) lista.item(i);

                String id = alumno.getAttribute("id");
                String nombre = alumno.getElementsByTagName("nombre").item(0).getTextContent();
                String edad = alumno.getElementsByTagName("edad").item(0).getTextContent();
                String ciclo = alumno.getElementsByTagName("ciclo").item(0).getTextContent();

                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad + " | Ciclo: " + ciclo);

        }



        catch
        {

        }


    }


}
