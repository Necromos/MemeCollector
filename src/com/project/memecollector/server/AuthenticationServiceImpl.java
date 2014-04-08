package com.project.memecollector.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.memecollector.client.AuthenticationService;
import com.project.memecollector.shared.models.User;

public class AuthenticationServiceImpl extends RemoteServiceServlet implements AuthenticationService {

	private static final long serialVersionUID = 1L;

	private List<User> userDB = new ArrayList<User>();
	
	public AuthenticationServiceImpl() {
		this.userDB.add(new User((long) 1, "Necromos", "test"));
	}
	
	@Override
	public Boolean checkCredentials(String username, String password) {
		for(User user : this.userDB){
			if(user.getUsername().compareTo(username) == 0 && user.getPassword().compareTo(password) == 0){
				return true;
			}
		}
		return false;
	}

}
