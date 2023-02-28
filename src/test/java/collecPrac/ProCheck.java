package collecPrac;
public class ProCheck {

	public static void main(String[] args) {
		String s="Welcome to TYSS";
		String arr[]=splitEx(s);
		String str1=""; // welcome to
//		reverseRx(arr,arr.length);
//		for(int i=0;i<arr.length;i++)
//		{
//			String str2=arr[i];
//			str1=str1+" "+str2;
//			String str3=""; // tyss
//			for(int j=i+1;j<arr.length;j++)
//			{
//				str3=str3+"  "+arr[j];
//			}		
//			System.out.println(str3+" "+str1);
//
//		}
		int a=0;
		int b=1;
		int c=2;
		int i=0;
		int jj=0;
		int temp;
		
		while(i<arr.length)
			{
				while(jj <arr.length)
				{
				
				temp=a;
				a=b;
				b=c;
				c=temp;
				System.out.print(arr[a]+" "+arr[b]+" "+arr[c]);
				System.out.println();
				jj++;
				}
//				i++;
//				jj=0;
		}
	
	}

	public static String[] splitEx(String x)
	{
		char z[]=x.toCharArray();
		String a[]=new String[3];
		int j=0;
		String temp="";
		for (int i = 0; i < z.length; i++) {


			if(z[i]!=' ' )
			{
				temp=temp+z[i];
				a[j]=temp;
			}
			else
			{
				j++;
				temp="";				
			}
		}

		return a;
	}

	public static void reverseRx(String[] arr,int size)
	{
		int z[][]=new int[size][size];
		int a=0;
		int b=1;
		int c=2;
		int i=0;
		int jj=0;
		int temp;
		
		for (int j = 0; j < z.length; j++) {
			temp=a;
			a=b;
			b=c;
			c=temp;
			String zz="";
			zz=zz+a+b+c;
			for (int j2 = 0; j2 < z.length; j2++) {
				
				z[i][j]=Integer.parseInt(zz);
				
			}
		}
		
		for (int j = 0; j < z.length; j++) {
			for (int j2 = 0; j2 < z.length; j2++) {
				System.out.print(z[i][j]);
			}
			System.out.println();
		}
		
//		while(i<arr.length)
//		{
//			String z="";
//			while(jj <arr.length)
//			{
//			
//			temp=a;
//			a=b;
//			b=c;
//			c=temp;
//			arr[a]
//			System.out.print(arr[a]+" "+arr[b]+" "+arr[c]);
//			System.out.println();
//			jj++;
//			}
//			i++;
//			jj=0;
//	}
	}




}
