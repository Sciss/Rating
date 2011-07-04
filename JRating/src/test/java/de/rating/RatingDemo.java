package de.rating;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RatingDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public RatingDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rating");
		
		getContentPane().setLayout(new GridLayout(4, 2));
		
		getContentPane().add(new JLabel("1:"));
		getContentPane().add(new JRating());
		
		getContentPane().add(new JLabel("1:"));
		getContentPane().add(new JRating());
		
		getContentPane().add(new JLabel("1:"));
		getContentPane().add(new JRating());
		
		getContentPane().add(new JLabel("1:"));
		getContentPane().add(new JRating());
		pack();
//		setLocationRelativeTo(null);
		setLocationByPlatform(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				new RatingDemo().setVisible(true);
			}
		});
	}
}
