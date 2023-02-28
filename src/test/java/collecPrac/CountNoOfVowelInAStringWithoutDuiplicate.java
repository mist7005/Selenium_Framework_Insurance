package collecPrac;

import java.util.LinkedHashSet;

public class CountNoOfVowelInAStringWithoutDuiplicate {

	public static void main(String[] args) {
		String s="india";
		LinkedHashSet<Character> lhs=new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			lhs.add(s.charAt(i));
		}
		int vCount=0;
		for (Character c1 : lhs) {
			if(c1=='a'||c1=='e'||c1=='i'||c1=='o'||c1=='u')
			{
				vCount++;
					
			}
		}
		
		System.out.println("vowel count is :"+ vCount);
	}

}
