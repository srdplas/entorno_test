package entorno.yuri.tarea5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
@DisplayName("Test a la clase Cuenta")
class CuentaTest extends CoreMatchers{

	
	private Cuenta c;
	private Movimiento m;
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
		
		c= new Cuenta(numCuenta, titular);
		
		assertThat("Error el constructor no funciona",c.mTitular, is(titular));
	}//Constructor

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para ingresar dinero")
	void testIngresarDouble(String numCuenta, String titular, double ingreso) throws Exception{
		
		c= new Cuenta(numCuenta, titular);
		if(ingreso<=0) {
			ingreso=1;
		}
		c.ingresar(ingreso);
		
		assertThat("Error el metodo Ingresar_Double no funciona", c.getSaldo(), is(ingreso));
		
	}//Ingresar dinero double

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para retirar dinero")
	void testRetirarDouble(String numCuenta, String titular, double ingreso, double retiro) throws Exception {
		c= new Cuenta(numCuenta, titular);
		
		
		if(retiro<=0||ingreso<=0) {
			ingreso=1;
			retiro=1;
			
		}
		c.ingresar(ingreso);
		c.retirar(retiro);
		double op = ingreso-retiro;
		assertThat("Error el metodo Ingresar_Double no funciona", c.getSaldo(), is(op));
	}

	@ParameterizedTest
	@MethodSource("cuenta")
	@DisplayName("Test al metodo para ingresar dinero con asunto")
	@Disabled
	void testIngresarStringDouble(String numCuenta, String titular, double ingreso, String asunto) throws Exception {
		c= new Cuenta(numCuenta, titular);
		
		c.ingresar(asunto, ingreso);
		
		assertThat("Error el metodo ingresar_String_Double, la cantidad no funciona",is(true));
		
	}

	@Test
	@DisplayName("Test al metodo para retirar dinero con asunto")
	@Disabled
	void testRetirarStringDouble() {
		fail("Not yet implemented");
	}

	@ParameterizedTest
	@MethodSource("cuenta")
	void testGetSaldo(String numCuenta, String titular, double ingreso) throws Exception {
		
		c= new Cuenta(numCuenta, titular);
		if(ingreso<=0) {
			ingreso=1;
		}
		c.ingresar(ingreso);
		assertThat("Error el metodo getSaldo", c.getSaldo(), is(ingreso));
		
	}

	@Test
	@Disabled
	void testAddMovimiento(String numCuenta, String titular, double ingreso) {
		c= new Cuenta(numCuenta, titular);
		c.addMovimiento(m);
		
	}

}
