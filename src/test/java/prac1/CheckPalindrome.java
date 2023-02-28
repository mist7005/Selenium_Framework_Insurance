package prac1;

public class CheckPalindrome {

	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("malayalam");
		String temp=s.toString();
		String acString=s.reverse().toString();
		if(acString.equals(temp))
		{
			System.out.println("palindrome");
		}
		else
			System.out.println("not palindrome");
		
	}

}
