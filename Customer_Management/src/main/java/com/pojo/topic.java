package com.pojo;

public class topic {
	
	private int id;
	private String name;
	
	
	public topic(String name) {
		super();
		this.name = name;
	}
	
   
	
	
	public topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	@Override
	public String toString() {
		return "topic [id=" + id + ", name=" + name + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
