package ArcoFinal;

public class Ejemplo5 {

	public static void main(String[] args) {
		int a=10, b=0, c=0;
		try {
			c=a/b;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("C es "+c);
	}
}
