package com.pojo;

import java.util.Date;

public class tutorial {
	
//	id | name        | author | publish_date | visits | contents | topic_id
	
	
	private int id;
	private String name;
	private String author;
	private String publish_date;
	private int visits;
	private String contents;
	private int topic_id;
	
	
	public tutorial(String name, String author, String publish_date, int visits, String contents,
			int topic_id) {
		super();
		this.name = name;
		this.author = author;
		this.publish_date = publish_date;
		this.visits = visits;
		this.contents = contents;
		this.topic_id = topic_id;
		
	}

	public tutorial(int id, String name, String author, String publish_date, int visits, String contents,
			int topic_id) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publish_date = publish_date;
		this.visits = visits;
		this.contents = contents;
		this.topic_id = topic_id;
	}

	@Override
	public String toString() {
		return "tutorial [id=" + id + ", name=" + name + ", author=" + author + ", publish_date=" + publish_date
				+ ", visits=" + visits + ", contents=" + contents + ", topic_id=" + topic_id + "]";
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


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublish_date() {
		return publish_date;
	}


	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}


	public int getVisits() {
		return visits;
	}


	public void setVisits(int visits) {
		this.visits = visits;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public int getTopic_id() {
		return topic_id;
	}


	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	
	
	
	

}
