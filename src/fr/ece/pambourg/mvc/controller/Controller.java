package fr.ece.pambourg.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

import fr.ece.pambourg.mvc.model.UserList;
import fr.ece.pambourg.mvc.view.GUIListener;
import fr.ece.pambourg.mvc.view.View;

public class Controller implements GUIListener {
	protected UserList userList;
	protected View view;	
	
	public Controller(UserList userList, View view) {
		super();
		this.userList = userList;
		this.view = view;
		this.view.setController(this);
		this.userList.addObserver(view);
	}
	
	public void start()
	{
		this.view.start();
	}

	@Override
	public ActionListener getAddUserListener(JTextComponent textComponent) {
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(textComponent)) {
					userList.addUser(textComponent.getText());
					textComponent.setText("");
				}
			}
		};		
		return al;
	}
	
}
