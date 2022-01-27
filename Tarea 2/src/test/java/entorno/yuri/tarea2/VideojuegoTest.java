package entorno.yuri.tarea2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;


public class VideojuegoTest {

    private static Videojuego video, video2;
    
    @BeforeAll
    static void init(){
        video = new Videojuego();
        video2 = new Videojuego();
    }
    
    @AfterAll
    static void finish(){
        video=null;
        video2=null;
    }
    
	@Test
	public void testGetTitulo() {
		
		video.setTitulo("The Witcher 3");
		assertEquals("The Witcher 3", video.getTitulo(), "Error Metodo no funciona");
	}

	@Test
	public void testSetTitulo() {
		
		video.setTitulo("The Witcher 3");
		assertEquals("The Witcher 3", video.getTitulo(), "Error Metodo no funciona");
	}

	@Test
	public void testGetHorasEstimadas() {
		
		video.setHorasEstimadas(60);
		assertEquals(60, video.getHorasEstimadas(), "Error Metodo no funciona");
	}

	@Test
	public void testSetHorasEstimadas() {
		
		video.setHorasEstimadas(60);
		assertEquals(60, video.getHorasEstimadas(), "Error Metodo no funciona");
	}

	@Test
	public void testGetGenero() {
		
		video.setGenero("Accion");
		assertEquals("Accion", video.getGenero(), "Error Metodo no funciona");
	}

	@Test
	public void testSetGenero() {
		
		video.setGenero("Accion");
		assertEquals("Accion", video.getGenero(), "Error Metodo no funciona");
	}

	@Test
	public void testGetcompañia() {
		
		video.setcompañia("CD Proyect");
		assertEquals("CD Proyect", video.getcompañia(), "Error Metodo no funciona");
	}

	@Test
	public void testSetcompañia() {
		
		video.setcompañia("CD Proyect");
		assertEquals("CD Proyect", video.getcompañia(), "Error Metodo no funciona");
	}

	@Test
	public void testEntregar() {
		
		video.entregar();
		assertTrue(video.isEntregado(), "Error Metodo no funciona");
	}

	@Test
	public void testDevolver() {
		
		video.entregar();
		video.devolver();
		assertFalse(video.isEntregado(), "Error Metodo no funciona");
	}

	@Test
	public void testIsEntregado() {
		
		video.entregar();
		video.devolver();
		video.entregar();
		
		assertTrue(video.isEntregado(), "Error Metodo no funciona");
	}

	@Test
	public void testCompareTo() {
		
		
		video.setHorasEstimadas(55);
		video2.setHorasEstimadas(55);
		
		assertEquals(0, video.compareTo(video2), "Error metodo no funciona");
	}

	@Test
	public void testEqualsVideojuego() {
		
		video.setTitulo("DOTA");
		video.setcompañia("OpenH");
		video2.setTitulo("DOTA");
		video2.setcompañia("OpenH");
		
		assertTrue(video.equals(video2), "Error metodo no funciona");
	}
        
        
        
        
	@Test
	public void testVideojuego() {
		video = new Videojuego();
		assertEquals(100,video.getHorasEstimadas(), "Error metodo no funciona");
	}
       
	@Test
	public void testVideojuegoStringString() {
		video = new Videojuego("GTA V", "RockStar");
                assertEquals("GTA V", video.getTitulo(), "Error metodo no funciona");
                assertEquals("RockStar", video.getcompañia(), "Error metodo no funciona");
                
	}

	@Test
	public void testVideojuegoStringIntStringString() {
		video = new Videojuego("Borderlands 2", 200, "Accion", "RealiseDex");
                assertEquals("Borderlands 2", video.getTitulo(), "Error metodo no funciona");
                assertEquals(200, video.getHorasEstimadas(), "Error metodo no funciona");
                assertEquals("Accion", video.getGenero(), "Error metodo no funciona");
                assertEquals("RealiseDex", video.getcompañia(), "Error metodo no funciona");
                
	}

}
