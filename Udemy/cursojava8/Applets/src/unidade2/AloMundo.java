package unidade2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

public class AloMundo extends JApplet {
	
	public void paint(Graphics g) {
		g.drawRect(0, 0, 150, 150);
		g.setColor(Color.CYAN);
		g.setFont(new Font("Time New Roman", Font.BOLD, 16));
		g.drawString("alo mundo", 20, 20);
	}

}
