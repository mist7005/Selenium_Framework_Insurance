package interviewQue;


public class ThirdMaxNum {

	public static void main(String[] args) {
		int a[]= {20,14,1,2,20,14,13,1,6};
		int a1[]=removeDuplicateInArray(a);
		int a2[]=sortDesc(a1);
//		System.out.println("length is "+a2.length);
		int sum=0;
		for (int i = 0; i < 3; i++) {
			sum=sum+a2[i];
		}

		System.out.println("sum of first 3 num "+sum);
		System.out.println("third max num is "+a2[2]);
	}

	public static int[] removeDuplicateInArray(int a[])
	{

		boolean[] b=new boolean[a.length];
		String s="";
		for (int i = 0; i < a.length; i++) {
			if(b[i]==false)
			{
				for (int j = 1; j < b.length; j++) {
						if(a[i]==a[j])
						{
							b[j]=true;
						}
				}
				s=s+a[i]+" ";
			}
		}
		String s1[]=s.split(" ");
		int arr[]=new int[s1.length];
		for (int i = 0; i < s1.length; i++) {
			int t=stringToInt(s1[i]);
			arr[i]=t;
		}
		return arr;

	}
	
	private static int stringToInt(String x)
	{
		int num=0;
		char z[]=x.toCharArray();
		int len=z.length;
		for (int i = 0; i < len; i++) {
			num=num*10+z[i]-48;
		}
		return num;
		
	}
	
	public static int[] sortDesc(int a[])
	{
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;		
				}
			}
		}
		return a;
	}
	

}
