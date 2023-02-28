package collecPrac;

import java.util.LinkedHashSet;

public class NumberDuplicate {

	public static void main(String[] args) {
		int x[]= {5,6,6,7,1,5,0};
		LinkedHashSet<Integer> set=new LinkedHashSet<>();
		for (int i = 0; i < x.length; i++) {
			set.add(x[i]);
		}
		
		for (Integer in : set) {
			int count=0;
			for (int i = 0; i < x.length; i++) {
				if(in==x[i])
				{
					count++;
					
				}
				
			}
			if(count>0)
				System.out.println(in +" is repeating "+count);
		}
	}

}
