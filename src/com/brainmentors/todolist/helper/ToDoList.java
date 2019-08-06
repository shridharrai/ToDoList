package com.brainmentors.todolist.helper;

import java.time.LocalDate;
import java.util.Date;

public class ToDoList implements Comparable<ToDoList> {
	private int id;
	private String name;
	private String desc;
	private LocalDate date;
	@Override
	public boolean equals(Object object) {
		if(object == this) {
			return true;
		}
		if(object instanceof ToDoList) {
			ToDoList l = (ToDoList)object;
			if(this.id>0 && this.name == null) {
			if(this.id == l.id) {
				return true;
			}
			}
			if(this.name!=null) {
				if(this.id == l.id && this.name.equals(l.name)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public ToDoList() {
		
	}
	public ToDoList(int id,String name,String desc,LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.date = date;
	}
	public int getId() {
		return id>0?id:0;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name.length()>0?name:"";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ToDoList [id=" + id + ", name=" + name + ", desc=" + desc + ", date=" + date + "]";
	}

	@Override
	public int compareTo(ToDoList o) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(o.name);
	}
}
