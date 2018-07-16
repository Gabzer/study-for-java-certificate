package unidade6;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTFApp {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Primeira aplicação");
		frame.setSize(350, 250);
		Container cont = frame.getContentPane();
		JTextField tf = new JTextField("Digite aqui");		
		cont.add(tf, BorderLayout.NORTH);
		frame.setVisible(true);

	}

}
