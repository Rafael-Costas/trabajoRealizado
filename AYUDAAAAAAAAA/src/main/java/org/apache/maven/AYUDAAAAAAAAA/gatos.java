package org.apache.maven.AYUDAAAAAAAAA;

import jakarta.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class gatos {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String raza;
private String nombre;
private String foto;
public String getFoto() {
	return foto;
}
public void setFoto(String foto) {
	this.foto = foto;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRaza() {
	return raza;
}
public void setRaza(String raza) {
	this.raza = raza;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

}
