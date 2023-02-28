package collecPrac;

public class MalayalamSubSeq {
	public static void main(String[] args) {
		String s="malayalam";
		int count=0;

		int len=1;
		int j=1;
		int k=2;
		while(len<s.length())
		{
			for (int i = 0; i<s.length(); i++) {
				if(i==s.length()-j)
				{
//					System.out.println("i break "+i);
					break;
				}
				String sub="";
				sub=s.substring(i, i+k);
				if(isPalindrome(sub))
				{
					count++;
				}
				
			}
			k++;
			j++;
			len++;
//			System.out.println();
			
		}
		System.out.println("count is : "+count);
	}
	static boolean isPalindrome(String x)
	{
		String rev="";
		for (int i = 0; i < x.length(); i++) {
			rev=rev+x.charAt(x.length()-i-1);
		}
		if(x.equals(rev))
		{
			return true;
		}
		else
			return false;
	}

}
