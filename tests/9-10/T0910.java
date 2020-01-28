class T0910{
  /*
  Java: A Beginner's Guide, 6th Ed.
  Chapter 9 Test 10
  Improved from TwoDShape and related classes(on page 236 or chapter 7 list 21) 
  */
  public static void main(String arg[]){
    Stack s1 = new Stack(5);
    s1.put('1');
    s1.put('2');
    s1.put('3');
    Stack s2 = new Stack(s1);
    char chars[] = {'6','7','8'};
    Stack s3 = new Stack(chars);
    System.out.print("s1 elements: ");
    for(int i=0;i<3;i++)
      System.out.print(s1.get()+" ");
    System.out.println();
    System.out.print("s2 elements: ");
    for(int i=0;i<3;i++)
      System.out.print(s2.get()+" ");
    System.out.println();
    System.out.print("s3 elements: ");
    for(int i=0;i<3;i++)
      System.out.print(s3.get()+" ");
    System.out.println();
    System.out.println("----------[Ready for stack full exception]----------");
    char chars2[] = {'1','2','3','4','5'};
    Stack sf = new Stack(chars2);
    sf.put('A');
    System.out.println("----------[Ready for stack empty exception]----------");
    Stack se = new Stack(1);
    se.get();
  }
}

class Stack{
  private char s[]; // this array holds the stack   
  private int top; // the put and get indices   
   
  // Construct an empty Stack given its size.  
  Stack(int size) {   
    s = new char[size]; // allocate memory for stack   
    top = 0;   
  }   
  
  // Construct a Stack from a Stack.  
  Stack(Stack ob) {  
    top = ob.top;   
    s = new char[ob.s.length];  
  
    // copy elements  
    for(int i=0; i < top; i++)  
      s[i] = ob.s[i];  
  }  
  
  // Construct a Stack with initial values.  
  Stack(char a[]) {  
    top = 0;   
    s = new char[a.length];  
  
    for(int i = 0; i < a.length; i++) put(a[i]);  
  }  
      
  // Put a characer into the stack.   
  void put(char ch) {   
  	try{
	  if(top==s.length) {   
	    System.out.println(" -- Stack is full.");   
	    throw new StackFullException(top);
	  }
	  s[top++] = ch;   	
  	}
  	catch(StackFullException exc){
  		return;
  	}
  }   
   
  // Get a character from the stack.  
  char get() {
    try{   
      if(top<=0) {   
        System.out.println(" -- Stack is empty.");   
        throw new StackEmptyException();  
      }   
      return s[--top];   
    }
    catch(StackEmptyException exc){
    	return (char) 0;
    }
  }   
}


class StackFullException extends Exception{
	StackFullException(){
		System.out.println("StackFullException!!  the stack is full.");
	}
	StackFullException(int top){
		System.out.println("StackFullException!!  the stack is full.");
		System.out.println("the length of the stack is "+top+", and the number "+(top+1)+" element is being pushed");
	}
}

class StackEmptyException extends Exception{
	StackEmptyException(){
		System.out.println("StackEmptyException!!  the stack is empty.");
	}
}