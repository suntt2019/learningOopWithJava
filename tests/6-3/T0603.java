class T0603{
  /*
  Java: A Beginner's Guide, 6th Ed.
  Chapter 6 Test 3
  Improved from Queue class(on page 181 or Chapter 6 List 14) 
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
    if(top==s.length) {   
      System.out.println(" -- Stack is full.");   
      return;   
    }   
       
    s[top++] = ch;   
  }   
   
  // Get a character from the stack.  
  char get() {   
    if(top<0) {   
      System.out.println(" -- Stack is empty.");   
      return (char) 0;    
    }   
     
    return s[--top];   
  }   
}


// A queue class for characters.   
class Queue {   
  private char q[]; // this array holds the queue   
  private int putloc, getloc; // the put and get indices   
   
  // Construct an empty Queue given its size.  
  Queue(int size) {   
    q = new char[size]; // allocate memory for queue   
    putloc = getloc = 0;   
  }   
  
  // Construct a Queue from a Queue.  
  Queue(Queue ob) {  
    putloc = ob.putloc;  
    getloc = ob.getloc;  
    q = new char[ob.q.length];  
  
    // copy elements  
    for(int i=getloc; i < putloc; i++)  
      q[i] = ob.q[i];  
  }  
  
  // Construct a Queue with initial values.  
  Queue(char a[]) {  
    putloc = 0;  
    getloc = 0;  
    q = new char[a.length];  
  
    for(int i = 0; i < a.length; i++) put(a[i]);  
  }  
      
  // Put a characer into the queue.   
  void put(char ch) {   
    if(putloc==q.length) {   
      System.out.println(" -- Queue is full.");   
      return;   
    }   
       
    q[putloc++] = ch;   
  }   
   
  // Get a character from the queue.  
  char get() {   
    if(getloc == putloc) {   
      System.out.println(" -- Queue is empty.");   
      return (char) 0;    
    }   
     
    return q[getloc++];   
  }   
}   
