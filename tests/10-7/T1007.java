import java.io.*;

class T1007{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 10 Test 7
	*/
	public static void main(String args[]){
		int ch;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try{
			fin = new FileInputStream("T1007.in");
			fout = new FileOutputStream("T1007.out");
			do{
				ch=fin.read();
				if(ch==' ')
					ch='-';
				if(ch!=-1)
					fout.write(ch);
			}while(ch!=-1);
		}
		catch(FileNotFoundException exc){
			System.out.println("File not found.");
		}
		catch(IOException exc){
			System.out.println("An IOException.");
		}
		finally{
			try{
				if(fin!=null){
					fin.close();
					System.out.println("Input file closed.");
				}
				if(fout!=null){
					fout.close();
					System.out.println("Output file closed.");
				}
			}
			catch(IOException exc){
				System.out.println("IOException when closing.");
			}
		}
		System.out.println("Finished");
	}
}