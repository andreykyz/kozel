/**
 * 
 */
package ru.devhead.goatgame.display;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	SimpleBoard board;
	Thread boardThread;
	
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
				disp = new DisplayWrapper();
				board = new SimpleBoard(disp);
				Thread boardThread = new Thread(board);
				disp.setBoardThread(boardThread);
				boardThread.setName("Board thread");
				boardThread.start();
				frame.setContentPane(disp);
				frame.pack();				
			}

		});

		JMenuItem miNewCheaterGame = new JMenuItem("New cheater game");
		miNewCheaterGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Доделать
			}
		});

		JMenu mFile = new JMenu("File");
		mFile.setMnemonic(KeyEvent.VK_F);
		mFile.add(miNewGame);
		mFile.add(miNewCheaterGame);
		mFile.addSeparator();
		mFile.add(miExit);

		JMenu mHelp = new JMenu("Help");
		mHelp.setMnemonic(KeyEvent.VK_H);
		mHelp.add(miAbout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(mFile);
		menuBar.add(mHelp);
		setJMenuBar(menuBar);
		setPreferredSize(new Dimension(DisplayWrapper.TABLE_WIDTH, DisplayWrapper.TABLE_HEIGHT));
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		
	}

}
