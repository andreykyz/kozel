/**
 * 
 */
package ru.devhead.goatgame.display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ru.devhead.goatgame.logic.Card;
import ru.devhead.goatgame.logic.CardBatch;

/**
 * @author kyznecov
 * 
 */
public class WindowSwing extends JFrame implements Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final String PROGRAM_NAME = "Goat card game (Swing version)";
	final String DEVELOPER = "Andrey Kyznetsov";
	final String EMAIL = "andreykyz@gmail.com";

	JFrame frame;

	public WindowSwing() {
		frame = this;
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, DEVELOPER + "\n" + EMAIL,
						PROGRAM_NAME, JOptionPane.PLAIN_MESSAGE);

			}

		});
		 JMenuItem miNewGame = new JMenuItem("New game");
		 miNewGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			 
		 });
		 
		 JMenu mFile = new JMenu("File");
		 mFile.setMnemonic(KeyEvent.VK_F);
		 mFile.add(miNewGame);
		 mFile.add(miExit);

		 JMenu mHelp = new JMenu("Help");
		 mHelp.setMnemonic(KeyEvent.VK_H);
		 mHelp.add(miAbout);
		 
		 JMenuBar menuBar = new JMenuBar();
		 menuBar.add(mFile);
		 menuBar.add(mHelp);
		 
		 setJMenuBar(menuBar);
		 
		 

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.devhead.goatgame.display.Display#print(ru.devhead.goatgame.logic.Card)
	 */
	@Override
	public void print(Card card) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.devhead.goatgame.display.Display#print(ru.devhead.goatgame.logic.Card
	 * [])
	 */
	@Override
	public void print(Card[] card) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.devhead.goatgame.display.Display#printSuit(ru.devhead.goatgame.logic
	 * .Card)
	 */
	@Override
	public void printSuit(Card card) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.devhead.goatgame.display.Display#print(ru.devhead.goatgame.logic.CardBatch
	 * )
	 */
	@Override
	public void print(CardBatch batch) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.devhead.goatgame.display.Display#print(java.lang.String)
	 */
	@Override
	public void print(String str) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.devhead.goatgame.display.Display#println(java.lang.String)
	 */
	@Override
	public void println(String str) {
		// TODO Auto-generated method stub

	}

}
