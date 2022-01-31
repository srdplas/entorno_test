package entorno.yuri.tarea5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CreditoTest extends CoreMatchers{

	private static Credito c;
	private static Date date;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		date = new Date();
		date.setYear(2030);
		c = new Credito("135", "Yuri", date, 500);
		Cuenta cu = new Cuenta("135", "Yuri");
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		date = null;
		c=null;
	}

	@Test
	void testRetirar() throws Exception {
		Movimiento m = new Movimiento();
		c.ingresar(100);
		c.retirar(99);
		
		
		assertThat("Error en el metodo retir<r", c.getCreditoDisponible(), is(1));
	}

	@Test
	void testIngresar() {
		fail("Not yet implemented");
	}

	@Test
	void testPagoEnEstablecimiento() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSaldo() {
		fail("Not yet implemented");
	}

	@Test
	void testCredito() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCreditoDisponible() {
		fail("Not yet implemented");
	}

	@Test
	void testLiquidar() {
		fail("Not yet implemented");
	}

	@Test
	void testTarjeta() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCuenta() {
		fail("Not yet implemented");
	}

}
