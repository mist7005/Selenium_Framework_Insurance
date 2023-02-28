package interviewQue;

public class PatternProg {

	public static void main(String[] args) {
		int n=5;
		
		rightAngled(n);
		downRightAngled(n);
		
		triangle(n);
		downTriangle(n);
		
		leftAngled(n);
		downLeftAngled(n);
		
		
		
	}
	
	public static void rightAngled(int n)
	{
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void downRightAngled(int n)
	{
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= n-i+1; j++) {
				System.out.print("* ");
			}
			
			for (int j = 1; j <=i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}	
	}
	
	public static void leftAngled(int n)
	{
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n-i; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}
	
	public static void downLeftAngled(int n)
	{
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <i; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= n-i+1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}
	
	public static void downTriangle(int n)
	{
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n-i+1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}
	
	public static void triangle(int n)
	{
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}

}
