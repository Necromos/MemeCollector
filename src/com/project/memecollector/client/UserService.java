package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.memecollector.shared.models.User;

@RemoteServiceRelativePath("user")
public interface UserService extends RemoteService {
	public void addUser(User user);
	public void removeUser(Long id);
}
