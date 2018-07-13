package unidade5;

@FunctionalInterface
public interface Validador<T> {	
	boolean valida(T t);	
}
