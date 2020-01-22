class T0309{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 3 Test 9
	*/
	public static void main(String[] arg){
		for(int i=1;i<=32;i*=2){
			if(i!=1)
				System.out.print(",");
			System.out.print(i);
		}
		System.out.println("...");
	}
}