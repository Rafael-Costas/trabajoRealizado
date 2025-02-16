// default package
// Generated 28 feb 2024, 10:23:41 by Hibernate Tools 6.3.1.Final

import java.sql.Date;

/**
 * Libro generated by hbm2java
 */
public class Libro implements java.io.Serializable {

	private Integer id;
	private String titulo;
	private String autor;
	private Date añoPublicacion;

	public Libro() {
	}

	public Libro(String titulo, String autor, Date añoPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getAñoPublicacion() {
		return this.añoPublicacion;
	}

	public void setAñoPublicacion(Date añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

}
