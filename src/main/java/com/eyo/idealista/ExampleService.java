package com.eyo.idealista;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {

	@Autowired
	private DriverDrone driverDrone;

	/**
	 * Reads next record from input
	 */
	@Override
	public String getMessage() {
		return "Hello world!";
	}

	@Override
	public String[] obtenerUrnanizaciones(double coordenadaX, double coordenadaY, int rango) {
		String[] salida = null;
		if (rango > 0) {
			String identificadorIzquierdoAlto = driverDrone.obtenerIdentificadorUrbanizacion(coordenadaX, coordenadaY);
			String identificadorDerechoBajo = driverDrone.obtenerIdentificadorUrbanizacion(coordenadaX, coordenadaY);
			for (int i = 0; i < rango; i++) {
				identificadorIzquierdoAlto = driverDrone.obtenerAdyacente(identificadorIzquierdoAlto,
						Direccion.IZQUIERDA);
				identificadorIzquierdoAlto = driverDrone.obtenerAdyacente(identificadorIzquierdoAlto, Direccion.ARRIBA);
				identificadorDerechoBajo = driverDrone.obtenerAdyacente(identificadorDerechoBajo, Direccion.DERECHA);
				identificadorDerechoBajo = driverDrone.obtenerAdyacente(identificadorDerechoBajo, Direccion.ABAJO);
			}
			HashSet<String> listaUrbanizaciones = new LinkedHashSet<>();
			listaUrbanizaciones.add(identificadorDerechoBajo);
			listaUrbanizaciones.add(identificadorIzquierdoAlto);
			String identificadorIzquierdoHorizontal = identificadorIzquierdoAlto;
			String identificadorDerechoHorizontal = identificadorDerechoBajo;
			String identificadorIzquierdoVertical = identificadorIzquierdoAlto;
			String identificadorDerechoVertical = identificadorDerechoBajo;
			listaUrbanizaciones.add(driverDrone.obtenerIdentificadorUrbanizacion(coordenadaX, coordenadaY));
			for (int i = 0; i < rango * 2; i++) {
				identificadorIzquierdoHorizontal = driverDrone.obtenerAdyacente(identificadorIzquierdoHorizontal,
						Direccion.DERECHA);
				listaUrbanizaciones.add(identificadorIzquierdoHorizontal);
				identificadorDerechoHorizontal = driverDrone.obtenerAdyacente(identificadorDerechoHorizontal,
						Direccion.IZQUIERDA);
				listaUrbanizaciones.add(identificadorDerechoHorizontal);
				identificadorIzquierdoVertical = driverDrone.obtenerAdyacente(identificadorIzquierdoVertical,
						Direccion.ABAJO);
				listaUrbanizaciones.add(identificadorIzquierdoVertical);
				identificadorDerechoVertical = driverDrone.obtenerAdyacente(identificadorDerechoVertical,
						Direccion.ARRIBA);
				listaUrbanizaciones.add(identificadorDerechoVertical);
			}
			List<String> listaSalida = new ArrayList<String>();
			listaSalida.addAll(listaUrbanizaciones);
			int tamanhoLista = 0;
			if (rango == 1){
				tamanhoLista = 9;
			}else{
				int longitud = rango*2 + 1;
				int longitudPrevia = longitud - 2;
				tamanhoLista = longitud*longitud + 1 - longitudPrevia*longitudPrevia;
			}
			salida = listaSalida.toArray(new String[tamanhoLista]);
		}
		return salida;
	}

}
