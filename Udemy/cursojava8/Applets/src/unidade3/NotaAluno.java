package unidade3;

public class NotaAluno {
    double valor;
    
    <T extends Number> NotaAluno (T obj) {
        valor = obj.doubleValue();
    }
    
    <T extends Number>void retornaValor(T obj) {
    	
    }
}
