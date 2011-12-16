package ru.devhead.goatgame.logic;

public class Card {
	
	private int faceId;
	private int suitId;
	private String faceName;
//	String suitName;
	private int picture;
	


	public Card(int value)
	{
		faceId = value;
		switch (value)
		{
			case CardsNames.SIX_CROSSES:
			{
				faceName = "SIX_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_PINOCHELE:
			{
				faceName=  "SIX_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_HEARTS:
			{
				faceName = "SIX_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SIX_DIAMONDS:
			{
				faceName = "SIX_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.SIX;
				break;
			}
			case CardsNames.SEVEN_CROSSES:
			{
				faceName = "SEVEN_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_PINOCHELE:
			{
				faceName = "SEVEN_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_HEARTS:
			{
				faceName = "SEVEN_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.SEVEN_DIAMONDS:
			{
				faceName = "SEVEN_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.SEVEN;
				break;
			}
			case CardsNames.EIGHT_CROSSES:
			{
				faceName = "EIGHT_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_PINOCHELE:
			{
				faceName = "EIGHT_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_HEARTS:
			{
				faceName = "EIGHT_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.EIGHT_DIAMONDS:
			{
				faceName = "EIGHT_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.EIGHT;
				break;
			}
			case CardsNames.NINE_CROSSES:
			{
				faceName = "NINE_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_PINOCHELE:
			{
				faceName = "NINE_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_HEARTS:
			{
				faceName = "NINE_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.NINE_DIAMONDS:
			{
				faceName = "NINE_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.NINE;
				break;
			}
			case CardsNames.TEN_CROSSES:
			{
				faceName = "TEN_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_PINOCHELE:
			{
				faceName = "TEN_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_HEARTS:
			{
				faceName = "TEN_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.TEN_DIAMONDS:
			{
				faceName = "TEN_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.TEN;
				break;
			}
			case CardsNames.JACK_CROSSES:
			{
				faceName = "JACK_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_PINOCHELE:
			{
				faceName = "JACK_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_HEARTS:
			{
				faceName = "JACK_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.JACK_DIAMONDS:
			{
				faceName = "JACK_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.JACK;
				break;
			}
			case CardsNames.QUEEN_CROSSES:
			{
				faceName = "QUEEN_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_PINOCHELE:
			{
				faceName = "QUEEN_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_HEARTS:
			{
				faceName = "QUEEN_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.QUEEN_DIAMONDS:
			{
				faceName = "QUEEN_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.QUEEN;
				break;
			}
			case CardsNames.KING_CROSSES:
			{
				faceName = "KING_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_PINOCHELE:
			{
				faceName = "KING_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_HEARTS:
			{
				faceName = "KING_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.KING_DIAMONDS:
			{
				faceName = "KING_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.KING;
				break;
			}
			case CardsNames.ACE_CROSSES:
			{
				faceName = "ACE_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_PINOCHELE:
			{
				faceName = "ACE_PINOCHELE";
				suitId = CardsNames.PINOCHELE;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_HEARTS:
			{
				faceName = "ACE_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.ACE;
				break;
			}
			case CardsNames.ACE_DIAMONDS:
			{
				faceName = "ACE_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.ACE;
				break;
			}
		}
		
	}
	
	public int getFaceId() {
		return faceId;
	}
	
	public int getSuitId(){
		return suitId;
	}
	
	public String getFaceName() {
		return faceName;
	}
	
	public int getPicture(){
		return picture;
	}

	public String getSuitName() {
		switch (suitId) {
		case CardsNames.CROSSES:
			return "CROSSES";
		case CardsNames.PINOCHELE:
			return "PINOCHELE";
		case CardsNames.HEARTS:
			return "HEARTS";
		case CardsNames.DIAMONDS:
			return "DIAMONDS";
		}
		return faceName;

	}
	
}
