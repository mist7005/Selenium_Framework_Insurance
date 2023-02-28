package collecPrac;

public class RemoveDuplicateWord {

	public static void main(String[] args) {
		
		String s="i am am from a sdet44 a batch";
		
	}
	public static boolean checkIfPresent(int ar[],int num)
	{
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i]==num)
				return true;
		}
		return false;
	}
	public static void printFreq(int ar[])
	{
		int arr[] = new int[ar.length];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=-1;
		}
		for(int i=0;i<ar.length;i++)
		{
			if(!checkIfPresent(arr,ar[i]))
			{
			arr[i]=ar[i];
			int count=1;
			for(int j=i+1;j<ar.length;j++)
				{
					if(ar[i]==ar[j])
						{
							count++;
						}
				}
			if(count>0)
				System.out.println(ar[i]+"===>"+count);
			}
		}
	}

	public static void freqOfArEle(int ar[])
	{
		for(int i=0;i<ar.length;i++)
		{	
			int x=ar[i];
			int count=0;
			if(ar[i]!=-1)
			{
			for(int j=0;j<ar.length;j++)
			{	
				if(x==ar[j])
					{
					ar[j]=-1;
					count++;
					}
			}
			if(count>0)
				{
					System.out.println("count of "+x+"====>"+count);
				}
			//ar[i]=-1;
			}
		}


	}


}
