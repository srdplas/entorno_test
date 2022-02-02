package entorno.srdplas.Tarea1;


import static org.junit.jupiter.api.Assertions.*;
import javax.swing.plaf.basic.BasicPanelUI;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.*;
import org.junit.*;

@DisplayName("Test a la clase Persona")
class PersonaTest extends CoreMatchers{
	
	private static Persona p;
	
	@BeforeAll
	static void init() {
		p= new Persona();
	}
	
	@AfterAll 
	static void finish(){
		p = null;
	}
	
	
	@Test
	@DisplayName("Metodo para Calcular el IMC de una persona 😇")
	void testCalcularIMC() {
		
		p.setAltura(1.85);
		p.setEdad(19);
		p.setNombre("Manolo");
		p.setPeso(20.67);
		
		
		assertEquals(1, p.calcularIMC(), "Error el metodo no funciona el peso no supera el minimo de los if");
		
	}

	@Test
	@DisplayName("Metodo para saber si es mayor de edad de una persona 😇")
	void testEsMayorDeEdad() {
		
		p.setEdad(17);
	
		assertFalse(p.esMayorDeEdad());
		
	}

	

}
