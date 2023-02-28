package interviewQue;

public class Malayalam {

	public static void main(String[] args) {
		String s="Malayalam";
		s=s.toLowerCase();
		
		boolean ar[]=new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int count=0;
			if(ar[i]==false)
			{
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j))
				{
					count++;
					ar[j]=true;
				}
			}
			System.out.print(s.charAt(i)+":"+count);
			}
		}
		
		
	}

}
