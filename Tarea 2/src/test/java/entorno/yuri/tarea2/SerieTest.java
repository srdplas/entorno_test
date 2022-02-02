package entorno.yuri.tarea2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;
@DisplayName("Test a la clase Serie")
public class SerieTest {

    private static Serie serie, serie2;
    
        @BeforeAll
        
        static void init(){
            serie = new Serie();
            serie2 = new Serie();
        }
        
        @AfterAll 
        static void finish(){
            serie = null;
            serie2 = null;
        }
    
	@Test
	@DisplayName("Test al metodo para obtener el titulo")
	public void testGetTitulo() {
		
		serie.setTitulo("Daredevil");
		assertEquals("Daredevil",serie.getTitulo(), "Error el metodo no funciona");
	}
	
	@Test
	@DisplayName("Test al metodo para indicar el titulo")
	public void testSetTitulo() {
		
		serie.setTitulo("Spider-Man");
		assertEquals("Spider-Man",serie.getTitulo(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para obtener el numero de temporadas")
	public void testGetnumeroTemporadas() {
		
		serie.setnumeroTemporadas(4);
		assertEquals(4,serie.getnumeroTemporadas(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para indicar el numero de temporadas")
	public void testSetnumeroTemporadas() {
		
		serie.setnumeroTemporadas(12);
		assertEquals(12,serie.getnumeroTemporadas(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para obtener el genero")
	public void testGetGenero() {
		
		serie.setGenero("Marvel");
		assertEquals("Marvel",serie.getGenero(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para indicar el genero")
	public void testSetGenero() {
		
		serie.setGenero("Fantasia");
		assertEquals("Fantasia",serie.getGenero(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para obtener el creador")
	public void testGetcreador() {
		Serie serie = new Serie();
		serie.setcreador("Stan Lee");
		assertEquals("Stan Lee",serie.getcreador(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para indicar el genero")
	public void testSetcreador() {
		
		serie.setcreador("Stan Lee");
		assertEquals("Stan Lee",serie.getcreador(), "Error el metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para entregar la serie")
	public void testEntregar() {
		
		serie.devolver();
		serie.entregar();
		assertTrue(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para devolver la serie")
	public void testDevolver() {
		
		serie.entregar();
		serie.devolver();
		assertFalse(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para obtener si esta entregado")
	public void testIsEntregado() {
		
		serie.entregar();
		serie.devolver();
		serie.entregar();
		serie.devolver();
		assertFalse(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para comparar una serie con otra")
	public void testCompareTo() {
		
		serie.setnumeroTemporadas(2);
		serie2.setnumeroTemporadas(4);
		
		
		assertEquals(-1, serie.compareTo(serie2), "Error metodo no funciona");
	}


	@Test
	@DisplayName("Test al metodo para saber si es igual a otra serie")
	public void testEqualsSerie() {
		
		serie.setTitulo("Daredevil");
		serie.setcreador("Marvel");
		serie2.setTitulo("Bolt");
		serie2.setcreador("Disney");
		int igual = -1;
		
		
		
		assertFalse(serie.equals(serie2));
	}

	@Test
	@DisplayName("Test al metodo para comprobar el constructor")
	public void testSerie() {
		
		serie = new Serie();
		assertEquals(3,serie.getnumeroTemporadas(), "Error metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para comprobar el constructor con 2 parametros")
	public void testSerieStringString() {
		serie = new Serie("Iron Man", "Marvel");
		/*boolean funciona=false;
		if("Iron Man".equals(serie.getTitulo())&&"Marvel".equals(serie.getcreador())) {
			funciona=true;
		}*/
		
               assertEquals("Iron Man", serie.getTitulo(), "Error metodo no funciona");
               assertEquals("Marvel", serie.getcreador(), "Error metodo no funciona");
	}

	@Test
	@DisplayName("Test al metodo para comprobar el constructor con varios parametros")
	public void testSerieStringIntStringString() {
		serie = new Serie("Thor", 2, "accion", "Marvel");
		/*boolean funciona=false;
		if("Thor".equals(serie.getTitulo())&&"Marvel".equals(serie.getcreador())&&2==serie.getnumeroTemporadas()&&"accion".equals(serie.getGenero())) {
			funciona=true;
		}*/
		assertEquals("Thor", serie.getTitulo(), "Error metodo no funciona");
                assertEquals(2, serie.getnumeroTemporadas(), "Error metodo no funciona");
                assertEquals("accion", serie.getGenero(), "Error metodo no funciona");
                assertEquals("Marvel", serie.getcreador(), "Error metodo no funciona");
	}

}
