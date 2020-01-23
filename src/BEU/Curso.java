
package BEU;


public class Curso {
    private String titulo;
    private float costo;
    private String descripcion;

    public Curso(String titulo, float costo, String descripcion) {
        this.titulo = titulo;
        this.costo = costo;
        this.descripcion = descripcion;
    }  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    
    
    
}
