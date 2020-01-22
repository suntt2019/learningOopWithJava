class T0310{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 3 Test 10
	*/
	public static void main(String arg[])
		throws java.io.IOException{
		char ch;
		int count=0;
		do{
			ch=(char)System.in.read();
			count++;
			if('a'<=ch&&ch<='z'){
				ch-=32;
			}else if('A'<=ch&&ch<='Z'){
				ch+=32;
			}else{
				count--;
			}
			System.out.print(ch);
		}while(ch!='.');
		System.out.println();
	}
}