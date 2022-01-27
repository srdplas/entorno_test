package entorno.yuri.tarea3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	
	private static ShoppingCart sh;
	private static Product p,o;
	
	@BeforeAll
	
	static void init() {
		sh = new ShoppingCart();
		p = new Product("Pato", 21.6);
		o = new Product("Oso", 34.6);
	}
	
	
	@AfterAll
	static void finish() {
		sh=null;
	}
	
	@Test
	void testShoppingCart(){
	// 1. El carrito est� vacio cuando se crea
		
		assertEquals(0, sh.getItemCount(), "Error en el resultado esperado");
	}

	@Test
	void testGetBalance(){
		//4. Balance del carrito devuelve la suma de los precios de los items que haya en el carro
		
		sh.addItem(o);
		sh.addItem(p);
		assertEquals(56.2, sh.getBalance(), "Error en el resultado esperado");
		
	}

	@Test
	void testAddItem(){
		//3. Se incrementa la cuenta de items al añadir un item al carrito
		
		sh.addItem(p);
		assertEquals(1, sh.getItemCount(), "Error en el resultado esperado");
	}

	@Test
	void testRemoveItem(){
		
		//5. Al quitar un item del carrito la cuenta de items debe decrementarse
		
		sh.addItem(p);
		
		//6. Agregar un try y metodo fail cuando se intenta quitar un item que no estaba en el carro
		try {
		sh.removeItem(p);
		sh.removeItem(o);
		
		
		} catch (ProductNotFoundException e) {
			
			fail();
		}
		assertEquals(0, sh.getItemCount(), "Error resultado no esperado");
	}

	@Test
	void testGetItemCount(){
		
		assertEquals(0, sh.getItemCount());
		
	}

	@Test
	void testEmpty(){
		//2. Carrito 0 items al vaciarlo
		
		sh.addItem(p);
		sh.empty();
		assertEquals(0, sh.getItemCount(), "Error en el resultado esperado");
	}

}
