public class Objeto 
{
    private String nombreObjeto;
    private String descripcion;

    public Objeto(String nombreObjeto, int cantidad, String descripcion)
    {
        this.nombreObjeto = nombreObjeto;
        this.descripcion = descripcion;
    }

    public String getNombreObjeto()
    {
        return this.nombreObjeto;
    }
    public void setNombreObjeto(String nombreObjeto)
    {
        this.nombreObjeto = nombreObjeto;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }





}
