package ru.devhead.goatgame.logic;

public class SimpleCard implements Card {

	private int faceId;
	private int suitId;
	private String name;
	private int cost = 0;
	// String suitName;
	private int pictureId;
	protected boolean visible;

	public SimpleCard(int value) {
		visible = true;
		faceId = value;
		switch (value) {
		case CardsNames.SIX_CROSSES: {
			name = "SIX_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.SIX;
			break;
		}
		case CardsNames.SIX_SPADE: {
			name = "SIX_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.SIX;
			break;
		}
		case CardsNames.SIX_HEARTS: {
			name = "SIX_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.SIX;
			break;
		}
		case CardsNames.SIX_DIAMONDS: {
			name = "SIX_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.SIX;
			break;
		}
		case CardsNames.SEVEN_CROSSES: {
			name = "SEVEN_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.SEVEN;
			break;
		}
		case CardsNames.SEVEN_SPADE: {
			name = "SEVEN_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.SEVEN;
			break;
		}
		case CardsNames.SEVEN_HEARTS: {
			name = "SEVEN_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.SEVEN;
			break;
		}
		case CardsNames.SEVEN_DIAMONDS: {
			name = "SEVEN_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.SEVEN;
			break;
		}
		case CardsNames.EIGHT_CROSSES: {
			name = "EIGHT_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.EIGHT;
			break;
		}
		case CardsNames.EIGHT_SPADE: {
			name = "EIGHT_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.EIGHT;
			break;
		}
		case CardsNames.EIGHT_HEARTS: {
			name = "EIGHT_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.EIGHT;
			break;
		}
		case CardsNames.EIGHT_DIAMONDS: {
			name = "EIGHT_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.EIGHT;
			break;
		}
		case CardsNames.NINE_CROSSES: {
			name = "NINE_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.NINE;
			break;
		}
		case CardsNames.NINE_SPADE: {
			name = "NINE_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.NINE;
			break;
		}
		case CardsNames.NINE_HEARTS: {
			name = "NINE_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.NINE;
			break;
		}
		case CardsNames.NINE_DIAMONDS: {
			name = "NINE_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.NINE;
			break;
		}
		case CardsNames.TEN_CROSSES: {
			name = "TEN_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.TEN;
			cost = 10;
			break;
		}
		case CardsNames.TEN_SPADE: {
			name = "TEN_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.TEN;
			cost = 10;
			break;
		}
		case CardsNames.TEN_HEARTS: {
			name = "TEN_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.TEN;
			cost = 10;
			break;
		}
		case CardsNames.TEN_DIAMONDS: {
			name = "TEN_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.TEN;
			cost = 10;
			break;
		}
		case CardsNames.JACK_CROSSES: {
			name = "JACK_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.JACK;
			cost = 2;
			break;
		}
		case CardsNames.JACK_SPADE: {
			name = "JACK_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.JACK;
			cost = 2;
			break;
		}
		case CardsNames.JACK_HEARTS: {
			name = "JACK_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.JACK;
			cost = 2;
			break;
		}
		case CardsNames.JACK_DIAMONDS: {
			name = "JACK_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.JACK;
			cost = 2;
			break;
		}
		case CardsNames.QUEEN_CROSSES: {
			name = "QUEEN_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.QUEEN;
			cost = 3;
			break;
		}
		case CardsNames.QUEEN_SPADE: {
			name = "QUEEN_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.QUEEN;
			cost = 3;
			break;
		}
		case CardsNames.QUEEN_HEARTS: {
			name = "QUEEN_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.QUEEN;
			cost = 3;
			break;
		}
		case CardsNames.QUEEN_DIAMONDS: {
			name = "QUEEN_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.QUEEN;
			cost = 3;
			break;
		}
		case CardsNames.KING_CROSSES: {
			name = "KING_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.KING;
			cost = 4;
			break;
		}
		case CardsNames.KING_SPADE: {
			name = "KING_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.KING;
			cost = 4;
			break;
		}
		case CardsNames.KING_HEARTS: {
			name = "KING_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.KING;
			cost = 4;
			break;
		}
		case CardsNames.KING_DIAMONDS: {
			name = "KING_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.KING;
			cost = 4;
			break;
		}
		case CardsNames.ACE_CROSSES: {
			name = "ACE_CROSSES";
			suitId = CardsNames.CROSSES;
			pictureId = CardsNames.ACE;
			cost = 11;
			break;
		}
		case CardsNames.ACE_SPADE: {
			name = "ACE_SPADE";
			suitId = CardsNames.SPADE;
			pictureId = CardsNames.ACE;
			cost = 11;
			break;
		}
		case CardsNames.ACE_HEARTS: {
			name = "ACE_HEARTS";
			suitId = CardsNames.HEARTS;
			pictureId = CardsNames.ACE;
			cost = 11;
			break;
		}
		case CardsNames.ACE_DIAMONDS: {
			name = "ACE_DIAMONDS";
			suitId = CardsNames.DIAMONDS;
			pictureId = CardsNames.ACE;
			cost = 11;
			break;
		}
		}

	}

	@Override
	public int getId() {
		return faceId;
	}

	@Override
	public int getSuitId() {
		return suitId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPicture() {
		return pictureId;
	}

	@Override
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
		return name;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this.hashCode() == obj.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
