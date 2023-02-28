package interviewQue;

import java.util.LinkedHashSet;

public class UpdateDuplicateWithItsCount {

	public static void main(String[] args) {
		String s="aaabccddf";
		//a2bc2d2f
		
		LinkedHashSet<Character> lhs=new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			lhs.add(s.charAt(i));
		}
		
		for (Character ch1 : lhs) {
			int count=0;
			for (int i = 0; i < s.length(); i++) {
				if(ch1==s.charAt(i))
				{
					count++;
				}
			}
			System.out.print(ch1);
			if(count>1)
			{
				System.out.print(count);
			}
		}
	}

}
