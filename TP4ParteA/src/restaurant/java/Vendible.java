package restaurant.java;

public interface Vendible {
	public float getPrecioVenta();
	public void preparar() throws SinSuficientesIngredientesException;
}
