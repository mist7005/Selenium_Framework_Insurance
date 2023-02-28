package collecPrac;

public class NearestPAlindrome {

	public static void main(String[] args) {
		int num=136;
		checkNearestPalindrome(num);
		
	}
	public static boolean isPalindrome(int x)
	{
		
		int temp=x;
		int rev=0;
		while(temp!=0)
		{
			int d=temp%10;
			rev=rev*10+d;
			temp=temp/10;
			
		}
		if(rev==x)
			return true;
		else
			return false;
		
	}
	public static void checkNearestPalindrome(int x)
	{
		if(isPalindrome(x))
		{
			System.out.println("nearest palindrome is:"+(x-10)+" and "+(x+10));	
		}
		else
		{
		int num1=0;
		int num2=0;
		int temp=x;
		int lastDigit=temp%10;
		num1=num1+((x-lastDigit)+1);
		num2=num2+x+(10-lastDigit)+1;
		
		System.out.println(num1);
		System.out.println(num2);
		
		int num1Diff=x-num1;
		int num2Diff=num2-x;

		if(num1Diff<num2Diff)
		{
			System.out.println("nearest palindrome is: "+ num1);
		}
		else if(num1Diff>num2Diff)
			System.out.println("nearest palindrome is :"+ num2);
		
		else
			System.out.println("nearest palindrome is "+num1 +" and "+num2);
		
			
	}
	}
}
