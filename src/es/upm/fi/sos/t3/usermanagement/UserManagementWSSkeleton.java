/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package es.upm.fi.sos.t3.usermanagement;

/**
 * UserManagementWSSkeleton java skeleton for the axisService
 */
public class UserManagementWSSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @return
	 */

	public void logout(

	) {
		// TODO : fill this with the necessary business logic
		// Obtener la sesión
		// Cerrarla

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param user
	 * @return response
	 */

	public Response login(User user) {
		// TODO : fill this with the necessary business logic
		// Ver que user existe (¿CÓMO?)
		// Crear la sesión (ContextSession creo)
		// Devolver true en la Response
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#login");
	}

	/*
	 * Los siguientes métodos tendrán que usar getSession() o algo parecido
	 */

	/**
	 * Auto generated method signature
	 * 
	 * @param user1
	 * @return response2
	 */

	public Response addUser(User user1) {
		// TODO : fill this with the necessary business logic
		// Ver que la sesión es de superuser
		// Añadirlo
		// true
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#addUser");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param passwordPair
	 * @return response3
	 */

	public Response changePassword(PasswordPair passwordPair) {
		// TODO : fill this with the necessary business logic
		// Obtener User al que pertenece la sesión actual
		// Ver que la pswd actual coincide con la primera del pair
		// Cambiarla
		// True
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#changePassword");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param username
	 * @return response4
	 */

	public Response removeUser(Username username) {
		// TODO : fill this with the necessary business logic
		// Ver que la sesión es de superuser
		// Ver que un user con username existe
		// Borrar ese User
		// True
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#removeUser");
	}

}
