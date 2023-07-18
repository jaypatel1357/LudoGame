
package edu.pro.ludo.start;

import java.util.Deque;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import edu.pro.ludo.logic.DicePlay;
import edu.pro.ludo.pre.PreDetailForPlay;
import edu.pro.pojo.LudoStart;
import edu.pro.pojo.PlayerPojo;

/**
 * 
 * @author Jay
 *
 */
public class StartGame {
	
	Scanner objscanner = new Scanner(System.in);
	
	LudoStart objLudoStart = new LudoStart();
	
	DicePlay objDicePlay = null;
	
	public StartGame(){
		
		PreDetailForPlay objPreDetailForPlay = new PreDetailForPlay();
		
		int noOfUser = objPreDetailForPlay.getNoOfUser();
		
		Deque<String> playerDeque =  objPreDetailForPlay.getPlayerQueue(noOfUser);
		
		objLudoStart.setPlayerDeque(playerDeque);
		
		this.startMyGame();
		
		
		//System.out.println("No of user --- "+noOfUser);
	}
	
	
	boolean startMyGame(){
		
		objLudoStart.setGameOver(false);
		//boolean gameOver = false;

		//Foe the player whose turn come again in some condition like dice == 6.
        boolean samePlayerPlayAgain = false;
        
        String strPlayer = null;
        
        int play =0;
		
		 // Call iterator() method of Deque 
       Iterator iteratorVals = null; 
        
       //set default value
       setDefaultValue();
       
        while (!objLudoStart.isGameOver()){
        
        	 iteratorVals = objLudoStart.getPlayerDeque().iterator();
        	
	        while (iteratorVals.hasNext()) { 
	            
	        	if(!samePlayerPlayAgain)
	        		strPlayer = iteratorVals.next().toString();
	        	
	    //    	System.out.println("String player ==== "+strPlayer); 
	        	
	        	System.out.println("Hi "+ strPlayer + " please press enter button to play dise");
	        	
	        	objscanner.nextLine();
	        	
	        	samePlayerPlayAgain = startGameWithPlayer(strPlayer);
	        	
	        	//samePlayerPlayAgain = true;
	        	
	        	display(); //call
	        } 
	        if (play==100) {
	        	
	        	objLudoStart.setGameOver(true);
	        }
	        play++;  // play = play + 1;
	        System.out.println(play +"******************************* ");
        }
		return objLudoStart.isGameOver();
	}

