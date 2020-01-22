class T0504{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 5 Test 4
	Improved from Try this 5-1 
	*/
	public static void main(String[] args){
		String strings[]={"Peach","Apple","Orange","Pear","Banana"};
		String temp;
		for(int i=0;i<strings.length;i++){
			for(int j=strings.length-2;j>=i;j--){
				if(strings[j].compareTo(strings[j+1])>0){
					temp=strings[j+1];
					strings[j+1]=strings[j];
					strings[j]=temp;
				}
				/*
				//[[[DEBUG_OUTPUT]]]
				for(int k=0;k<strings.length;k++){
					System.out.print(" "+strings[k]);
					if(k==i)
						System.out.print("[i]");
					if(k==j)
						System.out.print("[j]");
				}
				System.out.println();
				*/
			}
		}
		for(int i=0;i<strings.length;i++)
			System.out.print(strings[i]+" ");
		System.out.println();
	}
}