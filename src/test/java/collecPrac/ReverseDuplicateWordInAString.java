package collecPrac;

import java.util.LinkedHashSet;

public class ReverseDuplicateWordInAString {

	public static void main(String[] args) {
		String s="I am from sdet44 batch batch";
		String str[]=s.split(" ");
		LinkedHashSet<String> lhs=new LinkedHashSet<>();
		for (String ss : str) {
			if(lhs.add(ss)==false)
			{
				System.out.println(reverse(ss));
				
			}
		}
		
	}
	public static String reverse(String s)
	{
		String z="";
		for (int i = 0; i < s.length(); i++) {
			z=z+s.charAt(s.length()-i-1);
		}
		return z;
	}

}
