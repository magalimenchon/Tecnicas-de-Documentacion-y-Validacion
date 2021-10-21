package restaurant.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import restaurant.java.*;
public class TestSinSuficientesIngredientesException {

	/**
	 * f. No es posible realizar una receta si no se cuenta con todos los ingredientes
	 */
	@Test
	public void testSinSuficientesIngredientesException() {
		Assertions.assertThrows(SinSuficientesIngredientesException.class, () ->{
			
			Ingrediente huevo=new Ingrediente("huevo", "unidades",240,200);
			Ingrediente papa = new Ingrediente("Papa","gramos",20000,200);
			
			Receta tortilla=new Receta("Tortilla",15);
			
			int cantInicialIngredientes = tortilla.getIngredientes().size();
			ItemReceta ir4 = new ItemReceta(huevo,4);
			ItemReceta ir5 = new ItemReceta(papa, 3);

			tortilla.addIngrediente(ir4);
			tortilla.addIngrediente(ir5);
			
			assertEquals(cantInicialIngredientes + 2, tortilla.getIngredientes().size());
		});
	}
}
