package entorno.srdplas.examen;

import org.hamcrest.CoreMatchers;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({CuentaTest.class, MovimientoTest.class})
public class SuiteTest extends CoreMatchers{

}
