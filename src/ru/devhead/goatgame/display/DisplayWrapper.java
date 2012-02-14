package ru.devhead.goatgame.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
public class DisplayWrapper extends JComponent implements ComponentListener,
		MouseListener, MouseMotionListener, Display {

	// constants
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND_COLOUR = Color.GREEN;
	private static final Color TEXT_COLOUR = Color.BLACK;
	private static final int TABLE_WIDTH = 800; // Pixels.
	private static final int TABLE_HEIGHT = 550; // Pixels.

	// fields
	private Point trumpSuitPoint;
	private ImageIcon trumpSuitImg;
	private Point textPoint;

	private String textLine = "Kozel card game";

	private CardBatch leftBatch;
	private CardBatch rightBatch;
	private CardBatch topBatch;
	private CardBatch bottomBatch;

	private CardWrapper[] turnedCards;
	private int turnedCardsIndex;

	public DisplayWrapper() {
		setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));

		leftBatch = new CardBatch();
		rightBatch = new CardBatch();
		topBatch = new CardBatch();
		bottomBatch = new CardBatch();

		turnedCards = new CardWrapper[4];
		turnedCardsIndex = 0;

		trumpSuitImg = new ImageIcon();
		trumpSuitPoint = new Point(0, 0);

		textPoint = new Point(5, TABLE_HEIGHT - 10);

		// Add listeners ...
		this.addComponentListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		// ... Paint background
		int width = getWidth();
		int height = getHeight();
		g.setColor(BACKGROUND_COLOUR);
		g.fillRect(0, 0, width, height);

		// Draw "say string" on the bottom
		g.setColor(TEXT_COLOUR);
		g.drawString(textLine, textPoint.x, textPoint.y);

		// Painting trump suit image
		trumpSuitImg.paintIcon(this, g, trumpSuitPoint.x, trumpSuitPoint.y);

		// Painting turned cards on the center
		for (int i = 0; i < 4; i++) {
			if (turnedCards[i] != null) {
				turnedCards[i].draw(g, this);
			}
		}

	}

	@Override
	public void printTurnCard(Card card) {
		if (card != null) {
			if (turnedCardsIndex == 4) {
				turnedCardsIndex = 0;
				turnedCards[1] = null;
				turnedCards[2] = null;
				turnedCards[3] = null;
			}
			turnedCards[turnedCardsIndex++] = new CardWrapper(card);
			turnedCards[turnedCardsIndex - 1].setVisible(true);
			fixOffsets();
		} else {
			turnedCardsIndex = 0;
			turnedCards[0] = null;
			turnedCards[1] = null;
			turnedCards[2] = null;
			turnedCards[3] = null;
		}
		this.repaint();
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
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		fixOffsets();
		this.repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Procedure for fix component's position
	 */
	private void fixOffsets() {
		// Hardcoded right top position for current suit
		trumpSuitPoint = new Point(this.getWidth()
				- trumpSuitImg.getIconWidth() * 2,
				trumpSuitImg.getIconHeight() * 2);

		// Hardcoded position for Text line at down
		textPoint = new Point(5, this.getHeight() - 10);

		// Hardcoded offset for turned cards - 5 pixels
		switch (turnedCardsIndex - 1) {
		case 0:
			turnedCards[0].moveTo(
					this.getWidth() / 2 - (turnedCards[0].getWidth() + 5),
					this.getHeight() / 2 - (turnedCards[0].getHeight() + 5));
			break;
		case 1:
			turnedCards[1].moveTo(this.getWidth() / 2 + 5, this.getHeight() / 2
					- (turnedCards[1].getHeight() + 5));
			break;
		case 2:
			turnedCards[2].moveTo(this.getWidth() / 2 + 5,
					this.getHeight() / 2 + 5);
			break;
		case 3:
			turnedCards[3].moveTo(
					this.getWidth() / 2 - (turnedCards[3].getWidth() + 5),
					this.getHeight() / 2 + 5);
			break;
		}

	}
}
