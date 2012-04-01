package ru.devhead.goatgame.logic.brain;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.verification.CardGroups;

@Test
public class GamerTest {
	
	@BeforeClass
	public void setUp() {
		CardGroups.init();
	}

	@DataProvider
	public Object[][] superTrumps() {
		Object data[][] = new Object[CardGroups.SuperTrumps.length][1];
		for (int i = 0; i < CardGroups.SuperTrumps.length; i++) {
			data[i][0] = CardGroups.SuperTrumps[i];
		}
		return data;
	}

	@DataProvider
	public Object[][] notSuperTrumps() {
		Object data[][] = new Object[CardGroups.notSuperTrumps.length][1];
		for (int i = 0; i < CardGroups.notSuperTrumps.length; i++) {
			data[i][0] = CardGroups.notSuperTrumps[i];
		}
		return data;
	}

	@DataProvider
	public Object[][] trumpAndTrumpSuitPairs() {
		return CardGroups.trumpAndTrumpSuitPairs;
	}
	
	@DataProvider
	public Object[][] noTrumpAndTrumpSuitPairs() {
		return CardGroups.noTrumpAndTrumpSuitPairs;
	}

	@Test(dataProvider = "trumpAndTrumpSuitPairs")
	public void IsItTrump(Card card, int trump) {
		assertTrue(Gamer.IsItTrump(card, trump), "isTrump " + card.getName());
	}

	@Test(dataProvider = "noTrumpAndTrumpSuitPairs")
	public void IsNotItTrump(Card card, int trump) {
		assertFalse(Gamer.IsItTrump(card, trump), "isNotTrump " + card.getName());
	}

	@Test(dataProvider = "superTrumps")
	public void isSuperTrump(Card card) {
		assertTrue(Gamer.isSuperTrump(card), "isSuperTrump " + card.getName());
	}

	@Test(dataProvider = "notSuperTrumps")
	public void isNotSuperTrump(Card card) {
		assertFalse(Gamer.isSuperTrump(card), "isNotSuperTrump " + card.getName());
	}

	@Test
	public void suitTest() {
		//Доделать
		throw new RuntimeException("Test not implemented");
	}
}
