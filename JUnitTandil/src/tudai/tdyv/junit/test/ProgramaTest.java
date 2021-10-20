/********************************ProgramaTest.java****************************************/
package tudai.tdyv.junit.test;
import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import tudai.junit.java.Programa;
import tudai.junit.java.Programacion;
import tudai.junit.java.ProgrmacionNoEncontradaException;
import tudai.junit.java.Tarea;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

//extends TestCase
public class ProgramaTest {
	
	private Programa 		_defaultPrograma;
	private Programacion 	_defaultProgramacion;
	private Tarea			_defaultTarea;
	
	
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestPrograma -> BeforeClass ");
	}
	/**
	 * Metodo tearDown para propiedades de clase
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestPrograma -> AfterClass ");
	}

	/**
	 * Metodo setup para instancias de test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("TestPrograma -> _Before___Setup");
		
	}
	/**
	 * Metodo tearDown para instancias de test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("TestPrograma -> After");
	}
	
	@Test
	public void testPrograma() {
		System.out.println("TestPrograma -> testPrograma");
	}
	/**
	 * Prueba el metodo de cantidad de ocurrencias
	 * La prueba se realiza vaciando las programaciones existentes y luego agrega tres
	 * programaciones. La cantidad de programaciones debe ser exactamente 3
	 */
	@Test
	public void testGetCantOcurrencias() {
		System.out.println("TestPrograma -> TestCantidadOcurrencias");
	}
	/**
	 * Prueba el metodo getCantTareasEntre
	 * La prueba se realiza insertando tres tareas de las cuales exactamente 2
	 * cumplen los requisitos
	 */

	@Test
	public void testGetCantTareasEntre() {
		System.out.println("TestPrograma -> testGetCantTareasEntre");
	}

	/**
	 * Prueba el metodo addPrrogramacion
	 * La prueba se realiza insertando una programacion nueva. El resultado es un
	 * programa con una nueva programacion
	 */
	@Test
	public void testAddProgramacion() {
		System.out.println("TestPrograma ->testAddProgramacion");
	}

	/**
	 * Prueba el metodo removeProgramacion
	 * La prueba se realiza insertando una programacion, 
	 * luego se calculan cuantas programaciones se tienen y posteriormente
	 * se elimina. La cantidad de programaciones debe haber disminuido
	 * @throws ProgrmacionNoEncontradaException 
	 */
	@Test
	public void testRemoveProgramacion() throws ProgrmacionNoEncontradaException {
		System.out.println("TestPrograma -> testRemoveProgramacion");
		
	}
	
	@Test
	public void testEliminarProgramaciones() {
		System.out.println("TestPrograma -> testEliminarProgramaciones");
	}

	@Test
	public void testProgramaVacio() {
		System.out.println("TestPrograma -> testProgramaVacio");

	}
	
	@Test
	public void testIniciar() throws InterruptedException {
		
		System.out.println("TestPrograma -> Test Iniciar");
		
	}
	
}