package com.project.memecollector.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.project.memecollector.shared.models.Meme;

public interface MemeServiceAsync {
	void addMeme(Long userId, Meme meme, AsyncCallback<Void> callback);
	void editMeme(Long userId, Meme editedMeme, AsyncCallback<Void> callback);
	void removeMeme(Long userId, Long id, AsyncCallback<Void> callback);
	void showById(Long userId, Long id, AsyncCallback<Meme> callback);
	void showByTitle(Long userId, String title, AsyncCallback<Meme> callback);
	void showAllMemes(Long userId, AsyncCallback<List<Meme>> callback);
}
