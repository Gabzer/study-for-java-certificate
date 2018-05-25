package unidade2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

public class AloMundo extends JApplet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		System.out.println("Inicializando...");
	}
	
	public void paint(Graphics g) {
		g.drawRect(0, 0, 150, 150);
		g.setColor(Color.CYAN);
		g.setFont(new Font("Time New Roman", Font.BOLD, 16));
		g.drawString("alo mundo", 20, 20);
	}
	
	@Override
	public void start() {
		System.out.println("Executando...");
	}
	
	@Override
	public void stop() {
		System.out.println("Parando...");
	}
	
	@Override
	public void destroy() {
		System.out.println("Eliminando...");
	}

}
