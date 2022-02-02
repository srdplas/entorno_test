package entorno.yuri.boletinjunit.ejercicio4;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.AnyOf;
import org.hamcrest.object.HasToString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
@DisplayName("Test a la clase Account")
class AccountTest extends CoreMatchers{
	
	private Account cuenta;
	
	private String duenio;
	private long numCuenta;
	private float dinero, deposito, retiro, tarifa;
	private boolean exitoRetiro=false;
	
	
	
	static Stream<Arguments> cuentas() {
		
		return Stream.of(
				
				Arguments.of("Yuri", 13,500, -1, 200, -1, false), 
				Arguments.of("Carlos", 11, 700, 900, 800, 20, false), 
				Arguments.of("Javi", 10, 1200,100, 500, 40, true)
		);
	}

	@MethodSource("cuentas")
	@ParameterizedTest
	@DisplayName("Test Constructor")
	void testAccount(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		long numeroCuenta=0;
		
		if(numCuenta==13) {
			numeroCuenta=numCuenta;
		
		}if(numCuenta==11) {
			numeroCuenta=numCuenta;
		
		}if(numCuenta==10) {
			numeroCuenta=numCuenta;
		}
		
		
		
		assertThat("Error el constructor no funciona",cuenta.getAccountNumber(), is(numeroCuenta));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo para depositar dinero en la cuenta")
	void testDeposit(String duenio, long numCuenta, float dinero, float deposito) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		boolean depositado;
		if(deposito>0) {
			depositado=true;
		}else {
			depositado=false;
		}
		
		assertThat("Error el metodo deposit no funciona", cuenta.deposit(deposito), is (depositado));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo para sacar dinero")
	void testWithdraw(String duenio, long numCuenta, float dinero, float deposito, float retiro, float tarifa, boolean exitoRetiro) {
		
		cuenta= new Account(duenio, numCuenta, dinero);

		assertThat("Error el metodo withdraw no funciona", cuenta.withdraw(retiro, tarifa), is (exitoRetiro));
	}
	

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo para añadir interes al dinero")
	void testAddInterest(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		float intereses=0.045f;
		float interes=dinero+(dinero*intereses);
		cuenta.addInterest();
		assertThat("Error el metodo addInterest no funciona", cuenta.getBalance(), is(interes));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo para ver el balance de la cuenta")
	void testGetBalance(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		float cartera= dinero;
		float okBalance=-1;
		
		if(cartera==500) {
			okBalance=cartera;	
		}if(cartera==700) {
			okBalance=cartera;
		}if(cartera==1200) {
			okBalance=cartera;	
		}
		
		
		assertThat("Error el metodo getBalance no funciona", cuenta.getBalance(), is(okBalance));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo para obtener el numero de la cuenta")
	void testGetAccountNumber(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		long numeroCuenta=0;
		
		if(numCuenta==13) {
			numeroCuenta=numCuenta;
		
		}
		if(numCuenta==11) {
			numeroCuenta=numCuenta;
		
		}
		if(numCuenta==10) {
			numeroCuenta=numCuenta;
		}
		assertThat("Error el constructor no funciona",cuenta.getAccountNumber(), is(numeroCuenta));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	@DisplayName("Test al metodo toString")
	void testToString(String duenio, long numCuenta, float dinero) {
		cuenta= new Account(duenio, numCuenta, dinero);
		
		long id=numCuenta;
		assertThat("Error no funciona el toString",cuenta.toString(), is(containsString(duenio)));
	}


	
	
}
