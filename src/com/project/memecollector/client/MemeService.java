package com.project.memecollector.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.project.memecollector.shared.models.Meme;

@RemoteServiceRelativePath("meme")
public interface MemeService extends RemoteService {
	public Boolean addMeme(Long userId, Meme meme);
	public void removeMeme(Long userId, Long id);
	public void editMeme(Long userId, Meme editedMeme);
	public List<Meme> showAllMemes(Long userId);
	public Meme showById(Long userId, Long id);
	public Meme showByTitle(Long userId, String title);
}
