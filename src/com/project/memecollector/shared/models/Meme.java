package com.project.memecollector.shared.models;

import java.io.Serializable;

public class Meme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String linkToMeme;
	private Long userId;
	
	public Meme(){}
	
	public Meme(String title, String linkToMeme){
		this.title = title;
		this.linkToMeme = linkToMeme;
	}
	
	public Meme(Long id, String title, String linkToMeme){
		this.id = id;
		this.title = title;
		this.linkToMeme = linkToMeme;
	}
	
	public Meme(Long id, String title, String linkToMeme, Long userId){
		this.id = id;
		this.title = title;
		this.linkToMeme = linkToMeme;
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkToMeme() {
		return linkToMeme;
	}
	public void setLinkToMeme(String linkToMeme) {
		this.linkToMeme = linkToMeme;
	}
	
	
}
