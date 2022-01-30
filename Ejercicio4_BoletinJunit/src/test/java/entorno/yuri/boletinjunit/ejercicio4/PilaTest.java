package entorno.yuri.boletinjunit.ejercicio4;


import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Assert;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
class PilaTest extends CoreMatchers{
	

	
	@Test
	void testPush() {
		Pila p = new Pila();
		p.push(21);
		assertThat("Error el metodo push() no funciona", p.top(), nullValue());
	}


	@Test
	void testPop() {
		Pila p = new Pila();
		p.push(10);
		assertThat("Error el metodo push() no funciona", p.pop(),is(10));
		assertThat("Error no se quita de la pila", p.isEmpty(), is(true));
	}

	@Test
	void testIsEmpty() {
		Pila p = new Pila();
		p.push(50);
		assertThat("Error el metodo isEmpty() no funciona", p.isEmpty(), is(true));
	}

	@Test
	void testTop() {
		Pila p = new Pila();

		p.push(5);
		p.push(12);
		p.push(3);
		p.push(2);
		assertThat("Error el metodo top() no funciona", p.top(), is(3));
	}

}
