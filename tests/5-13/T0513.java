class T0513{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 5 Test 13
	Improved from MinMax class(on page 126) 
	*/
	public static void main(String arg[]){
		int array[]={2,-1,998,3,-4,22,33,0};
		int min=array[0],max=array[0];
		for(int x:array){
			if(x<min)
				min=x;
			if(x>max)
				max=x;
		}
		System.out.println("min="+min+",max="+max+".");
	}
}
