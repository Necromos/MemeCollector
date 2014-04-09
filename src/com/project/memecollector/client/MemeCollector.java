package com.project.memecollector.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.project.memecollector.shared.models.Meme;
import com.project.memecollector.shared.models.User;

public class MemeCollector implements EntryPoint {

	private final AuthenticationServiceAsync authService = GWT.create(AuthenticationService.class);
	//private final UserServiceAsync userService = GWT.create(UserService.class);
	private final MemeServiceAsync memeService = GWT.create(MemeService.class);
	
	@Override
	public void onModuleLoad() {
		final User user = new User();
		// Login
		final TextBox loginTextBox = new TextBox();
		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		Button loginButton = new Button("Zaloguj");
		loginTextBox.setStyleName("form-control");
		passwordTextBox.setStyleName("form-control");
		loginButton.setStyleName("btn btn-primary");
		
		RootPanel.get("usernameTextBoxHolder").add(loginTextBox);
		RootPanel.get("passwordTextBoxHolder").add(passwordTextBox);
		RootPanel.get("loginButtonHolder").add(loginButton);
		
		// Logged
		final Label usernameLabel = new Label("dummy text");
		Button logoutButton = new Button("Wyloguj");
		logoutButton.setStyleName("btn btn-primary");
		usernameLabel.setStyleName("inline");
		RootPanel.get("usernameLabelHolder").add(usernameLabel);
		RootPanel.get("logoutButtonHolder").add(logoutButton);
		
		// Nav menu
		Element allMemes = DOM.getElementById("showAllMemesMenu");
		DOM.sinkEvents(allMemes, Event.ONCLICK);
		DOM.setEventListener(allMemes, new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				DOM.getElementById("showAllMemesMenu").setClassName("active");
				DOM.getElementById("addMemeMenu").setClassName("");
				DOM.getElementById("searchMemeMenu").setClassName("");
				DOM.getElementById("allMemeContainer").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("addMemeContainer").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("searchMemeContainer").getStyle().setDisplay(Display.NONE);
				getAllUserMemes(user.getId());
			}
		});
		Element addMeme = DOM.getElementById("addMemeMenu");
		DOM.sinkEvents(addMeme, Event.ONCLICK);
		DOM.setEventListener(addMeme, new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				DOM.getElementById("addMemeMenu").setClassName("active");
				DOM.getElementById("showAllMemesMenu").setClassName("");
				DOM.getElementById("searchMemeMenu").setClassName("");
				DOM.getElementById("allMemeContainer").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("addMemeContainer").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("searchMemeContainer").getStyle().setDisplay(Display.NONE);
			}
		});
		Element searchMeme = DOM.getElementById("searchMemeMenu");
		DOM.sinkEvents(searchMeme, Event.ONCLICK);
		DOM.setEventListener(searchMeme, new EventListener() {
			
			@Override
			public void onBrowserEvent(Event event) {
				DOM.getElementById("searchMemeMenu").setClassName("active");
				DOM.getElementById("showAllMemesMenu").setClassName("");
				DOM.getElementById("addMemeMenu").setClassName("");
				DOM.getElementById("allMemeContainer").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("addMemeContainer").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("searchMemeContainer").getStyle().setDisplay(Display.BLOCK);
			}
		});
		
		
		final TextBox titleTextBox = new TextBox();
		final TextBox urlTextBox = new TextBox();
		titleTextBox.setStyleName("form-control");
		urlTextBox.setStyleName("form-control");
		RootPanel.get("titleInput").add(titleTextBox);
		RootPanel.get("urlInput").add(urlTextBox);
		
		Element addNewMemeButton = DOM.getElementById("addNewMeme");
		DOM.sinkEvents(addNewMemeButton, Event.ONCLICK);
		DOM.setEventListener(addNewMemeButton, new EventListener() {

			@Override
			public void onBrowserEvent(Event event) {
				Meme meme = new Meme(titleTextBox.getText(),urlTextBox.getText());
				memeService.addMeme(user.getId(), meme, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						showAsyncAlert();
					}

					@Override
					public void onSuccess(Void result) {
						DOM.getElementById("succesAddAlert").getStyle().setDisplay(Display.BLOCK);
					}
				});
			}
			
		});
		
		
		
		loginButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final String username = loginTextBox.getText();
				authService.checkCredentials(username, passwordTextBox.getText(), new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						showAsyncAlert();
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result){
							loginTextBox.setText("");
							passwordTextBox.setText("");
							usernameLabel.setText(username);
							DOM.getElementById("loginForm").getStyle().setDisplay(Display.NONE);
							DOM.getElementById("logged").getStyle().setDisplay(Display.INLINE);
							DOM.getElementById("memeMenu").getStyle().setDisplay(Display.BLOCK);
							DOM.getElementById("allMemeContainer").getStyle().setDisplay(Display.BLOCK);
							authService.getUserId(username, new AsyncCallback<Long>(){

								@Override
								public void onFailure(Throwable caught) {
									showAsyncAlert();
								}

								@Override
								public void onSuccess(Long result) {
									user.setId(result);
									user.setUsername(username);
									getAllUserMemes(user.getId());
								}
								
							});
						}
						else {
							DOM.getElementById("noUserAlert").getStyle().setDisplay(Display.BLOCK);
						}
					}
					
				});
			}
		});
		
		logoutButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				user.clear();
				DOM.getElementById("loginForm").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("logged").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("memeMenu").getStyle().setDisplay(Display.NONE);
				DOM.getElementById("allMemeContainer").getStyle().setDisplay(Display.NONE);
			}
			
		});
	}
	
	void showAsyncAlert(){
		DOM.getElementById("failedAsyncAlert").getStyle().setDisplay(Display.BLOCK);
	}
	
	void getAllUserMemes(Long userId){
		memeService.showAllMemes(userId, new AsyncCallback<List<Meme>>(){

			@Override
			public void onFailure(Throwable caught) {
				showAsyncAlert();		
			}

			@Override
			public void onSuccess(List<Meme> result) {
				int currId = 1;
				for(Meme m : result){
					Element div = DOM.createDiv();
					String currentElement = "meme"+currId;
					div.setAttribute("id", currentElement);
					div.setClassName("row");
					DOM.appendChild(DOM.getElementById("allMemeContainer"), div);
					Element title = DOM.createDiv();
					Element img = DOM.createImg();
					title.setClassName("col-md-4");
					title.setInnerText(m.getTitle());
					img.setClassName("col-md-8");
					img.setAttribute("src", m.getLinkToMeme());
					DOM.appendChild(DOM.getElementById(currentElement),title);
					DOM.appendChild(DOM.getElementById(currentElement),img);
					currId++;
				}
			}
			
		});
	}

}
