package ru.devhead.goatgame.logic.verification;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardsNames;
import ru.devhead.goatgame.logic.SimpleCard;

public class CardGroups {

	private int trump;

	static public Card[] SuperTrumps;
	// then no super trump card.
	static public Card[] DiamondsCard;
	static public Card[] HeartsCard;
	static public Card[] SpadeCard;
	static public Card[] CrossesCard;

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
	// Without SIX_CROSSES
	static public int[] CrossesCardId = { CardsNames.NINE_CROSSES,
			CardsNames.TEN_CROSSES, CardsNames.KING_CROSSES,
			CardsNames.ACE_CROSSES };

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
	}

	public CardGroups() {
		// default trump is DIAMONDS
		setTrump(CardsNames.DIAMONDS);
	}

	public CardGroups(int trump) {
		setTrump(trump);
	}

	/**
	 * @return the trump
	 */
	public int getTrump() {
		return trump;
	}

	/**
	 * @param trump
	 *            the trump to set
	 */
	public void setTrump(int trump) {
		this.trump = trump;
	}
	
	Card[] getTrumps(){
		switch(getTrump()){
		case CardsNames.DIAMONDS:{
			return DiamondsCard;
		}
		case CardsNames.HEARTS:{
			return HeartsCard;
		}
		case CardsNames.SPADE:{
			return SpadeCard;
		}
		case CardsNames.CROSSES:{
			return CrossesCard;
		}
		}
		return null;
	}

}
