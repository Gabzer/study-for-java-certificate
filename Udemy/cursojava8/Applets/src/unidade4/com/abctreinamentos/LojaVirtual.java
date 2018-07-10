package unidade4.com.abctreinamentos;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LojaVirtual {
	
	static Map<Cliente, List<Curso>> pagamentos = new HashMap<>();
	
	public static void main(String[] args) {
		Curso java8 = new Curso(1, "Java 8 para Web", 2000, Paths.get("/java8"));
		Curso oracle12c = new Curso(2, "Oracle 12c", 2500, Paths.get("/oracle12c"));
		Curso php7 = new Curso(3, "Php 7", 1500, Paths.get("/php7"));
		
		Cliente antonio = new Cliente("123.456.789-00", "Antônio Sampaio Jr.", "assoftbel@gmail.com");
		
	}
}
