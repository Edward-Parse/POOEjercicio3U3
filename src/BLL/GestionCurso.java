package BLL;

import BEU.Curso;
import Guallichico.BasePersistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestionCurso extends BasePersistencia<Curso> {

    private List<Curso> cursos = new ArrayList<>();

    public GestionCurso() {       
    }

    public List<Curso> getCursos() throws IOException {
        String contenido = this.leer("cursos", "cursos.json");
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        
        Type listType = new TypeToken<ArrayList<Curso>>(){}.getType();
        cursos = gson.fromJson(contenido, listType);
        
        return cursos;
    }
    
    
}
