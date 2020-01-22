class T0606{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 6 Test 6
	*/
	public static void main(String arg[]){
		String test = new String("Hello");
		System.out.println(stringReverse(test));
	}

	static String stringReverse(String src){
		DoubleString ds = new DoubleString(src);
		ds.moveOneChar();
		return ds.dst;
	}

	
}

class DoubleString{
	String src;
	String dst;

	DoubleString(String source){
		src = new String(source);
		dst = new String();
	}

	void moveOneChar(){
		int dstLen=dst.length();
		int srcLen=src.length();
		int index=srcLen-dstLen-1;
		if(index==-1)
			return;
		dst+=src.charAt(index);
		moveOneChar();
	}
}