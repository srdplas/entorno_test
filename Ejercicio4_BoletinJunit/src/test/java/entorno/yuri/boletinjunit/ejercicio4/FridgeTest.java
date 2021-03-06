package entorno.yuri.boletinjunit.ejercicio4;


import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import java.util.stream.Stream;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert.*;
@DisplayName("Test a la clase Fridge")
class FridgeTest extends CoreMatchers {

	private String contenido;
	private static Fridge f;

	@BeforeAll
	static void init() {
		f = new Fridge();
	}

	@AfterAll
	static void finis() {
		f = null;
	}

	@Parameters
	static Stream<Arguments> contenidoFrigo() {
		return Stream.of(

				Arguments.of("Pollo"), Arguments.of("Manzana"), Arguments.of("Pera"));
	}

	@ParameterizedTest
	@MethodSource("contenidoFrigo")
	@DisplayName("Test al metodo para añadir items el frigorifico")
	void testPut(String contenido) {
		f.put(contenido);
		f.put(null);
		boolean colocar;
		if (f.contains(contenido)) {
			colocar = true;
		} else {
			colocar = false;
		}

		assertThat("Error el metodo put() no funciona", f.contains(contenido), equalTo(colocar));
	}

	@ParameterizedTest
	@MethodSource("contenidoFrigo")
	@DisplayName("Test al metodo para obtener el contenido del frigorifico")
	void testContains(String contenido) {

		f.put(contenido);

		boolean colocar;
		if (f.contains(contenido)) {
			colocar = true;
		} else {
			colocar = false;
		}

		assertThat("Error el metodo contains() no funciona", f.contains(contenido), equalTo(colocar));
	}

	@ParameterizedTest
	@MethodSource("contenidoFrigo")
	@DisplayName("Test al metodo para coger un item del frigorifico")
	void testTake(String contenido) throws NoSuchItemException {
		
		f.take(contenido);

		assertThat("Error el metodo contains() no funciona", f.contains(contenido), is(false));
	}

}
