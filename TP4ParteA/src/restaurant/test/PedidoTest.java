package restaurant.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import restaurant.java.ItemPedido;
import restaurant.java.Pedido;
import restaurant.java.Producto;
import restaurant.java.ProductoBasico;
import restaurant.java.SinSaldoException;
import restaurant.java.Usuario;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	private static Usuario defaultUsuario;
	private static Pedido defaultPedido;
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("PedidoTest -> BeforeAll");
		System.out.println("Se carga usuario -> BeforeAll");
		defaultUsuario = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		
	}
	/**
	 * Metodo tearDown para propiedades de clase
	 * @throws Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("PedidoTest -> AfterAll");
	}
	/**
	 * d. Un pedido reduce en saldo de un usuario
	 * @throws SinSaldoException 
	 */
	@Test
	public void TestReduccionDeSaldoAlSolicitarPedido() throws SinSaldoException {
		
		float saldoInicialUsuario = defaultUsuario.getSaldo();
		defaultPedido = new Pedido();
		defaultPedido.setUsuario(defaultUsuario);
		
		Producto p1= new ProductoBasico("Lata Coca Cola", 10, 20);
		
		defaultPedido.agregarItem(new ItemPedido(1,p1));

		//Assert.assertThrows(SinSaldoException.class, () ->{
			defaultPedido.solicitarPedido();
			//assertNotThrows(SinSaldoException.class);
			
			assertTrue(saldoInicialUsuario >= defaultPedido.getUsuario().getSaldo());
		//});
		
	}
}
