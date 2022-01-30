package entorno.yuri.boletinjunit.ejercicicio5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CuentaTest {
	
	private static Cuenta c;
	
	@BeforeAll
	static void init() {
		c= new Cuenta("134", "Yuri");
	}
	
	@AfterAll
	static void finish() {
		c = null;
	}
	
	@Test
	void testCuenta() {
		asserThat
	}

	@Test
	void testIngresarDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testRetirarDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testIngresarStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testRetirarStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSaldo() {
		fail("Not yet implemented");
	}

	@Test
	void testAddMovimiento() {
		fail("Not yet implemented");
	}

}
