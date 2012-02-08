package ru.devhead.goatgame.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;
import ru.devhead.goatgame.logic.CardsNames;

/**
 * @author Andrey Kuznetsov
 */
public class DisplayWrapper extends JComponent implements MouseListener,
		MouseMotionListener, Display {

	// constants
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND_COLOR = Color.GREEN;
	private static final int TABLE_SIZE = 400; // Pixels.

	// fields
	private Point trumpSuitPoint;
	private ImageIcon trumpSuitImg;
	private Point textPoint;
	
	private String textLine = "";
	
	private CardBatch leftBatch;
	private CardBatch rightBatch;
	private CardBatch topBatch;
	private CardBatch bottomBatch;
	
	private Card[] turnedCards;
	private int turnedCardsIndex;
	
	
	public DisplayWrapper(){
		leftBatch = new CardBatch();
		rightBatch = new CardBatch();
		topBatch = new CardBatch();
		bottomBatch = new CardBatch();
		
		turnedCards = new Card[4];
		turnedCardsIndex = 0;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// ... Paint background
		int width = getWidth();
		int height = getHeight();
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);
		g.drawString(textLine, textPoint.x, textPoint.y);
		
		
	}
	
	@Override
	public void printTurnCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTrumpSuit(Card card) {
		switch (card.getSuitId()) {
		case CardsNames.CROSSES:
			trumpSuitImg = new ImageIcon("cards/CROSSES.gif");
			break;
		case CardsNames.DIAMONDS:
			trumpSuitImg = new ImageIcon("cards/DIAMONDS.gif");
			break;
		case CardsNames.HEARTS:
			trumpSuitImg = new ImageIcon("cards/HEARTS.gif");
			break;
		case CardsNames.SPADE:
			trumpSuitImg = new ImageIcon("cards/SPADE.gif");
			break;
		}
		this.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Card getSelectCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printLeft(boolean visible, CardBatch batch) {
		leftBatch = batch;
		leftBatch.setVisible(visible);
		this.repaint();		
	}

	@Override
	public void printTop(boolean visible, CardBatch batch) {
		topBatch = batch;
		topBatch.setVisible(visible);
		this.repaint();	
	}

	@Override
	public void printBottom(boolean visible, CardBatch batch) {
		bottomBatch = batch;
		bottomBatch.setVisible(visible);
		this.repaint();	
	}

	@Override
	public void printRight(boolean visible, CardBatch batch) {
		rightBatch = batch;
		rightBatch.setVisible(visible);
		this.repaint();	
	}

	@Override
	public void printText(String line) {
		textLine = line;
		this.repaint();

	}

}
