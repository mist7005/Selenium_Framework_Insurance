package com.insurance.prac;

public class CleanStrings {

	public static void main(String[] args) {
//		String demo[]= {"13,njSn,12","10,300000","34,8990000"};
//		int copy=Integer.MAX_VALUE;
//		for (int i = 0; i < demo.length; i++) {
//			String s = demo[i];
//			String num="";
//			for (int j = 0; j < s.length(); j++) {
//				if(Character.isDigit(s.charAt(j)))
//				{
//					num=num+s.charAt(j);
//				}
//			}
//			if(copy>Integer.parseInt(num))
//			{
//				copy=Integer.parseInt(num);
//			}
//		}
//		System.out.println(copy);
		String num1="";
		String s1="13,njSn,12";
		for (int i = 0; i < s1.length(); i++) {
			
			if(Character.isDigit(s1.charAt(i)))
			{
				num1=num1+s1.charAt(i);
			}
		}
		System.out.println(num1);
		
	}

}
