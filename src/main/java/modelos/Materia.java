package modelos;

import java.util.List;

public class Materia {
	private MateriaEnum nombre;
	private List<Double> notas;
	
	
	public Materia(MateriaEnum nombre, List<Double> notas) {
		this.nombre = nombre;
		this.notas = notas;
	}
	
	public MateriaEnum getNombre() {
		return nombre;
	}
	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	
}
