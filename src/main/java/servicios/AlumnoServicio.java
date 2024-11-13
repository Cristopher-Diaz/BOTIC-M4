package servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public class AlumnoServicio {
	private final Map<String, Alumno> listaAlumnos = new HashMap<>();
	
    public void crearAlumno(String rut, String nombre, String apellido, String direccion) {
    	Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion);
        listaAlumnos.put(nuevoAlumno.getRut(), nuevoAlumno);
    }

    public void agregarMateria(String rutAlumno, Materia currentMate) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(currentMate);
        }
    }

    public List<Materia> materiasPorAlumnos(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        return alumno != null ? alumno.getMaterias() : null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
