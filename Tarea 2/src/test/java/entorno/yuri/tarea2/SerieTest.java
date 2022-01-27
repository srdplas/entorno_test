package entorno.yuri.tarea2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;

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
	public void testGetTitulo() {
		
		serie.setTitulo("Daredevil");
		assertEquals("Daredevil",serie.getTitulo(), "Error el metodo no funciona");
	}
	
	@Test
	public void testSetTitulo() {
		
		serie.setTitulo("Spider-Man");
		assertEquals("Spider-Man",serie.getTitulo(), "Error el metodo no funciona");
	}

	@Test
	public void testGetnumeroTemporadas() {
		
		serie.setnumeroTemporadas(4);
		assertEquals(4,serie.getnumeroTemporadas(), "Error el metodo no funciona");
	}

	@Test
	public void testSetnumeroTemporadas() {
		
		serie.setnumeroTemporadas(12);
		assertEquals(12,serie.getnumeroTemporadas(), "Error el metodo no funciona");
	}

	@Test
	public void testGetGenero() {
		
		serie.setGenero("Marvel");
		assertEquals("Marvel",serie.getGenero(), "Error el metodo no funciona");
	}

	@Test
	public void testSetGenero() {
		
		serie.setGenero("Fantasia");
		assertEquals("Fantasia",serie.getGenero(), "Error el metodo no funciona");
	}

	@Test
	public void testGetcreador() {
		Serie serie = new Serie();
		serie.setcreador("Stan Lee");
		assertEquals("Stan Lee",serie.getcreador(), "Error el metodo no funciona");
	}

	@Test
	public void testSetcreador() {
		
		serie.setcreador("Stan Lee");
		assertEquals("Stan Lee",serie.getcreador(), "Error el metodo no funciona");
	}

	@Test
	public void testEntregar() {
		
		serie.devolver();
		serie.entregar();
		assertTrue(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	public void testDevolver() {
		
		serie.entregar();
		serie.devolver();
		assertFalse(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	public void testIsEntregado() {
		
		serie.entregar();
		serie.devolver();
		serie.entregar();
		serie.devolver();
		assertFalse(serie.isEntregado(), "Error metodo no funciona");
	}

	@Test
	public void testCompareTo() {
		
		serie.setnumeroTemporadas(2);
		serie2.setnumeroTemporadas(4);
		
		
		assertEquals(-1, serie.compareTo(serie2), "Error metodo no funciona");
	}


	@Test
	public void testEqualsSerie() {
		
		serie.setTitulo("Daredevil");
		serie.setcreador("Marvel");
		serie2.setTitulo("Bolt");
		serie2.setcreador("Disney");
		int igual = -1;
		
		
		
		assertFalse(serie.equals(serie2));
	}

	@Test
	public void testSerie() {
		
		serie = new Serie();
		assertEquals(3,serie.getnumeroTemporadas(), "Error metodo no funciona");
	}

	@Test
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
