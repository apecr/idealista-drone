package com.eyo.idealista;

import org.springframework.stereotype.Component;

@Component
public class DriverDroneImpl implements DriverDrone {

	private MapaUrbanizacionesVO mapa;

	@Override
	public String obtenerIdentificadorUrbanizacion(double coordenadaX, double coordenadaY) {
		UrbanizacionVO[][] urbanizaciones = mapa.getMapaUrbanizaciones();
		UrbanizacionVO urbanizacionSalida = urbanizaciones[(int) coordenadaX][(int) coordenadaY];
		return urbanizacionSalida.getIdentificadorUrbanizacion();
	}

	@Override
	public String obtenerAdyacente(String identificadorUrbanizacionOrigen, Direccion direccion) {
		UrbanizacionVO[][] urbanizaciones = mapa.getMapaUrbanizaciones();
		int lengthArray = urbanizaciones[0].length;
		int i = 0, j = 0;
		int coordenadaX = 0;
		int coordenadaY = 0;
		for (i = 0; i < lengthArray; i++) {
			for (j = 0; j < lengthArray; j++) {
				if (urbanizaciones[i][j].getIdentificadorUrbanizacion().equals(identificadorUrbanizacionOrigen)) {
					coordenadaX = i;
					coordenadaY = j;
					i = lengthArray;
					j = lengthArray;
				}
			}
		}
		if (direccion.equals(Direccion.ABAJO)){
			coordenadaX++;
		}else if (direccion.equals(Direccion.ARRIBA)){
			coordenadaX--;
		}else if (direccion.equals(Direccion.DERECHA)){
			coordenadaY++;
		}else if (direccion.equals(Direccion.IZQUIERDA)){
			coordenadaY--;
		}
		return urbanizaciones[coordenadaX][coordenadaY].getIdentificadorUrbanizacion();
	}

	@Override
	public MapaUrbanizacionesVO getMapa() {
		return mapa;
	}

	@Override
	public void setMapa(MapaUrbanizacionesVO mapa) {
		this.mapa = mapa;
	}

}
