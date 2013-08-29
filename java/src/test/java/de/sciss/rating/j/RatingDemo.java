package de.sciss.rating.j;

import java.awt.GridLayout;

import javax.swing.*;

import de.sciss.rating.j.ui.RenderBasedRatingUI;
import de.sciss.rating.j.ui.StarRenderer;


public class RatingDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public RatingDemo() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rating");
		
		getContentPane().setLayout(new GridLayout(4, 2));
		
		getContentPane().add(new JLabel("1:"));
		JRating rating1 = new JRating();
		rating1.setUI(new RenderBasedRatingUI(new StarRenderer()));
		getContentPane().add(rating1);
		
		getContentPane().add(new JLabel("2:"));
		JRating rating2 = new JRating();
		rating2.getModel().setMaxCount(3);
		rating2.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		getContentPane().add(rating2);
		
		getContentPane().add(new JLabel("3:"));
		getContentPane().add(new JRating());
		
		getContentPane().add(new JLabel("4:"));
		getContentPane().add(new JRating());
		pack();
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
