package collecPrac;

public class ReverseEachLetter {

	public static void main(String[] args) {
		String str="I am from sdet44 batch";
		String s[]=str.split(" ");
		
		for (int i = 0; i < s.length; i++) {	
			System.out.print(reverseW(s[i])+" ");
				
			}
	}

	public static String reverseW(String x)
	{
		String g="";
		for (int i = 0; i < x.length(); i++) {
			g=g+x.charAt(x.length()-1-i);
		}
		return g;
		
	}
}
