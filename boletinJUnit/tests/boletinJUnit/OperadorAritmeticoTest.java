package boletinJUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hamcrest.*;
class OperadorAritmeticoTest extends CoreMatchers{
	
	private static OperadorAritmetico op;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		op = new OperadorAritmetico();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		op = null;
	}

	@Test
	void testSuma() {
		assertThat(2, equalTo (op.suma(1, 1));
	}

	@Test
	void testDivision() {
		fail("Not yet implemented");
	}

}
