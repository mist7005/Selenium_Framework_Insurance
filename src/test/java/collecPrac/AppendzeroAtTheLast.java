package collecPrac;

public class AppendzeroAtTheLast {

	public static void main(String[] args) {
		int a[]= {1,0,1,0,0};
		int b[]= new int[a.length];
		int n=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==1)
			{
				b[n]=a[i];
				n++;
			}
			

		}

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
	}
}


