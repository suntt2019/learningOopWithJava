class T0613{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 6 Test 13
	*/
	public static void main(String args[]){
		System.out.println(sum(1,2,3,4,5));
	}

	static int sum(int ... a){
		int sum=0;
		for(int x : a)
			sum+=x;
		return sum;
	}
}