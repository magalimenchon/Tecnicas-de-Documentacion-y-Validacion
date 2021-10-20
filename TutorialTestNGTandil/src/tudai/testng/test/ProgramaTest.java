package tudai.testng.test;

/*********** PASO 2 ********************/
//Sirve para ver el orden/flujo/hilo de ejecución
import org.testng.annotations.Test;

import tudai.testng.src.Tarea;
import tudai.testng.src.Usuario;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ProgramaTest {

	@DataProvider
	// Define una matriz de objetos
	public Object[][] dp() {
		System.out.println("dp()");
		return new Object[][] {
				// cada fila representa al conjunto de parametros de la invocacion
				// de un test, de una invocación
				new Object[] { 1, "a" }, new Object[] { 2, "b" }, };// se puede empaquetar directamente el objeto del
																	// parámetro y mandar directamente un objeto.
	}

	// Test que utiliza un proveedor de datos "dp"
	//En los resultados del test tenemos:
	/**
	 * Test Provider ->
	 * 				1, "a"
	 * Test Provider ->
	 * 				2, "b"
	 */
	//Se llama 2 veces (1 vez por cada fila), y cada instanciacion o llamado en particular
	//se llamó con los datos definidos en la matriz
	@Test(dataProvider = "dp")
	public void TestProvider(Integer n, String s) {
		System.out.println("f(" + s + ")");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod()");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest()");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest()");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite()");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite()");
	}

	@Test
	public void addProgramacion() {
		System.out.println("addProgramacion");
	}

	@Test
	public void eliminarProgramaciones() {
		System.out.println("EliminarProgramaciones");
	}

	@Test
	public void getCantOcurrencias() {
		System.out.println("getCantOcurrencias");
	}

	@Test
	public void getCantProgramaciones() {
		System.out.println("getCantProgramaciones()");
	}
/*
	@Test
	public void getCantTareasEntre() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void programaVacio() {
		// throw new RuntimeException("Test not implemented");
		fail();
	}

	@Test
	public void removeProgramacion() {
		System.out.println("Remove Programacion");
		throw new RuntimeException("Test not implemented");
	}
*/
	/*********** PASO 3 DESDE ACA *******************/

	@DataProvider(name = "generador-usr")
	public Usuario[] dpUsers() {
		// se informa que se generaran usuarios
		System.out.println("Generando Usuarios");
		// directamente se hace un arreglo de usuarios
		Usuario ret[] = new Usuario[7];

		ret[0] = new Usuario("Juan", "1979-01-01", 42, true);
		ret[1] = new Usuario("Pedro", "1980-02-01", 41, true);
		ret[2] = new Usuario("Maria", "1981-03-01", 47, true);
		ret[3] = new Usuario("Cecilia", "1983-04-01", 38, true);
		ret[4] = new Usuario("Carlos", "1985-04-01", 36, true);
		ret[5] = new Usuario("Jose", "1987-04-01", 34, true);
		ret[6] = new Usuario("Quique", "23-01-1980", 41, true);
		return ret;
		// Acá directamente se podria usar las funciones de JDK estandars,
		// se carga directamente de un archivo de texto, un JSON, o de la red
		// por ejemplo, consultando con un endpoint y obteniendo los datos, etc
	}

	//Usa el DataProvider de arriba
	//Este método se llamará tantas veces como elementos haya generado el DataProvider.
	//Sitengo que probar un método que no necesariamente
	//tiene un unico objeto, que puede tener varios objetos de parametro,
	//Se puede interpretar como que cada fila de la matriz es un llamado distinto a un test, 
	//y cada columna es un parametro de cada uno de los parametros de ese llamado especifico.
	//Fila == cada uno de los llamados a los test.
	//Columna == cada uno de los parametros del test.
	//Aca se instancia mas simple con un unico objeto
	//Se va a repetir el test de los 7 usuarios 5 veces.
	@Test(dataProvider = "generador-usr", invocationCount=5)
	public void testUsr(Usuario u) {
		System.out.println("f(" + u.getNombre() + ")");
	}

	/************* HASTA ACA ******************/

	/************** PASO 6 ************************/
	@Test
	@Parameters({ "prog-count" })
	//El parametro prog-count, va a alimentar el parametro de la funcion (el int count)
	//Sino se ejecuta desde el xml, no tiene parámetro para agarrar, por eso
	//se debe agregar el optional, sino se define ejecuta con 10
	public void addMuchasProgramaciones(@Optional("10") int count) {
		
		//System.out.println("Se crearan: " + count);
		
		//este parametro podria utilizarse por ejemplo para generar determinada situacion o
		//cantidad de tiempo, o realizar determinada cant de consultas.
		for(int i=0; i<count; i++)
			System.out.println("i: " + i);
	}

	/************* HASTA ACA ********************/
	//IDEA DE ALEATORIEDAD
	/******************* PASO 7 ******************/
	  @DataProvider (name="gen-rand")
	  public Iterator<Object[]> getRandTask(){
		  //Se prepara una cant aleatoria de datos 
		  final Random r = new Random(101);
		  //arreglo que contiene tareas
		  ArrayList<Object[]> dp = new ArrayList<Object[]>();
		  //devuelve un int entre 0 y 100
		  int instCount = r.nextInt(100);
		  	//se agregan una cantidad aleatoria de tareas al arreglo dp que tareas
			for (int i = 0; i < instCount; i++)
				//se agrega una tarea
				dp.add(new Object[] {
										new Tarea("Tarea" + i) 
									}
			);
			return dp.iterator();
	  }
	  /*************HASTA ACA***************/
	  //se define un test para el dataprovider anterior
	  @Test(dataProvider="gen-rand")
	  public void testTareas(Object o) {
		  System.out.print("("+o+")");
	  }
}
/***************** HASTA ACA ********************/
