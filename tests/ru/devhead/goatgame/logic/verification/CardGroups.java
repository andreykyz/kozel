package ru.devhead.goatgame.logic.verification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;

public class CardGroups {

	static public Card[] SuperTrumps;
	// then no super trump card.
	static public Card[] DiamondsCard;
	static public Card[] HeartsCard;
	static public Card[] SpadeCard;
	static public Card[] CrossesCard;
	static public Card[] notSuperTrumps;
	static public Object[][] trumpAndTrumpSuitPairs;
	static public Object[][] noTrumpAndTrumpSuitPairs;

	static int[] SuperTrumpId = { CardsNames.SIX_CROSSES,
			CardsNames.JACK_DIAMONDS, CardsNames.JACK_HEARTS,
			CardsNames.JACK_SPADE, CardsNames.JACK_CROSSES,
			CardsNames.QUEEN_DIAMONDS, CardsNames.QUEEN_HEARTS,
			CardsNames.QUEEN_SPADE, CardsNames.QUEEN_CROSSES };

	static public int[] DiamondsCardId = { CardsNames.SIX_DIAMONDS,
			CardsNames.NINE_DIAMONDS, CardsNames.TEN_DIAMONDS,
			CardsNames.KING_DIAMONDS, CardsNames.ACE_DIAMONDS };
	static public int[] HeartsCardId = { CardsNames.SIX_HEARTS,
			CardsNames.NINE_HEARTS, CardsNames.TEN_HEARTS,
			CardsNames.KING_HEARTS, CardsNames.ACE_HEARTS };
	static public int[] SpadeCardId = { CardsNames.SIX_SPADE,
			CardsNames.NINE_SPADE, CardsNames.TEN_SPADE, CardsNames.KING_SPADE,
			CardsNames.ACE_SPADE };
	// without SIX_CROSSES
	static public int[] CrossesCardId = { CardsNames.NINE_CROSSES,
			CardsNames.TEN_CROSSES, CardsNames.KING_CROSSES,
			CardsNames.ACE_CROSSES };

	// fill card groups
	static {
		SuperTrumps = new Card[SuperTrumpId.length];
		for (int i = 0; i < SuperTrumps.length; i++) {
			SuperTrumps[i] = new SimpleCard(SuperTrumpId[i]);
		}
		DiamondsCard = new Card[DiamondsCardId.length];
		for (int i = 0; i < DiamondsCard.length; i++) {
			DiamondsCard[i] = new SimpleCard(DiamondsCardId[i]);
		}
		HeartsCard = new Card[HeartsCardId.length];
		for (int i = 0; i < HeartsCard.length; i++) {
			HeartsCard[i] = new SimpleCard(HeartsCardId[i]);
		}
		SpadeCard = new Card[SpadeCardId.length];
		for (int i = 0; i < SpadeCard.length; i++) {
			SpadeCard[i] = new SimpleCard(SpadeCardId[i]);
		}
		CrossesCard = new Card[CrossesCardId.length];
		for (int i = 0; i < CrossesCard.length; i++) {
			CrossesCard[i] = new SimpleCard(CrossesCardId[i]);
		}

		// fill notSuperTrump
		notSuperTrumps = new Card[28 - SuperTrumps.length];
		for (int i = 0; i < DiamondsCard.length; i++) {
			notSuperTrumps[i] = DiamondsCard[i];
		}
		for (int i = 0; i < HeartsCard.length; i++) {
			notSuperTrumps[i + DiamondsCard.length] = HeartsCard[i];
		}
		for (int i = 0; i < SpadeCard.length; i++) {
			notSuperTrumps[i + DiamondsCard.length + HeartsCard.length] = SpadeCard[i];
		}
		for (int i = 0; i < CrossesCard.length; i++) {
			notSuperTrumps[i + DiamondsCard.length + HeartsCard.length
					+ SpadeCard.length] = CrossesCard[i];
		}

		// fill trumpAndTrumpSuit
		int dataLength = SuperTrumps.length * 4 + DiamondsCard.length
				+ HeartsCard.length + SpadeCard.length + CrossesCard.length;
		trumpAndTrumpSuitPairs = new Object[dataLength][2];
		// first for diamonds
		dataLength = DiamondsCard.length;
		int dataLengthStart = 0;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = DiamondsCard[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.DIAMONDS;
		}
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + SuperTrumps.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = SuperTrumps[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.DIAMONDS;
		}
		// fill hearts
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + HeartsCard.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = HeartsCard[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.HEARTS;
		}
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + SuperTrumps.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = SuperTrumps[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.HEARTS;
		}
		// fill spade
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + SpadeCard.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = SpadeCard[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.SPADE;
		}
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + SuperTrumps.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = SuperTrumps[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.SPADE;
		}
		// fill crosses
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + CrossesCard.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = CrossesCard[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.CROSSES;
		}
		dataLengthStart = dataLength;
		dataLength = dataLengthStart + SuperTrumps.length;
		for (int i = dataLengthStart; i < dataLength; i++) {
			trumpAndTrumpSuitPairs[i][0] = SuperTrumps[i];
			trumpAndTrumpSuitPairs[i][1] = CardsNames.CROSSES;
		}
		// fill noTrumpAndTrumpSuit
		int trump;
		dataLength = 0;
		dataLengthStart = 0;
		List<Object[]> noTrumpAndTrumpSuitPairsList = new ArrayList<Object[]>();
		List<Card> notSuperTrumpsList = Arrays.asList(notSuperTrumps);
		for (trump = 0; trump < 4; trump++) {
			Iterator<Card> it = notSuperTrumpsList.iterator();
			while (it.hasNext()) {
				Card card = it.next();
				if (card.getSuitId() != trump) {
					Object obj[] = new Object[] { card, trump };
					noTrumpAndTrumpSuitPairsList.add(obj);
				}
			}
		}
		noTrumpAndTrumpSuitPairs = (Object[][]) noTrumpAndTrumpSuitPairsList.toArray();
	}
}
