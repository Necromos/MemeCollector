package com.project.memecollector.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class MemeCollector implements EntryPoint {

	private final UserServiceAsync userService = GWT.create(UserService.class);
	private final MemeServiceAsync memeService = GWT.create(MemeService.class);
	
	@Override
	public void onModuleLoad() {
		// Login
		TextBox loginTextBox = new TextBox();
		PasswordTextBox passwordTextBox = new PasswordTextBox();
		Button loginButton = new Button("Zaloguj");
		loginTextBox.setStyleName("form-control");
		passwordTextBox.setStyleName("form-control");
		loginButton.setStyleName("btn btn-primary");
		
		RootPanel.get("usernameTextBoxHolder").add(loginTextBox);
		RootPanel.get("passwordTextBoxHolder").add(passwordTextBox);
		RootPanel.get("loginButtonHolder").add(loginButton);
	}

}
