package servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import modelos.Alumno;

public class ArchivoServicio {
    private List<Alumno> alumnosACargar;
    private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();
    
    public void exportarDatos(Map<String, Alumno> alumnos) {
        String rutaArchivo = "promedios.txt"; 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
                Alumno alumno = entry.getValue();
                String linea = generarLineaExportacion(alumno);
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente al archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    private String generarLineaExportacion(Alumno alumno) {
        StringBuilder sb = new StringBuilder();
        sb.append("Alumno: ").append(alumno.getRut()).append(" - ").append(alumno.getNombre());

        if (alumno.getMaterias() != null && !alumno.getMaterias().isEmpty()) {
            sb.append(" [materia ");
            alumno.getMaterias().forEach(materia -> {
                sb.append("[nombre=").append(materia.getNombre()).append(", notas=").append(materia.getNotas()).append("]");
                double promedio = promedioServicioImp.calcularPromedio(materia.getNotas());
                sb.append(" - Promedio: ").append(promedio).append("]");
            });
        } else {
            sb.append(" - No tiene materias registradas");
        }
        return sb.toString();
    }
}
