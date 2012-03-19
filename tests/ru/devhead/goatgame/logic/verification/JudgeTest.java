package ru.devhead.goatgame.logic.verification;

import static org.junit.Assert.*;

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
	
	public JudgeTest(int iteration, String testData) {
		this.iteration = iteration;
		this.testData = testData;
	}

	@Parameters
	 public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 1,"fsdf" }, { 2,"fsdfsdfsdf" }, { 3,"fssdfsdfdf" }, {4,"fsfsdfsddf" } };
	//	for (int j = 0; j < data[0].length; j++) {
			//data[0][j] = 1;
		//}
		return Arrays.asList(data);
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
	
	@Ignore
	@Test
	public void testCheckTurnCardCardGamer() {
		fail("Not yet implemented");
	}

	@Ignore
	@Before
	public void setUpFirstCardCheck() {

	}

	@Test
	public void testFirstCardCheck() {
		Judge judge = new Judge(new SimpleCard(3), gamersTeam);
		boolean test = judge.firstCardCheck(superTrumps[rnd.nextInt(9)],
				gamersTeam.getGamer1()).getCheatCode() == CheatingType.OK;
//		System.out.println(testData);
		assertTrue("ff", test);
	}
	
	@Ignore
	@Test
	public void testCheckTurnCardGamer() {
		fail("Not yet implemented");
	}

}
