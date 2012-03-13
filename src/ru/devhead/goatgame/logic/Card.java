package ru.devhead.goatgame.logic;

public class Card {
	
	private int faceId;
	private int suitId;
	private String faceName;
	private int cost = 0;
//	String suitName;
	private int picture;
	protected boolean visible = true;


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
			case CardsNames.SIX_SPADE:
			{
				faceName=  "SIX_SPADE";
				suitId = CardsNames.SPADE;
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
			case CardsNames.SEVEN_SPADE:
			{
				faceName = "SEVEN_SPADE";
				suitId = CardsNames.SPADE;
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
			case CardsNames.EIGHT_SPADE:
			{
				faceName = "EIGHT_SPADE";
				suitId = CardsNames.SPADE;
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
			case CardsNames.NINE_SPADE:
			{
				faceName = "NINE_SPADE";
				suitId = CardsNames.SPADE;
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
				cost = 10;
				break;
			}
			case CardsNames.TEN_SPADE:
			{
				faceName = "TEN_SPADE";
				suitId = CardsNames.SPADE;
				picture = CardsNames.TEN;
				cost = 10;
				break;
			}
			case CardsNames.TEN_HEARTS:
			{
				faceName = "TEN_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.TEN;
				cost = 10;
				break;
			}
			case CardsNames.TEN_DIAMONDS:
			{
				faceName = "TEN_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.TEN;
				cost = 10;
				break;
			}
			case CardsNames.JACK_CROSSES:
			{
				faceName = "JACK_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.JACK;
				cost = 2;
				break;
			}
			case CardsNames.JACK_SPADE:
			{
				faceName = "JACK_SPADE";
				suitId = CardsNames.SPADE;
				picture = CardsNames.JACK;
				cost = 2;
				break;
			}
			case CardsNames.JACK_HEARTS:
			{
				faceName = "JACK_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.JACK;
				cost = 2;
				break;
			}
			case CardsNames.JACK_DIAMONDS:
			{
				faceName = "JACK_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.JACK;
				cost = 2;
				break;
			}
			case CardsNames.QUEEN_CROSSES:
			{
				faceName = "QUEEN_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.QUEEN;
				cost = 3;
				break;
			}
			case CardsNames.QUEEN_SPADE:
			{
				faceName = "QUEEN_SPADE";
				suitId = CardsNames.SPADE;
				picture = CardsNames.QUEEN;
				cost = 3;
				break;
			}
			case CardsNames.QUEEN_HEARTS:
			{
				faceName = "QUEEN_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.QUEEN;
				cost = 3;
				break;
			}
			case CardsNames.QUEEN_DIAMONDS:
			{
				faceName = "QUEEN_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.QUEEN;
				cost = 3;
				break;
			}
			case CardsNames.KING_CROSSES:
			{
				faceName = "KING_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.KING;
				cost = 4;
				break;
			}
			case CardsNames.KING_SPADE:
			{
				faceName = "KING_SPADE";
				suitId = CardsNames.SPADE;
				picture = CardsNames.KING;
				cost = 4;
				break;
			}
			case CardsNames.KING_HEARTS:
			{
				faceName = "KING_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.KING;
				cost = 4;
				break;
			}
			case CardsNames.KING_DIAMONDS:
			{
				faceName = "KING_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.KING;
				cost = 4;
				break;
			}
			case CardsNames.ACE_CROSSES:
			{
				faceName = "ACE_CROSSES";
				suitId = CardsNames.CROSSES;
				picture = CardsNames.ACE;
				cost = 11;
				break;
			}
			case CardsNames.ACE_SPADE:
			{
				faceName = "ACE_SPADE";
				suitId = CardsNames.SPADE;
				picture = CardsNames.ACE;
				cost = 11;
				break;
			}
			case CardsNames.ACE_HEARTS:
			{
				faceName = "ACE_HEARTS";
				suitId = CardsNames.HEARTS;
				picture = CardsNames.ACE;
				cost = 11;
				break;
			}
			case CardsNames.ACE_DIAMONDS:
			{
				faceName = "ACE_DIAMONDS";
				suitId = CardsNames.DIAMONDS;
				picture = CardsNames.ACE;
				cost = 11;
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
		case CardsNames.SPADE:
			return "SPADE";
		case CardsNames.HEARTS:
			return "HEARTS";
		case CardsNames.DIAMONDS:
			return "DIAMONDS";
		}
		return faceName;
	}
	
	public int getCost() {
		return cost;
	}

	public int hashCode() {
		return this.getFaceId();
	}

	public boolean equals(Object obj) {
		if (this.hashCode() == obj.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

}
