/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package es.upm.fi.sos.t3.usermanagement;

import java.util.HashMap;
import java.util.Map;

/**
 * UserManagementWSSkeleton java skeleton for the axisService
 */


public class UserManagementWSSkeleton {

	private static Map<String, User> allUsers = new HashMap<String, User>();
	private User loggedUser;
	private static User superuser = new User();

	// Añadir administrador (solo 1 vez)
	public UserManagementWSSkeleton() {
		if (!allUsers.containsKey("admin")) {
			superuser.setName("admin");
			superuser.setPwd("admin");
			allUsers.put("admin", superuser);
		}
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
		if (this.loggedUser != null) { //No se puede 2 login seguidos
			resp.setResponse(false);
		} else {
			User user2 = allUsers.get(user.getName());
			//user existe y password correcta
			if (user2 != null && user2.getPwd().equals(user.getPwd())) { 
				this.loggedUser = user;
				resp.setResponse(true);
			} else {
				resp.setResponse(false);
			}
		}
		return resp;

	}


	/**
	 * Auto generated method signature
	 * 
	 * @param user1
	 * @return response2
	 */

	public Response addUser(User user1) {
		Response resp = new Response();
		if (this.loggedUser != null && this.loggedUser.getName().equals("admin")
				&& !allUsers.containsKey(user1.getName())) {
			allUsers.put(user1.getName(), user1);
			resp.setResponse(true);
		} else {
			resp.setResponse(false);
		}
		return resp;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param passwordPair
	 * @return response3
	 */

	public Response changePassword(PasswordPair passwordPair) {
		Response resp = new Response();
		if (this.loggedUser != null && this.loggedUser.getPwd().equals(passwordPair.getOldpwd())) {
			this.loggedUser.setPwd(passwordPair.getNewpwd());
			resp.setResponse(true);
		} else
			resp.setResponse(false);

		return resp;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param username
	 * @return response4
	 */

	public Response removeUser(Username username) {
		Response resp = new Response();
		if (this.loggedUser != null && this.loggedUser.getName().equals("admin")
				&& allUsers.containsKey(username.getUsername())) {
			allUsers.remove(username.getUsername());
			resp.setResponse(true);
		} else
			resp.setResponse(false);

		return resp;
	}

}
