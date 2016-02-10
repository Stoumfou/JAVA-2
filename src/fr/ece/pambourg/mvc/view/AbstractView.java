package fr.ece.pambourg.mvc.view;
import fr.ece.pambourg.mvc.model.Model;

public abstract class AbstractView implements View{
	protected GUIListener controller;
	protected Model storageUser;
	
	public AbstractView(Model m) {
		this.storageUser = m;
	}
	
	protected final Model getModel() {
		return this.storageUser;
	}
	protected final GUIListener getController() {
		return this.controller;
	}
}
