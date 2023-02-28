package interviewQue;

public class FindMissingElement {

	public static void main(String[] args) {
		int a[]= {1,3,5,7,10};
		int start=a[0];
		int end=a[0];

		for(int i=0;i<a.length-1;i++)
		{
			int n=a[i+1]-a[i];
			int count=1;
			while(n>1)
			{
				System.out.print(a[i]+count+" ");
				count++;
				n--;
			}
		}
	
	}

}
