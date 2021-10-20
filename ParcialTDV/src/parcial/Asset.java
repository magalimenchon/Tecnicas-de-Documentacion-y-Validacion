package parcial;
/**
 * La clase Asset compone un activo
 * @author Magalí
 * @version 1.1
 * @since 20/09/21
 * 
 */
public class Asset {
	/**
	 *   id numero unico que identifica al activo
	 */
	private int id;
	/**
	 *   describe al activo
	 */
	private String description;
	/**
	 *   usuario propietario
	 */
	private User user;
	
	/**
	 * Construye la estructura de un activo.
	 * @param id numero unico que identifica al activo
	 * @param description información relevante que describe al activo
	 * @param user propietario del activo
	 * @see User
	 */
	public Asset(int id, String description, User user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}
	
	/**
	 * Realiza el alta a la base de datos conforme a un activo
	 * dado, registrando los datos que lo componen.
	 * @param asset recibe el activo el cual se dará de alta
	 */
	public void Alta(Asset asset) {
		
	}
	/**
	 * Elimina de la Base de datos al activo, buscandolo por su
	 * identificador y usuario al que pertenece
	 * @param id el identificador único numerico del activo
	 * @param user el usuario propietario
	 */
	public void Baja(int id, User user) {
		
	}
	/**
	 * Modifica un registro en la Base de datos,
	 * realizando la busqueda por medio de su id
	 * y modifica los parametros correspondiente
	 * @param id
	 * @param description
	 * @param user
	 */
	public void Modificacion(int id, String description, User user) {
		
	}
	
}
