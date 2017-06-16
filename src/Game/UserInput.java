package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public UserInput(Game pGame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChessgame = new JLabel("Arduino ChessGame CPU ");
		lblChessgame.setBounds(105, 6, 177, 16);
		contentPane.add(lblChessgame);
		
		textField = new JTextField();
		textField.setBounds(25, 60, 168, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pGame.handleMove(lblChessgame.getText());
					pGame.saveMoves(lblChessgame.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPlay.setBounds(227, 60, 117, 29);
		contentPane.add(btnPlay);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGame.saveGame(lblChessgame.getText());
			}
		});
		btnSave.setBounds(189, 113, 117, 29);
		contentPane.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGame.loadGame(lblChessgame.getText());
			}
		});
		btnLoad.setBounds(59, 113, 117, 29);
		contentPane.add(btnLoad);
	}
}
