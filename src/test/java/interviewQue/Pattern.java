package interviewQue;

public class Pattern {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		String z="hello12bye";
		
		z=z.replaceAll("[0-9]","");
		System.out.println(z);
		
	}

}
