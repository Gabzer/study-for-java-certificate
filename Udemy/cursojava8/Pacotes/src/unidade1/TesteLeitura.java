package unidade1;

public class TesteLeitura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[10];
		System.out.println("Digite algo: ");
		//System.in.read(bytes);
		/*try {
			System.in.read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("\nEco: " + new String(bytes));
	}

}
