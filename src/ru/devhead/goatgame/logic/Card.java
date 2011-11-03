package ru.devhead.goatgame.logic;

public class Card {
	
	int faceId;
	int suit;
	String face;
	int picture;

	Card(int value)
	{
		faceId = value;
		switch (value)
		{
			case CardsNames.SIX_CROSSES:
			{
				face = "SIX_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_PINOCHELE:
			{
				face=  "SIX_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_HEARTS:
			{
				face = "SIX_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_DIAMONDS:
			{
				face = "SIX_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SEVEN_CROSSES:
			{
				face = "SEVEN_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_PINOCHELE:
			{
				face = "SEVEN_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_HEARTS:
			{
				face = "SEVEN_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_DIAMONDS:
			{
				face = "SEVEN_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.EIGHT_CROSSES:
			{
				face = "EIGHT_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_PINOCHELE:
			{
				face = "EIGHT_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_HEARTS:
			{
				face = "EIGHT_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_DIAMONDS:
			{
				face = "EIGHT_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.NINE_CROSSES:
			{
				face = "NINE_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_PINOCHELE:
			{
				face = "NINE_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_HEARTS:
			{
				face = "NINE_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_DIAMONDS:
			{
				face = "NINE_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.TEN_CROSSES:
			{
				face = "TEN_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_PINOCHELE:
			{
				face = "TEN_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_HEARTS:
			{
				face = "TEN_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_DIAMONDS:
			{
				face = "TEN_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.JACK_CROSSES:
			{
				face = "JACK_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_PINOCHELE:
			{
				face = "JACK_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_HEARTS:
			{
				face = "JACK_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_DIAMONDS:
			{
				face = "JACK_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.QUEEN_CROSSES:
			{
				face = "QUEEN_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_PINOCHELE:
			{
				face = "QUEEN_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_HEARTS:
			{
				face = "QUEEN_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_DIAMONDS:
			{
				face = "QUEEN_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.KING_CROSSES:
			{
				face = "KING_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_PINOCHELE:
			{
				face = "KING_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_HEARTS:
			{
				face = "KING_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_DIAMONDS:
			{
				face = "KING_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.ACE_CROSSES:
			{
				face = "ACE_CROSSES";
				suit = CardsNames.CROSSES;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_PINOCHELE:
			{
				face = "ACE_PINOCHELE";
				suit = CardsNames.PINOCHELE;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_HEARTS:
			{
				face = "ACE_HEARTS";
				suit = CardsNames.HEARTS;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_DIAMONDS:
			{
				face = "ACE_DIAMONDS";
				suit = CardsNames.DIAMONDS;
				picture = CardsNames.ACE;
				break;
			}
		}
		
	}
	
	public int getFaceId() {
		return faceId;
	}
	
	public int getSuit(){
		return suit;
	}
	
	public String getFace() {
		return face;
	}
	
	public int getPicture(){
		return picture;
	}
}
