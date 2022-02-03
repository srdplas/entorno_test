package entorno.srdplas.examen;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Test a la clase cuenta")
@SuppressWarnings("unused")
class CuentaTest extends CoreMatchers{

	private static Cuenta c;
	
	
	@Test
	@DisplayName("Test al constructor")
	void testCuenta() {
		c= new Cuenta("666", "Yuri");
		assertThat("Error en el cosntructor de la clase cuenta",c.mTitular, is("Yuri"));
	}

	@Test
	@DisplayName("Test al metodo para ingresar dinero")
	void testIngresar() throws IngresoNegativoException {
		c= new Cuenta("666", "Yuri");
		c.ingresar("MiExamen", 200);
		assertThat("Error en el metodo ingresar de la clase Cuenta", c.getSaldo(), equalTo(200.00));
		assertThat("Error en el metodo ingresar de la clase Cuenta", c.mMovimientos.size(), equalTo(1));
	}

	@Test
	@DisplayName("Test al metodo para retirar dinero")
	void testRetirar() throws IngresoNegativoException, SaldoInsuficienteException {
		c= new Cuenta("666", "Yuri");
		c.ingresar("Aprobamos", 50.00);
		c.retirar("Aprobamos", 20.00);
		assertThat("Error en el metodo retirar de la clase Cuenta", c.getSaldo(), is(30.00));
		assertThat("Error en el metodo ingresar de la clase Cuenta", c.mMovimientos.size(), is(2));
	}

	@Test
	@DisplayName("Test al metodo para obtener el saldo de la cuenta")
	void testGetSaldo() throws IngresoNegativoException {
		c= new Cuenta("666", "Yuri");
		c.ingresar("Aprobamos", 25.00);
		c.ingresar("Aprobamos", 15.00);
		assertThat("Error en el metodo retirar de la clase Cuenta", c.getSaldo(), is(40.00));
		assertThat("Error en el metodo ingresar de la clase Cuenta", c.mMovimientos.size(), is(2));
	}

	@Test
	void testAddMovimiento() {
		c= new Cuenta("666", "Yuri");
		Movimiento m = new Movimiento();
		m.setConcepto("Testeito");
		m.setImporte(100.00);
		c.addMovimiento(m);
		assertThat("Error en el metodo ingresar de la clase Cuenta", c.mMovimientos.size(), equalTo(1));
		assertThat("Error en el metodo retirar de la clase Cuenta", c.getSaldo(), equalTo(100.00));
		
	}

}
