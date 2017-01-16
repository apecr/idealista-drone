package com.eyo.idealista;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes={TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTest {

	@Autowired
	private Service service;
	@Autowired
	private DriverDrone driverDrone;

	@Test
	public void testSimpleProperties() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}
	
	@Test
	public void testRango1Size5(){
		//Given
		this.driverDrone.setMapa(TestConfiguration.mapaUrbanizacionesVo(5));
		//When
		String [] salida = this.service.obtenerUrnanizaciones(2, 2, 1);
		List<String> listaSalida = Arrays.asList(salida);
		//Then
		assertEquals(9, listaSalida.size());
	}
	
	@Test
	public void testRango2Size5(){
		//Given
		this.driverDrone.setMapa(TestConfiguration.mapaUrbanizacionesVo(5));
		//When
		String [] salida = this.service.obtenerUrnanizaciones(2, 2, 2);
		List<String> listaSalida = Arrays.asList(salida);
		//Then
		assertEquals(17, listaSalida.size());
	}

}
