package entorno.yuri.boletinjunit.ejercicio4;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Test a la clase Subcripcion")
class SubscripcionTest extends CoreMatchers{
	
	private static Subscripcion su;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		su = new Subscripcion(50, 12);
		//Precio y periodo de la subcripción
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		su = null;
	}

	@Test
	@DisplayName("Test del constructor")
	void testSubscripcion() {
		assertThat("Error el constructor no funciona", su, notNullValue());
	}

	@Test
	@DisplayName("Test al metodo para indicar el precio al mes")
	void testPrecioPorMes() {
		double precio=-1;
		precio=Math.round(su.precioPorMes());
		//Redondeamos para no fallar en decimales
		double esperado=5;
		
		assertThat("Error el metodo precioPorMes no funciona", precio, is(esperado));
	}

	@Test
	@DisplayName("Test al metodo para cancelar la subcripcion")
	void testCancel() {
		su.cancel();
		double esperado=0;
		
		assertThat("Error el metodo cancelarSubscripcion no funciona", su.precioPorMes(), is(esperado));
	}

}
