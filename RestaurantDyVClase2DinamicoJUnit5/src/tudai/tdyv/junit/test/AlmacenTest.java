/********************************AlmacenTest.java****************************************/
package tudai.tdyv.junit.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import restaurant.*;

/***********************AlmacenTest********************************************/
/* Imports */


//extends TestCase
public class AlmacenTest {
	
	//static Ingrediente ingATestear[];
	static List<Ingrediente> ingATestear;
	Ingrediente defaultIngrediente;
	
	//ESTE TEST ES DINAMICO
	@BeforeAll
	static void initClass() {
		ingATestear = new ArrayList<Ingrediente>();
		ingATestear.add(new Ingrediente("harina", "kgs", 10, 200));
		ingATestear.add(new Ingrediente("aceite", "kgs", 15, 200));
		ingATestear.add(new Ingrediente("papa", "kgs", 170, 200));
		ingATestear.add(new Ingrediente("huevo", "kgs", 150, 200));
		ingATestear.add(new Ingrediente("fideos", "kgs", 10, 200));
	}
	
	//Antes de ejecutar el método, tomamos aleatoriamente uno de los ingredientes para testear
	@BeforeEach
	void setUp() throws Exception {
		int cualTomamos = (int)(Math.random()*5);

		defaultIngrediente = AlmacenTest.ingATestear.get(cualTomamos);
	}
	@AfterEach
	void tearDown() throws Exception{
		
	}
	
	@RepeatedTest(15)
	void testIngresarConsumibles() {
		System.out.println(defaultIngrediente);

		// FORMA ALEATORIA, USANDO RANDOM DE INGREDIENTE
		//Obtiene la cantidad inicial del ingrediente random
		int cantidadInicial = defaultIngrediente.getStock();
		// Calculo aleatoriamente una cantidad para agregar
		int cantidadAgregada = (int) (Math.random() * 10);
		// agrego esa cantidad al almacen
		Almacen.IngresarConsumibles(defaultIngrediente, cantidadAgregada);
		// Se asegura que el stock se esta actualizando bien
		Assert.assertEquals(cantidadInicial + cantidadAgregada, defaultIngrediente.getStock());
	}
	
	@Test
	void testExtrarConsumibles() {
		Assert.fail("Not yet implemented");
	}
	
	//GENERANDO EL TEST DINAMICO
	@TestFactory
	Stream<DynamicTest>dynamicTestIngredientes(){
		
		return 
				//voy a hacer una cadena de test (stream de tests)
				AlmacenTest.ingATestear.stream().
				map(dom ->
				//se define un nombre por cada dinamic test (Testing + objeto que se va a probar)
					DynamicTest.dynamicTest("Testing: " + dom,
							() -> { 
									int cantidadInicial = dom.getStock();
									int cantidadAgregada = (int) (Math.random() * 10);
									Almacen.IngresarConsumibles(dom, cantidadAgregada);
									Assert.assertEquals(cantidadInicial + cantidadAgregada, dom.getStock());
								})
					);
	}


}