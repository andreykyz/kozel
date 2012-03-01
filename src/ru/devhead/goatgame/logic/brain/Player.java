package ru.devhead.goatgame.logic.brain;

import java.util.Scanner;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.display.Display;
import ru.devhead.goatgame.logic.Card;


public class Player extends Gamer {

	Display display;
	private static Logger logger = Logger.getLogger(Gamer.class);
	
	public Player(Display display, int id){
		super(display, id);
	}
	
	@Override
	public Card turn(Card[] table, int stepNum) {
		Scanner scan = new Scanner(System.in);
		display.printBottom(true, batchOnHand);
		System.out.println("");
		for (int i=0;i<stepNum;i++){
			System.out.print("" + i + ":");
			display.printTurnCard(table[i]);
		}
		System.out.println("");
		System.out.println("Введите номер карты:");
		return batchOnHand.remove(scan.nextInt());
	}

	@Override
	public int assignTrump() {
			return display.getSelectSuit();
	}

}
