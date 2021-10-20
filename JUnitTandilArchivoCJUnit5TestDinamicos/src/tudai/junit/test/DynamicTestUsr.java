package tudai.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import tudai.junit.java.Padron;
import tudai.junit.java.Usuario;

public class DynamicTestUsr {
//Acá solamente se tiene 1 test, anotado como TestFactory, significa que
//se ira creando dinamicamente
	@TestFactory
//Este método...
	// CON ITERADOR
	Iterator<DynamicTest> dynamicTestsConIterador() {
//generará una secuencia de test que se van a ir generando

		// Se define una secuencia y esa secuencia va a tener un iterador,
		// y JUnit5 va a ir iterando desde ahi
		// Se genera un conjunto de datos con los que se va a estimular:
		List<Usuario> testList = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("Juan", "1979-01-01", 42, true);
		Usuario u2 = new Usuario("Pedro", "1980-02-01", 41, true);
		Usuario u3 = new Usuario("Maria", "1981-03-01", 40, true);
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);

		// Se retorna el test para cada uno de esos datos.
		// A continuacion se define un test dinamico denominado "Kevin no esta"
		// con su bloque ejecutable (lo que está entre {})
		// Entonces la función taggeada como TestFactory va a estar retornando
		// diferentes Tests en una lista`

		// 1ro: se devuelve el test Kevin no esta
		return Arrays.asList(DynamicTest.dynamicTest("Kevin no esta", () -> {
			Iterator<Usuario> i = testList.iterator();
			// a partir de un conjunto de datos, revisa si esta el nombre kevin
			while (i.hasNext())
				assertTrue(i.next().getNombre() != "Kevin");
			// 2do: luego, se devuelve este test de multiplicacion (q no tiene nada q ver
			// c/lo anterior, solo p/ ejemplificar)
		}), DynamicTest.dynamicTest("Multiply Test", () -> assertEquals(4, Math.multiplyExact(2, 2)))).iterator();
	}

	// CON COLECCIONES
	// -------------------------------------------------------------------------------------------------------
	@TestFactory
	Collection<DynamicTest> dynamicTestsCollecion() {
		List<Usuario> testList = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("Juan", "1979-01-01", 42, true);
		Usuario u2 = new Usuario("Pedro", "1980-02-01", 41, true);
		Usuario u3 = new Usuario("Maria", "1981-03-01", 40, true);
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);

		// Acá se hacen los diferentes test
		return Arrays.asList(
					// 1er test: verificar que para cada entrada el nombre no sea nulo
					DynamicTest.dynamicTest("Nombre no es nulo",
							() -> assertTrue(u1.getNombre() != null)
					),
					// 2do test: chequear que la fecha de nacimiento no sea nula
					DynamicTest.dynamicTest("Fecha Nacimiento no es nula",
							() -> assertTrue(u1.getFechaNacimiento() != null)
					)
				);
	}
	// ------------------------------------------------------------------------------------

	// CON STREAM
	@TestFactory
	//permite trabajar sobre todo el conjunto de datos y hacer test mas cortos
	
	//ESTE TEST DARÁ UNA FALLA CON EL CASO DE MARIA, YA QUE ACÁ EN LA LISTA
	//DE TEST DICE QUE TIENE 40 AÑOS, Y EN EL PATRON FIGURA 47. NO CUMPLE
	//CON LA ASERCION (PREDICADO QUE SE SUPONE QUE SIEMPRE SE CUMPLE)
	Stream<DynamicTest> dynamicTestsFromUsuarios() {

		Padron padron = new Padron();

		List<Usuario> testList = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("Juan", "1979-01-01", 42, true);
		Usuario u2 = new Usuario("Pedro", "1980-02-01", 41, true);
		Usuario u3 = new Usuario("Maria", "1981-03-01", 40, true);
		//Usuario u3 = new Usuario("Maria", "1981-03-01", 47, true);
		testList.add(u1);
		testList.add(u2);
		testList.add(u3);

		List<Integer> edades = Arrays.asList(42, 41, 40);

		return  //retorna un stream de test, un conjunto de test, en el cual:
				testList.stream().
				// se van a probar todos los valores que defini en mi dominio (nombre del usuario que estoy testeando):
				map(dom -> DynamicTest.dynamicTest("Testing: " + dom.getNombre(),
						//por cada uno de esos valores se genera un test donde
							() -> {
									int id = testList.indexOf(dom);
									//determinado valor que tenga guardado en la estructura
									//sea igual al de otra estructura
									
									assertEquals(edades.get(id), padron.getUsuario(dom.getNombre()).getEdad());
								  }
							)
				   );

	}

}
