package collecPrac;

import java.util.TreeSet;

public class ProgEx {

	public static void main(String[] args) {
		int a[]= {6,1,1,1,1,1,3,22,43,11,7};
		getNum(a,3);
		sumOfNum(a,3);

	}

	public static void getNum(int a[],int n)
	{
		TreeSet<Integer>ts=new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			ts.add(a[i]);
		}
		int j[]=new int[ts.size()];
		int i=0;
		for (Integer in : ts) {
			j[i++]=in;
		}
		System.out.println(j[n-1]);
	}

	public static void sumOfNum(int a[],int target)
	{
		TreeSet<Integer>ts=new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			ts.add(a[i]);
		}
		int i=0;
		int sum=0;
		for (Integer in : ts) {
			if(i<=(target-1))
			{
			sum=sum+in;
			}
			i++;
		}
		System.out.println("sum of first+"+target+" num is ===>"+sum);
	}

	public static void mulOfNum(int a[],int target)
	{
		TreeSet<Integer>ts=new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			ts.add(a[i]);
		}
		int i=0;
		int mul=1;
		for (Integer in : ts) {
			if(i<=(target-1))
			{
			mul=mul*in;
			}
			i++;
		}
		System.out.println("mul of first+"+target+" num is ===>"+mul);
	}

}
