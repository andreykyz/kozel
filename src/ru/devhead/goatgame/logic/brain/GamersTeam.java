package ru.devhead.goatgame.logic.brain;

import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.Card;

public class GamersTeam {
	
	private Gamer gamer1;
	private Gamer gamer2;
	private Gamer gamer3 = null;
	
	private int cash;
	private CardBatch cashBatch = new CardBatch();;
	private int points;
	
	/**
	 * Constructor for game on 4 Gamers
	 * 
	 * @param gamer1
	 * @param gamer2
	 */
	public GamersTeam(Gamer gamer1, Gamer gamer2) {
		this.gamer1 = gamer1;
		this.gamer2 = gamer2;
		cash = 0;
		points = 0;
	}
	
	public GamersTeam(Gamer gamer1, Gamer gamer2, Gamer gamer3) {
		this.gamer1 = gamer1;
		this.gamer2 = gamer2;
		this.gamer3 = gamer3;
		cash = 0;
		points = 0;
	}
	
	public void resetCash() {
		cash = 0;
	}
	
	public void addBeatCards(Card cards[]) {
		for (int i = 0; i<cards.length; i++){
			cashBatch.add(cards[i]);
		}
	}
	
	public void addCash(int cash){
		this.cash = this.cash + cash;
	}
	
	public void addPoints(int points) {
		this.points = this.points + points;
	}
	
	public boolean haveGamer(Gamer gamer) {
		if (gamer.equals(gamer1)) {
			return true;
		} else if (gamer.equals(gamer2)) {
			return true;
		} else if (gamer.equals(gamer3)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getCash() {
		return cash;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Gamer getGamer1() {
		return gamer1;
	}

	public void setGamer1(Gamer gamer1) {
		this.gamer1 = gamer1;
	}

	public Gamer getGamer2() {
		return gamer2;
	}

	public void setGamer2(Gamer gamer2) {
		this.gamer2 = gamer2;
	}

	public Gamer getGamer3() {
		return gamer3;
	}

	public void setGamer3(Gamer gamer3) {
		this.gamer3 = gamer3;
	}

}
