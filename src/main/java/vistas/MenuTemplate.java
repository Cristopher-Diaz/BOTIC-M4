package vistas;
import java.util.Scanner;

public abstract class MenuTemplate {
	private Scanner read = new Scanner(System.in);
	
	public abstract void exportarDatos();
	public abstract void crearAlummno();
	public abstract void agregarMateria();
	public abstract void agregarNotaPasoUno();
	public abstract void listarAlummnos();
	public abstract void terminarPrograma();
	
	
	public  void iniciarMenu() {
        int option = -1;
        do {
            System.out.println("--- Menú de Principal ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Exportar datos");
            System.out.println("6. Terminar programa");

            option = read.nextInt();
            switch (option){
                case 1: crearAlummno();
                    break;
                case 2: listarAlummnos();
                    break;
                case 3: agregarMateria();
                    break;
                case 4: agregarNotaPasoUno();
                    break;
                case 5: exportarDatos();
                    break;
                case 6: terminarPrograma();
                    break;
                default: System.out.println("Opción inválida, Intente nuevamente");
            }
        } while (option != 6);
	}
	
}
