package restaurant.test.testng;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.*;

import restaurant.java.*;

public class Tests {
	// De donde se deberían obtener los datos ya generados
	static List<Ingrediente> listaTotalIngredientes;
	static int cantIngredientes;
	static List<Receta> listaTotalRecetas;
	static int cantRecetas;
	static List<Producto> listaTotalProductos;
	static int cantProductos;
	static List<Usuario> listaTotalUsuarios;
	static int cantUsuarios;

	/**
	 * 1. Implemente un generador de Ingredientes con 10 items
	 * 
	 * @param count
	 */
	@BeforeClass
	//Se definen posibles opciones de ingredientes
	public void beforeClassDatosIngredientes(@Optional("10") int count) {
		cantIngredientes = count;
		/*** Esto debería hacerse con datos reales desde algun origen */
		listaTotalIngredientes = new ArrayList<Ingrediente>();
		listaTotalIngredientes.add(new Ingrediente("harina", "kg", (int) (Math.random())));
		listaTotalIngredientes.add(new Ingrediente("aceilte", "ltd", (int) (Math.random())));
		listaTotalIngredientes.add(new Ingrediente("papa", "kg", (int) (Math.random())));
		listaTotalIngredientes.add(new Ingrediente("huevo", "un", (int) (Math.random())));
		listaTotalIngredientes.add(new Ingrediente("fideos", "kg", (int) (Math.random())));
	}

	/** 
	 *  Genera aleatoriamente una lista de diferentes ingredientes
	 *  listaTotal está definida por extensión, pero en un caso más real, ese conjunto
	 *  de datos debería ser cargado desde un archivo o desde una conexión a una 
	 *  base de datos
	 * */
	// Genera un iterador sobre los datos
	@DataProvider(name = "generarIngredientes")
	public Iterator<Ingrediente> generarIngredientes() {
		/** A continuacion se crea una lista de ingredientes al azar */
		//se genera una lista random en base a cualquiera de los ingredientes a elegir
		List<Ingrediente> ingATestear = new ArrayList<Ingrediente>();
		for (int i = 0; i < Tests.cantIngredientes; i++)
			ingATestear.add(listaTotalIngredientes.get((int) (Math.random() * listaTotalIngredientes.size())));

		return ingATestear.iterator();
	}

	/**
	 * 2. Implemente un generador de Recetas con los ingredientes del item anterior,
	 * pero con cantidades aleatorias
	 */
	@BeforeClass
	//Se definen posibles opciones de recetas
	public void beforeClassDatosRecetas(@Optional("10") int count) {
		cantRecetas = count;
		/*** Esto debería hacerse con datos reales desde algun origen */
		listaTotalRecetas = new ArrayList<Receta>();
		listaTotalRecetas.add(new Receta("Tortilla", 15));
		listaTotalRecetas.add(new Receta("hamburguesa grande", 5));
		listaTotalRecetas.add(new Receta("papas fritas", 7));
		
		Iterator<Ingrediente> iteradorIngredientes = generarIngredientes();
		while(iteradorIngredientes.hasNext()) {
			ItemReceta itemActual = new ItemReceta(iteradorIngredientes.next(), (int) Math.random() * cantIngredientes);
			int recetaSeleccionada = (int) (Math.random() * cantRecetas);
			listaTotalRecetas.get(recetaSeleccionada).addIngrediente(itemActual);
		}
		
	}
	
	// Genera un iterador sobre los datos
	@DataProvider(name = "generarRecetas")
	public Iterator<Receta> generarRecetas() {
		/** A continuacion se crea una lista de recetas al azar */
		//se genera una lista random en base a cualquiera de las posibles recetas a elegir
		List<Receta> recATestear = new ArrayList<Receta>();
		for (int i = 0; i < Tests.cantRecetas; i++)
			recATestear.add(listaTotalRecetas.get((int) (Math.random() * listaTotalRecetas.size())));

		return recATestear.iterator();
	}
	
