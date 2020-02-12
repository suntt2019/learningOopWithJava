import java.awt.*; 
import java.applet.*; 
/* 
<applet code="T1503" width=300 height=50> 
</applet> 
*/ 

/*
Java: A Beginner's Guide, 6th Ed.
Chapter 15 Test 3
Improved form try this 15-1(P468)
*/

//listing 4
/*  
   Try This 15-1
 
   A simple banner applet. 
 
   This applet creates a thread that scrolls 
   the message contained in msg right to left 
   across the applet's window. 
*/ 
 
public class T1503 extends Applet implements Runnable { 

  String msg; 
  int sleepTime=-1;
  Thread t; 
  boolean stopFlag; 
 
  // Initialize t to null.  
  public void init() { 
    t = null; 
  } 
 
  // Start thread 
  public void start() { 
    msg = getParameter("msg");
    if(msg == null)
      msg = " message NOT FOUND!! ";
    try{
      sleepTime = Integer.parseInt(getParameter("sleepTime"));
    }
    catch(NumberFormatException exc){
      msg+=" NumberFormatException!! ";
    }
    if(sleepTime < 0){
      sleepTime=100;
      msg += " sleepTime NOT FOUND!! ";
    }
    t = new Thread(this); 
    stopFlag = false; 
    t.start(); 
  } 
 
  // Entry point for the thread that runs the banner. 
  public void run() { 
 
    // Display banner  
    for( ; ; ) { 
      try { 
        repaint(); 
        Thread.sleep(sleepTime); 
        if(stopFlag)
          break; 
      } catch(InterruptedException exc) {} 
    } 
  } 
 
  // Pause the banner. 
  public void stop() { 
    stopFlag = true; 
    t = null; 
  } 
 
  // Display the banner. 
  public void paint(Graphics g) { 
    char ch; 
    //showStatus("sleepTime="+sleepTime);
    ch = msg.charAt(0); 
    msg = msg.substring(1, msg.length()); 
    msg += ch; 
    g.drawString(msg, 50, 30); 
  } 
}