	private boolean startGameWithPlayer(String sPlayer) {

		// TODO Auto-generated method stub
		
		objDicePlay = new DicePlay();
		
		boolean samePlayerPlayAgain = false;
		
		LinkedHashMap<String, PlayerPojo> objLinkedHashMapPlayerPojo = objLudoStart.getObjPlayerPojo();
		
		PlayerPojo objPlayerPojo = objLinkedHashMapPlayerPojo.get(sPlayer);
		
		
		
		int randomeValue = objDicePlay.getRandomValue();
		
		int newposition = 0;
		
		if(objPlayerPojo.isFirstTimePlay()) {
			
			if(randomeValue == 6) {
				
				objPlayerPojo.setFirstTimePlay(false);
				System.out.println(sPlayer+" Please enter which pice you want to move from 1 , 2 , 3 , 4");
				
				Scanner objscanner = new Scanner(System.in);
			//	System.out.println("Please Enter no of user from 2,3,4");
				int piceNumber = objscanner.nextInt();
				newposition = 1;
				
				if(piceNumber == 1) {
					objPlayerPojo.setPice1(newposition);
		
				}else if(piceNumber == 2) {
					objPlayerPojo.setPice2(newposition);
				}
				else if(piceNumber == 3) {
					objPlayerPojo.setPice3(newposition);				
				}
				else if(piceNumber == 4) {
					objPlayerPojo.setPice4(newposition);
				}
				
				objLinkedHashMapPlayerPojo.put(sPlayer, objPlayerPojo);
				objLudoStart.setObjPlayerPojo(objLinkedHashMapPlayerPojo);
				samePlayerPlayAgain = true;
			}else {
				samePlayerPlayAgain = false;
			}
			
		}else {
			
			if(randomeValue == 6) {
				
				System.out.println(sPlayer +" Please enter which pice you want to move from 1 , 2 , 3 , 4");
				
				int piceNumber = objscanner.nextInt();
				
				if(piceNumber == 1) {
					
					if(objPlayerPojo.getPice1() == 0) {
						
						newposition = 1;
						objPlayerPojo.setPice1 (newposition);
					}else {
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
					}
					
				}else if(piceNumber == 2) {
					if(objPlayerPojo.getPice2() == 0) {
						
						newposition = 1;
						objPlayerPojo.setPice2(newposition );
					}else {
						
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
						
					}
				}
				else if(piceNumber == 3) {
					if(objPlayerPojo.getPice3() == 0) {
						
						newposition = 1;
						objPlayerPojo.setPice3(newposition);
					}else {
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
					}
					
				}
				else if(piceNumber == 4) {
					if(objPlayerPojo.getPice4() == 0) {
						
						newposition = 1;
						objPlayerPojo.setPice4( newposition);
					}else {
						
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
					}
				}
				if(objPlayerPojo.getPice1() == 0) {
					
					newposition = objPlayerPojo.getPice1()+   randomeValue;
					objPlayerPojo.setPice1(newposition);
			
				}else if(objPlayerPojo.getPice1() == 0) {
					
					newposition = objPlayerPojo.getPice2()+   randomeValue;
					objPlayerPojo.setPice2(newposition);
					
					                                         //objPlayerPojo.setPice2(objPlayerPojo.getPice2()+   randomeValue);
				}
				else if(objPlayerPojo.getPice1() == 0) {
				
					newposition = objPlayerPojo.getPice3()+   randomeValue;
					objPlayerPojo.setPice3(newposition);				
				}
				else if(objPlayerPojo.getPice1() == 0) {
					
					newposition = objPlayerPojo.getPice4()+   randomeValue;
					objPlayerPojo.setPice4(newposition);
				}
			
				
				//update the value of player pojo in player hash table
				objLinkedHashMapPlayerPojo.put(sPlayer, objPlayerPojo);
				
				//update the hash map of players in main ludo start object
				objLudoStart.setObjPlayerPojo(objLinkedHashMapPlayerPojo);
				
				samePlayerPlayAgain = true;
				
			}
			else {
				
				int piceNumber = 0;
				
				if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice3() == 0 && objPlayerPojo.getPice4() == 0) {
					System.out.println(sPlayer +" You can't move any of your pice.");
					
				}else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice3() == 0) {
					
					System.out.println(sPlayer +" your 4 pice is moving");
					newposition = objPlayerPojo.getPice4()+   randomeValue;
					objPlayerPojo.setPice4(newposition);
					
				}
				else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice3() == 0 && objPlayerPojo.getPice4() == 0) {
					System.out.println(sPlayer +" your 2 pice is moving");
					newposition = objPlayerPojo.getPice2()+   randomeValue;
					objPlayerPojo.setPice2(newposition);
					
				}
				else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice4() == 0) {
					System.out.println(sPlayer +" your 3 pice is moving");
					newposition = objPlayerPojo.getPice3()+   randomeValue;
					objPlayerPojo.setPice3(newposition);
					
				}
				else if(objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice3() == 0 && objPlayerPojo.getPice4() == 0) {
					System.out.println(sPlayer +" your 1 pice is moving");
					newposition = objPlayerPojo.getPice1()+   randomeValue;
					objPlayerPojo.setPice1(newposition);
					
				}	
				else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice2() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 3,4");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 3) {
						
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
					                                               // 	objPlayerPojo.setPice3(objPlayerPojo.getPice3()+randomeValue);
					}else {
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);	
					}
					
				}
				else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice3() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 2,4");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber ==2) {
					
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
				
					}else  {
						
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
					
					}	
					
					
				}
				else if(objPlayerPojo.getPice1() == 0 && objPlayerPojo.getPice4() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 2,3");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 2) {
					
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
					
				}	else {
				
					newposition = objPlayerPojo.getPice3()+   randomeValue;
					objPlayerPojo.setPice3(newposition);	
					
				}
					
				}
				else if(objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice3() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 1,4");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 1) {
					
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
					
					}	else {
					
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
					
					}	
					
				}
				else if(objPlayerPojo.getPice2() == 0 && objPlayerPojo.getPice4() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 1,3");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 1) {
					
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
					
					}	else {
					
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
					
					}	
					
				}
				else if( objPlayerPojo.getPice3() == 0 && objPlayerPojo.getPice4() == 0 ) {
					
					System.out.println(sPlayer +" Please enter which pice you want to move from 1,2");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 1) {
					
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
					
					}else {	
					
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
					
					}	
					
				}
				else if(objPlayerPojo.getPice1() == 0 ) {
					

					System.out.println(sPlayer +" Please enter which pice you want to move from 2,3,4");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 2) {
					
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
					
					}else if(piceNumber == 3) {	
					
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
					
					}else {	
					
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
					
					}	
					
				}
                else if(objPlayerPojo.getPice2() == 0 ) {
                	
                	System.out.println(sPlayer +" Please enter which pice you want to move from 3,4,1");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 3){
                	
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
                	
					}else if (piceNumber == 4) {	
                	
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
                	
					}	else {
                	
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
                	
					}	
					
				}
                else if(objPlayerPojo.getPice3() == 0 ) {
                	
                	System.out.println(sPlayer +" Please enter which pice you want to move from 4,1,2");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 4) {
                	
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
                	
					}	else if(piceNumber == 1) {
                	
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
                	
					}else {	
                	
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
                	
					}	
					
				}
                else if( objPlayerPojo.getPice4() == 0 ) {
                	
                	System.out.println(sPlayer +" Please enter which pice you want to move from 1,2,3");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 1) {
                	
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
                	
					}else if(piceNumber == 2) {	
                	
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
                	
					}	else {
                	
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);                	
					}	
					
				}else
				
				{
					System.out.println(sPlayer +" Please enter which pice you want to move from 1,2,3,4");
					
					piceNumber = objscanner.nextInt();
					
					if(piceNumber == 1) {
	            	
						newposition = objPlayerPojo.getPice1()+   randomeValue;
						objPlayerPojo.setPice1(newposition);
	            	
					}else if(piceNumber == 2) {	
	            	
						newposition = objPlayerPojo.getPice2()+   randomeValue;
						objPlayerPojo.setPice2(newposition);
	            	
					}	else if(piceNumber == 3) {
	            	
						newposition = objPlayerPojo.getPice3()+   randomeValue;
						objPlayerPojo.setPice3(newposition);
	            	
					}	else {
						
						newposition = objPlayerPojo.getPice4()+   randomeValue;
						objPlayerPojo.setPice4(newposition);
					}
						
					//update the value of player pojo in player hash table
					objLinkedHashMapPlayerPojo.put(sPlayer, objPlayerPojo);
					
					//update the hash map of players in main ludo start object
					objLudoStart.setObjPlayerPojo(objLinkedHashMapPlayerPojo);
					
					
					
						
				}
			}
			
			LinkedHashMap<String, PlayerPojo> objLinkedHashMapPlayerPojoClone = (LinkedHashMap<String, PlayerPojo>) objLinkedHashMapPlayerPojo.clone();
			
			objLinkedHashMapPlayerPojoClone.remove(sPlayer);
			
			//cheack for safe place
			System.out.println("---------------------------   "+newposition);
			//If(newposition)
			
			if  (newposition == 1 || newposition == 14 || newposition == 22 
				|| newposition == 27 || newposition == 35 || newposition == 40
				|| newposition == 48 || newposition >= 52) {
				
			} 
			else {
				
				
				PlayerPojo playerPojoObj = null;
				int newPlace = 0;
				
				for(Map.Entry  playerPojoObjHm:objLinkedHashMapPlayerPojoClone.entrySet()){  
					  
					System.out.println(playerPojoObjHm.getKey()+" ++++++++++++++++++++++++++++ "); 
					playerPojoObj = (PlayerPojo) playerPojoObjHm.getValue();
					
					if(sPlayer.equals("player 1")) {
					
						if(playerPojoObjHm.getKey().equals("player 2")) {
							if(newposition > 0 && newposition < 13) {
								
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition+39) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition+39) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition+39) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
								
								newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition+39) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
	
								objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);
								
							}else {
								
									newPlace = playerPojoObj.getPice1() ;
									
									if(newPlace == newposition-13) {
										
										playerPojoObj.setPice1(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice2();
									
									if(newPlace == newposition-13) {
										
										playerPojoObj.setPice2(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice3();
									
									if(newPlace == newposition -13) {
										
										playerPojoObj.setPice3(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice4() ;
									
									if(newPlace == newposition - 13) {
										
										playerPojoObj.setPice4(0);
										
										samePlayerPlayAgain = true;
									
									}
									objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);
							}
							
						}
						
						
					if(playerPojoObjHm.getKey().equals("player 3")) {
						
						if(newposition > 0 && newposition < 26) {
								
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition+26) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition+26) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition + 26) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
								
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition +26) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}

								objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);
							}	
							else {
								
									newPlace = playerPojoObj.getPice1() ;
									
									if(newPlace == newposition -26) {
										
										playerPojoObj.setPice1(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice2() ;
									
									if(newPlace == newposition - 26) {
										
										playerPojoObj.setPice2(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice3() ;
									
									if(newPlace == newposition -26) {
										
										playerPojoObj.setPice3(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice4();
									
									if(newPlace == newposition - 26 ) {
										
										playerPojoObj.setPice4(0);
										
										samePlayerPlayAgain = true;
									
									}
								
									objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);
								}
						
							}
						
							if(playerPojoObjHm.getKey().equals("player 4")) {
								
								if(newposition > 0 && newposition < 39) {
									
									newPlace = playerPojoObj.getPice1() ;
									
									if(newPlace == newposition + 13) {
										
										playerPojoObj.setPice1(0);
										
										samePlayerPlayAgain = true;
									}
									
									newPlace = playerPojoObj.getPice2();
									
									if(newPlace == newposition + 13) {
										
										playerPojoObj.setPice2(0);
										
										samePlayerPlayAgain = true;
										
									}
									
									newPlace = playerPojoObj.getPice3();
									
									if(newPlace == newposition + 13) {
										
										playerPojoObj.setPice3(0);
										
										samePlayerPlayAgain = true;
									
									}
									
								 	newPlace = playerPojoObj.getPice4() ;
									
									if(newPlace == newposition + 13) {
										
										playerPojoObj.setPice4(0);
										
										samePlayerPlayAgain = true;
									
									}
									objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);
								}
								else {
									
									newPlace = playerPojoObj.getPice1() ;
									
									if(newPlace == newposition - 39) {
										
										playerPojoObj.setPice1(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice2();
									
									if(newPlace == newposition - 39) {
										
										playerPojoObj.setPice2(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice3();
									
									if(newPlace == newposition - 39) {
										
										playerPojoObj.setPice3(0);
										
										samePlayerPlayAgain = true;
									
									}
								
								
									newPlace = playerPojoObj.getPice4();
									
									if(newPlace == newposition - 39) {
										
										playerPojoObj.setPice4(0);
										
										samePlayerPlayAgain = true;
									
									}
									objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);	

								}
							
							}
						}
				
				//player 2
				
				else if(sPlayer.equals("player 2")) {
					
					if(playerPojoObjHm.getKey().equals("player 3")) {
						if(newposition > 0 && newposition < 13) {
							
							newPlace = playerPojoObj.getPice1() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2();
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3();
							
							if(newPlace == newposition + 39 ) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);
							
						}else {
							
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);
						}
						
					}
					
					
				if(playerPojoObjHm.getKey().equals("player 4")) {
					
					if(newposition > 0 && newposition < 26) {
							
							newPlace = playerPojoObj.getPice1() ;
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2() ;
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3() ;
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4();
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);
						}	
						else {
							
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
							
								objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);
							}
					
						}
					
						if(playerPojoObjHm.getKey().equals("player 1")) {
							
							if(newposition > 0 && newposition < 39) {
								
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
								
							 	newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);
							}
							else {
								
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);	

							}
						
						}
					}
			
           // player 3
					
				else if(sPlayer.equals("player 3")) {
					
					if(playerPojoObjHm.getKey().equals("player 4")) {
						if(newposition > 0 && newposition < 13) {
							
							newPlace = playerPojoObj.getPice1() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);
							
						}else {
							
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 4", playerPojoObj);
						}
						
					}
					
					
				if(playerPojoObjHm.getKey().equals("player 1")) {
					
					if(newposition > 0 && newposition < 26) {
							
							newPlace = playerPojoObj.getPice1() ;
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2();
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3();
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4() ;
							
							if(newPlace == newposition + 26) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);
						}	
						else {
							
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition - 26) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
							
								objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);
							}
					
						}
					
						if(playerPojoObjHm.getKey().equals("player 2")) {
							
							if(newposition > 0 && newposition < 39) {
								
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
								
							 	newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition + 13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);
							}
							else {
								
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition - 39) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);	

							}
						
						}
					}
			

	       // player 4				
				else {
					
					if(playerPojoObjHm.getKey().equals("player 1")) {
						if(newposition > 0 && newposition < 13) {
							
							newPlace = playerPojoObj.getPice1() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2() ;
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3() ;
							
							if(newPlace == newposition +39) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4();
							
							if(newPlace == newposition + 39) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);
							
						}else {
							
								newPlace = playerPojoObj.getPice1() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4() ;
								
								if(newPlace == newposition - 13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 1", playerPojoObj);
						}
						
					}
					
					
				if(playerPojoObjHm.getKey().equals("player 2")) {
					
					if(newposition > 0 && newposition < 26) {
							
							newPlace = playerPojoObj.getPice1();
							
							if(newPlace == newposition +26) {
								
								playerPojoObj.setPice1(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice2();
							
							if(newPlace == newposition +26) {
								
								playerPojoObj.setPice2(0);
								
								samePlayerPlayAgain = true;
								
							}
							
							newPlace = playerPojoObj.getPice3();
							
							if(newPlace == newposition +26) {
								
								playerPojoObj.setPice3(0);
								
								samePlayerPlayAgain = true;
							
							}
							
							newPlace = playerPojoObj.getPice4();
							
							if(newPlace == newposition +26) {
								
								playerPojoObj.setPice4(0);
								
								samePlayerPlayAgain = true;
							
							}

							objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);
						}	
						else {
							
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition -26) {
									
									playerPojoObj.setPice1(0);
								
									samePlayerPlayAgain = true;
								}
							
							
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition -26) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3() ;
								
								if(newPlace == newposition -26) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition -26) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
							
								objLinkedHashMapPlayerPojo.put("player 2", playerPojoObj);
							}
					
						}
					
						if(playerPojoObjHm.getKey().equals("player 3")) {
							
							if(newposition > 0 && newposition < 39) {
								
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition +13) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition +13) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
									
								}
								
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition +13) {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
								
							 	newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition +13) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);
							}
							else {
								
								newPlace = playerPojoObj.getPice1();
								
								if(newPlace == newposition -39) {
									
									playerPojoObj.setPice1(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice2();
								
								if(newPlace == newposition -39) {
									
									playerPojoObj.setPice2(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice3();
								
								if(newPlace == newposition -39)  {
									
									playerPojoObj.setPice3(0);
									
									samePlayerPlayAgain = true;
								
								}
							
							
								newPlace = playerPojoObj.getPice4();
								
								if(newPlace == newposition -39) {
									
									playerPojoObj.setPice4(0);
									
									samePlayerPlayAgain = true;
								
								}
								objLinkedHashMapPlayerPojo.put("player 3", playerPojoObj);	

							}
						
						}
					
				}	
				
				
						objLudoStart.setObjPlayerPojo(objLinkedHashMapPlayerPojo);
													
					//samePlayerPlayAgain = true;
				}
			}
		}
		return samePlayerPlayAgain;
	}
	
	/**
	 * 
	 * @jay
	 */
    public boolean getplayerwin() {
	
		LinkedHashMap<String,Boolean> hm=new LinkedHashMap<String,Boolean>();  
		
		boolean getplayerwin = false;
		
		Iterator iteratorVals = objLudoStart.getPlayerDeque().iterator();
		while (iteratorVals.hasNext()) {
			hm.put(iteratorVals.next().toString(),false);  
		 }
		for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		}
		return false;	
	}
    
    public void setDefaultValue() {
    	
    	//System.out.println("--------- setDefaultValue ------------ ");
    	
    	LinkedHashMap<String, PlayerPojo> objHashMapPlayerPojo= new  LinkedHashMap<String , PlayerPojo>();
    	
    	PlayerPojo objPlayerPojo = new PlayerPojo();
    	
    	PlayerPojo objpojo1 = null;
    	
    	for(String Str: objLudoStart.getPlayerDeque()) {
			
    		 objpojo1 = new PlayerPojo();

	    	objpojo1.setPice1(0);
	    	objpojo1.setPice2(0);
	    	objpojo1.setPice3(0);
	    	objpojo1.setPice4(0);

	    	objpojo1.setPlayerwin(false);
	    	objpojo1.setFirstTimePlay(true);
	    	
	    	objHashMapPlayerPojo.put(Str, objpojo1);
	    	
			//System.out.println(Str);
		}
    	
    	objLudoStart.setObjPlayerPojo( objHashMapPlayerPojo);
    	
    	objLudoStart.getObjPlayerPojo();
    	
    	
    	LinkedHashMap<String, PlayerPojo> objLinkedHashMapPlayerPojo = objLudoStart.getObjPlayerPojo();
    	
    	System.out.println("Current position of player piceas "  );
    	
    	
    	for(Map.Entry  m:objLinkedHashMapPlayerPojo.entrySet()){  
 		   System.out.println("Player name ---- > "+m.getKey());  
 		   
    		PlayerPojo obj = (PlayerPojo) m.getValue();
 		  
	 		System.out.println("pice 1 place ---- > "+obj.getPice1());
	 		System.out.println("pice 2 place ---- > "+obj.getPice2());
	 		System.out.println("pice 3 place ---- > "+obj.getPice3());
	 		System.out.println("pice 4 place ---- > "+obj.getPice4());
	 		  
 		}
    	
    	
    }
    public void display() {
    	
    	LinkedHashMap<String, PlayerPojo> objLinkedHashMapPlayerPojo = objLudoStart.getObjPlayerPojo();
    	
    	System.out.println("Current position of player piceas "  );
    	
    	for(Map.Entry  m:objLinkedHashMapPlayerPojo.entrySet()){  
 		   System.out.println("Player name ---- > "+m.getKey());  
 		   
    		PlayerPojo obj = (PlayerPojo) m.getValue();
 		  
	 		System.out.println("pice 1 place ---- > "+obj.getPice1());
	 		System.out.println("pice 2 place ---- > "+obj.getPice2());
	 		System.out.println("pice 3 place ---- > "+obj.getPice3());
	 		System.out.println("pice 4 place ---- > "+obj.getPice4());
	 		  
 		}
    	
    	
    }
			}






