package unidade2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ScannerAppv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner entrada = new Scanner(new FileReader("D:/Gabriel/Certificado-Java/exercicios/Udemy/cursojava8/Applets/src/unidade2/numeros.txt"));
			double soma = 0;
			String valor;
			while (entrada.hasNext()) {
				valor = entrada.next();
				soma = soma + Double.parseDouble(valor);
			}
			entrada.close();
			JOptionPane.showMessageDialog(null, "A soma dos valores é: " + soma);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
