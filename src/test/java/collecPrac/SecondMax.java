package collecPrac;

public class SecondMax {

	public static void main(String[] args) {
		int a[]= {6,22,43,1,11,7};
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]<a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for (int i = 1; i < a.length; i++) {
			if(a[i]!=a[i-1])
			{
				System.out.println("second max is====>"+a[i]);
				break;
			}
		}
	}

}
