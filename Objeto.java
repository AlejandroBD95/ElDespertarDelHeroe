public class Objeto 
{
    private String nombreObjeto;
    private String descripcion;
    private int cantidadSanacion;
    public Objeto(String nombreObjeto, int cantidadSanacion, String descripcion)
    {
        this.nombreObjeto = nombreObjeto;
        this.descripcion = descripcion;
        this.cantidadSanacion = cantidadSanacion;
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

    public int getCantidadSanacion()
    {
        return this.cantidadSanacion;
    }
    public void setCantidadSanacion(int cantidadSanacion)
    {
        this.cantidadSanacion = cantidadSanacion;
    }
}
