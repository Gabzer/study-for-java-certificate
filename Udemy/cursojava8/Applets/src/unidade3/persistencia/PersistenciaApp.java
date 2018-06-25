package unidade3.persistencia;

import unidade1.br.abctreinamentos.rh.Administrativo;
import unidade1.br.abctreinamentos.rh.Diretor;

public class PersistenciaApp {

	public static void main(String[] args) {

		GenericDAO<Administrativo> admin = new GenericDAO<>();
		admin.create(new Administrativo());
		
		GenericDAO<Diretor> diretor = new GenericDAO<>();
		diretor.create(new Diretor());
		
	}

}
