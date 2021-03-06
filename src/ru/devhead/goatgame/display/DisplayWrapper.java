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
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

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
	static final Color BACKGROUND_COLOUR = Color.GREEN;
	static final Color TEXT_COLOUR = Color.BLACK;
	static final int TABLE_WIDTH = 800; // Pixels.
	static final int TABLE_HEIGHT = 550; // Pixels.

	// modes
	private int displayMode;
	// display modes
	private static final int PC_THINK_MODE = 0x00;
	private static final int USER_CARD_SELECT_MODE = 0x01;
	private static final int USER_SUIT_SELECT_MODE = 0x02;

	// fields
	private Point trumpSuitPoint;
	private ImageIcon trumpSuitImg;
	private Point textPoint;
	private Point mousePressedPoint;
	private Card selectedCard;

	private String textLine = "Kozel card game";

	private CardBatch leftBatch;
	private CardBatch rightBatch;
	private CardBatch topBatch;
	private CardBatch bottomBatch; // player batch

	private Card[] turnedCards;
	private int turnedCardsIndex;

	private Object boardThread;

	public DisplayWrapper() {
		setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));

		turnedCards = new Card[4];
		turnedCardsIndex = 0;

		trumpSuitImg = new ImageIcon();
		trumpSuitPoint = new Point(0, 0);

		textPoint = new Point(5, TABLE_HEIGHT - 10);
		mousePressedPoint = new Point();
		displayMode = PC_THINK_MODE;

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
				((CardWrapper) turnedCards[i]).draw(g, this);
			}
		}

		// Painting batches
		Iterator<Card> it;
		// Left batch

		if (leftBatch != null) {
			synchronized (leftBatch) {
				it = leftBatch.iterator();
				while (it.hasNext()) {
					((CardWrapper) it.next()).draw(g, this);
				}
			}
		}

		if (rightBatch != null) {
			synchronized (rightBatch) {
				it = rightBatch.iterator();
				while (it.hasNext()) {
					((CardWrapper) it.next()).draw(g, this);
				}
			}
		}

		if (topBatch != null) {
			synchronized (topBatch) {
				it = topBatch.iterator();
				while (it.hasNext()) {
					((CardWrapper) it.next()).draw(g, this);
				}
			}
		}

		if (bottomBatch != null) {
			synchronized (bottomBatch) {
				it = bottomBatch.iterator();
				while (it.hasNext()) {
					((CardWrapper) it.next()).draw(g, this);
				}
			}
		}

	}

	@Override
	public void printTurnCard(Card card) {
		synchronized (turnedCards) {
			if (card != null) {
				if (turnedCardsIndex == 4) {
					turnedCardsIndex = 0;
					turnedCards[1] = null;
					turnedCards[2] = null;
					turnedCards[3] = null;
				}
				turnedCards[turnedCardsIndex++] = card;
				turnedCards[turnedCardsIndex - 1].setVisible(true);
				fixOffsets();
			} else {
				turnedCardsIndex = 0;
				turnedCards[0] = null;
				turnedCards[1] = null;
				turnedCards[2] = null;
				turnedCards[3] = null;
			}
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
		fixOffsets();
		this.repaint();

	}

	@Override
	public void printLeft(boolean visible, CardBatch batch) {
		leftBatch = batch;
		leftBatch.setVisible(visible);
		fixOffsets();
		this.repaint();
	}

	@Override
	public void printTop(boolean visible, CardBatch batch) {
		topBatch = batch;
		topBatch.setVisible(visible);
		fixOffsets();
		this.repaint();
	}

	@Override
	public void printBottom(boolean visible, CardBatch batch) {
		bottomBatch = batch;
		bottomBatch.setVisible(visible);
		fixOffsets();
		this.repaint();
	}

	@Override
	public void printRight(boolean visible, CardBatch batch) {
		rightBatch = batch;
		rightBatch.setVisible(visible);
		fixOffsets();
		this.repaint();
	}

	@Override
	public void printText(String line) {
		textLine = line;
		fixOffsets();
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
		switch (getDisplayMode()) {
		case USER_CARD_SELECT_MODE:
			mousePressedPoint.move(arg0.getX(), arg0.getY());
			// add find card in playerBatch
			Iterator<Card> it = bottomBatch.descendingIterator();
			Card testCard;
			while (it.hasNext()) {
				testCard = it.next();
				if (testCard.contains(mousePressedPoint.x, mousePressedPoint.y)) {
					selectedCard = testCard;
					synchronized (boardThread) {
						boardThread.notify();
						setDisplayMode(PC_THINK_MODE);
					}
					break;
				}
			}
			break;
		case PC_THINK_MODE:
			break;
		}
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
		mousePressedPoint.move(arg0.getX(), arg0.getY());
		// add find card in playerBatch
		Iterator<Card> it = bottomBatch.descendingIterator();
		Card testCard;
		while (it.hasNext()) {
			testCard = it.next();
			if (testCard.contains(mousePressedPoint.x, mousePressedPoint.y)) {
				bottomBatch.remove(testCard);
				bottomBatch.add(testCard);
				break;
			}
		}
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Card getSelectCard() {
		synchronized (boardThread) {
			try {
				setDisplayMode(USER_CARD_SELECT_MODE);
				// call wait until user is selecting card
				boardThread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectedCard;
	}

	/**
	 * You want to set
	 * 
	 * @param boardThread
	 */
	public void setBoardThread(Object boardThread) {
		this.boardThread = boardThread;
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
		// Calculate half-hardcoded right top position for current suit
		trumpSuitPoint = new Point(this.getWidth()
				- trumpSuitImg.getIconWidth() * 2, trumpSuitImg.getIconHeight());

		// Calculate half-hardcoded position for Text line at down
		textPoint = new Point(10, this.getHeight() - 10);

		// Calculate half-hardcoded offset for turned cards - 5 pixels
		synchronized (turnedCards) {
			for (int i = 0; i < turnedCardsIndex; i++) {
				switch (i) {
				case 0:
					turnedCards[0].moveTo(
							this.getWidth() / 2
									- (turnedCards[0].getWidth() + 5),
							this.getHeight() / 2
									- (turnedCards[0].getHeight() + 5));
					break;
				case 1:
					turnedCards[1].moveTo(this.getWidth() / 2 + 5,
							this.getHeight() / 2
									- (turnedCards[1].getHeight() + 5));
					break;
				case 2:
					turnedCards[2].moveTo(this.getWidth() / 2 + 5,
							this.getHeight() / 2 + 5);
					break;
				case 3:
					turnedCards[3].moveTo(
							this.getWidth() / 2
									- (turnedCards[3].getWidth() + 5),
							this.getHeight() / 2 + 5);
					break;
				}
			}
		}

		// Calculate offset for leftCardBatch, step - 13 pixels, border -25
		int step = 13;
		int stepW = getWidth() > 400 ? (getWidth() - 400) / 13 + 20 : 20;
		int border = 25;
		if (leftBatch != null) {
			if (leftBatch.sizeSync() > 0) {
				synchronized (leftBatch) {
					Iterator<Card> it = leftBatch.iterator();
					int CH = (leftBatch.getFirst()).getHeight();
					int y = (getHeight() - (CH + leftBatch.size() * step)) / 2;
					int x = border;
					while (it.hasNext()) {
						Card cardw = it.next();
						cardw.moveTo(x, y);
						cardw.setVisible(leftBatch.isVisible());
						y = y + step;
					}
				}
			}

		}

		// Calculate offset for rightCardBatch

		if (rightBatch != null) {
			if (rightBatch.sizeSync() > 0) {
				synchronized (rightBatch) {
					Iterator<Card> it = rightBatch.iterator();
					int CH = (rightBatch.getFirst()).getHeight();
					int CW = (rightBatch.getFirst()).getWidth();
					int y = (getHeight() - (CH + rightBatch.size() * step)) / 2;
					int x = getWidth() - (CW + border);
					while (it.hasNext()) {
						Card cardw = it.next();
						cardw.moveTo(x, y);
						cardw.setVisible(rightBatch.isVisible());
						y = y + step;
					}
				}
			}
		}

		// Calculate offset for topCardBatch
		if (topBatch != null) {
			if (topBatch.sizeSync() > 0) {
				synchronized (topBatch) {
					Iterator<Card> it = topBatch.iterator();
					int CW = (topBatch.getFirst()).getWidth();
					int y = border;
					int x = (getWidth() - (CW + topBatch.size() * step)) / 2;
					while (it.hasNext()) {
						Card cardw = it.next();
						cardw.moveTo(x, y);
						cardw.setVisible(topBatch.isVisible());
						x = x + step;
					}
				}
			}
		}

		// Calculate offset for bottomCardBatch
		if (bottomBatch != null) {
			if (bottomBatch.sizeSync() > 0) {
				synchronized (bottomBatch) {
					stepW = stepW > (bottomBatch.getFirst()).getWidth() + 13 ? (bottomBatch
							.getFirst()).getWidth() + 13 : stepW;
					Iterator<Card> it = bottomBatch.iterator();
					int CH = (bottomBatch.getFirst()).getHeight();
					int CW = (bottomBatch.getFirst()).getWidth();
					int y = getHeight() - (CH + border);
					int x = (getWidth() - (CW + bottomBatch.size() * stepW)) / 2;
					while (it.hasNext()) {
						Card cardw = it.next();
						cardw.moveTo(x, y);
						cardw.setVisible(bottomBatch.isVisible());
						x = x + stepW;
					}
				}
			}
		}
	}

	/**
	 * @return the displayMode
	 */
	public synchronized int getDisplayMode() {
		return displayMode;
	}

	/**
	 * @param displayMode
	 *            the displayMode to set
	 */
	public synchronized void setDisplayMode(int displayMode) {
		this.displayMode = displayMode;
	}

	// доделать
	@Override
	public int getSelectSuit() {
		synchronized (boardThread) {
			try {
				setDisplayMode(USER_SUIT_SELECT_MODE);
				boardThread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// for a while use only bubi
		return 0;
	}

	/**
	 * Window for select Suit by user(player)
	 * 
	 * @author kyznecov
	 * 
	 */
	// Доделать
	private class SuitChooser extends JPanel implements Runnable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SuitChooser() {
			JButton diamonsButton = new JButton(new ImageIcon(
					"cards/DIAMONDS.gif"));
			diamonsButton.setHorizontalAlignment(AbstractButton.CENTER);
			JButton heartsButton = new JButton(
					new ImageIcon("cards/HEARTS.gif"));
			heartsButton.setHorizontalAlignment(AbstractButton.CENTER);
			JButton spadeButton = new JButton(new ImageIcon("cards/SPADE.gif"));
			spadeButton.setHorizontalAlignment(AbstractButton.CENTER);
			JButton crossesButton = new JButton(new ImageIcon(
					"cards/CROSSES.gif"));
			crossesButton.setHorizontalAlignment(AbstractButton.CENTER);
			add(diamonsButton);
			add(heartsButton);
			add(spadeButton);
			add(crossesButton);

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

}
