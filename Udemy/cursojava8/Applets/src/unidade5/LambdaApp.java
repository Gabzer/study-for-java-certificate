package unidade5;

import java.util.Arrays;
import java.util.List;

public class LambdaApp {
	
	static int numero;
	int somatorio;
	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1,2,3,4);
		LambdaApp app = new LambdaApp();
		
		//System.out.println(integers);
		//lambda
		//integers.forEach(x -> System.out.println(x));
		integers.forEach(x -> {
			numero = 10;
			x = x + numero;
			app.somatorio = app.somatorio + x;
			System.out.println(x);
		});			
		System.out.println(app.somatorio);
	}

}
