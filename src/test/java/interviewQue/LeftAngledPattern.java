package interviewQue;

public class LeftAngledPattern {

	public static void main(String[] args) {
		int num=5;
		int x=1;
		
			
		
			
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num-i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= i; j++) {
				
				System.out.print("* ");
			}
			System.out.println();
		}
	

	}

}
