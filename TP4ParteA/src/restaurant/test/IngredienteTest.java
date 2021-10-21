package restaurant.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import restaurant.java.*;
public class IngredienteTest {

	/**
	 * g. La reposición de stock aumenta el número de ítems disponibles.
	 */
	@Test
	public void testReposicionStock() {
		Ingrediente huevo=new Ingrediente("huevo", "unidades",240, 20);
		int cantidadInicialStock = huevo.getStock();
		
		//Numero entero entre 1 y 5
		int reposicion =  (int) Math.floor(Math.random()*6+1);
		
		huevo.reponerStock(reposicion);
		
		assertEquals(cantidadInicialStock + reposicion, huevo.getStock());
	}
}
