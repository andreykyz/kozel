package ru.devhead.goatgame.display;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.SimpleCard;

public class CardWrapper extends SimpleCard {
	
	private ImageIcon faceImage;
	private ImageIcon backImage;
	private int _x;
	private int _y;

	public CardWrapper(int value) {
		super(value);
		faceImage = new ImageIcon("cards/" +  this.getName() + ".gif");
		backImage = new ImageIcon("cards/back/book.gif");
	}
	
	public CardWrapper(Card card) {
		super(card.getId());
		faceImage = new ImageIcon("cards/" +  this.getName() + ".gif");
		backImage = new ImageIcon("cards/back/book.gif");
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
		return faceImage.getIconWidth();
	}

	// ================================================================
	// getHeight
	public int getHeight() {
		return faceImage.getIconHeight();
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
		if (visible) {
			faceImage.paintIcon(c, g, _x, _y);
		} else {
			// face down
			backImage.paintIcon(c, g, _x, _y);
		}
	}

}
