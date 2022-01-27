package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SubscripcionTest extends CoreMatchers{
	
	private static Subscripcion su;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		su = new Subscripcion(50, 12);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		su = null;
	}

	@Test
	void testSubscripcion() {
		fail("Not yet implemented");
	}

	@Test
	void testPrecioPorMes() {
		fail("Not yet implemented");
	}

	@Test
	void testCancel() {
		fail("Not yet implemented");
	}

}
