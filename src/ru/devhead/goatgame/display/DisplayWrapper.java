package ru.devhead.goatgame.display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

public class DisplayWrapper extends JComponent implements MouseListener,
		MouseMotionListener, Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayWrapper(){
		
	}
	
	@Override
	public void printTurnCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTrumpSuit(Card card) {
		// TODO Auto-generated method stub

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
	public void printLeft(boolean open, CardBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printTop(boolean open, CardBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printBottom(boolean open, CardBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printRight(boolean open, CardBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printText(String line) {
		// TODO Auto-generated method stub
		
	}

}
