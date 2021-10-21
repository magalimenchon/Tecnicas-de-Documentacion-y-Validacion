package restaurant.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import restaurant.java.Usuario;


public class UsuarioTest {

	private static List<Usuario> testList = new ArrayList<Usuario>();
	/**
	 * a. No existen usuarios repetidos
	 */
	/**
	 * Hecho dinamicamente
	 */
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("UsuarioTest -> BeforeAll");
		System.out.println("Carga de usuarios de prueba");
		Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
		Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
		Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
		Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		Usuario uFallaEnRepetido =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
		Usuario uFallaEnMailArroba =new Usuario("Seymour Skinner", 0, 0, "sskinnerspringfield.com");
		
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);
		testList.add(u4);
		testList.add(uFallaEnRepetido);
		testList.add(uFallaEnMailArroba);
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UsuarioTest -> AfterAll");
	}
	
	
	@TestFactory
	Stream<DynamicTest> TestExisteUsuario() {
		
		return  //retorna un stream de test, un conjunto de test, en el cual:
				testList.stream().
				// se van a probar todos los valores que defini en mi dominio (nombre del usuario que estoy testeando):
				map(dom -> DynamicTest.dynamicTest("Testing: " + dom,
						//por cada uno de esos valores se genera un test donde
							() -> {
									int id = testList.indexOf(dom);
									//busco si algun elemento de la lista coincide con el que estoy testeando
									//if(assertNotSame(testList.get(id), dom)) {
									for(int i = 0; i < testList.size() - 1; i++)
									if(testList.get(id) != dom) {	//diferente dirección en memoria
										assertFalse(testList.get(id).equals(dom), "Falla: Usuario repetido");
									}
								  }
							)
				   );
	}
	/**
	 * b. Todos los usuarios poseen un correo electrónico válido (contiene @)
	 * @return aserción
	 * @see Assert
	 */
	/**
	 * Hecho dinamicamente
	 */
	@TestFactory
	Stream<DynamicTest> TestCorreoValidoUsuario() {
			
			return  //retorna un stream de test, un conjunto de test, en el cual:
					testList.stream().
					// se van a probar todos los valores que defini en mi dominio (nombre del usuario que estoy testeando):
					map(dom -> DynamicTest.dynamicTest("Testing: " + dom,
							//por cada uno de esos valores se genera un test donde
								() -> {
										assertTrue(dom.getEmail().contains("@"), "Falla: Mail no contiene @");
									  }
								)
					   );
		}
}
