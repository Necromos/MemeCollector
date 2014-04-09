package com.project.memecollector.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.project.memecollector.client.MemeService;
import com.project.memecollector.shared.models.Meme;

public class MemeServiceImpl extends RemoteServiceServlet implements MemeService {

	private static final long serialVersionUID = 1L;

	private List<Meme> memeDB = new ArrayList<Meme>();
	private Long counter = (long)4;
	
	public MemeServiceImpl(){
		this.memeDB.add(new Meme((long)1,"Joke","https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-frc1/t1.0-9/10003328_654516501286374_4778785600626733645_n.jpg",(long)1));
		this.memeDB.add(new Meme((long)2,"Woops","http://d24w6bsrhbeh9d.cloudfront.net/photo/a6wx28A_460sa.gif",(long)1));
		this.memeDB.add(new Meme((long)3,"Slap it!","http://d24w6bsrhbeh9d.cloudfront.net/photo/a8Wno8d_460sa.gif",(long)1));
	}
	
	@Override
	public void addMeme(Long userId, Meme meme) {
		meme.setUserId(userId);
		meme.setId(counter++);
		if(this.memeDB.add(meme)){
			System.out.println("added");
		}
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
