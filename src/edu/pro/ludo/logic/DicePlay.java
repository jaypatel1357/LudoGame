package edu.pro.ludo.logic;

public class DicePlay {

    public int getRandomValue () {
		int min = 1;
		int max = 6;
		
		int random_int = 0;
		
		
		System.out.println("Random value in int from "+min+" to "+max+ ":");
      
		random_int = (int)(Math.random() * (max - min + 1) + min);				
				//  ( 0.5 * (6-1 +1) + 1)
				      //( 0.5 * 6 +1) 
				      // 5 * 6 + 1) / 10
				      // 31/10
				      //3.15
				      
		System.out.println(random_int);
		
		return random_int;
    }


}
