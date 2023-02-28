package collecPrac;

import java.util.LinkedHashSet;

public class OccurenceOFEachCharacter {

	public static void main(String[] args) {

		String s="Tester".toLowerCase();
		char ch[]=s.toCharArray();
		LinkedHashSet<Character> lhs=new LinkedHashSet<>();
		for (Character c : ch) {
			lhs.add(c);
		}
		int indx=0;
		for (Character ch1 : lhs) {
			int count=0;
			for (int i=0;i<s.length();i++) {
				if(ch1==s.charAt(i))
				{
					count++;
					indx=i;
				}
			}
			if(count>1)
			{
				System.out.println(ch1+"  "+count+" index is "+indx);
				indx=0;
			}
		}

	}
}


