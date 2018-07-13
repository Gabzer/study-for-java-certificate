package unidade5;

public class Calculadorav2 {

	public static void main(String[] args) {
		
		Calculadorav2 objeto = new Calculadorav2();
		
		IMath somar = (a,b) -> a+b;
		IMath subtrair = (a,b) -> a-b;
		IMath multiplicar = (a,b) -> a*b;
		IMath dividir = (a,b) -> a/b;
		IMath exponenciacao = (a,b) -> Math.pow(a, b);
		IMath raticiacao = (a,b) -> Math.pow(a, 1/b);
		
		System.out.println(objeto.execOperacao(5,5,somar));
        System.out.println(objeto.execOperacao(6,4,subtrair));
        System.out.println(objeto.execOperacao(3,4,multiplicar));
        System.out.println(objeto.execOperacao(10,2,dividir));
        System.out.println(objeto.execOperacao(10,2,exponenciacao));
        System.out.println(objeto.execOperacao(10,2,raticiacao));

	}
	
	public double execOperacao(double a, double b, IMath op) {
		return op.operacao(a, b);
	}

}
