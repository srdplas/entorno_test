package entorno.yuri.tarea5;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
@DisplayName("Test a la clase Cuenta")
class CuentaTest extends CoreMatchers {

	private Cuenta c;
	
	private String numCuenta, titular, asunto;
	private double ingreso, retiro;

	
	
	static Stream<Arguments> cuenta() {
		return Stream.of(

				Arguments.of("123", "Yuri", 100.99, 59.99, "Compras de Naviadd"),
				Arguments.of("612", "Fernando", -50.51, -30, "Deudas"),
				Arguments.of("222", "Antonio", 100.99, 20.99, "Materil Escolar")

		);
	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al constructor")
	void testCuenta(String numCuenta, String titular) {

		c = new Cuenta(numCuenta, titular);

		assertThat("Error el constructor no funciona", c.mTitular, is(titular));
	}// Constructor

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para ingresar dinero")
	void testIngresarDouble(String numCuenta, String titular, double ingreso) throws Exception {

		c = new Cuenta(numCuenta, titular);
		if (ingreso <= 0) {
			ingreso = 1;
		}
		c.ingresar(ingreso);

		assertThat("Error el metodo Ingresar_Double no funciona", c.getSaldo(), is(ingreso));

	}// Ingresar dinero double

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para retirar dinero")
	void testRetirarDouble(String numCuenta, String titular, double ingreso, double retiro) throws Exception {
		c = new Cuenta(numCuenta, titular);

		if (retiro <= 0 || ingreso <= 0) {
			ingreso = 1;
			retiro = 1;

		}
		c.ingresar(ingreso);
		c.retirar(retiro);
		double op = ingreso - retiro;
		assertThat("Error el metodo Ingresar_Double no funciona", c.getSaldo(), is(op));
	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para ingresar dinero con asunto")

	void testIngresarStringDouble(String numCuenta, String titular, double ingreso, double retiro, String asunto)
			throws Exception {
		c = new Cuenta(numCuenta, titular);

		if (ingreso <= 0) {
			ingreso = 1;

		}

		c.ingresar(asunto, ingreso);

		assertThat("Error en el metodo ingresar con asunto", c.mMovimientos.size(), is(1));

	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para retirar dinero con asunto")
	void testRetirarStringDouble(String numCuenta, String titular, double ingreso, double retiro, String asunto) throws Exception {
		c = new Cuenta(numCuenta, titular);

		if (ingreso <= 0||retiro<=0) {
			ingreso = 1;
			retiro=1;

		}

		c.ingresar(asunto, ingreso);
		c.retirar(asunto, retiro);
		assertThat("Error en el metodo ingresar con asunto", c.mMovimientos.size(), is(2));
	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para obtrner el saldo")
	void testGetSaldo(String numCuenta, String titular, double ingreso) throws Exception {

		c = new Cuenta(numCuenta, titular);
		if (ingreso <= 0) {
			ingreso = 1;
		}
		c.ingresar(ingreso);
		assertThat("Error el metodo getSaldo", c.getSaldo(), is(ingreso));

	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para añadir un movimiento")
	void testAddMovimiento(String numCuenta, String titular, double ingreso) {
		c = new Cuenta(numCuenta, titular);
		Movimiento m = new Movimiento();
		m.setConcepto("Pruebas");
		c.addMovimiento(m);

		assertThat("Error en el metodo ingresar con asunto", c.mMovimientos.size(), is(1));

	}

}
