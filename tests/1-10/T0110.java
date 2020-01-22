class T0110{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 1 Test 10
	*/
	public static void main(String arg[]){
		double meters;
		for(double inches=1;inches<=144;inches++){
			meters=inches/39.37;
			System.out.println(inches+" inches is "+meters+" meters.");
			if(inches%12==0)
				System.out.println();
		}
	}
}