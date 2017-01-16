package com.eyo.idealista;

/**
 * Interfaz creada por idealista para el proyecto drone
 *
 */
public interface DriverDrone {
	
	/**
	 * Obtiene el identificador de la urbanizacion en funcion de las coordenadas
	 * @param coordenadaX {@link Double} Valor de la coordenada X
	 * @param coordenadaY {@link Double} Valor de la coordenada Y
	 * @return {@link String} Valor del identificador de la urbanizacion
	 */
	String obtenerIdentificadorUrbanizacion(double coordenadaX, double coordenadaY);
	
	/**
	 * Obtiene el identificador de urbanizacion adyacente a la urbanizacion de origen <br>
	 * en la {@link Direccion} direccion que se pasa en la entrada 
	 * @param identificadorUrbanizacionOrigen {@link String} Identificador de la urbanizacion
	 * @param direccion {@link Direccion} Direccion sobre la que buscar la urbanizacion adyacente.
	 * @return {@link String} Valor del identificador de la urbanizacion adyacente en la direccion indicada
	 */
	String obtenerAdyacente(String identificadorUrbanizacionOrigen, Direccion direccion);
	
	/**
	 * @param mapa the mapa to set
	 */
	void setMapa(MapaUrbanizacionesVO mapa);
	
	/**
	 * @return the mapa
	 */
	MapaUrbanizacionesVO getMapa();

}
