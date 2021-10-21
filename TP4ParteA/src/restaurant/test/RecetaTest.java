package restaurant.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import restaurant.java.Ingrediente;
import restaurant.java.ItemReceta;
import restaurant.java.Receta;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class RecetaTest {
	private static Receta defaultReceta;
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("RecetaTest -> BeforeAll");
	}
	/**
	 * Metodo tearDown para propiedades de clase
	 * @throws Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("RecetaTest -> AfterAll");
	}
	/**
	 * c. Una receta está compuesta por uno o más ingredientes
	 */
	@Test
	public void TestAlMenosUnIngrediente() {
		
		defaultReceta = new Receta("Torta de manzana", 35);
		
		int cantidadElementosInicialReceta = defaultReceta.getIngredientes().size();
		
		Ingrediente ingrediente = new Ingrediente("azucar", "kgs",1, 200);
		ItemReceta itemReceta= new ItemReceta(ingrediente, 1);
		
		defaultReceta.addIngrediente(itemReceta);
		
		assertTrue(cantidadElementosInicialReceta + 1 == defaultReceta.getIngredientes().size(), "Falla: Problemas al insertar ingrediente(itemReceta) en receta");
	}
}
