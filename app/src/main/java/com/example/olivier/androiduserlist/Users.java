package com.example.olivier.androiduserlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Users {
	private final ArrayList<UserData> results = new ArrayList<>();
	 
	public List<UserData> userList(){
		return results;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(UserData user : results){
			sb.append(user.toString()).append(" ");
		}
		return sb.toString();
	}
}
