package ru.devhead.goatgame.logic.verification;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Calendar;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class JudgeTestNG {

	static GamersTeam gamersTeam;
	static Card superTrumps[];
	static Card otherCards[];
	static int trump;
	private int iteration;
	private String testString;
	private static Random rnd;

	@Test(dataProvider = "dp")
	public void testFirstCardCheck() {
		Judge judge = new Judge(new SimpleCard(3), gamersTeam);
		boolean test = judge.firstCardCheck(superTrumps[rnd.nextInt(9)],
				gamersTeam.getGamer1()).getCheatCode() == CheatingType.OK;
		System.out.println(iteration);
		System.out.println(testString);
		assertTrue("ff", test);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" },
				new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {

		rnd = new Random(Calendar.getInstance().getTimeInMillis());

		gamersTeam = new GamersTeam(new StupidBumpkin(null, 0),
				new StupidBumpkin(null, 1));
		superTrumps = new Card[9];
		superTrumps[0] = new SimpleCard(CardsNames.SIX_CROSSES);
		for (int i = CardsNames.JACK_DIAMONDS; i <= CardsNames.QUEEN_CROSSES; i++) {
			superTrumps[i + 1 - CardsNames.JACK_DIAMONDS] = new SimpleCard(i);
		}
	}

	@BeforeTest
	public void beforeTest() {
	}

}
