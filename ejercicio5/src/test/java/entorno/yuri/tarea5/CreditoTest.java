package entorno.yuri.tarea5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.CoreMatchers;

import org.hamcrest.object.HasEqualValues;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreditoTest extends CoreMatchers {

	private static Cuenta cuen, cuen2;
	private static Credito c, c2;
	private static Date date;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		c = new Credito("135", "Yuri", date, 200);
		cuen = new Cuenta("135", "Yuri");
		cuen.ingresar(100);
		c.setCuenta(cuen);

	}

	@AfterAll
	static void finish() {
		c = new Credito(null, null, date, 0);
		cuen=new Cuenta(null, null);
		c.setCuenta(cuen);
		
		
	}

	@Test
	@DisplayName("Test al metodo retirar dinero")
	void testRetirar() throws Exception {
		c.ingresar(100);
		c.retirar(100);

		assertThat("Error en el metodo retirar", c.mCuentaAsociada.getSaldo(), is(200.00));
	}

	@Test
	@DisplayName("Test al metodo ingresar dinero")
	void testIngresar() throws Exception {
		c.ingresar(100);
		
		assertThat("Error en el metodo ingresar", c.mCuentaAsociada.getSaldo(), is(300.00));
	}

	@Test
	@DisplayName("Test al metodo seleccionar cuenta")
	void testSetCuenta() throws Exception {
		cuen2 = new Cuenta("135", "yuri");
		c2 = new Credito("135", "Yuri", date, 200);
		c2.setCuenta(cuen2);

		assertThat("Error en el metodo setCuenta", c.mCuentaAsociada.getSaldo(), is(200.00));
	}

	@Test
	@DisplayName("Test al metodo para pagar en el establecimiento")
	void testPagoEnEstablecimiento() throws Exception {
		c.pagoEnEstablecimiento("Paga mensual", 20);
		assertThat("Error en el metodo pago en establecimiento", c.getSaldo(), is(23.00));
	}

	@Test
	@DisplayName("Test al metodo al constructor")
	void testCredito() {
		
		assertThat("Error en el constructor",c.mTitular, is("Yuri"));
	}

	@Test
	@DisplayName("Test al metodo para obtener el credito disponible de la tarjeta")
	void testGetCreditoDisponible() throws Exception {
		
		c = new Credito("135", "Yuri", date, 200);

		assertThat("Error en el metodo setCuenta", c.getCreditoDisponible(), is(200.00));
	}

	@Test
	@DisplayName("Test al metodo para liquidar la tarjeta")
	void testLiquidar() throws Exception {
		c.setCuenta(cuen);
		c.ingresar(22);
		
		c.liquidar(12, 2022);
		assertThat("Error en el metodo setCuenta", c.mMovimientos.size(), is(1));
	}

	@Test
	@DisplayName("Test al metodo para obtener el saldo de la cuenta")
	void testGetSaldo() throws Exception {
		c.retirar(20);

		assertThat("Error en el metodo para obtener el saldo", c.getSaldo(), is(3.00));
	}

}
