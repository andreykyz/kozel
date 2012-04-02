package ru.devhead.goatgame.logic.verification;

import static org.testng.Assert.*;

import java.util.Calendar;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class JudgeTest {

	private GamersTeam gamersTeam;
	private GamersTeam gamersTeamTrumpSetter;
	private int trump = 0;
	private Random rnd;
	private Judge judge;

	@DataProvider
	public Object[][] forTestFirstCardCheck() {
		return new Object[500][1];
	}

	@BeforeClass
	public void beforeClass() {
		CardGroups.init();
		rnd = new Random(Calendar.getInstance().getTimeInMillis());
		gamersTeam = new GamersTeam(new StupidBumpkin(null, 0),
				new StupidBumpkin(null, 1));
		gamersTeamTrumpSetter = new GamersTeam(new StupidBumpkin(null, 2),
				new StupidBumpkin(null, 3));
		judge = new Judge(trump, gamersTeamTrumpSetter);

	}

	@BeforeTest
	public void beforeTest() {
	}

	@Test(dataProvider = "forTestFirstCardCheck")
	public void testFirstCardCheckTrue() {
		Card card;
		boolean assertFlag = false;
		int randInt;
		switch (rnd.nextInt(2)) {
		// trump or superTrump + TrumpSetter
		case 0: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card,
					gamersTeamTrumpSetter.getGamer1()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag,
					"trump - " + trump + " card - " + card.getName()
							+ " trumpsetter");
			break;
		}
			// not trump + NotTrumpSetter
		case 1: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card,
					gamersTeamTrumpSetter.getGamer1()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag,
					"trump - " + trump + " card - " + card.getName()
							+ " NotTrumpsetter");
			break;
		}
		}
		assertTrue(true);
	}

	@Test(dataProvider = "forTestFirstCardCheck")
	public void testFirstCardCheckFalse() {
		switch (rnd.nextInt(3)) {
		// козырь по масти + TrumpSetter
		case 0: {
			int trump = rnd.nextInt(4);

			break;
		}
			// супер козырь + TrumpSetter
		case 1: {
			break;
		}
			// не козырь + NotTrumpSetter
		case 2: {
			break;
		}
		}
		assertFalse(false);
	}
}
