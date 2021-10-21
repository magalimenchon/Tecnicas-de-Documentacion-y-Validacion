package restaurant.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import restaurant.java.Ingrediente;
import restaurant.java.ItemReceta;
import restaurant.java.Producto;
import restaurant.java.ProductoBasico;
import restaurant.java.ProductoElaborado;
import restaurant.java.Receta;

public class ProductoTest {
	private static List<Producto> testList = new ArrayList<Producto>();
	/**
	 * a. No existen usuarios repetidos
	 */
	/**
	 * Hecho dinamicamente
	 */
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("UsuarioTest -> BeforeAll");
		
		Ingrediente huevo=new Ingrediente("huevo", "unidades",200, 240);
		Ingrediente papa = new Ingrediente("Papa", "gramos", 200, 20000);
		Ingrediente sal = new Ingrediente("Sal", "gramos", 200, 1000);
		Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 200, 10000);
		Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 200 , 100);

		ItemReceta ir1 = new ItemReceta(huevo, 1);
		ItemReceta ir2 = new ItemReceta(carnePicada, 100);
		ItemReceta ir3 = new ItemReceta(sal, 20);
		ItemReceta ir4 = new ItemReceta(huevo, 4);
		ItemReceta ir5 = new ItemReceta(papa, 3);
		ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);

		Receta tortilla = new Receta("Tortilla", 15);
		tortilla.addIngrediente(ir4);
		tortilla.addIngrediente(ir5);

		Receta hamburguesa = new Receta("hamburguesa grande", 5);
		hamburguesa.addIngrediente(ir2);
		hamburguesa.addIngrediente(ir1);
		hamburguesa.addIngrediente(ir3);
		hamburguesa.addIngrediente(ir6);

		Receta papasFritas = new Receta("papas fritas", 7);
		papasFritas.addIngrediente(ir5);
		papasFritas.addIngrediente(ir3);
		Producto p1= new ProductoBasico("Lata Coca Cola", 10, 20);
		Producto p2= new ProductoBasico("Lata Sprite", 10, 22);
		Producto p3= new ProductoElaborado("Retorti", 120);
		((ProductoElaborado)p3).setReceta(tortilla);	
		Producto p4= new ProductoElaborado("BIG O", 150);
		((ProductoElaborado)p4).setReceta(hamburguesa);	
		Producto p5= new ProductoElaborado("PATATAS", 120);
		((ProductoElaborado)p3).setReceta(papasFritas);	
		
		testList.add(p1);
		testList.add(p2);
		testList.add(p3);
		testList.add(p4);
		testList.add(p5);

	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UsuarioTest -> AfterAll");
	}
	
	/**
	 * e. Los la venta de productos o elaboración de estos dejan una ganancia mayor al 20%
	 * @return
	 */
	@TestFactory
	Stream<DynamicTest> TestExisteUsuario() {
		
		return  //retorna un stream de test, un conjunto de test, en el cual:
				testList.stream().
				// se van a probar todos los valores que defini en mi dominio (nombre del usuario que estoy testeando):
				map(dom -> DynamicTest.dynamicTest("Testing: " + dom,
						//por cada uno de esos valores se genera un test donde
							() -> {
								float ganancia = dom.getPrecioUnitarioVenta() - dom.getPrecioUnitarioCompra();
								assertTrue(ganancia > (dom.getPrecioUnitarioCompra() / 100) * 20);
							}
							)
				   );
	}
}
