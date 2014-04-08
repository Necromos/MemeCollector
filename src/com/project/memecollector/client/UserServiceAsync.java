package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.memecollector.shared.models.User;

public interface UserServiceAsync{
	public void addUser(User user, AsyncCallback<Void> callback);
	public void removeUser(Long id, AsyncCallback<Void> callback);
}
