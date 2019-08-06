package com.brainmentors.todolist.controller;

import java.util.ArrayList;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> i = new ArrayList<>();
		i.add(1000);
		for(int k=1; k<=1000000000; ++k) {
			i.add(k);
		}
		i.add(4000);
		i.add(4000);
		i.add(6000);
		long startTime = System.currentTimeMillis();
		long r = i.parallelStream().filter((j)->j>3000).mapToInt((z)->z).sum();
		System.out.println(r);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime)+"ms");

	}

}
