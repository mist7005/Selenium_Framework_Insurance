package prac1;

public class StringPRob {

	public static void main(String[] args) {
		String s="abhi123@hf1@4ghj$24%";
		
		String z=s.replaceAll("[^0-9]","");
		System.out.println(z);
		
		String z1=s.replaceAll("[0-9 @ $ %]", "");
		System.out.println(z1);
		
		String z2=s.replaceAll("[a-z 0-9]", "");
		System.out.println(z2);
		
//		String zz="12";
//		char zz1='A';
//		System.out.println(zz.charAt(1)-48);
//		System.out.println((int)zz1);
//		System.out.println((char)(zz1+32));

	}

}
