package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.memecollector.shared.models.Meme;

public interface MemeServiceAsync {
	public void addMeme(Meme meme, AsyncCallback<Void> callback);
}
