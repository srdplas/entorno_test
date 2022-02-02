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
@DisplayName("Test a la clase Account Mirando BadMOney")
class AccountTestBadMoney extends CoreMatchers{
	
	private Account cuenta;
	
	private String duenio;
	private long numCuenta;
	private float dinero, deposito, retiro, tarifa;
	private boolean exitoRetiro=false;
	
	
	
	static Stream<Arguments> cuentas() {
		
		return Stream.of(
				
				Arguments.of("Yuri", 13,500f, -1, 200f, -1f, false), 
				Arguments.of("Carlos", 11, 700f, 900f, 800f, 20f, false), 
				Arguments.of("Javi", 10, 1200f,100f, 500f, 40f, true)
		);
	}

	@MethodSource("cuentas")
	@ParameterizedTest
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
	void testDeposit(String duenio, long numCuenta, float dinero, float deposito) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		boolean depositado;
		if(deposito>0f) {
			depositado=true;
		}else {
			depositado=false;
		}
		
		assertThat("Error el metodo deposit no funciona", cuenta.deposit(deposito), is (depositado));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	void testWithdraw(String duenio, long numCuenta, float dinero, float deposito, float retiro, float tarifa, boolean exitoRetiro) {
		
		cuenta= new Account(duenio, numCuenta, dinero);

		assertThat("Error el metodo withdraw no funciona", cuenta.withdraw(retiro, tarifa), is (exitoRetiro));
	}
	

	@ParameterizedTest
	@MethodSource("cuentas")
	void testAddInterest(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		float intereses=0.045f;
		float interes=dinero+(dinero*intereses);
		cuenta.addInterest();
		assertThat("Error el metodo addInterest no funciona", cuenta.getBalance(), is(interes));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
	void testGetBalance(String duenio, long numCuenta, float dinero) {
		
		cuenta= new Account(duenio, numCuenta, dinero);
		float cartera= dinero;
		float okBalance=-1;
		
		if(cartera==500f) {
			okBalance=cartera;	
		}if(cartera==700f) {
			okBalance=cartera;
		}if(cartera==1200f) {
			okBalance=cartera;	
		}
		
		
		assertThat("Error el metodo getBalance no funciona", cuenta.getBalance(), is(okBalance));
	}

	@ParameterizedTest
	@MethodSource("cuentas")
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
	void testToString(String duenio, long numCuenta, float dinero) {
		cuenta= new Account(duenio, numCuenta, dinero);
		
		long id=numCuenta;
		assertThat("Error no funciona el toString",cuenta.toString(), is(containsString(duenio)));
	}


	
	
}
