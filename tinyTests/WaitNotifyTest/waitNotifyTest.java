class MyThread implements Runnable{
	Thread thrd;
	int cnt=0;
	boolean stop=false;
	MyThread(String name){
		thrd = new Thread(this,name);
		thrd.start();
	}

	public void run(){
		System.out.println(thrd.getName()+" Started!");
		while(!stop){
			System.out.println(thrd.getName()+" is running ...");
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException exc){
				System.out.println("InterruptedException in "+thrd.getName()+"!");
			}
			if(cnt==3&&thrd.getName().equals("T0000000")){
				myWait(this);
			}
			if(cnt==6&&thrd.getName().equals("T1111111")){
				myNotify(WaitNotifyTest.mt1);
			}
			cnt++;
		}
	}

	synchronized public void myWait(MyThread ob){
		System.out.println("ob="+ob);
		System.out.println("before wait");
		try{
			wait();
		}
		catch(InterruptedException exc){
				System.out.println("InterruptedException in "+thrd.getName()+"!");
		}
		System.out.println("after wait");
	}

	synchronized public void myNotify(MyThread ob){
		System.out.println("ob="+ob);
		notify();
	}
}

class Useless{
	public String name;
	Useless(String givenName){
		name=givenName;
		System.out.println("QAQ...I'm a useless object.");
	}
}

class WaitNotifyTest{
	public static Useless us1 = new Useless("us1");
	public static Useless us2 = new Useless("us2");
	static MyThread mt0 = new MyThread("T0000000");
	static MyThread mt1 = new MyThread("T1111111");
	public static void main(String args[]){
		try{
			mt0.thrd.join();
			mt1.thrd.join();
		}
		catch(InterruptedException exc){
			System.out.println("InterruptedException in main method!");
		}
	}
}