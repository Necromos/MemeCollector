package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.memecollector.shared.models.Meme;

@RemoteServiceRelativePath("auth")
public interface AuthenticationService extends RemoteService {
	public Boolean checkCredentials(String username, String password);
}
