import java.awt.*; 
import java.applet.*; 
import java.util.*;
/* 
<applet code="T1504" width=300 height=50> 
</applet> 
*/ 

/*
Java: A Beginner's Guide, 6th Ed.
Chapter 15 Test 4
Reference:
	https://docs.oracle.com/javase/8/docs/api/
	https://blog.csdn.net/dz77dz/article/details/85173984
*/
// class ThreadClass implements Runnable{
//还真就非得弄到一个类里面去...
// 	ThreadClass(){
// 		Thread thrd = new Thread(this);
// 		thrd.start();
// 	}

// 	public void run(){
// 		for( ; ; ) { 
// 			try { 
// 				T1504.repaint(); //这样不行
// 				T1504.msg+="o";
// 				Thread.sleep(500); 
// 				if(stopFlag)
// 					break;
// 			} catch(InterruptedException exc) {} 
// 	    } 
// 	}
// }

public class T1504 extends Applet implements Runnable{
	String msg;
	Calendar rightNow;

	public void init(){
		msg="yooo";
	}

	public void start(){

		Thread thrd = new Thread(this);
		thrd.start();
		//rigthNow = new Calendar();
		//rigthNow.setTimeZone(8);
	}

	public void run(){
		while(true){
			rightNow = Calendar.getInstance();
			msg = (new Date()).toString();//看了半天calendar类的官方文档，结果Date类解决了..
			repaint();
			try{
				Thread.sleep(500);
			}catch(InterruptedException exc){
				;
			}
		}
	}

	public void paint(Graphics g) { 
		g.drawString(msg,50,30); 
	}
}