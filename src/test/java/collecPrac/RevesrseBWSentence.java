package collecPrac;

public class RevesrseBWSentence {

	public static void main(String[] args) {
		String str="I am from sdet44 batch hello pankja";// batch am from sdet44 i 

		String s[]=str.split(" ");

		for (int i = 0; i <= s.length/2; i++) {
			String temp="";
			temp=s[i];
			s[i]=s[s.length-i-1];
			s[s.length-i-1]=temp;
			System.out.println(temp);
		}
		
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
	}

}
