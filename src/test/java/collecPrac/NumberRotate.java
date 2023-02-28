package collecPrac;

public class NumberRotate {

	public static void main(String[] args) {
		int a=0;  int b=1;  int c=2;
		int i=0;
		int temp;
		// a= 1 b = 2 c= 0
		// a= 2 b= 0 c=1
		// a=0 b=1  c=2
		while(i<3)
		{
			temp=a;
			a=b;
			b=c;
			c=temp;
			System.out.println(i+" rotation ");
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			i++;
		}
			
		
		
		
	}

}
