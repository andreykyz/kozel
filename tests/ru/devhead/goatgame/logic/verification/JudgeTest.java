package ru.devhead.goatgame.logic.verification;

import static org.testng.Assert.*;

import java.util.Calendar;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;
import ru.devhead.goatgame.logic.brain.Gamer;
import ru.devhead.goatgame.logic.brain.GamersTeam;
import ru.devhead.goatgame.logic.brain.StupidBumpkin;

public class JudgeTest {

	Gamer gamerWithOnlyTrumps;
	Gamer gamerWithSimpleCards;
	Gamer gamerWithoutCards;
	private GamersTeam gamersTeam;
	private GamersTeam gamersTeamTrumpSetter;
	private int trump = 0;
	private Random rnd;
	private Judge judge;

	@DataProvider
	public Object[][] forTestFirstCardCheck() {
		return new Object[1000][1];
	}

	@BeforeClass
	public void beforeClass() {
		CardGroups.init();
		rnd = new Random(Calendar.getInstance().getTimeInMillis());
		
		gamerWithoutCards = new StupidBumpkin(null, 0);
		
		gamerWithOnlyTrumps = new StupidBumpkin(null, 0);
		gamerWithOnlyTrumps.pushCard(new SimpleCard(CardsNames.SIX_CROSSES));
		gamerWithOnlyTrumps.pushCard(new SimpleCard(CardsNames.QUEEN_CROSSES));
		
		gamerWithSimpleCards = new StupidBumpkin(null, 1);
		gamerWithSimpleCards.pushCard(new SimpleCard(CardsNames.SIX_CROSSES));
		gamerWithSimpleCards.pushCard(new SimpleCard(CardsNames.SIX_DIAMONDS));
		gamerWithSimpleCards.pushCard(new SimpleCard(CardsNames.SIX_HEARTS));
		
		gamersTeam = new GamersTeam(gamerWithOnlyTrumps, gamerWithSimpleCards);
		
		gamersTeamTrumpSetter = new GamersTeam(new StupidBumpkin(null, 2),
				new StupidBumpkin(null, 3),	new StupidBumpkin(null, 4));
		// gamer with simple card
		gamersTeamTrumpSetter.getGamer1().pushCard(new SimpleCard(CardsNames.SIX_HEARTS));
		gamersTeamTrumpSetter.getGamer1().pushCard(new SimpleCard(CardsNames.SIX_DIAMONDS));
		// gamer without simple card
		gamersTeamTrumpSetter.getGamer2().pushCard(new SimpleCard(CardsNames.SIX_CROSSES));
		gamersTeamTrumpSetter.getGamer2().pushCard(new SimpleCard(CardsNames.JACK_HEARTS));
		
		judge = new Judge(trump, gamersTeamTrumpSetter);
	}

	@Test(dataProvider = "forTestFirstCardCheck")
	public void testFirstCardCheckTrue(Object obj) {
		Card card;
		boolean assertFlag = false;
		int randInt;
		switch (rnd.nextInt(2)) {
		// trump or superTrump + TrumpSetter with simple card
		case 0: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamersTeamTrumpSetter.getGamer1()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " trumpsetter with simple card");
			break;
		}
		// trump or superTrump + TrumpSetter without simple card
		case 1: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamersTeamTrumpSetter.getGamer2()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " trumpsetter without simple card");
			break;
		}
			// not trump + TrumpSetter without simple card
		case 2: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamersTeamTrumpSetter.getGamer2()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " trumpsetter without simple card");
			break;
		}
			// not trump + NotTrumpSetter with simple card
		case 3: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamerWithSimpleCards).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " NotTrumpsetter");
			break;
		}
		// not trump + NotTrumpSetter without simple card
		case 4: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamerWithOnlyTrumps).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " NotTrumpsetter");
			break;
		}
		// trump or superTrump + NotTrumpSetter without simple card
		case 5: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamerWithOnlyTrumps).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " NotTrumpsetter");
			break;
		}
		// trump or superTrump + NotTrumpSetter without cards
		case 6: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamerWithoutCards).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " NotTrumpsetter without cards");
			break;
		}
		// not trump + NotTrumpSetter without cards
		case 7: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamerWithoutCards).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " NotTrumpsetter without cards");
			break;
		}
		// trump or superTrump + TrumpSetter without cards
		case 8: {
			randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamersTeamTrumpSetter.getGamer3()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " Trumpsetter without cards");
			break;
		}
		// not trump + TrumpSetter without cards
		case 9: {
			randInt = rnd.nextInt(CardGroups.noTrumpAndTrumpSuitPairs.length);
			card = (Card) CardGroups.noTrumpAndTrumpSuitPairs[randInt][0];
			trump = (Integer) CardGroups.noTrumpAndTrumpSuitPairs[randInt][1];
			judge.setTrump(trump);
			assertFlag = (judge.firstCardCheck(card, gamersTeamTrumpSetter.getGamer3()).getCheatCode() == CheatingType.OK);
			assertTrue(assertFlag, "trump - " + trump + " card - " + card.getName()	+ " Trumpsetter without cards");
			break;
		}
		}
	}

	@Test(dataProvider = "forTestFirstCardCheck")
	public void testFirstCardCheckFalse(Object obj) {
		// trump or superTrump + NotTrumpSetter
		int randInt = rnd.nextInt(CardGroups.trumpAndTrumpSuitPairs.length);
		Card card = (Card) CardGroups.trumpAndTrumpSuitPairs[randInt][0];
		trump = (Integer) CardGroups.trumpAndTrumpSuitPairs[randInt][1];
		judge.setTrump(trump);
		assertFalse(false);
	}
}
