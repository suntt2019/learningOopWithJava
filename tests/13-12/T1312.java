class T1312{
  /*
  Java: A Beginner's Guide, 6th Ed.
  Chapter 13 Test 12
  Improved from Chapter 9 Test 10.
  */
  public static void main(String arg[]){
    Character chars1[] = {'1','2','3'};
    Character chars2[] = {'1','2','3'};
    Character chars3[] = {'6','7','8'};
    Stack<Character> s1 = new Stack<>(chars1);
    Stack<Character> s2 = new Stack<>(chars2);
    Stack<Character> s3 = new Stack<Character>(chars3);
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
    Character charsf[] = {'1','2','3','4','5'};
    Stack<Character> sf = new Stack<>(charsf);
    sf.put('A');
    Character charse[] = {};
    System.out.println("----------[Ready for stack empty exception]----------");
    Stack<Character> se = new Stack<>(charse);
    se.get();
  }
}

interface IGenStack<TT>{
  void put(TT x);
  TT get();
}

class Stack<T> implements IGenStack<T>{
  private T s[]; // this array holds the stack   
  private int top; // the put and get indices   
   
  Stack(T a[]) {    
    s = a;
    T temp;
    top = s.length;
    for(int i = 0; i < s.length; i++){
      temp=s[i];
      s[i]=s[s.length-1-i];
      s[s.length-1-i]=temp;
    }  
  }  
      
  // Put a characer into the stack.   
  public void put(T x) {   
  	try{
	  if(top==s.length) {   
	    System.out.println(" -- Stack is full.");   
	    throw new StackFullException(top);
	  }
	  s[top++] = x;   	
  	}
  	catch(StackFullException exc){
  		return;
  	}
  }   
   
  // Get a character from the stack.  
  public T get() {
    try{   
      if(top<=0) {   
        System.out.println(" -- Stack is empty.");   
        throw new StackEmptyException();  
      }   
      return s[--top];   
    }
    catch(StackEmptyException exc){
    	return null;
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