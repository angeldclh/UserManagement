/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package es.upm.fi.sos.t3.usermanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.AxisService;

/**
 * UserManagementWSSkeleton java skeleton for the axisService
 */

/*
 * En el ejemplo servicelifecycle de Axis2 hay una clase UserList
 */

public class UserManagementWSSkeleton {

	private Map<String,User> allUsers;
//	private Map<String,User> loggedUsers;
	User loggedUser;
	
	public UserManagementWSSkeleton(){
		this.allUsers = new HashMap<String,User>();
		User superuser = new User();
		superuser.setName("admin");
		superuser.setPwd("admin");
		this.allUsers.put(superuser.getName(), superuser);
		//this.loggedUsers = new HashMap<String,User>();
		this.loggedUser = null;
	}

	
	// Métodos para el manejo de la sesión
	public void init(ServiceContext serviceContext) throws AxisFault {
//		AxisService service = serviceContext.getAxisService();
		// Las dos siguientes líneas serán algo parecido a lo que hay
//		this.allUsers = (Map<String,User>) service.getParameterValue("users");
//		this.loggedUsers = (Map<String,User>) service.getParameterValue("loggedUsers");
	}
	
	public void destroy(ServiceContext serviceContext) throws AxisFault {
//		AxisService service = serviceContext.getAxisService();
		// Las dos siguientes líneas serán algo parecido a lo que hay
//		service.addParameter("users", this.allUsers);
//		service.addParameter("loggedUsers", this.loggedUsers);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @return
	 */

	public void logout() {
		this.loggedUser = null;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param user
	 * @return response
	 */

	public Response login(User user) {
		Response resp = new Response();
		if (this.allUsers.containsValue(user)){ //user existe
//			this.loggedUsers.put(user.getName(), user);
			this.loggedUser = user;
			resp.setResponse(true);
		}
		else
			resp.setResponse(false);
		
		return resp;
		
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
