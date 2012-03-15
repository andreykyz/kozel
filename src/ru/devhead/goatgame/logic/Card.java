package ru.devhead.goatgame.logic;

public interface Card {

	/**
	 * 
	 * @return uniq card id
	 */
	public int getId();

	/**
	 * CROSSES - 3,
	 * SPADE - 2,
	 * HEARTS - 1,
	 * DIAMONDS - 0.
	 * @return one of four said suit id
	 */
	public int getSuitId();

	/**
	 * 
	 * @return Human readable full card name
	 */
	public String getName();
	
	/**
	 * Similar with getSuitId(), but return SIX - 0, SEVEN - 4, EIGHT - 8, ... , ACE -  32.
	 * @return one of four said id 0, 4, 8 ....
	 */
	public int getPicture();
	
	/**
	 * 
	 * @return Human readable suit name of the card
	 */
	public String getSuitName();
	
	/**
	 * 
	 * @return what is the cost the card.
	 */
	public int getCost();

	/**
	 * Switch visibility
	 * @param visible
	 */
	public void setVisible(boolean visible);
	
	/**
	 * 
	 * @return true if card visible
	 */
	public boolean isVisible();
/*
	public void moveTo(int x, int y);

	public boolean contains(int x, int y);

	public int getWidth();
	
	public int getHeight();
	
	public int getX();
	
	public int getY();
	
	public void draw(Graphics g, Component c);*/
}