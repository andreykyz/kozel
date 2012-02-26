package ru.devhead.goatgame.display;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import ru.devhead.goatgame.logic.Card;

public class CardWrapper extends Card {
	
	private ImageIcon faceImage;
	private ImageIcon backImage;
	private boolean visible = true;
	private int _x;
	private int _y;

	public CardWrapper(int value) {
		super(value);
		faceImage = new ImageIcon("cards/" +  this.getFaceName() + ".gif");
		backImage = new ImageIcon("cards/back/book.gif");
	}
	
	public CardWrapper(Card card) {
		super(card.getFaceId());
		faceImage = new ImageIcon("cards/" +  this.getFaceName() + ".gif");
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

}
