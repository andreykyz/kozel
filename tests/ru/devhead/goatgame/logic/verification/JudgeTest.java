package ru.devhead.goatgame.logic.verification;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

@RunWith(value = Parameterized.class)
public class JudgeTest {
	
	static GamersTeam gamersTeam;
	static Card superTrumps[];
	static Card otherCards[];
	static int trump;
	private int iteration;
	private String testData;
	private static Random rnd;
	
	public JudgeTest(int iteration) {
		this.iteration = iteration;
		//this.testData = testData;
	}

	@Parameters
	public static Collection<Object[]> data() {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 100; i++) {
			list.add(new Integer[]{1});
		}

		return list;
	}

	@BeforeClass
	public static void setUpBefore() {
		
		rnd = new Random(Calendar.getInstance().getTimeInMillis());

		gamersTeam = new GamersTeam(new StupidBumpkin(null, 0),
				new StupidBumpkin(null, 1));
		superTrumps = new Card[9];
		superTrumps[0] = new SimpleCard(CardsNames.SIX_CROSSES);
		for (int i = CardsNames.JACK_DIAMONDS; i <= CardsNames.QUEEN_CROSSES; i++) {
			superTrumps[i + 1 - CardsNames.JACK_DIAMONDS] = new SimpleCard(i);
		}
	
	}
	
	@Test
	public void testFirstCardCheck() {
		Judge judge = new Judge(new SimpleCard(3), gamersTeam);
		boolean test = judge.firstCardCheck(superTrumps[rnd.nextInt(9)],
				gamersTeam.getGamer1()).getCheatCode() == CheatingType.OK;
//		System.out.println(testData);
		assertTrue("ff", test);
	}
	
}
