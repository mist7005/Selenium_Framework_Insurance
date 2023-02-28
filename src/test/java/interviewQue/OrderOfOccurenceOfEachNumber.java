package interviewQue;

public class OrderOfOccurenceOfEachNumber {
	
	
	public static void main(String[] args) {
		int a[]= {4,1,1,2,0,0,2,2,4,4,4,4,4,9,5};
		int z[]=arrWithoutDup(a);
		for (int i = 0; i < z.length; i++) {
			System.out.print(z[i]+" ");
		}
	}
	
	
	public static int[] arrWithoutDup(int a[]) {
		
		
		String s="";
		boolean b[]= new boolean[a.length];
		
		for (int i = 0; i < b.length; i++) {
			if(b[i]==false)
			{
				int count=1;
			for (int j = 1; j < b.length; j++) {
				if(a[i]==a[j])
				{
					b[j]=true;
					count++;
				}
			}
			s=s+a[i];
//			System.out.println(a[i]+"====>"+count);
			}
		}
		
		
		
		int arr[]=new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			char zz=s.charAt(i);
			int z1=zz-48;
			arr[i]=z1;
		}
		
		return arr;
	}

}

