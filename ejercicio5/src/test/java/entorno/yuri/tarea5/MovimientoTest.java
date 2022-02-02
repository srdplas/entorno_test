package entorno.yuri.tarea5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@SuppressWarnings("unused")
@DisplayName("Test a la clase Movimiento")
class MovimientoTest extends CoreMatchers{

	private static Movimiento m;
	
	@BeforeAll
	static void init() {
		m = new Movimiento();
		
	}
	
	@AfterAll
	static void finish() {
		m = null;
	}
	
	@Test
	@DisplayName("Test al constructor")
	void testMovimiento() {
		Movimiento mov = new Movimiento();
		assertThat("Error no funciona el constructor", mov.getFecha(), notNullValue());
	}

	@Test
	@DisplayName("Test al metodo para obtener el importe")
	void testGetImporte() {
		double importe =55.5;
		m.setImporte(importe);
		assertThat("Error en el metodo para obtener el importe", m.getImporte(), is(importe));
	}

	@Test
	@DisplayName("Test al metodo para obtener el concepto")
	void testGetConcepto() {
		m.setConcepto("Compra Navideña");
		assertThat("Error en el metodo para obtener el concepto", m.getConcepto(), is("Compra Navideña"));
	}

	@Test
	@DisplayName("Test al metodo para indicar el concepto")
	void testSetConcepto() {
		m.setConcepto("Compra Navideña");
		assertThat("Error el metodo para obtener el concepto", m.getConcepto(), is("Compra Navideña"));
	}

	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Test al metodo para obtener la fecha")
	void testGetFecha() {
		Date time = new Date();
		time.setYear(2);
		m.setFecha(time);
		System.out.println(time);
		assertThat("Error en el metodo para obtener la fecha", m.getFecha(), is(time));
		
	}
	

	@Test
	@DisplayName("Test al metodo para indicar la fecha")
	void testSetFecha() {
		m.setFecha(null);
		assertThat("Error en el metodo para obtener la fecha", m.getFecha(), nullValue());
	}

	@Test
	@DisplayName("Test al metodo para indicar el importe")
	void testSetImporte() {
		double importe =120;
		m.setImporte(importe);
		assertThat("Error en el metodo para obtener el importe", m.getImporte(), is(importe));
	}

}
