package edu.pro.ludo.pre;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PreDetailForPlay {
	
	public Deque<String> getPlayerQueue(int noOfUser) {
		
		int player= 2;
		
		Deque<String> deque =new ArrayDeque <String>(); 

		if (noOfUser==2){
			deque.add("player 1");
			deque.add("player 2");
		}
		else if (noOfUser==3) {
			deque.add("player 1");
			deque.add("player 2");
			deque.add("player 3");
		}
		else {
			deque.add("player 1");
			deque.add("player 2");
			deque.add("player 3");
			deque.add("player 4");
		}
		
		System.out.println("Name of players: ");
		for(String Str:deque) {
			
			System.out.println(Str);
		}
		
		return deque;
	}

	
	public int getNoOfUser(){
		Scanner objScanner = new Scanner(System.in);
		System.out.println("Please Enter no of user from 2,3,4");
		int noOfUser = objScanner.nextInt();
        if(  noOfUser>4 || noOfUser <1) {
        	noOfUser = getNoOfUser();
		}
		System.out.println(noOfUser);
		return noOfUser;
	}

}
