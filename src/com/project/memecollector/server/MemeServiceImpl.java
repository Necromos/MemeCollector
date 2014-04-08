package com.project.memecollector.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.memecollector.client.MemeService;
import com.project.memecollector.shared.models.Meme;

public class MemeServiceImpl extends RemoteServiceServlet implements MemeService {

	private static final long serialVersionUID = 1L;

	@Override
	public void addMeme(Long userId, Meme meme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMeme(Long userId, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editMeme(Long userId, Meme editedMeme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Meme> showAllMemes(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meme showById(Long userId, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meme showByTitle(Long userId, String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
