/********************************AlmacenTest.java****************************************/
package tudai.tdyv.junit.test;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import restaurant.*;

/***********************AlmacenTest********************************************/
/* Imports */


//extends TestCase
public class AlmacenTest {
	
	static Ingrediente ingATestear[];
	Ingrediente defaultIngrediente;
	
	//ESTE TEST ES VARIABLE, NO DINAMICO
	@BeforeAll
	static void initClass() {
		ingATestear = new Ingrediente[5];
		ingATestear[0]= new Ingrediente("harina", "kgs", 10, 200);
		ingATestear[1]= new Ingrediente("aceite", "kgs", 15, 200);
		ingATestear[2]= new Ingrediente("papa", "kgs", 170, 200);
		ingATestear[3]= new Ingrediente("huevo", "kgs", 150, 200);
		ingATestear[4]= new Ingrediente("fideos", "kgs", 10, 200);
	}
	
	//Antes de ejecutar el método, tomamos aleatoriamente uno de los ingredientes para testear
	@BeforeEach
	void setUp() throws Exception {
		int cualTomamos = (int)(Math.random()*5);
		//System.out.println(cualTomamos);
		//System.out.println((int)(Math.random()*5));
		defaultIngrediente = AlmacenTest.ingATestear[cualTomamos];
	}
	@AfterEach
	void tearDown() throws Exception{
		
	}
	
	@RepeatedTest(15)
	void testIngresarConsumibles() {
		System.out.println(defaultIngrediente);
		/*//Tengo un ingrediente de 10 kgs
		Ingrediente harina = new Ingrediente("harina", "kgs", 10, 200);
		//Agrego al almacen 15 kgs
		Almacen.IngresarConsumibles(harina, 15);
		//La cantidad de stock deberia ser 25
		Assert.assertEquals(25, harina.getStock());*/
		
		//FORMA DINAMICA
		/*Ingrediente harina = new Ingrediente("harina", "kgs", 10, 200);
		//Obtengo la cantidad inicial de stock de harina
		int cantidadInicial = harina.getStock();
		//Calculo aleatoriamente una cantidad para agregar
		int cantidadAgregada = (int)(Math.random()*10);
		//agrego esa cantidad al almacen
		Almacen.IngresarConsumibles(harina, cantidadAgregada);
		//comprueba que se haya agregado correctamente
		Assert.assertEquals(cantidadInicial+cantidadAgregada, harina.getStock());*/
		
		
		//FORMA MAS ALEATORIA
		//Calcula una cantidad aleatoria inicial de stock de harina
		/*int cantidadGenerada = (int)(Math.random()*10);
		Ingrediente harina = new Ingrediente("harina", "kgs", cantidadGenerada, 200);
		//Asegura que se cree el objeto bien
		Assert.assertEquals(cantidadGenerada, harina.getStock());
		//Calculo aleatoriamente una cantidad para agregar
		int cantidadAgregada = (int)(Math.random()*10);
		//agrego esa cantidad al almacen
		Almacen.IngresarConsumibles(harina, cantidadAgregada);
		//Se asegura que el stock se esta actualizando bien
		Assert.assertEquals(cantidadGenerada+cantidadAgregada, harina.getStock());*/

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


}