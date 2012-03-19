package ru.devhead.goatgame.logic.verification;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class JudgeTest {
	
	static GamersTeam gamersTeam;
	static Card superTrumps[];
	static Card otherCards[];
	static int trump;
	
	@BeforeClass
	public static void setUpBefore() {
		gamersTeam = new GamersTeam(new StupidBumpkin(null, 0),
				new StupidBumpkin(null, 1));
		superTrumps = new Card[9];
		superTrumps[0] = new SimpleCard(CardsNames.SIX_CROSSES);
		for (int i = CardsNames.JACK_DIAMONDS; i <= CardsNames.QUEEN_CROSSES; i++) {
			superTrumps[i + 1 - CardsNames.JACK_DIAMONDS] = new SimpleCard(i);
		}
	}

	@Test
	public void testCheckTurnCardCardGamer() {
		fail("Not yet implemented");
	}
	
	@Before
	public void setUpFirstCardCheck() {
		
	}
	
	@Test
	public void testFirstCardCheck() {
		Judge judge = new Judge(null, null);

	}

	@Test
	public void testCheckTurnCardGamer() {
		fail("Not yet implemented");
	}

}
