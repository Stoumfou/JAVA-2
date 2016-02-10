package fr.ece.pambourg.mvc.view;

import fr.ece.pambourg.mvc.model.DataAccess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI implements DataAccess {

	@Override
	public String[] getData() {
		// TODO Auto-generated method stub

		return null;
	}

	private final Frame frame;
	private final JList<String> list = new JList<>();

	public GUI(String title, int width, int height) {
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
		panel.add(list, BorderLayout.CENTER);
	}

	public void start() {
		configJMenuBar();
		configJPanel();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUI gui = new GUI("foo", 320, 240);
		gui.start();
	}
}

