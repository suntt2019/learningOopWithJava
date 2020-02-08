class T1409{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 13 Test 12
	Improved from Try this 14-1(P443).
	*/
	public static void main(String args[]){
		StringFunc p = (str)->{
			String ret = new String();
			for(int i=0;i<str.length();i++)
				if(str.charAt(i)!=' ')
					ret+=str.charAt(i);
			return ret;
		};

		String testRet = changeStr(p,"Ha! l a m b d a a a a a a !");
		System.out.println(testRet);
	}

	static String changeStr(StringFunc sf, String s){
		return sf.func(s);
	}
}

interface StringFunc{
	String func(String str); 
}

