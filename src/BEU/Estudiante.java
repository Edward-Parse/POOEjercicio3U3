package BEU;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Guallichico.Persona {

    private String carrera;
    private final List<String> clubes = new ArrayList<>();

    public Estudiante() {
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void addClub(String Club) {
        if (!Club.isEmpty()) {
            this.clubes.add(Club);
        }
    }

    public List<String> getClubes() {
        return clubes;
    }

}
