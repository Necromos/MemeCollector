package com.project.memecollector.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.memecollector.client.MemeService;
import com.project.memecollector.shared.models.Meme;

public class MemeServiceImpl extends RemoteServiceServlet implements MemeService {

	private static final long serialVersionUID = 1L;

	private List<Meme> memeDB = new ArrayList<Meme>();
	
	public MemeServiceImpl(){
		this.memeDB.add(new Meme((long)1,"Gry-fb","http://fabrykamemow.pl/uimages/services/fabrykamemow/i18n/pl_PL/201304/1366916702_by_rozbuj6_500.jpg?1366916703",(long)1));
		this.memeDB.add(new Meme((long)2,"Yo mama - wii fit","http://d24w6bsrhbeh9d.cloudfront.net/photo/a6wx5p2_460s.jpg",(long)1));
		this.memeDB.add(new Meme((long)3,"Slap it!","http://d24w6bsrhbeh9d.cloudfront.net/photo/a8Wno8d_460sa.gif",(long)1));
	}
	
	@Override
	public void addMeme(Long userId, Meme meme) {
		meme.setUserId(userId);
		this.memeDB.add(meme);
	}

	@Override
	public void removeMeme(Long userId, Long id) {
		for(Meme m : this.memeDB){
			if(m.getId() == id && m.getUserId() == userId){
				this.memeDB.remove(m);
				break;
			}
		}
	}

	@Override
	public void editMeme(Long userId, Meme editedMeme) {
		if (userId == editedMeme.getUserId()){
			int i = 1;
			for(Meme m : this.memeDB){
				if(m.getId() == editedMeme.getId()){
					this.memeDB.set(i, editedMeme);
					break;
				}
				i++;
			}
		}
	}

	@Override
	public List<Meme> showAllMemes(Long userId) {
		List<Meme> result = new ArrayList<Meme>();
		for(Meme m : this.memeDB){
			if(m.getUserId() == userId){
				result.add(m);
			}
		}
		return result;
	}

	@Override
	public Meme showById(Long userId, Long id) {
		for(Meme m : this.memeDB){
			if(m.getId() == id && m.getUserId() == userId){
				return m;
			}
		}
		return null;
	}

	@Override
	public Meme showByTitle(Long userId, String title) {
		for(Meme m : this.memeDB){
			if(m.getTitle() == title && m.getUserId() == userId){
				return m;
			}
		}
		return null;
	}

}
