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
import ru.devhead.goatgame.logic.SimpleBoard;

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
	DisplayWrapper disp;

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
		
		disp = new DisplayWrapper();

		JMenuItem miNewGame = new JMenuItem("New game");
		miNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleBoard board = new SimpleBoard(disp);
				new Thread(board);
			
			}
			
		});

		JMenuItem miNewCheaterGame = new JMenuItem("New cheater game");
		miNewCheaterGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleBoard board = new SimpleBoard(disp);
				new Thread(board);
			
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
		setContentPane(disp);
		setJMenuBar(menuBar);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}

}
