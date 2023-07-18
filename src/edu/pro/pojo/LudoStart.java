package edu.pro.pojo;

import java.util.Deque;
import java.util.LinkedHashMap;

public class LudoStart {

	private boolean gameOver ;
	private Deque<String> playerDeque ;
	private LinkedHashMap<String, PlayerPojo> objPlayerPojo;
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public Deque<String> getPlayerDeque() {
		return playerDeque;
	}
	
	public void setPlayerDeque(Deque<String> playerDeque) {
		this.playerDeque = playerDeque;
	}
	
	public LinkedHashMap<String, PlayerPojo> getObjPlayerPojo() {
		return objPlayerPojo;
	}
	
	public void setObjPlayerPojo(LinkedHashMap<String, PlayerPojo> objPlayerPojo) {
		this.objPlayerPojo = objPlayerPojo;
	}
}
