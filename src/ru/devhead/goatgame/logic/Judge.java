package ru.devhead.goatgame.logic;

import ru.devhead.goatgame.logic.brain.GamersTeam;

/**
 * class for check rule
 * @author kyznecov
 *
 */
public class Judge {
	
	Card trump;
	GamersTeam trumpSetter;
	GamersTeam otherTeam;
	
	public Judge(Card trump, GamersTeam trumpSetter) {
		this.trump = trump;
		this.trumpSetter = trumpSetter;
	}
	
	

}
