package entorno.yuri.tarea5;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CreditoTest.class, CuentaTest.class, MovimientoTest.class, DebitoTest.class})
@DisplayName("Suite Test Tarea 5")
public class Test_General extends CoreMatchers {

}
