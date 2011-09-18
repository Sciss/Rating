package de.rating.demo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.rating.JRating;
import de.rating.ui.RenderBasedRatingUI;
import de.rating.ui.StarRenderer;

public class JRatingDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	BufferedImage back;
	
	public JRatingDemo() {
		setSize(543, 630);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("guigarage.com: jRating-Preview");
		try {
			back = ImageIO.read(load("/de/rating/demo/back.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel backPanel = new JPanel() {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(back, 0, 0, null);
			}
		};
		getContentPane().add(backPanel);
		backPanel.setLayout(null);
		
		JRating rating1 = new JRating();
		rating1.setMarkCount(3);
		rating1.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		rating1.setSize(rating1.getPreferredSize());
		rating1.setLocation(35, 100);
		backPanel.add(rating1);
		
		JRating rating2 = new JRating();
		rating2.setMaxCount(3);
		rating2.setMarkCount(1);
		rating2.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		rating2.setSize(rating2.getPreferredSize());
		rating2.setLocation(35, 180);
		backPanel.add(rating2);
		
		JRating rating3 = new JRating();
		rating3.setMaxCount(9);
		rating3.setMarkCount(3);
		rating3.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		rating3.setSize(rating3.getPreferredSize());
		rating3.setLocation(35, 220);
		backPanel.add(rating3);
		
		JRating rating4 = new JRating();
		rating4.setMaxCount(4);
		rating4.setMarkCount(2);
		rating4.setGap(14);
		rating4.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		rating4.setSize(rating4.getPreferredSize());
		rating4.setLocation(35, 300);
		backPanel.add(rating4);
		
		JRating rating5 = new JRating();
		rating5.setMarkCount(4);
		rating5.setUI(new RenderBasedRatingUI(new StarRenderer(false)));
		rating5.setSize(rating5.getPreferredSize());
		rating5.setLocation(40, 420);
		backPanel.add(rating5);
		
		JRating rating6 = new JRating();
		rating6.setMarkCount(3);
		rating6.setUI(new RenderBasedRatingUI(new StarRenderer(true)));
		rating6.setSize(rating6.getPreferredSize());
		rating6.setLocation(35, 450);
		backPanel.add(rating6);
		
		JRating rating7 = new JRating();
		rating7.setMarkCount(1);
		rating7.setUI(new RenderBasedRatingUI(new SmileyRenderer()));
		rating7.setSize(rating7.getPreferredSize());
		rating7.setLocation(30, 490);
		backPanel.add(rating7);
	}
	
	public URL load(String path) throws IOException {
        URL url = ClassLoader.getSystemClassLoader().getResource(path);
        if (url == null) {
            // Fuer den Gebrauch mit Jars
            url = this.getClass().getResource(path);
        }
        if (url == null) {
            url = ClassLoader.getSystemResource(path);
        }
        if (url == null) {
            throw new IOException("URL für " + path + " konnte nicht erstellt werden!");
        }
        return url;
    }
	
	public static void main(String[] args) {
		new JRatingDemo().setVisible(true);
	}
}
