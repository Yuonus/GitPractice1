package nationWideMotorsLLC;

public class LocalMergeConcept {
	
	public static void main(String[] args) {
		
		
		int a = 10;
		int b = 0;
		
		try {
			int result = a/b;
			System.out.println(result);
		}catch (ArithmeticException e ) {
			System.out.println("The exception was caught so badly and it didnt have chance to escape.");
		}
		
	}

}
