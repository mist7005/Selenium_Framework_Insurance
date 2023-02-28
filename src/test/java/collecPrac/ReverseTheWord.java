package collecPrac;


public class ReverseTheWord {

	public static void main(String[] args) {
		String str="I am from sdet44 batch";
		String s[]=str.split(" ");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[s.length-1-i]+" ");
		}

	}

}
