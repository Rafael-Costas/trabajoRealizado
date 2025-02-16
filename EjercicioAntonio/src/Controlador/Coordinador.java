package Controlador;

import Vistas.Base;
import Vistas.ListadoCuentas;
import Vistas.transacciones;
import modelo.Logica;
import modelo.vo.cuentaVo;


public class Coordinador {
	private Logica miLogica;
	private Base miBase;
	private ListadoCuentas miListadoCuentas;
	private transacciones miTransacciones;
	public Base getMiBase() {
		return miBase;
	}
	public void setMiBase(Base miBase) {
		this.miBase = miBase;
	}

	public Logica getMiLogica() {
		return miLogica;
	}
	public void setMiLogica(Logica miLogica) {
		this.miLogica = miLogica;
	}
	public Base getMiVentanaPrincipal() {
		return miBase;
	}
	public void setMiVentanaPrincipal(Base miVentanaPrincipal) {
		this.miBase = miVentanaPrincipal;
	}
	public ListadoCuentas getMiVentanaRegistro() {
		return miListadoCuentas;
	}
	public void setMiVentanaRegistro(ListadoCuentas miVentanaRegistro) {
		this.miListadoCuentas = miVentanaRegistro;
	}
	public transacciones getMiVentanaBuscar() {
		return miTransacciones;
	}
	public void setMiVentanaBuscar(transacciones miVentanaBuscar) {
		this.miTransacciones = miVentanaBuscar;
	}
	
	
	
	////////////////////////////////////////////////////////////////
	

	public void mostrarListadoCuentas() {
		miListadoCuentas.setVisible(true);
	}
	public void mostrarVentanaTransacciones() {
		miTransacciones.setVisible(true);
	}
	
	public void insertar(cuentaVo cuenta) {
		miLogica.validarRegistro(cuenta);
	}
}
