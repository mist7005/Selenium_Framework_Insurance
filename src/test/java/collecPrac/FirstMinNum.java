package collecPrac;

public class FirstMinNum {

	public static void main(String[] args) {
		int a[]= {6,22,43,1,11,7};
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.print(a[0]+" ");
	}

}
