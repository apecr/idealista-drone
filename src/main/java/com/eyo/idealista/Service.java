package com.eyo.idealista;

public interface Service {
	
	String getMessage();
	
	/**
	 * Obtiene los identificadores de urbanizaciones a rastrear por el dron
	 * 
	 * @param coordenadaX
	 *            {@link Double} Valor de la coordenada X
	 * @param coordenadaY
	 *            {@link Double} Valor de la coordenada Y
	 * @param rango
	 *            {@link Integer} Valor del rango a buscar
	 * @return {@link String}[] Array con los identificadores de urbanizacion
	 *         que tiene <br>
	 *         barrer el dron
	 */
	String[] obtenerUrnanizaciones(double coordenadaX, double coordenadaY, int rango);

}
