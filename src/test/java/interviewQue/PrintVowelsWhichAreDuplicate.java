package interviewQue;

public class PrintVowelsWhichAreDuplicate {

	public static void main(String[] args) {
		String s="aabhisheeko";
		
		int a[]=new int[256];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i)]=a[s.charAt(i)]+1;
		}
		
		for (int i = 0; i < 256; i++) {
			if(a[i]==2 && ((char)i=='a' || (char)i=='e' || (char)i=='i' || (char)i=='o' || (char)i=='u'))
			{
				System.out.println((char)i);
			}
		}
	}

}
