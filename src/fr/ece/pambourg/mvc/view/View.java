package fr.ece.pambourg.mvc.view;

public interface View extends java.util.Observer{
	void setController(GUIListener controller);
	void start();
}
