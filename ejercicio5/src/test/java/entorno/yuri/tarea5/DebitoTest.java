package entorno.yuri.tarea5;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Date;
import org.hamcrest.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DebitoTest extends CoreMatchers{

	

	@Test
	@DisplayName("Test al metodo para retirar dinero")
	void testRetirar() throws Exception {
		Date date = new Date();
		Debito d = new Debito("123", "Yuri", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		d.mCuentaAsociada.ingresar(250);
		d.retirar(200);
		assertThat("Error en el metodo retirar", d.getSaldo(), is(50.00));
		
	}

	@Test
	@DisplayName("Test al metodo para ingresar dinero")
	void testIngresar() throws Exception {
		Date date = new Date();
		Debito d = new Debito("123", "Yuri", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		d.mCuentaAsociada.ingresar(200);//El dinero de la cuenta
		d.ingresar(50);//Hemos sacado de la cuenta 50€ y metido a la tarjeta 
		assertThat("Error en el metodo retirar", d.getSaldo(), is(150.00));
	}

	@Test
	@DisplayName("Test al metodo para pagar en el establecimiento")
	void testPagoEnEstablecimiento() throws Exception {
		Date date = new Date();
		Debito d = new Debito("123", "Yuri", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		d.mCuentaAsociada.ingresar(20);
		d.pagoEnEstablecimiento("Yuri", 12);
		
		assertThat("Error en el metodo retirar", d.getSaldo(), is(8.00));
	}

	@Test
	@DisplayName("Test al metodo para obtener el saldo de la tarjeta")
	void testGetSaldo() throws Exception {
		Date date = new Date();
		Debito d = new Debito("123", "Yuri", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		d.mCuentaAsociada.ingresar(20);
		
		assertThat("Error en el metodo retirar", d.getSaldo(), is(20.00));
	}

	@Test
	@DisplayName("Test al constructor")
	void testDebito() throws Exception {
		Date date = new Date();
		Debito d = new Debito("123", "Yuri", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		
		assertThat("Error en el metodo retirar", d.mTitular, startsWith("Yuri"));
		
	}



	@Test
	@DisplayName("Test al metodo para indicar la cuenta")
	void testSetCuenta() throws Exception {
		Date date = new Date();
		Debito d = new Debito("Yuri", "123", date);
		Cuenta c = new Cuenta("123", "Yuri");
		d.setCuenta(c);
		d.mCuentaAsociada.ingresar(50);
		
		assertThat("Error en el metodo retirar", d.getSaldo(), is(50.00));
	}

}
