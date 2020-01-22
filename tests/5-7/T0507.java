class T0507{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 5 Test 7
	Improved from Encode.class(on page 154) 
	*/
	public static void main(String arg[]){
		String passwd = "mimamima";
		String msg="12345678910]]]",cipher,result;
		System.out.println("message: "+msg);
		cipher=encode(msg,passwd);
		System.out.println("encoded: "+cipher);
		result=encode(cipher,passwd);
		System.out.println("decoded: "+result);
	}

	static String encode(String input,String passwd){
		String output = new String();
		for(int i=0;i<input.length();i++){
			output+=(char)(input.charAt(i)^passwd.charAt(i%passwd.length()));
		}
		return output;
	}
}