package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthenticationServiceAsync {

	public void checkCredentials(String username, String password,
			AsyncCallback<Boolean> callback);
	
}
