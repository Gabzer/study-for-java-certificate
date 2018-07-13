package unidade5;

public class ValidadorApp {

	public static void main(String[] args) {
		
		String celular = "99113-6566";
		
		Validador<String> validacao = valor -> valor.matches("[0-9]{5}-[0-9]{4}");
		
		System.out.println(validacao.valida(celular));
		
	}

}
