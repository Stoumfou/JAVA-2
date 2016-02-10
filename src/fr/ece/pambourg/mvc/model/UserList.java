package fr.ece.pambourg.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	
	private List<String> userList = new ArrayList<String>();
	
	public UserList(List<String> userList) {
		super();
		this.userList = userList;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public boolean addUser(String user)
	{
		if (user == null)
		{
			return false;
		}
		else
		{
			this.userList.add(user);
			return true;
		}
	}

}
