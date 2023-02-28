package collecPrac;

public class PrintAABBBABC {

	public static void main(String[] args) {
		String s="AABBBABC";
//		int x=s.length()-2;
		for (int x = 0; x <= s.length(); x++) 
			
		{
		for (int i = x; i < s.length()-1; i++) {
			
			for (int j = x; j <=i+1 ; j++) {
				System.out.print(s.charAt(j));
			}
			System.out.println();
			}
		}
		System.out.println(s.charAt(s.length()-1));
	}
}
