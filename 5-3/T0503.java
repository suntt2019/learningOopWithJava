class T0503{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 5 Test 3
	*/
	public static void main(String arg[]){
		double array[]={1.2,2.3,4,3.141,6,7.22,2,-3,10,0};
		double sum=0,ave;
		for(int i=0;i<array.length;i++)
			sum+=array[i];
		ave=sum/array.length;
		System.out.println("average of the 10 numbers is "+ave+".");
		return;
	}
}