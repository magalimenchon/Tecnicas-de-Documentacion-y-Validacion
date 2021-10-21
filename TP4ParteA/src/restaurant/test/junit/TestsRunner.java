package restaurant.test.junit;

/**********************TestsRunner.java **********************************/
import org.junit.runner.JUnitCore;

import restaurant.test.TestSuite;

/**
 * Dado el c�digo provisto por la c�tedra, analizar la prueba aislada
 * (ver Main.java) para luego:
 * A. Generar los test que se describen a continuaci�n.
 * En el caso que el test falle, realizar la correcci�n o bien implementar
 * el c�digo faltante para que el caso se prueba se cumpla

 * @author Magal�
 *
 */
public class TestsRunner {

	 public static void main(String args[]) {
	        JUnitCore.runClasses(TestSuite.class);
	    }
	
}