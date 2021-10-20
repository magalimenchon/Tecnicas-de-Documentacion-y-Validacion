package parcial;

import java.sql.Time;

/**
 * La clase History compone el seguimiento de un activo
 * @author Magalí
 * @version 1.1
 * @since 20/09/21
 * @See Time
 */
public class History {

	/**
	 * identificador del activo
	 */
	private int idAsset;
	/**
	 * posicion del activo
	 */
	private Position position;
	/**
	 * intervalo de tiempo actual de recorrido del activo
	 */
	private Time time;
	
	/**Da de alta un seguimiento de un activo por medio de su id.
	 * Se checkea que no se haya dado de alta anteriormente
	 * 
	 * @param idAsset identificacion del activo
	 */
	public void Alta(int idAsset) {
		
	}
	/**Da de baja el activo por medio de su id
	 * 
	 * 
	 * @param idAsset identificacion del activo
	 */
	public void Baja(int idAsset) {
		
	}
	/**
	 * Modifica dada la id del activo y sus respectivos datos
	 * la historia correspondiente a un activo en la Base de datos.
	 * @param idAsset identificador del activo
	 * @param position posicion actual del activo
	 * @param time tiempo actual de recorrido del activo
	 */
	public void Modificacion(int idAsset, Position position, Time time) {
		
	}
	/**
	 * Actualiza la posición de un activo dada su id
	 * @param idAsset identificador del archivo
	 * @param position nueva posicion
	 */
	public void push(int idAsset, Position position) {
		
	}
	/**
	 * Retorna el recorrido realizado entre las dos fechas
	 * dadas por paràmetro
	 * @param inicialTime fecha inicial
	 * @param finallyTime fecha final
	 * @return
	 */
	public History getTrack(Time inicialTime, Time finallyTime) {

	}
}
