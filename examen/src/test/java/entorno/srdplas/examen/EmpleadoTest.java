package entorno.srdplas.examen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
@DisplayName("Test a los metodos para subir nota")
class EmpleadoTest extends CoreMatchers{

	
	private Empleado p;
	private String nombre, apellido;
	private int edad,mayor;
	private boolean condicion, condicion2;

	
	static Stream<Arguments> subirnota() {
		return Stream.of(
				
				Arguments.of("Manolo", "Fernandez", 17, 1000.00, 0, false, true), 
				Arguments.of("Manolo", "Fernandez",17,900.00, 0, false, true), 		
				Arguments.of("Carlos", "Sevilla",40, 750.00, 0, false, true)
		);
	}
	
	
	
	@ParameterizedTest
	@MethodSource("subirnota")
	void testPlus(String nombre, String apellido, int edad, double salario, int mayor, boolean condicion, boolean condicion2) {
		p= new Empleado(nombre, apellido, edad, salario);
		assertThat("Error en el metod Plus",p.plus(mayor), is(condicion));
	}

	@ParameterizedTest
	@MethodSource("subirnota")
	void testEqualsEmpleado(String nombre, String apellido, int edad, double salario, int mayor, boolean condicion, boolean condicion2) {
		p= new Empleado(nombre, apellido, edad, salario);
		
		assertThat("Error en el metod Plus",p.equals(p), is(condicion2));
	}

	@ParameterizedTest
	@MethodSource("subirnota")
	void testCompareTo(String nombre, String apellido, int edad, double salario, int mayor, boolean condicion, boolean condicion2) {
		p= new Empleado(nombre, apellido, edad, salario);
		assertThat("Error el metodo EqualsTest no funciona", p.compareTo(p), equalTo(mayor));
	}

}
