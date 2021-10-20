/********************************ProgramaTest.java****************************************/
package tudai.tdyv.junit.test;

import static org.junit.Assert.*;

import java.util.Date;

import tudai.junit.java.Programa;
import tudai.junit.java.Programacion;
import tudai.junit.java.ProgrmacionNoEncontradaException;
import tudai.junit.java.Tarea;

/***********************ProgramaTest********************************************/
/* Imports */

import java.util.Date;

//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.jupiter.api.*;
//import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//extends TestCase
public class ProgramaTest {

	private Programa _defaultPrograma;
	private Programacion _defaultProgramacion;
	private Tarea _defaultTarea;

	/**
	 * Metodo setup para propiedades de clase
	 * 
	 * @throws Exception
	 */
	// @BeforeClass de JUnit4 === @BeforeAll de JUnit5
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestPrograma -> BeforeClass ");
	}

	/**
	 * Metodo tearDown para propiedades de clase
	 * 
	 * @throws Exception
	 */
	// @AfterClass de JUnit4 === @AfterAll de JUnit5
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestPrograma -> AfterClass ");
	}

	/**
	 * Metodo setup para instancias de test
	 * 
	 * @throws Exception
	 */
	// @Before de JUnit4 === @BeforeEach de JUnit5
	@BeforeEach
	public void setUp() throws Exception {
		Date d1 = new Date(2015, 12, 24, 22, 00);
		Date d2 = new Date(2015, 12, 25, 06, 00);
		System.out.println("Setup");

		_defaultTarea = new Tarea("Festejar Navidad");
		_defaultProgramacion = new Programacion(d1, d2, _defaultTarea);
		_defaultPrograma = new Programa();
	}

	/**
	 * Metodo tearDown para instancias de test
	 * 
	 * @throws Exception
	 */
	// @After de JUnit4 === @AfterEach de JUnit5
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("TestPrograma -> After");
	}

	@Test
	public void testPrograma() {
		System.out.println("TestPrograma -> testPrograma");
	}

	/**
	 * Prueba el metodo de cantidad de ocurrencias La prueba se realiza vaciando las
	 * programaciones existentes y luego agrega tres programaciones. La cantidad de
	 * programaciones debe ser exactamente 3
	 */
	// -----------------------------------------------/
	@RepeatedTest(5)
	// Darle nombre "amigable" para ver cómo funciona
	@DisplayName("Test de contar la cantidad de ocurrencias")
	public void testGetCantOcurrencias() {
		System.out.println("test GetCantOcurrencias");

		// inicialmente se eliminan todas las programaciones
		// por ej, eliminando todos los elementos de un arreglo
		_defaultPrograma.eliminarProgramaciones();
		// se espera que la cantidad de elementos del arreglo sea 0,
		// al haberlo vaciado
		assertEquals(0, _defaultPrograma.getCantProgramaciones());

		// se agrega 1 programacion
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		Date d1 = new Date(2016, 1, 23, 00, 00);
		Date d2 = new Date(2016, 1, 23, 23, 59);
		Date d3 = new Date(2016, 1, 06, 00, 00);
		Date d4 = new Date(2016, 1, 06, 06, 00);

		Tarea t1 = new Tarea("Festejar Cumpleanios");
		Tarea t2 = new Tarea("Cortar pasto para camellos");

		// la programación va a ser entre dos fechas d1 y d2,
		// y tendra una tarea t1 asociada
		Programacion cumpleanios = new Programacion(d1, d2, t1);
		Programacion reyes = new Programacion(d3, d4, t2);

		// se agregan 2 programaciones mas
		_defaultPrograma.addProgramacion(cumpleanios);
		_defaultPrograma.addProgramacion(reyes);

		// se espera que el arreglo tenga 3 programaciones
		assertEquals(3, _defaultPrograma.getCantProgramaciones(), "la cantidad debe ser 3");
	}

	/**
	 * Prueba el metodo getCantTareasEntre La prueba se realiza insertando tres
	 * tareas de las cuales exactamente 2 cumplen los requisitos
	 */

	@Test
	public void testGetCantTareasEntre() {
		// System.out.println("TestPrograma -> testGetCantTareasEntre");
		// forzando la muestra de una falla al ejecutar el test
		fail();
	}

	/**
	 * Prueba el metodo addPrrogramacion La prueba se realiza insertando una
	 * programacion nueva. El resultado es un programa con una nueva programacion
	 */
	// --------------------------------------------------
	@RepeatedTest(4)
	public void testAddProgramacion() {
		System.out.println("testAddProgramacion");
		// se chequea la cantidad que tengo de programaciones hasta el momento
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		// agrega 1
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		// se comprueba que al haber agregado 1, la cantidad anterior se haya
		// incrementado en 1.
		assertEquals(programacionesHastaElMomento + 1, _defaultPrograma.getCantProgramaciones());
	}

	/**
	 * Prueba el metodo removeProgramacion La prueba se realiza insertando una
	 * programacion, luego se calculan cuantas programaciones se tienen y
	 * posteriormente se elimina. La cantidad de programaciones debe haber
	 * disminuido
	 * 
	 * @throws ProgrmacionNoEncontradaException
	 */
	// ---------------------------------------

	@Test
	// dispara una excepción
	public void testRemoveProgramacion() throws ProgrmacionNoEncontradaException {
		System.out.println("testRemoveProgramacion");
		Date d1 = new Date(2015, 12, 31, 22, 00);
		Date d2 = new Date(2016, 1, 1, 06, 00);
		Tarea t = new Tarea("Recibir anio nnuevo");

		Programacion otraProgramacion = new Programacion(d2, d2, t);
		// se crean y se agrega 1 programacion
		_defaultPrograma.addProgramacion(otraProgramacion);
		// se chequea cuantas hay agregandola
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		// se la borra
		_defaultPrograma.removeProgramacion(otraProgramacion);
		// se chequea que haya cantidad - 1 por la borrada
		assertEquals(programacionesHastaElMomento - 1, _defaultPrograma.getCantProgramaciones());

	}

	// --------------------------------------------
	@Test
	public void testEliminarProgramaciones() {
		System.out.println("testEliminarProgramaciones");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(0, _defaultPrograma.getCantProgramaciones());

	}

	//-------------------------------------------
		@Test
		public void testProgramaVacio() {
			System.out.println("testProgramaVacio");
			//si se eliminan todas las programaciones
			_defaultPrograma.eliminarProgramaciones();
			//se verifica que el programa este vacio
			assertEquals(true,_defaultPrograma.programaVacio());
		}

	@Test
	public void testIniciar() throws InterruptedException {

		System.out.println("TestPrograma -> Test Iniciar");

	}

	// ----------------------------------------------
	// Reemplazar
	@Test
	public void testExpectedProgramacionNoEnconreadaException() {
		// JUnit 5 permite asegurarnos que una excepción se ejecute
		// Voy a pedirle que se dispare esa excepcion cuando...
		Assertions.assertThrows(ProgrmacionNoEncontradaException.class, () -> {
			// borro todo lo que haya en el arreglo de programaciones
			_defaultPrograma.eliminarProgramaciones();
			// posteriormente le pido que borre una programación dentro del arreglo (vacío)
			_defaultPrograma.removeProgramacion(_defaultProgramacion);
			// debería dispararse la excepcion
		});

	}

}