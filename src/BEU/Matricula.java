package BEU;

import Guallichico.Persona;
import Guallichico.Unidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {

    //Datos
    private final String numero;
    private Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private final List<Calificacion> calificaciones = new ArrayList<>();

    //Información
    private float promedio;

    public Matricula() {
        fecha = Calendar.getInstance();
        estado = Estado.REGISTRADA;
        UUID numeroAleatorio = UUID.randomUUID();
        this.numero = numeroAleatorio.toString();
    }

    public String getNumero() {
        return numero;
    }
   

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void CalcularPromedio() {
        if (this.calificaciones.isEmpty()) {
            return;
        }
        float suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.valor;// se puede acceder al atributo porque es una clace interna
        }
        int divisor = this.calificaciones.size();
        promedio = (float) suma / (float) divisor;

        if (divisor == 3) {
            if (promedio > 14) {
                this.estado = Estado.APROBADO;
            } else {
                this.estado = Estado.REPROBADO;
            }
        }

    }

    //este metodo registra una calificacion y retorna un numero
    //1 si es la nota de la Unidad I
    //2 se es la nota de la Unidad II
    //3 si es la nota de la Unidad III
    //0 si ya tiene todas las notas
    public int addCalificacion(float v) {
        Calificacion cal = new Calificacion();
        int cuentaNotas = this.calificaciones.size();
        switch (cuentaNotas) {
            case 0:
                cal.setUnidad(Unidad.I);
                break;
            case 1:
                cal.setUnidad(Unidad.II);
                break;
            case 2:
                cal.setUnidad(Unidad.III);
                break;
            default:
                return 0;//en caso de tener todoas las notas retorna 0
        }
        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.CalcularPromedio();
        //Retorna el tamaño de la lista
        return this.calificaciones.size();
    }

    @Override
    public String toString() {
        return estudiante.toString() + " # " + numero;
    }
    
    public String toSave(){
    GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(this);
    }
    

    public String imprimirDetalle() {
        String str = "\n\t" + this.estudiante;
        for (Calificacion c : this.calificaciones) {
            str += "\t\t" + c.getValor();
        }
        str += "\t\t" + this.promedio + "\n";
        return str;
    }

    public String imprimirDetalleTotal() {
        String str = "\n\t" + this.estudiante;
        for (Calificacion c : this.calificaciones) {
            str += "\t\t" + c.getValor();
        }
        str += "\t\t" + this.promedio + "\t\t" + this.estado + "\n";
        return str;
    }

    class Calificacion {

        private Calendar fecha;
        private float valor;
        private Unidad unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidad unidad) {
            this.unidad = unidad;
        }

    }

}
