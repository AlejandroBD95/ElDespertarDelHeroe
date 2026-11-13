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



public class gestorClasificacion
{

    public static class HeroeClasificacion
    {
        String nombre;
        int puntuacion;

        public HeroeClasificacion(String nombre, int puntuacion)
        {
            this.nombre = nombre;
            this.puntuacion = puntuacion;
        }
    }

    public static void crearXML(String ruta)
    {
    try
    {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        
        //fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
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
        nombre.setTextContent("Sheldyn");
        heroe.appendChild(nombre);
            
        Element puntuacion = documento.createElement("puntuacion");
        puntuacion.setTextContent("100");
        heroe.appendChild(puntuacion);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Clasificacion.dtd");

        DOMSource origen = new DOMSource(documento);

        StreamResult destino = new StreamResult(new File("Clasificacion.xml"));

        transformer.transform(origen, destino);

        System.out.println("XML generado correctamente");
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    }

    public static void leerXML(String ruta)
    {
        try
        {

            File archivo = new File(ruta);
            if(!archivo.exists())
                {
                    crearXML(ruta);
                }
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            //fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList lista = documento.getElementsByTagName("heroe");
            System.out.println("\n==================================");
            System.out.println("       TOP 10 - CLASIFICACIÓN        ");
            System.out.println("==================================");
            System.out.println("Total de heroes: " + lista.getLength());
            
            int totalHeroes = lista.getLength();
            if (totalHeroes == 0)
            {
                System.out.println("Todavía no hay registros");
                System.out.println("=========================\n");
                return;
            }

            HeroeClasificacion[] listaHeroes = new HeroeClasificacion[totalHeroes];

            for (int i = 0; i < lista.getLength(); i++) 
                {
                Element heroe = (Element) lista.item(i);

                String id = heroe.getAttribute("id");
                String nombre = heroe.getElementsByTagName("nombre").item(0).getTextContent();
                String puntuacion = heroe.getElementsByTagName("puntuacion").item(0).getTextContent();
                
                int puntosInt = Integer.parseInt(puntuacion);
                listaHeroes[i] = new HeroeClasificacion(nombre, puntosInt);

                System.out.println("ID: " + id + " | Nombre: " + nombre + " | puntuación: " + puntuacion );
                }
            
                for (int i= 0; i < listaHeroes.length - 1; i++)
                    {
                        for (int j = 0; j < listaHeroes.length - 1 -i; j++)
                            {
                                if(listaHeroes[j].puntuacion < listaHeroes[j + 1].puntuacion)
                                    {
                                        HeroeClasificacion aux = listaHeroes[j];
                                        listaHeroes[j] = listaHeroes[j + 1];
                                        listaHeroes[ j + 1] = aux;
                                    }
                            }
                    }
                int limite = Math.min(10, listaHeroes.length);

                for(int i = 0; i < limite; i++)
                {
                    System.out.println((i + 1) + ". " + listaHeroes[i].nombre + " - " + listaHeroes[i].puntuacion + " pts");
                }
                System.out.println("==================================\n");

        }
        catch (Exception e) 
        {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }


    }

    
    public static void modificarXML(String ruta, String nombreNuevo, String puntuacionNueva)
    {
        try 
        {
            File archivo = new File(ruta);
            if(!archivo.exists())
            {
                crearXML(ruta);
            }
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);

            Element raiz = documento.getDocumentElement();

            Element nuevoHeroe = documento.createElement("heroe");

            NodeList lista = documento.getElementsByTagName("heroe");
            String nuevoId = String.valueOf(lista.getLength() + 1);
            nuevoHeroe.setAttribute("id", nuevoId);

            Element nombre = documento.createElement("nombre");
            nombre.setTextContent(nombreNuevo);
            nuevoHeroe.appendChild(nombre);

            Element puntuacion = documento.createElement("puntuacion");
            puntuacion.setTextContent(puntuacionNueva);
            nuevoHeroe.appendChild(puntuacion);

            raiz.appendChild(nuevoHeroe);
            guardarXML(documento, ruta);
        }
         catch (Exception e) 
        {
            System.out.println("Error al modificar el XML: " + e.getMessage());
        }
    }

    public static void guardarXML(Document documento, String ruta)
    {
        try
        {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource fuente = new DOMSource(documento);
            StreamResult resultado = new StreamResult(new File(ruta));
            transformer.transform(fuente, resultado);
        }
        catch (Exception e) 
        {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
