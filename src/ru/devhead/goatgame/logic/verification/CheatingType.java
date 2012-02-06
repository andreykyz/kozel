package ru.devhead.goatgame.logic.verification;

public class CheatingType {
	
	private String cheatString;
	private int cheatCode;
	private int cheatPoints;
	
	static public final int OK = 0;
	static public final int SUIT_CHEAT_CODE = 1;
	static public final int TRUMP_CHEAT_CODE = 2;
	static public final int FIRST_TURN_CHEAT_CODE = 3;

	static public final String SUIT_CHEAT = "Do not follow suit.";
	static public final String TRUMP_CHEAT = "It is forbidden to turn trump.";
	static public final String FIRST_TURN_CHEAT = "Gamer can't trump setter.";
	static public final String OTHER_CHEAT = "Do not know cheating.";
	
	
	public CheatingType(int cheatCode) {
		switch(cheatCode) {
		case OK:
			this.setCheatCode(cheatCode);
			setCheatPoints(0);
			break;
		case SUIT_CHEAT_CODE:
			setCheatString(SUIT_CHEAT);
			this.setCheatCode(cheatCode);
			setCheatPoints(4);
			break;
		case TRUMP_CHEAT_CODE:
			setCheatString(TRUMP_CHEAT);
			this.setCheatCode(cheatCode);
			setCheatPoints(4);
			break;
		case FIRST_TURN_CHEAT_CODE:
			setCheatString(FIRST_TURN_CHEAT);
			this.setCheatCode(cheatCode);
			setCheatPoints(4);
			break;
		default:
			setCheatString(OTHER_CHEAT);
			this.setCheatCode(cheatCode);
			setCheatPoints(4);
			break;
		}
	}



	public void setCheatCode(int cheatCode) {
		this.cheatCode = cheatCode;
	}


	public int getCheatCode() {
		return cheatCode;
	}


	public void setCheatPoints(int cheatPoints) {
		this.cheatPoints = cheatPoints;
	}


	public int getCheatPoints() {
		return cheatPoints;
	}



	public void setCheatString(String cheatString) {
		this.cheatString = cheatString;
	}



	public String getCheatString() {
		return cheatString;
	}

}
