package interviewQue;

public class ProgIntString {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		shiftingKeys(a, 4);

	}
	public static void shiftingKeys(int n[],int key)
	{
		int i=0;
		while(i<=key)
		{
			int temp=n[0];
			for (int j = 1; j < n.length; j++) {
				
				n[j-1]=n[j];
			}
			n[n.length-1]=temp;
			i++;
		}
		
		for (int j = 0; j < n.length; j++) {
			System.out.print(n[j]+" ");
		}

	}
}
