class T0604{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 6 Test 4
	*/
	public static void main(String arg[]){
		Test t1 = new Test(1);
		Test t2 = new Test(2);
		t1.swap(t2);
		System.out.println("t1.a="+t1.a);
		System.out.println("t2.a="+t2.a);
	}
}

class Test{
	int a;
	Test(int i){ a=i; }
	public void swap(Test ob){
		int temp=a;
		a=ob.a;
		ob.a=temp;
		return;
	}
}