package fr.ece.pambourg.mvc.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import fr.ece.pambourg.mvc.model.UserList;
import fr.ece.pambourg.mvc.view.CLI;
import fr.ece.pambourg.mvc.view.GUI;
import fr.ece.pambourg.mvc.view.View;

public class main{

	public static void main(String[] args){
		UserList model = new UserList();
		GUI gui = new GUI("Lab3",320,240,model);
		CLI cli = new CLI(model);
		Set<View> set= new HashSet<>(Arrays.asList(gui,cli));
		Controller controller = new Controller(model,set);
		controller.start();


	}

}
