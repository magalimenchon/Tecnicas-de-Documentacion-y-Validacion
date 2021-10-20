package restaurant;
import java.util.ArrayList;
import java.util.List;
/**
 * Define la administración y almacenamiento de los
 * listados de pedido.
 * @author Magalí
 * @version 1.8
 * 
 */
public class AdminOrdenes {
List<Pedido> pedidos;

public AdminOrdenes() {
	super();
	pedidos= new ArrayList<Pedido>();
}
void procesar() {
	 
}
/*
 * Inserta el pedido ingresado en la última posición del arreglo
 * que contiene todos los pedidos encargados.
 * @param p es el objeto con el pedido que se quiere almacenar.
 * @return id identificador único con 
 */
int agregar(Pedido p)  {
	p.setEstado("ENCARGADO");
	pedidos.add(p);
	int id=Pedido.getNextID();
	p.setId(id);
	Pedido.setNextID(id+1);
	System.out.println("se ha generado el pedido con el id: "+id);
	return id;
}


}
