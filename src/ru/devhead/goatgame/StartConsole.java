package ru.devhead.goatgame;

import org.apache.log4j.BasicConfigurator;

import ru.devhead.goatgame.logic.Board;

public class StartConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		new Board();
		
	}

}
