enum Tools{
	SCREWDRIVER, WRENCH, HAMMER, RLIERS
}


class T1203{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 12 Test 3
	*/
	public static void main(String args[]){
		for(Tools t : Tools.values()){
			System.out.println("Tools["+t.ordinal()+"]: "+t);
		}
		return;
	}
}