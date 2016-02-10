package fr.ece.pambourg.mvc.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import fr.ece.pambourg.mvc.controller.Controller;
import fr.ece.pambourg.mvc.model.Model;
import fr.ece.pambourg.mvc.model.UserList;

public class GUI extends AbstractView implements View {

	private final Frame frame;
	private final JList<String> list = new JList<>();

	public GUI(String title, int width, int height, UserList m) {
		super(m);
		frame = new JFrame(title);
		frame.setSize(width, height);
		((JFrame) frame).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void configJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		fileMenu.add(quitItem);
		((JFrame) frame).setJMenuBar(menuBar);
	}

	private void configJPanel() {
		JPanel panel = new JPanel();
		((JFrame) frame).getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		final JTextField textField = new JTextField();

		panel.add(textField, BorderLayout.PAGE_START);
		textField.addActionListener(this.getController().getAddUserListener(textField));
		panel.add(list, BorderLayout.CENTER);
	}

	public void start() {
		configJMenuBar();
		configJPanel();
		frame.setVisible(true);
	}

	/*public static void main(String[] args) {
		UserList model=new UserList();
		GUI gui=new GUI("Lab3",320,240,model);
		Controller controller=new Controller(model,gui);
		controller.start();
	}*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o.getClass().equals(UserList.class)) {
			this.list.setListData(((UserList) o).getData()); 
		}
	}
}

