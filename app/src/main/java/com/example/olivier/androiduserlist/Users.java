package com.example.olivier.androiduserlist;

import java.util.Arrays;
import java.util.List;


class Users {
	private final UserData [] results = new UserData[51];
	 
	public List<UserData> userList(){
		return Arrays.asList(results);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(UserData user : results){
			sb.append(user.toString()).append(" ");
		}
		return sb.toString();
	}
}
