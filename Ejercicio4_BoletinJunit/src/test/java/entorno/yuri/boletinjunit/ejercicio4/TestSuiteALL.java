package entorno.yuri.boletinjunit.ejercicio4;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.*;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.CoreMatchers;
@Suite
@SelectClasses( { BoaTest.class, FridgeTest.class, OperadorAritmeticoTest.class, PilaTest.class, SubscripcionTest.class, AccountTest.class } )
@DisplayName("Suite que ejecuta todos los test")
public class TestSuiteALL extends CoreMatchers{

}
