package com.insurance.prac;

import java.util.HashSet;
import java.util.Set;

public class PrintIndexOfDup {

	public static void main(String[] args) {
		int a[]= {4,12,3,12,4,5,6,7,7};
		Set<Integer> s=new HashSet<Integer>();
		//		for(int i=0;i<a.length;i++)
		//		{
		//			int j=(s.add(a[i])) ? 0:i;
		//			boolean m=(j!=0)?true:false;
		//			while(m)
		//			{
		//			System.out.println(a[i]+"is repeated at index position: "+j);
		//			break;
		//			}
		//		}
		for (int i = 0; i < a.length; i++) {
			while(s.add(a[i])==false)
			{
				System.out.println(a[i]+"is repeated at index position: "+i);
				break;
			}
		}

	}
}


