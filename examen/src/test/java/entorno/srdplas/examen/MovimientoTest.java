package entorno.srdplas.examen;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
@DisplayName("Test a la clase Movimiento")
class MovimientoTest extends CoreMatchers{

	private static Movimiento m;
	
	@Test
	@DisplayName("Test al metodo para obtener el importe")
	void testGetImporte() {
		m = new Movimiento();
		m.setImporte(120.00);
		assertThat("Error en el metodo para obtener el movimiento", m.getImporte(), is(120.00));
		assertThat("Error en el metodo para obtener el movimiento", m.mImporte, is(120.00));
		
	}

	@Test
	@DisplayName("Test al metodo para obtener el concepto")
	void testGetConcepto() {
		m = new Movimiento();
		m.setImporte(10.00);
		m.setConcepto("Hamcrest");
		assertThat("Error en el metodo para obtener el movimiento", m.getImporte(), is(10.00));
		assertThat("Error en el metodo para obtener el movimiento", m.getConcepto(), is("Hamcrest"));
		assertThat("Error en el metodo para obtener el movimiento", m.mImporte, is(10.00));
		assertThat("Error en el metodo para obtener el movimiento", m.mConcepto, is("Hamcrest"));
	}

	@Test
	@DisplayName("Test al metodo para indicar el concepto")
	void testSetConcepto() {
		m = new Movimiento();
		m.setImporte(15.00);
		m.setConcepto("Tier1");
		assertThat("Error en el metodo para obtener el movimiento", m.getImporte(), is(15.00));
		assertThat("Error en el metodo para obtener el movimiento", m.getConcepto(), is("Tier1"));
		assertThat("Error en el metodo para obtener el movimiento", m.mImporte, is(15.00));
		assertThat("Error en el metodo para obtener el movimiento", m.mConcepto, is("Tier1"));
	}
	

	@Test
	@DisplayName("Test al metodo para indicar el importe")
	void testSetImporte() {
		m = new Movimiento();
		m.setImporte(990.00);
		assertThat("Error en el metodo para obtener el movimiento", m.getImporte(), is(990.00));
		assertThat("Error en el metodo para obtener el movimiento", m.mImporte, is(990.00));
	}

}
