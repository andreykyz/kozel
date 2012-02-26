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
 * Interface based on swing frame work.
 * 
 * @author Kyznecov Andrey
 * 
 */
public class WindowSwing extends JFrame {

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
		miNewGame.addActionListener(new ActionListener() {

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
		DisplayWrapper disp = new DisplayWrapper();
		setContentPane(disp);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// for testing start 
		CardBatch batch1 = new CardBatch();
		for (int i = 0; i < 7; i++) {
			batch1.add(new CardWrapper(CardBatch.kozelBatch[i]));
		}
		batch1.mixCardBatch();
		
		CardBatch batch2 = new CardBatch();
		for (int i = 0; i < 7; i++) {
			batch2.add(new CardWrapper(CardBatch.kozelBatch[i]));
		}
		batch2.mixCardBatch();
		disp.printTrumpSuit(new CardWrapper(15));
//		disp.printTop(false, batch1);
		disp.printLeft(false, batch1);
		disp.printRight(false, batch2);
		
		disp.printTurnCard(new CardWrapper(15));
		disp.printTurnCard(new CardWrapper(18));
		disp.printTurnCard(new CardWrapper(25));
//		disp.printTurnCard(new CardWrapper(26));
//		disp.printTurnCard(new CardWrapper(28));
		
		// for testing end
		
	}

}
