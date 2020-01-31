class MyThread implements Runnable{

	Thread thrd;
	MyThread(String name){
		thrd = new Thread(this,name);
		thrd.start();
	}
	public void run(){
		System.out.println(thrd.getName()+" started.");
		synchronized(Wnt.exob){
			Wnt.exob.lockingMethod();
		}
		// lockingMethod();
		
	}

	synchronized void lockingMethod(){
		System.out.println("Begin locking method,locked="+Wnt.locked+", exob.value="+Wnt.exob.value);
		Wnt.exob.value++;
		Wnt.locked++;
		// try{
		// 	Thread.sleep(500);
		// }
		// catch(InterruptedException exc){
		// 	System.out.println("Exception when sleeping");
		// }

		
		System.out.println("Finished locking method,locked="+Wnt.locked+", exob.value="+Wnt.exob.value);
	}
}

class Exob{
	public int value=0;

	int getValue(){
		return value;
	}
	void lockingMethod(){
		System.out.println("[in Exob]Begin locking method,locked="+Wnt.locked+", exob.value="+Wnt.exob.value);
		Wnt.exob.value++;
		Wnt.locked++;

		try{
			notify();
			Thread.sleep(2000);
			wait();
		}
		catch(InterruptedException exc){
			System.out.println("Exception when sleeping");
		}
		
		System.out.println("[in Exob]Finished locking method,locked="+Wnt.locked+", exob.value="+Wnt.exob.value);
	}
}

class Wnt{
	public static int locked=0;
	public static Exob exob = new Exob();
	public static void main(String args[]){
		MyThread mt1 = new MyThread("T01");
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException exc){
			System.out.println("Exception when sleeping");
		}
		System.out.println("main thread: exob.value="+exob.value);
		synchronized(Wnt.exob){
			System.out.println("main thread: exob.getValue()="+exob.getValue());
		}
		MyThread mt2 = new MyThread("T02");
		try{
			mt1.thrd.join();
			mt2.thrd.join();
		}
		catch(InterruptedException exc){
			System.out.println("Exception when sleeping");
		}

	}
}