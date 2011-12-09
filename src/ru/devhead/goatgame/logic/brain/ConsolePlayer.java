package ru.devhead.goatgame.logic.brain;

import java.util.Scanner;

import org.apache.log4j.Logger;

import ru.devhead.goatgame.display.Console;
import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

public class ConsolePlayer extends Gamer {

	Console display;
	private static Logger logger = Logger.getLogger(Gamer.class);
	
	public ConsolePlayer(Console display){
		this.display = display; 
		this.batchOnHand = new CardBatch();
	}
	
	@Override
	public Card turn(Card[] table, int stepNum) {
		Scanner scan = new Scanner(System.in);
		display.print(batchOnHand);
		System.out.println("");
		for (int i=0;i<stepNum;i++){
			System.out.print("" + i + ":");
			display.print(table[i]);
		}
		System.out.println("");
		System.out.println("Введите номер карты:");
		return batchOnHand.remove(scan.nextInt());
	}

	@Override
	public int assignTrump() {
		System.out.println("");
		display.print(batchOnHand);
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("3 Крести");
		System.out.println("2 Пики");
		System.out.println("1 Черви");
		System.out.println("0 Буби");
		System.out.println("Введите номер масти:");
		System.out.println("");
		return scan.nextInt();
	}

}
