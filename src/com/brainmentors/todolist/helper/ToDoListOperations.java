package com.brainmentors.todolist.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SortById implements Comparator<ToDoList> {

	@Override
	public int compare(ToDoList o1, ToDoList o2) {
		// TODO Auto-generated method stub
		return ((Integer)o1.getId()).compareTo(o2.getId());
	}
	
}

public class ToDoListOperations {
	public static ArrayList<ToDoList> list = new ArrayList<>();
	public void add(ToDoList todo) {
		list.add(todo);
		System.out.println("List is "+list);
	}
	public boolean delete(int id) {
		int index = search(id);
		if(index>=0) {
			list.remove(index);
			return true;
		}
		return false;
	}
	public int search(int id) {
//		list.contains(id);
		ToDoList todo = new ToDoList();
		todo.setId(id);
		int index = list.indexOf(todo);
		System.out.println("The search object is "+list.get(index));
		return index;
	}
	public void update() {
		
	}
	public void sort() {
//		Collections.sort(list);
//		Collections.sort(list, new SortById());
//		Collections.sort(list, new Comparator<ToDoList>() {
//
//			@Override
//			public int compare(ToDoList o1, ToDoList o2) {
//				// TODO Auto-generated method stub
//				return ((Integer)o1.getId()).compareTo(o2.getId());
//			}
//			
//		});
		Collections.sort(list, 
				(obj1,obj2)->
		obj1.getName().compareTo(obj2.getName()));
		Collections.sort(list, 
				(obj1,obj2)->
		((Integer)obj1.getId()).compareTo(obj2.getId()));
	}
	public void showFinish() {
		
	}
	public void showPending() {
		
	}
	public void countFinish() {
		
	}
	public void countPending() {
		
	}
}
