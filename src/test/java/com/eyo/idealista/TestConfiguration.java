package com.eyo.idealista;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.eyo.idealista" })
public class TestConfiguration {


	public static MapaUrbanizacionesVO mapaUrbanizacionesVo(int tamanho) {
		MapaUrbanizacionesVO mapa = new MapaUrbanizacionesVO();
		mapa.setMapaUrbanizaciones(mapaUrbanizaciones(tamanho));
		return mapa;
	}

	public static UrbanizacionVO[][] mapaUrbanizaciones(int size) {
		UrbanizacionVO[][] mapa = new UrbanizacionVO[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				UrbanizacionVO urbanizacionIJ = new UrbanizacionVO();
				int position = (j + 1) + (i * size);
				urbanizacionIJ.setIdentificadorUrbanizacion("idUrb" + position);
				urbanizacionIJ.setCoordenadaX(i);
				urbanizacionIJ.setCoordenadaY(j);
				mapa[i][j] = urbanizacionIJ;
			}
		}
		return mapa;
	}


}
