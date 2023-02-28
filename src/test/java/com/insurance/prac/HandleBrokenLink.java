package com.insurance.prac;

public class HandleBrokenLink {

	
	
	public static void main(String[] args) {
		//find minimun
		String money[]= {"23k","50k","80k","15k"};
		int maxMon = Integer.MAX_VALUE;
		for (int i = 0; i < money.length; i++) {
			String m=money[i];
			String c="";
			for (int j = 0; j < m.length(); j++) {
				if(Character.isDigit(m.charAt(j)))
				{
					c=c+m.charAt(j);
				}
			}
			if(maxMon>Integer.parseInt(c))
			{
				maxMon=Integer.parseInt(c);
			}
		}
		System.out.println(maxMon);

		
		//find maximum
		String demo[]= {"13,njSn,12","10,300000","34,8990000"};
		int copy=Integer.MIN_VALUE;
		for (int i = 0; i < demo.length; i++) {
			String s = demo[i];
			String num="";
			for (int j = 0; j < s.length(); j++) {
				if(Character.isDigit(s.charAt(j)))
				{
					num=num+s.charAt(j);
				}
			}
//			System.out.println(num);
			if(copy<Integer.parseInt(num))
			{
				copy=Integer.parseInt(num);			
			}
		}
		System.out.println(copy);
	}

}
