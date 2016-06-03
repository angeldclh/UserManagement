/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package es.upm.fi.sos.t3.usermanagement;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ServiceContext;

/**
 * UserManagementWSSkeleton java skeleton for the axisService
 */

/*
 * En el ejemplo servicelifecycle de Axis2 hay una clase UserList
 */

public class UserManagementWSSkeleton {

	private static Map<String,User> allUsers = new HashMap<String,User>();
//	private Map<String,User> loggedUsers;
	private static User loggedUser;
	
	public UserManagementWSSkeleton(){
		User superuser = new User();
		superuser.setName("admin");
		superuser.setPwd("admin");
		allUsers.put(superuser.getName(), superuser);
		//loggedUsers = new HashMap<String,User>();
	}

	
	
	public String verUsuarios(){
		String res="\n";
		for(User u : allUsers.values())
			res+=u.getName() + "\n";
		return res;
	}



	// Métodos para el manejo de la sesión
	public void init(ServiceContext serviceContext) throws AxisFault {
//		AxisService service = serviceContext.getAxisService();
		// Las dos siguientes líneas serán algo parecido a lo que hay
//		allUsers = (Map<String,User>) service.getParameterValue("users");
//		loggedUsers = (Map<String,User>) service.getParameterValue("loggedUsers");
	}
	
	public void destroy(ServiceContext serviceContext) throws AxisFault {
//		AxisService service = serviceContext.getAxisService();
		// Las dos siguientes líneas serán algo parecido a lo que hay
//		service.addParameter("users", allUsers);
//		service.addParameter("loggedUsers", loggedUsers);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @return
	 */

	public void logout() {
		loggedUser = null;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param user
	 * @return response
	 */

	public Response login(User user) {
		Response resp = new Response();
		
		User user2 = allUsers.get(user.getName());
		if (user2 != null && user2.getPwd().equals(user.getPwd())){ //user existe y password correcta
//			loggedUsers.put(user.getName(), user);
			loggedUser = user;
			resp.setResponse(true);
		}
		else{
			resp.setResponse(false);
		}
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
		Response resp = new Response();
		if (loggedUser.getName().equals("admin") &&
				!allUsers.containsKey(user1.getName())){
			allUsers.put(user1.getName(), user1);
			resp.setResponse(true);
		}
		else{
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
		if(loggedUser.getPwd().equals(passwordPair.getOldpwd())){
			loggedUser.setPwd(passwordPair.getNewpwd());
			resp.setResponse(true);
		}
		else
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
		if (loggedUser.getName().equals("admin") &&
				allUsers.containsKey(username.getUsername())){
			allUsers.remove(username.getUsername());
			resp.setResponse(true);
		}
		else
			resp.setResponse(false);
		
		return resp;
	}
	
	

}
