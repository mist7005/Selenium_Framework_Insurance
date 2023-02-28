package interviewQue;

public class SortWithoutUsingBubbleSort {

	public static void main(String[] args) {
		int a[]={7,-3,0,2,1,-9};
		for (int i = 0; i < a.length-1; i++) {
			int index=i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j]>a[index])
				{
					index=j;
				}
			}
			int smallestNumber=a[index];
			a[index]=a[i];
			a[i]=smallestNumber;
			
			System.out.print(a[i]+" ");
		}
		
		int sum=0;
		int prod=1;
		for (int i = 0; i < 3; i++) {
			sum=sum+a[i];
			prod=prod*a[i];
		}
		
		System.out.println("sum is :"+sum);
		System.out.println("prod is :"+prod);
	}
	
}
