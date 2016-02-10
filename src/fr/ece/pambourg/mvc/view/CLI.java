package fr.ece.pambourg.mvc.view;

import javax.swing.*;

import fr.ece.pambourg.mvc.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CLI extends AbstractView implements View /* TODO: makethisclassaView */
{
	public CLI(Model m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o,Object arg){
		new SwingWorker<List<String>,String>(){
			List<String> users = new ArrayList<>();
			@Override
			protected List<String> doInBackground()throws Exception{
				String[] data = ((Model) users).getData();//TODO:getdata
				int index =0;
				while(index<data.length&&!isCancelled()){
					users.add(data[index]);
					publish((data[index]));
				}
				return users;
			}
			@Override
			protected void process(List<String>chunks){
				for(String data:chunks){
					System.out.println(data);
				}
			}
			@Override
			protected void done(){
				System.out.println("−−−");
			}
		}.execute();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}
