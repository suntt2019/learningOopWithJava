import java.io.*;

class T1008{
	/*
	Java: A Beginner's Guide, 6th Ed.
	Chapter 10 Test 8
	Improved from Chapter 10 Test 7 (T1007.java).
	*/
	public static void main(String args[]){
		int ch;
		try(BufferedReader br = new BufferedReader(new FileReader("T1008.in"));
			FileWriter fw = new FileWriter("T1008.out",false);){
			
			do{
				ch = br.read();
				if(ch==' ')ch='-';
				if(ch!=-1)fw.write(ch);
			}while(ch!=-1);
		}
		catch(FileNotFoundException exc){
			System.out.println("File not found.");
		}
		catch(IOException exc){
			System.out.println("An IOException.");
		}
	}
}