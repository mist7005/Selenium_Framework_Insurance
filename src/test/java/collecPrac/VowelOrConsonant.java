package collecPrac;

public class VowelOrConsonant {

	public static void main(String[] args) {
		String s="Pankaj";
		char ch[]=s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u' ||
					(ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U'))
			{
				System.out.println(ch[i]+" is vowel");
			}
			else 
			{
				System.out.println(ch[i]+" is consosant");
			}
		}
	}

}
