
public abstract class Funcionario {
	
	public static void main(String[] args) {
		
		Funcionario antonio = new Professor();
		Funcionario andrea = new Administrativo();
		Funcionario pedro = new Diretor();
		
		pedro.verificarTipoFuncionario(pedro);
		
		Funcionario objeto;
		objeto = new Diretor();
		
		((Diretor)objeto).departamento = "RH";//casting
		
	}
	
	public abstract void getBonificacao();
	
	void verificarTipoFuncionario(Funcionario objeto) {
		if (objeto instanceof Diretor) {
			System.out.println("Diretor");
		} else if (objeto instanceof Professor) {
			System.out.println("Professor");
		} else {
			System.out.println("Administrativo");
		}
	}
	
}
