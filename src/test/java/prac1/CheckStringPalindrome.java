package prac1;

public class CheckStringPalindrome {

	public static boolean isPalindrome(String s)
	{
		String temp="";
		for (int i = 0; i < s.length(); i++) {
			temp=temp+s.charAt(s.length()-1-i);
		}
		if(temp.equals(s))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String s="malayalam";

		if(isPalindrome(s))
			System.out.println(s+"===> the string is palindrome");
		else
			System.out.println(s+"====> String is not palindrome");

	}

}
