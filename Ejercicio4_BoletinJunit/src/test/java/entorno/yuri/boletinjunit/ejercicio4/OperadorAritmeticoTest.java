package entorno.yuri.boletinjunit.ejercicio4;

import static org.hamcrest.MatcherAssert.*;


import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Test a la clase OperadorAritmetico")
class OperadorAritmeticoTest extends CoreMatchers{
	
	private static OperadorAritmetico op;
	
	@BeforeAll
	static void init(){
		op = new OperadorAritmetico();
	}

	@AfterAll
	static void finish(){
		op = null;
	}

	@Test
	@DisplayName("Test al metodo que permite sumar valores")
	void testSuma() {
		assertThat("Error no funciona el metodo SUMA", op.suma(2, 2), is(4));
	}

	@Test
	@DisplayName("Test al metodo que permite dividir valores")
	void testDivision() throws Exception {
		int resultado=-1;
		resultado=op.division(10, 2);
		
		assertThat("Error no funciona el metodo SUMA", resultado, is(5));
	}

}