	/**
	 * 3. Implemente un generador de Productos con 10 items
	 */
	@BeforeClass
	//Se definen posibles opciones de recetas
	public void beforeClassDatosProductos(@Optional("10") int count) {
		cantProductos = count;
		/*** Esto debería hacerse con datos reales desde algun origen */
		listaTotalProductos = new ArrayList<Producto>();
		listaTotalProductos.add(new ProductoBasico("Lata Coca Cola", 10, 20));
		listaTotalProductos.add(new ProductoBasico("Lata Sprite", 10, 22));
		listaTotalProductos.add(new ProductoElaborado("Retorti", 120));
		//listaTotalProductos.add(new ProductoElaborado("Retorti", 120).setReceta(tortilla));
		listaTotalProductos.add(new ProductoElaborado("BIG O", 150));
		listaTotalProductos.add(new ProductoElaborado("PATATAS", 120));
		//listaTotalProductos.add(((ProductoElaborado)p3).setReceta(papasFritas));
		
		
	}
	
	// Genera un iterador sobre los datos
	@DataProvider(name = "generarProductos")
	public Iterator<Producto> generarProductos() {
		/** A continuacion se crea una lista de recetas al azar */
		//se genera una lista random en base a cualquiera de las posibles Producto a elegir
		List<Producto> prodATestear = new ArrayList<Producto>();
		for (int i = 0; i < Tests.cantProductos; i++)
			prodATestear.add(listaTotalProductos.get((int) (Math.random() * listaTotalProductos.size())));

		return prodATestear.iterator();
	}
	/**
	 * 4. Implemente un consumidor de ingredientes aleatorio (generador de cantidades
		aleatorias para consumir)
	 */
	/**
	 * --Resuelto en el inciso 1?
	 */
	/**
	 * 5. Pruebe la funcionalidad que permita testear que el precio de venta unitario es
		siempre mayor al precio de venta unitario
	 */
	@Test(dataProvider = "generarProductos")
	public void testPreciosUnitarios(Producto p) {
		 assertTrue(p.getPrecioUnitarioVenta() > p.getPrecioUnitarioCompra(), "Falla: el precio unitario de costo no puede ser menor al de venta");
	}
	/**
	 * 6. Pruebe la funcionalidad que permita testear que la ganancia de cada producto es
		siempre mayor a un parámetro dado
	 */
	@Test(dataProvider = "generarProductos")
	 public void testGananciaMayor(Producto p) {
		float ganancia = p.getPrecioUnitarioVenta() - p.getPrecioUnitarioCompra();
		float parametroDado = (float) (Math.random() * 1000 +1);
		assertTrue(ganancia > parametroDado);
	}
	/**
	 * 7. Pruebe si es posible descontar cantidades de ingredientes aun cuando esta cantidad
		es < 0. ¿Como se actuaría ante esta situación?
	 */
	  @Test(dataProvider = "generadoringredientes")
	  public void testDeStressCantidadStockDeIngrediente(Ingrediente i) {
		  i.consumirStock(i.getStock() - (int) Math.random() * 1000 +1);
		  assertTrue(i.getStock() >= 0);
		  //¿Como se actuaría ante esta situación?
		  //Enviaría una excepción en el método cuando este llega a ser cero.
		  //Controlaría que no siga consumiendo a valores menores a este.
	  }
	/**
	 * 8. Pruebe si ante la insuficiencia de saldo del usuario, se dispara la excepción
		SinSaldoException
	 */
	  @DataProvider (name = "generador-usuarios")
	  public Usuario[] dpUsuarios() {
		  System.out.println("Generando Usuarios");
		  Usuario us []= new Usuario[4];
		  
		  us [0] =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		  us [1] =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		  us [2] =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		  us [3]=new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		  return us;     
	  }
	  @Test(expectedExceptions = SinSaldoException.class, dataProvider = "generador-usuarios")
	  public void testThrowSinSaldoException(Usuario u) throws SinSaldoException {
		  
		  u.descontarSaldo(u.getSaldo() + (int) Math.random() * 1000 +1);
	  }
	/**
	 * 10. En un archivo recetas.xml, implemente un test que permita asegurarse que no
		existen recetas cuyo nombre no comienzan con determinada letra configurada como
		parámetro
	 */
	  @Test(dataProvider = "generarRecetas")
	  @Parameters({ "letra-buscada" })
	  public void testPrimerLetraDistinta(@Optional("L") String letra, Receta r) {

			  assertFalse(r.getNombreInterno().startsWith(letra));  
	  }
}
