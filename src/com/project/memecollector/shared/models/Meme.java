package com.project.memecollector.shared.models;

import java.io.Serializable;

public class Meme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String linkToMeme;
	
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
