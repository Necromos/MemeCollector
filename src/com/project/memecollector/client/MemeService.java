package com.project.memecollector.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.memecollector.shared.models.Meme;

@RemoteServiceRelativePath("meme")
public interface MemeService extends RemoteService {
	public void addMeme(Meme meme);
}
