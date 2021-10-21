package restaurant.test.junit;

/**********************TestsRunner.java **********************************/
import org.junit.runner.JUnitCore;

import restaurant.test.TestSuite;

/**
 * Dado el código provisto por la cátedra, analizar la prueba aislada
 * (ver Main.java) para luego:
 * A. Generar los test que se describen a continuación.
 * En el caso que el test falle, realizar la corrección o bien implementar
 * el código faltante para que el caso se prueba se cumpla

 * @author Magalí
 *
 */
public class TestsRunner {

	 public static void main(String args[]) {
	        JUnitCore.runClasses(TestSuite.class);
	    }
	
}