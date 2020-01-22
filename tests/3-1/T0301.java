class T0301{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 3 Test 1
	*/
	static public void main(String[] arg)
		throws java.io.IOException{
		char ch;
		int spaceCount=0;
		do{
			ch=(char)System.in.read();
			if(ch==' ')
				spaceCount++;
		}while(ch!='.');
		System.out.println("the count of space is "+spaceCount+".");
	}
}
