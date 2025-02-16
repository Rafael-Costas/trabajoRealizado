package Examen;

public class Libro {

	/*
	 * Crea una clase llamada Libro que guarde la información de cada uno de los
	 * libros de una biblioteca. La clase debe guardar el título del libro, autor,
	 * número de ejemplares del libro y número de ejemplares prestados. Además,
	 * contendrá: Constructor por defecto. Constructor con parámetros. Métodos
	 * setters/getters. Método toString. Método préstamo que incremente el atributo
	 * correspondiente cada vez que se realice un préstamo del libro. No se podrán
	 * prestar libros de los que no queden ejemplares disponibles para prestar.
	 * Devuelve true si se ha podido realizar la operación y false en caso
	 * contrario. Método devolución que decremente el atributo correspondiente
	 * cuando se produzca la devolución de un libro. No se podrán devolver libros
	 * que no se hayan prestado. Devuelve true si se ha podido realizar la operación
	 * y false en caso contrario. Pruebe la clase creando al menos tres libros que
	 * prueben todos los métodos.
	 */
	String titulo;
	String autor;
	int numEjem=0;
	int prestado=0;
	
	Libro(){
		this.titulo="";
		this.autor="";
		this.numEjem=0;
		this.prestado=0;
	}
	
	Libro(String T, String A, int N, int P){
		this.titulo=T;
		this.autor=A;
		this.numEjem=N;
		this.prestado=P;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumEjem() {
		return numEjem;
	}

	public void setNumEjem(int numEjem) {
		this.numEjem = numEjem;
	}

	public int getPrestado() {
		return prestado;
	}

	public void setPrestado(int prestado) {
		this.prestado = prestado;
	}
	
	public boolean prestamo() {
		if(this.numEjem>this.prestado) {
			this.prestado++;
			return true;
		}
		return false;
	}
	public boolean devolucion() {
		if(this.prestado<=0) {
			return false;
		}
		this.prestado--;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", numEjem=" + numEjem + ", prestado=" + prestado + "]";
	}
	
	
}
