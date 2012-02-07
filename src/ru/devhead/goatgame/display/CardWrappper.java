package ru.devhead.goatgame.display;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import ru.devhead.goatgame.logic.Card;

public class CardWrappper extends Card {
	
	private ImageIcon cardImage;
	private int _x;
	private int _y;

	public CardWrappper(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	// ===================================================================
	// moveTo
	public void moveTo(int x, int y) {
		_x = x;
		_y = y;
	}

	// =================================================================
	// contains
	public boolean contains(int x, int y) {
		return (x > _x && x < (_x + getWidth()) && y > _y && y < (_y + getHeight()));
	}

	// =================================================================
	// getWidth
	public int getWidth() {
		return cardImage.getIconWidth();
	}

	// ================================================================
	// getHeight
	public int getHeight() {
		return cardImage.getIconHeight();
	}

	// =====================================================================
	// getX
	public int getX() {
		return _x;
	}

	// =====================================================================
	// getY
	public int getY() {
		return _x;
	}

	// =====================================================================
	// draw
	public void draw(Graphics g, Component c) {
		cardImage.paintIcon(c, g, _x, _y);
	}

}
