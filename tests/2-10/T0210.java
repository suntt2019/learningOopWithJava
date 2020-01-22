class T0210{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 2 Test 10
	*/
	static boolean IsPrime(int x){
		for(int i=2;i<x;i++){
			if(x%i==0)
				return false;
		}
		return true;
	}

	public static void main(String arg[]){
		System.out.println("Primes between 2 and 100:");
		for(int i=2;i<=100;i++){
			if(IsPrime(i))
				System.out.print(i+" ");
		}
		System.out.println();
	}
}