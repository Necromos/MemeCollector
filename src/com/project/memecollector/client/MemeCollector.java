package com.project.memecollector.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class MemeCollector implements EntryPoint {

	private final AuthenticationServiceAsync authService = GWT.create(AuthenticationService.class);
	//private final UserServiceAsync userService = GWT.create(UserService.class);
	private final MemeServiceAsync memeService = GWT.create(MemeService.class);
	
	@Override
	public void onModuleLoad() {
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
		
		loginButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final String username = loginTextBox.getText();
				authService.checkCredentials(username, passwordTextBox.getText(), new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						DOM.getElementById("failedAsyncAlert").getStyle().setDisplay(Display.BLOCK);
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result){
							usernameLabel.setText(username);
							DOM.getElementById("loginForm").getStyle().setDisplay(Display.NONE);
							DOM.getElementById("logged").getStyle().setDisplay(Display.INLINE);
							DOM.getElementById("memeMenu").getStyle().setDisplay(Display.BLOCK);
						}
						else {
							DOM.getElementById("noUserAlert").getStyle().setDisplay(Display.BLOCK);
						}
					}
					
				});
			}
		});
	}

}
