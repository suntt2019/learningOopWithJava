class T1108{
  /*
  Java: A Beginner's Guide, 6th Ed.
  Chapter 11 Test 8
  Improved from Chapter 11 listing 10 (P360).
  */
  public static void main(String args[]) { 
    TickTock tt = new TickTock(); 
    MyThread mt1 = new MyThread("Tick", tt); 
    MyThread mt2 = new MyThread("Tock", tt); 
 
    try { 
      mt1.thrd.join(); 
      mt2.thrd.join(); 
    } catch(InterruptedException exc) { 
      System.out.println("Main thread interrupted."); 
    } 
  } 
}
//listing 10
// Use wait() and notify() to create a ticking clock. 
 
class TickTock { 

  String state; // contains the state of the clock
 
  synchronized void tick(boolean running) { 
    if(!running) { // stop the clock 
      state = "ticked";
      notify(); // notify any waiting threads 
      return; 
    } 
 
    System.out.print("Tick "); 

    state = "ticked"; // set the current state to ticked
    try { 
      Thread.sleep(500);
      notify(); // let tock() run 
      while(!state.equals("tocked"))
        wait(); // wait for tock() to complete 
    } 
    catch(InterruptedException exc) { 
      System.out.println("Thread interrupted."); 
    } 
  } 
 
  synchronized void tock(boolean running) { 
    if(!running) { // stop the clock 
      state = "tocked";
      notify(); // notify any waiting threads 
      return; 
    } 
 
    System.out.println("Tock"); 

    state = "tocked"; // set the current state to tocked

    
    try { 
      Thread.sleep(500);
      notify(); // let tick() run 
      while(!state.equals("ticked"))
        wait(); // wait for tick to complete 
    } 
    catch(InterruptedException exc) { 
      System.out.println("Thread interrupted."); 
    } 
  } 
}  
 
class MyThread implements Runnable { 
  Thread thrd; 
  TickTock ttOb; 
 
  // Construct a new thread. 
  MyThread(String name, TickTock tt) { 
    thrd = new Thread(this, name); 
    ttOb = tt; 
    thrd.start(); // start the thread 
  } 
 
  // Begin execution of new thread. 
  public void run() { 
 
    if(thrd.getName().compareTo("Tick") == 0) { 
      for(int i=0; i<5; i++) ttOb.tick(true); 
      ttOb.tick(false); 
    } 
    else { 
      for(int i=0; i<5; i++) ttOb.tock(true); 
      ttOb.tock(false); 
    } 
  } 
} 
 