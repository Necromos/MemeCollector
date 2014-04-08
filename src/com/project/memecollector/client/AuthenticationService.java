package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("auth")
public interface AuthenticationService extends RemoteService {
	public Boolean checkCredentials(String username, String password);
}
