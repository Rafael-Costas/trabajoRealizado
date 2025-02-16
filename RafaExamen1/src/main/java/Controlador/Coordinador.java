package Controlador;

import modelo.Country;
import modelo.countryDao;

import vistas.country;

public class Coordinador {

	country count;
	countryDao countDao;
	
	public void mostrarCountry() {
		count.setVisible(true);
	}

	public country getCount() {
		return count;
	}

	public void setCount(country count) {
		this.count = count;
	}

	public countryDao getCountDao() {
		return countDao;
	}

	public void setCountDao(countryDao countDao) {
		this.countDao = countDao;
	}
	
	public void subir(Country pais) {
		countDao.registrarPais(pais);
	}

}
