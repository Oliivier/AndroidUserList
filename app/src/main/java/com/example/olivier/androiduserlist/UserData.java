package com.example.olivier.androiduserlist;


class UserData {
	/* Inner Class */
	public class FirstName {
		private final String first;
		
		private FirstName(String first){
			this.first = first;
		}
		public String toString(){
			return first.substring(0, 1).toUpperCase()+first.substring(1);
		}
	}

	/* Inner Class */
	public class Picture {
		private final String medium;
		/*private String thumbnail;
		private String large;*/
		
		private Picture(String medium, String thumbnail, String large){
			this.medium = medium;
		/*	this.thumbnail = thumbnail;
			this.large = large;*/
		}
		public String toString(){
			return medium;
		}
	}

	private final FirstName name;
	private final Picture picture;
	private UserData(FirstName name, Picture picture){
		this.name = name;
		this.picture = picture;
	}
	public String getName() {
		return name.toString();
	}
	
	public String getPicture() {
		return picture.toString();
	}
	
	public String toString(){
		return name.toString()+" "+picture.toString();
	}

}
