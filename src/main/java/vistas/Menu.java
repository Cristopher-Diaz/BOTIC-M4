package vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

public class Menu extends MenuTemplate{
	AlumnoServicio alumnoServicio = new AlumnoServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	private Scanner read = new Scanner(System.in);
	
	@Override
	public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
		
	}

	@Override
	public void crearAlummno() {
		// TODO Auto-generated method stub
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = read.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = read.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = read.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = read.nextLine();
        

        alumnoServicio.crearAlumno(rut, nombre, apellido, direccion);
        System.out.println("--- ¡Alumno agregado! ---");
		
	}

	@Override
	public void agregarMateria() {

	    System.out.println("--- Agregar Materia ---");
	    System.out.print("Ingresa rut del Alumno: ");
	    String rut = read.nextLine();
	    System.out.println("1. MATEMATICAS");
	    System.out.println("2. LENGUAJE");
	    System.out.println("3. CIENCIA");
	    System.out.println("4. HISTORIA");
	    System.out.print("Selecciona una Materia: ");
	    int opcionMateria = read.nextInt();
	    read.nextLine(); 

	    MateriaEnum materiaEnum = null;
	    switch (opcionMateria) {
	        case 1:
	            materiaEnum = MateriaEnum.MATEMATICAS;
	            break;
	        case 2:
	            materiaEnum = MateriaEnum.LENGUAJE;
	            break;
	        case 3:
	            materiaEnum = MateriaEnum.CIENCIA;
	            break;
	        case 4:
	            materiaEnum = MateriaEnum.HISTORIA;
	            break;
	        default:
	            System.out.println("Opción no válida. No se agregó la materia.");
	            break;
	    }

	    if (materiaEnum != null) {
	        Materia materia = new Materia(materiaEnum, new ArrayList<>());
	        alumnoServicio.agregarMateria(rut, materia);
	        System.out.println("--- ¡Materia agregada! ---");
	    }
	}

	@Override
	public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = read.nextLine();

        List<Materia> materias = alumnoServicio.materiasPorAlumnos(rut);
        if (materias == null || materias.isEmpty()) {
            System.out.println("El alumno no tiene materias registradas.");
            return;
        }

        System.out.println("Alumno tiene las siguientes materias agregadas:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }

        System.out.print("Seleccionar materia: ");
        int indiceMateria = read.nextInt() - 1;
        read.nextLine(); 

        if (indiceMateria < 0 || indiceMateria >= materias.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        System.out.print("Ingresar nota: ");
        double nota = read.nextDouble();
        read.nextLine(); 

        Materia materiaSeleccionada = materias.get(indiceMateria);
        materiaSeleccionada.getNotas().add(nota);
        System.out.println("--- ¡Nota agregada a " + materiaSeleccionada.getNombre() + "! ---");
		
	}

	@Override
	public void listarAlummnos() {
        System.out.println("--- Listar Alumnos ---");
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            alumnos.forEach((rut, alumno) -> {
                System.out.println("RUT: " + alumno.getRut());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getApellido());
                System.out.println("Dirección: " + alumno.getDireccion());
                System.out.println("Materias:");
                List<Materia> materias = alumno.getMaterias();
                if (materias != null && !materias.isEmpty()) {
                    materias.forEach(materia -> {
                        System.out.println(materia.getNombre());
                        System.out.println("Notas: " + materia.getNotas());
                    });
                } else {
                    System.out.println("No hay materias registradas.");
                }
                System.out.println();
            });
        }
		
	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub
		
	}

}
