package ru.devhead.goatgame.logic.brain;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.verification.CardGroups;

@Test
public class GamerTest {

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

	@Test
	public void IsItTrump() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void IsNotItTrump() {
		throw new RuntimeException("Test not implemented");
	}

	@Test(dataProvider = "superTrumps")
	public void isSuperTrump(Card card) {
		assertTrue(Gamer.isSuperTrump(card), "isSuperTrump " + card.getName());
	}

	@Test(dataProvider = "notSuperTrumps")
	public void isNotSuperTrump(Card card) {
		assertFalse(Gamer.isSuperTrump(card), "isSuperTrump " + card.getName());
	}

	@Test
	public void suitTest() {
		throw new RuntimeException("Test not implemented");
	}
}
